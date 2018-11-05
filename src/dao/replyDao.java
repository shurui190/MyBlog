package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.*;

public class replyDao extends sqlDao  {

	public boolean setReply(Reply reply) {
		
		String sql = "INSERT INTO t_reply(content,time,article_id,user_id) VALUES(?,?,?,?)";
				
		try {
		
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, reply.getContent());
			pstat.setString(2, reply.getTime());
			pstat.setInt(3, reply.getArticle_id());
			pstat.setInt(4, reply.getUser_id());
			
			
			if(pstat.executeUpdate()==1) {
				System.out.println("成功向数据库插入1比数据");
				close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在setReply 出现错误");
			e.printStackTrace();
		}
		
			close();
			return false;
		
	}
	
	public List<Reply> getReplyByArticleId(int article_id) {
		List<Reply> list = new ArrayList<>(); 
		String sql = "SELECT * from t_reply join t_user on t_reply.user_id=t_user.id WHERE t_reply.article_id=? ORDER BY t_reply.id desc";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,article_id);
			
			ResultSet rs =pstat.executeQuery();
			while(rs.next()) {
				
					Reply reply = new Reply();
					reply.setArticle_id(rs.getInt("article_id"));
					reply.setContent(rs.getString("content"));
					reply.setId(rs.getInt("id"));
					reply.setTime(rs.getString("time"));
					reply.setUser_id(rs.getInt("user_id"));
					reply.setUser_name(rs.getString("userName"));
					reply.setUser_photo(rs.getString("photo"));
					
					
					
					list.add(reply);											
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getReplyByArticleId出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getReplyByArticleId出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		finally {
			close();
			
		}
		return list;
	}
	
public boolean deletReplyByArticleId(int  article_id) {
		
		String sql = "delete from t_reply where article_id=?";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, article_id);
			pstat.executeUpdate();
			System.out.println("成功删除"+pstat.executeUpdate()+"条数据");
			return true;
			
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在deletReplyByArticleId 出现错误");
			e.printStackTrace();
		}
		
		
		close();
		System.out.println("用户不存在");	
		return false;
	}
	
	
}
