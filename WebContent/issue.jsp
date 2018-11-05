<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Issue Me</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
  

    <!-- Font-Awesome -->
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>

    <!-- Styles -->
  <link rel="stylesheet" href="css/style.css" id="theme-styles">

    <!--[if lt IE 9]>      
        <script src="js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->
    
</head>
<body>
    <header>
        <div class="widewrapper masthead">
            <div class="container">
                <a href="index.view" id="logo">
                    <img src="img/logo.png" alt="clean Blog">
                </a>

                <div id="mobile-nav-toggle" class="pull-right">
                    <a href="#" data-toggle="collapse" data-target=".clean-nav .navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                </div>

                <nav class="pull-right clean-nav">
                <li>  <a href="login.jsp"><h3> Welcome:    <c:out value="${sessionScope.user.userName}" default="Please Login"/></h3>  </a>
                          </li>
                    <div class="collapse navbar-collapse">
                        <ul class="nav nav-pills navbar-nav">
                          
                             <li>
                                <a href="index.view">Home</a>
                            </li>
                            <li>
                                <a href="about.jsp">About</a>
                            </li>
                            <li>
                                <a href="issue.jsp">Issue</a>
                            </li>       
                            <li>
                                <a href="home.view">MyBlog</a>
                            </li>           
                        </ul>
                    </div>
                </nav>        

            </div>
        </div>

        <div class="widewrapper subheader">
            <div class="container">
                <div class="clean-breadcrumb">
                    <a href="#">Issue Me</a>
                </div>
                <div class="clean-searchbox">
                    <form action="#" method="get" accept-charset="utf-8">
                        
                        <input class="searchfield" id="searchbox" type="text" placeholder="Search">
                         <button class="searchbutton" type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </header>

    <div class="widewrapper main">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 clean-superblock" id="contact">
                    <h2>Issue</h2>
                    
                    <form action="doIssue"  enctype="multipart/form-data" method="post" accept-charset="utf-8" class="contact-form">
                    <label>文章标题</label>
                        <input type="text" name="title" id="contact-name" placeholder="title" class="form-control input-lg" >
                           <div class="form-group">
						<label>文章类型</label>
			              	<select id="userType" class="form-control" name="articletype_id">
			              		<option value="1"> 生活</option>
			              		<option value="2"> 社会</option>
			              		<option value="3"> 科技</option>
			              		<option value="4"> 娱乐</option>
			              		<option value="5"> 电影</option>
			              		<option value="6"> 新闻</option>
			              	</select>
			            </div>
							 <div class="form-group">
				            <label>文章配图</label>
				      
				            <img id="preview"  height ="100%"  width="50%"/> <br /> <input type="file" name="picture" onchange="imgPreview(this)" /> 
				        
				            </div> 
                        <textarea rows="10" name="content" id="contact-body" placeholder="Content" class="form-control input-lg"></textarea>
                        <div class="buttons clearfix">
                            <button type="submit" class="btn btn-xlarge btn-clean-one">Submit</button>
                        </div>                    
                    </form>
                </div>
            </div>        
        </div>
    </div>

   <footer>
        <div class="widewrapper footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-user"></i>About</h3>

                       <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab animi laboriosam nostrum consequatur fugiat at, labore praesentium modi, quasi dolorum debitis reiciendis facilis, dolor saepe sint nemo, earum molestias quas.</p>
                       <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum, error aspernatur assumenda quae eveniet.</p>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-pencil"></i> Recent Post</h3>
                        <ul class="clean-list">
                            <li><a href="">Clean - Responsive HTML5 Template</a></li>
                            <li><a href="">Responsive Pricing Table</a></li>
                            <li><a href="">Yellow HTML5 Template</a></li>
                            <li><a href="">Blackor Responsive Theme</a></li>
                            <li><a href="">Portfolio Bootstrap Template</a></li>
                            <li><a href="">Clean Slider Template</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-envelope"></i>Issue Me</h3>

                        <p>Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil fugiat, cupiditate veritatis excepturi tempore explicabo.</p>
                         <div class="footer-widget-icon">
                            <i class="fa fa-facebook"></i><i class="fa fa-twitter"></i><i class="fa fa-google"></i>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        <div class="widewrapper copyright">
                Copyright 2015
        </div>
    </footer>
    <script src="js/image_view.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modernizr.js"></script>

</body>
</html>