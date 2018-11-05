<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"   import ="model.*"   import="entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>首页</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/main1.css" rel="stylesheet">
	</head>
	<body>
<!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <!-- 导航栏 开始-->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Project</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="index.view">首页</a></li>
          <li><a href="admin.jsp">管理页面</a></li>
          <li><a href="doLoginOut">注销</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
   <!-- 导航栏 结束-->
  <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h1>成功登录！</h1>
    </div>
    
    
    <table	class="table table-bordered table-hover table-condensed table-full-width">
						<tr>
							<td width="90" class="success">用户名</td>
							<td width="150" >${sessionScope.user.userName}</td>
							<td width="90" class="success">email</td>
							<td width="150" >${sessionScope.user.email }</td>
							<td width="90" class="success">性别</td>
							<td width="150" >${sessionScope.user.gender}</td>
							<td rowspan="2" width='120'><img src='upload1/${sessionScope.user.photo} ' width='100'></td>
						</tr>
						<tr>
							<td width="90" class="success">类型</td>
							<td width="150" >${sessionScope.user.category}</td>
							<td width="90" class="success">兴趣</td>
							<td width="150" colspan="3" >${sessionScope.user.interest}</td>
						</tr>
					</table>
					<hr>
					
					<h2>我的文章</h2>
					<c:forEach var ="list" items="${sessionScope.user_nameArticleList}">
					<table	class="table table-bordered table-hover table-condensed table-full-width">
						<tr>
							<td width="90" class="success">文章名</td>
							<td width="150" >${list.title}</td>
							<td width="90" class="success">发布时间</td>
							<td width="150" >${list.put_date }</td>
							<td width="90" class="success">点击量</td>
							<td width="150" >${list.clickNum}</td>
							<td rowspan="2" width='120'><img src='article_image/${list.picture} ' width='100'></td>
						</tr>
						<tr>
							<td width="90" class="success">	内容</td>
							<td width="150"  colspan="3">${list.content}</td>
							<td width="90" class="success">操作</td>
							<td width="150"  ><a href="single.view?articleId=${list.id}&user_name=${sessionScope.user.userName}">详情</a> &nbsp&nbsp
							  <a href="editIssue.view?articleId=${list.id}">编辑</a>
							  <a href="doDeletArticle?articleId=${list.id}">删除</a></td>
						</tr>
					</table>
					</c:forEach>
  </div>
</div>

<div id="footer">
  <div class="container">
    <p class="text-muted credit">网站访问次数：</p>
  </div>
</div>

	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
	</body>
</html>