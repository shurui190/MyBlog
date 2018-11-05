package dao;
import java.sql.*;
public class sqlDao {
	protected String jdbcUrl = "jdbc:mysql://localhost:33006/blog";
	protected String userName = "root";
	protected String password = "190437";
	protected Connection conn =null;
	protected Statement stat = null;
	protected PreparedStatement pstat = null;
    
   public sqlDao() {
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("success loading mysql Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.out.println("default loading mysql Driver");
			e.printStackTrace();
		}
   }
   
   
   public void close () {
		
		try {
			if(pstat!=null) {
			pstat.close();
			}
			if(stat!=null) {
				stat.close();
			}
			if(conn!=null) {
				conn.close();
			}
			System.out.println("成功关闭connect和statement");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("未能正常关闭");
			e.printStackTrace();
		}
	}
   
   
   
   
   
   
   
   
   public static void main(String args[]) {
	   
   }
}
