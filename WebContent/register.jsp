<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>用户注册</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<style type="text/css">
		.modal-footer {   border-top: 0px; }
		</style>
	</head>
	<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h1 class="text-center">用户注册</h1>
      </div>
      <div class="modal-body">
          <form  enctype="multipart/form-data" action="doRegister" method="post" enctype="multipart/form-data"><!-- enctype="application/x-www-form-urlencoded" -->
            <div class="form-group">
            <label>用户名</label>
              <input type="text" name="userName" class="form-control input-lg" placeholder="用户名">
            </div>
            <div class="form-group">
            <label>密码</label>
              <input type="password" name="pwd" class="form-control input-lg" placeholder="密码">
            </div>
             <div class="form-group">
            <label>密码确认</label>
              <input type="password" name="pwdConfirm" class="form-control input-lg" placeholder="密码确认">
            </div>
            
            <div class="form-group">
            <label>邮箱</label>
              <input type="text" name="email" class="form-control input-lg" placeholder="email">
            </div>
            
             <div class="form-group">
            <label>电话</label>
              <input type="text" name="phone" class="form-control input-lg" placeholder="phone">
            </div>
            
             <div class="form-group">
            <label>qq</label>
              <input type="text" name="qq" class="form-control input-lg" placeholder="qq">
            </div>
             <div class="form-group">
            <label>info</label>
              <input type="text" name="info" class="form-control input-lg" placeholder="info">
            </div>
            
            
            
						<div class="form-group">
						<label>性别</label>
							<div class="radio">
								<label> <input type="radio" name="gender"
									id="maleRadios" value="男" checked>男
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="gender"
									id="femaleReadios" value="女">女
								</label>
							</div>
						</div>
						<div class="form-group">
						<label>用户类型</label>
              	<select id="userType" class="form-control" name="category">
              		<option value="VIP"> VIP用户</option>
              		<option value="普通"> 普通用户</option>
              	</select>
            </div>
            <div class="form-group">
               <label>兴趣</label>
         <div class="checkbox">
     
    <input type="checkbox" name="interest" value="sports">运动
</div>
<div class="checkbox">
    <input type="checkbox" name="interest" value="reading">阅读
</div>
</div>
 <div class="form-group">
            <label>头像</label>
            <input type="file" name="photo" class="form-control" placeholder="选择头像文件"> 
             
           
			
             
            </div> 
         <div class="btn-group pull-right">
         <button class="reset btn btn-default">重置</button>
          <button class="submit btn btn-primary">注册</button>
		  </div>	
          </form>
      </div>
      <div class="modal-footer">
        
      </div>
  </div>
  </div>
</div>
	<!-- script references -->
		<script type='text/javascript' src="js/image_view.js"></script>
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>

	</body>
</html>