package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.*;

public class articleDao extends sqlDao {
	
	
	public boolean setArticle(Article article) {
		
		String sql = "INSERT INTO t_article(title,content,put_date,user_id,articletype_id,picture,user_name) VALUES(?,?,?,?,?,?,?)";
				
		try {
		
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, article.getTitle());
			pstat.setString(2, article.getContent());
			pstat.setString(3, article.getPut_date());
			pstat.setInt(4, article.getUser_id());
			pstat.setInt(5, article.getArticletype_id());
			pstat.setString(6, article.getPicture());
			pstat.setString(7, article.getUser_name());
			
			if(pstat.executeUpdate()==1) {
				System.out.println("成功向数据库插入1比数据");
				close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在seArticle 出现错误");
			e.printStackTrace();
		}
		
			close();
			return false;
		
	}
	

	public boolean editArticle(Article article) {
		
		String sql = "update t_article set title=?,content=?,put_date=?,picture=? where id=?";
				
		try {
		
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, article.getTitle());
			pstat.setString(2, article.getContent());
			pstat.setString(3, article.getPut_date());
			pstat.setString(4, article.getPicture());
			pstat.setInt(5, article.getId());
		
			
			if(pstat.executeUpdate()==1) {
				System.out.println("成功向数据库插入1比数据");
				close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在seArticle 出现错误");
			e.printStackTrace();
		}
		
			close();
			return false;
		
	}
	
	
	public boolean updateClickNum(int id) {
		
		String sql = "update t_article set click_num= click_num+1 where id=?";
				
		try {
		
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1,id);
		
			
			if(pstat.executeUpdate()==1) {
				System.out.println("成功增加点击量+1");
				close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在updateClickNum 出现错误");
			e.printStackTrace();
		}
		
			close();
			return false;
		
	}
	
	public List<Article> getAllArticle() {
		List<Article> list = new ArrayList<>(); 
		String sql = "select * from t_article ORDER  BY click_num DESC ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				
					
					Article article = new Article();
					
					article.setArticletype_id(rs.getInt("articletype_id"));
					article.setClickNum(rs.getInt("click_num"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getInt("id"));
					article.setPicture(rs.getString("picture"));
					article.setPut_date(rs.getString("put_date"));
					article.setTitle(rs.getString("title"));
					article.setUser_id(rs.getInt("user_id"));
					article.setUser_name(rs.getString("user_name"));
					
					list.add(article);											
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle0出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle1出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		finally {
			close();
			
		}
		return list;
	}
	
	public List<Article> getOnesArticle(int user_id) {
		List<Article> list = new ArrayList<>(); 
		String sql = "select * from t_article where user_id = ?";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,user_id);
			
			ResultSet rs =pstat.executeQuery();
			while(rs.next()) {
				
					
					Article article = new Article();
					
					article.setArticletype_id(rs.getInt("articletype_id"));
					article.setClickNum(rs.getInt("click_num"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getInt("id"));
					article.setPicture(rs.getString("picture"));
					article.setPut_date(rs.getString("put_date"));
					article.setTitle(rs.getString("title"));
					article.setUser_id(rs.getInt("user_id"));
					article.setUser_name(rs.getString("user_name"));
					
					list.add(article);											
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle0出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle1出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		finally {
			close();
			
		}
		return list;
	}
	
	public List<Article> getOnesNameArticle(String user_name) {
		List<Article> list = new ArrayList<>(); 
		String sql = "select * from t_article where user_name = ?";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user_name);
			
			ResultSet rs =pstat.executeQuery();
			while(rs.next()) {
				
					
					Article article = new Article();
					
					article.setArticletype_id(rs.getInt("articletype_id"));
					article.setClickNum(rs.getInt("click_num"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getInt("id"));
					article.setPicture(rs.getString("picture"));
					article.setPut_date(rs.getString("put_date"));
					article.setTitle(rs.getString("title"));
					article.setUser_id(rs.getInt("user_id"));
					article.setUser_name(rs.getString("user_name"));
					
					list.add(article);											
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle0出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle1出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		finally {
			close();
			
		}
		return list;
	}
	
	public Article getArticleById(int id) {
		
		Article article = new Article();
		String sql = "select * from t_article where id = ?";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,id);
			
			ResultSet rs =pstat.executeQuery();
			while(rs.next()) {
				
					
					
					
					article.setArticletype_id(rs.getInt("articletype_id"));
					article.setClickNum(rs.getInt("click_num"));
					article.setContent(rs.getString("content"));
					article.setId(rs.getInt("id"));
					article.setPicture(rs.getString("picture"));
					article.setPut_date(rs.getString("put_date"));
					article.setTitle(rs.getString("title"));
					article.setUser_id(rs.getInt("user_id"));
					article.setUser_name(rs.getString("user_name"));
					
															
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle0出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallArticle1出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		finally {
			close();
			
		}
		return article;
	}
	
	
public boolean deletArticleById(int  id) {
		
		String sql = "delete from t_article where id=? ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int n=pstat.executeUpdate();
			System.out.println("成功删除"+n+"条数据");
			return true;
			
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在deletArticleById出现错误");
			e.printStackTrace();
		}
		
		
		close();
		
		return false;
	}
	
	

}
