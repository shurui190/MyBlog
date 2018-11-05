<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>About Me</title>
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
                    <a href="#">About Me</a>
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
        <div class="container about">
            <h1>Hello, My name is <span class="about-bold"> ${sessionScope.user.userName}</span></h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus inventore magni ratione perferendis ex molestiae cum reiciendis perspiciatis consequuntur, nihil ducimus corrupti! Ipsum nesciunt ipsa nobis obcaecati labore, rem recusandae?</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Qui quo sint asperiores, ut doloremque eum commodi, odit nisi sed repellendus earum recusandae pariatur consectetur minus rerum, magni dolores officiis magnam.</p>
            <hr>
			 <div class="col-md-6 col-md-offset-3 clean-superblock" id="contact">
                   <center> <h3>Myself info</h3></center>
                    <br>
            <form   action="doAbout" method="post" accept-charset="utf-8" class="contact-form">
                     
             <div class="form-group">
            <label>用户名</label>
              <input type="text" name="userName" class="form-control input-lg" placeholder="用户名"  value="${sessionScope.user.userName}">
            </div>  
            <div class="form-group">
            <label>密码</label>
              <input type="password" name="pwd" class="form-control input-lg" placeholder="密码"  value="${sessionScope.user.pwd}">
            </div>
             
            <div class="form-group">
            <label>邮箱</label>
              <input type="text" name="email" class="form-control input-lg" placeholder="email"  value="${sessionScope.user.email}">
            </div>
            
             <div class="form-group">
            <label>电话</label>
              <input type="text" name="phone" class="form-control input-lg" placeholder="phone"  value="${sessionScope.user.phone}">
            </div>
            
             <div class="form-group">
            <label>qq</label>
              <input type="text" name="qq" class="form-control input-lg" placeholder="qq"  value="${sessionScope.user.qq}">>
            </div>
            <!--  <div class="form-group">
            <label>info</label>
              <input type="text" name="info" class="form-control input-lg" placeholder="info" value="${sessionScope.user.info}">
            </div> -->
                        
                         <label>info</label>
                        
                        <textarea rows="10" name="info" id="contact-body" placeholder="Your info" class="form-control input-lg"  >${sessionScope.user.userName}</textarea>
                        <div class="buttons clearfix">
                            <button type="submit" class="btn btn-xlarge btn-clean-one">Save</button>
                        </div>                    
                    </form>
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
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modernizr.js"></script>

</body>
</html>