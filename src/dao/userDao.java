package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import dao.*;

public class userDao extends sqlDao {
	

	public  userDao() {
		super();
		
	}
	public boolean deletUser(int  id) {
		
		String sql = "delete from t_user where id=? ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int n=pstat.executeUpdate(sql);
			System.out.println("成功删除"+n+"条数据");
			return true;
			
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在deletUser 出现错误");
			e.printStackTrace();
		}
		
		
		close();
		System.out.println("用户不存在");	
		return false;
	}
	
	
	public boolean checkUser(User user) {
		String sql = "select * from t_user WHERE userName = ? ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUserName());
			ResultSet rs = pstat.executeQuery();
			
			
			while(rs.next()) {
				String userName = rs.getString("userName");
				System.out.println(userName);
				if(userName.equals(user.getUserName())) {
					
					System.out.println("用户已存在"+userName);
					close();
					return true;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在checkUser 出现错误");
			e.printStackTrace();
		}
		
		
		close();
		System.out.println("用户不存在");	
		return false;
		
	}
	public boolean checkUserName(String username, String pwd) {
		
		String sql = "select * from t_user WHERE userName = ? ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, username);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				String pwd0 = rs.getString("pwd");
				if(pwd.equals(pwd0)) {
					System.out.println("用户名和密码匹配");
					this.close();
					return true;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在checkUserName 出现错误");
			e.printStackTrace();
		}
		System.out.println("用户名和密码不匹配");
		close();
		return false;
	}

	 
	public User getUser(String username) {
		
		String sql = "select * from t_user WHERE userName = ? ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, username);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				if(rs.getString("userName").equals(username)) {
					User user=new User();

					int id = rs.getInt("id");
					
					String userName = rs.getString("userName");
					String pwd = rs.getString("pwd");
					String gender=rs.getString("gender");
					String category = rs.getString("category");
					String interest = rs.getString("interest");
					String photo = rs.getString("photo");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String qq = rs.getString("qq");
					String info = rs.getString("info");
					
					
					user.setUserName(userName);
					user.setGender(gender);
					user.setCategory(category);
					user.setPwd(pwd);
					user.setInterest(interest);
					user.setPhoto(photo);
					user.setEmail(email);
					user.setPhone(phone);
					user.setQq(qq);
					user.setInfo(info);
				
					
					
					user.setId(id);
					
					close();
					System.out.println("得到user："+username);
					return user;
					
				}
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getUser出现错误");
			e.printStackTrace();
		}
		
		close();
		return null;
	}

	public List<User> getAllUse() {
		List<User> list = new ArrayList<>(); 
		String sql = "select * from t_user  ";
		try {
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				
					User user=new User();
					
					int id = rs.getInt("id");
					
					String userName = rs.getString("userName");
					String pwd = rs.getString("pwd");
					String gender=rs.getString("gender");
					String category = rs.getString("category");
					String interest = rs.getString("interest");
					String photo = rs.getString("photo");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String qq = rs.getString("qq");
					String info = rs.getString("info");
					
					
					user.setUserName(userName);
					user.setGender(gender);
					user.setCategory(category);
					user.setPwd(pwd);
					user.setInterest(interest);
					user.setPhoto(photo);
					user.setEmail(email);
					user.setPhone(phone);
					user.setQq(qq);
					user.setInfo(info);
				
					
					
					user.setId(id);
					list.add(user);											
			}
	
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallUser0出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在getallUser1出现错误");
			
			e.printStackTrace();
			close();
			return null;
		}
		finally {
			close();
			
		}
		return list;
	}
	public boolean setUser(User user) {
		
		String sql = "INSERT INTO t_user(userName,pwd,gender,category,interest,photo,email,phone,qq,info) VALUES(?,?,?,?,?,?,?,?,?,?)";
				
		try {
		
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUserName());
			pstat.setString(2, user.getPwd());
			pstat.setString(3, user.getGender());
			pstat.setString(4, user.getCategory());
			pstat.setString(5, user.getInterest());
			pstat.setString(6, user.getPhoto());
			pstat.setString(7, user.getEmail());
			pstat.setString(8, user.getPhone());
			pstat.setString(9, user.getQq());
			pstat.setString(10, user.getInfo());
			
			if(pstat.executeUpdate()==1) {
				System.out.println("成功向数据库插入1比数据");
				close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在setUser 出现错误");
			e.printStackTrace();
		}
		
			close();
			return false;
		
	}
	
	
	public boolean updateUser(User user) {
		
		String sql = "update t_user set userName=?,pwd=?,email=?,phone=?,qq=? ,info=? where id=?";
				
		try {
		
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Success connect Mysql server!");
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUserName());
			pstat.setString(2, user.getPwd());
		
			
			pstat.setString(3, user.getEmail());
			pstat.setString(4, user.getPhone());
			pstat.setString(5, user.getQq());
			pstat.setString(6, user.getInfo());
			
			pstat.setInt(7, user.getId());
			
			if(pstat.executeUpdate()==1) {
				System.out.println("成功向数据库更新1比数据");
				close();
				return true;
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("在updateUser 出现错误");
			e.printStackTrace();
		}
		
			close();
			return false;
		
	}
	
	
	
	
 
}
