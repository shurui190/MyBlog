package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlserverjdbc {
	 public static void main(String args[]) {
		  Connection conn = null;
			Statement stmt = null;
			Statement stmt1 = null;
			Statement stmt2 = null;
			String sDBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=materialdb";
			
			try {
				//加载数据库驱动
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				//获取数据库链接
				conn = DriverManager.getConnection(
				        "jdbc:sqlserver://localhost:1433;DatabaseName=materialdb","sa","190437");
		        //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
				stmt = conn.createStatement(); //创建连接状态
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("2 22 22 2 ");
				System.err.println("数据库驱动注册错误信息： " + e.getMessage());
			} 
			System.out.println("111111"); 
		    
		  }
		  

}
