<%@ page language="java" import="java.sql.*"
	pageEncoding="UTF-8"%>



<%
try {
    Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
    //Class.forName("org.gjt.mm.mysql.Driver");
   System.out.println("Success loading Mysql Driver!");
  }
  catch (Exception e) {
    System.out.print("Error loading Mysql Driver!");
    e.printStackTrace();
  }
  try {
  	
    Connection connect = DriverManager.getConnection(
        "jdbc:mysql://localhost:33006/materialdb","root","190437");
         //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

    System.out.println("Success connect Mysql server!");
    Statement stmt = connect.createStatement();
    ResultSet rs = stmt.executeQuery("select * from t_user");
                                                            //t_user 为你表的名称
    while (rs.next()) {
      System.out.println(rs.getString("id"));
    }
    if(stmt!=null) {
  	  stmt.close();
    }
    if(connect!=null) {
  	  connect.close();
    }
  }
  catch (Exception e) {
    System.out.print("get data error!  ");
    e.printStackTrace();
  }
	/* Connection conn = null;
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
	System.out.println("111111"); */
	
%>
