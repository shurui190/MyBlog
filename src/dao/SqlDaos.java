package dao;
import java.sql.*;
public class SqlDaos {
   public	Connection conn = null;
   public Statement stmt = null;
   public Statement stmt1 = null;
   public Statement stmt2 = null;
   public SqlDaos() {
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
			System.out.println("连接失败 ");
			System.err.println("数据库驱动注册错误信息： " + e.getMessage());
		} 
		System.out.println("连接成功");
   }
   public static void main(String args[]) {
	   SqlDaos sd = new SqlDaos();
	   
   }
}
