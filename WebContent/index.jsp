<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"   import ="model.*"   import="entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
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
                    <a href="#">Blog</a>
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
                <div class="col-md-8 blog-main">
                    <div class="row">
                      <!--   <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="img/1.jpg" alt="">
                                    <h3><a href="single.jsp">How to Create Template</a></h3>
                                    <span class="meta">19 August 2015, John Doe</span>
                                    <hr>
                                </header>
                                <div class="body">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatum, sit. Doloribus dolores neque eos. Velit eveniet, necessitatibus aut sit tenetur perferendis!
                                </div>
                                <div class="clearfix">
                                    <a href="single.jsp" class="btn btn-clean-one">Read more</a>
                                </div>
                            </article>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="img/1.jpg" alt="">
                                    <h3><a href="single.jsp">How to Create Template</a></h3>
                                    <span class="meta">19 August 2015, John Doe</span>
                                    <hr>
                                </header>
                                <div class="body">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatum, sit. Doloribus dolores neque eos. Velit eveniet, necessitatibus aut sit tenetur perferendis!
                                </div>
                                <div class="clearfix">
                                    <a href="single.jsp" class="btn btn-clean-one">Read more</a>
                                </div>
                            </article>
                        </div> -->
                        <!-- 数据库的文章 -->
                        
                     <c:forEach var ="list" items="${sessionScope.articlelist}">
                   
                          <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="article_image/${list.picture }" alt="">
                                    <h3><a href="single.jsp">${list.title }</h3>
                                    <span class="meta">${list.put_date },${sessionScope.user.userName}</span>
                                    <hr>
                                </header>
                                <div class="body" style="overflow:hidden;height:100px">
                                  <p>  ${list.content }</p>
                                </div>
                                <div class="clearfix">
                                    <a href="single.view?articleId=${list.id }" class="btn btn-clean-one">Read more</a>
                                </div>
                            </article>
                        </div>
                        </c:forEach> 
                        
                        
                    </div>
                    
                  
                    

                    <div class="paging">
                        <a href="#" class="older">Older Post</i></a>
                    </div>
                </div>
                <aside class="col-md-4 blog-aside">
                    
                    <div class="aside-widget">
                        <header>
                            <h3>Click Rank</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                            <%
                            		int i=0;
                             		
                             		%>
                             <c:forEach var ="list" items="${sessionScope.articlelist}">
                             		
                             		<% if(i<10){i++;}
                             		   else { break;}
                             		
                             		%>
                             		
                             
                                <li><a href="single.view?articleId=${list.id }">${list.title }</a></li>
                                </c:forEach>
                                
                                <li><a href="">Clean Slider Template</a></li>
                            </ul>
                        </div>
                    </div>
                
                    <div class="aside-widget">
                        <header>
                            <h3>Related Post</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                                <li><a href="">Blackor Responsive Theme</a></li>
                                <li><a href="">Portfolio Bootstrap Template</a></li>
                                <li><a href="">Clean Slider Template</a></li>
                                <li><a href="">Clean - Responsive HTML5 Template</a></li>
                                <li><a href="">Responsive Pricing Table</a></li>
                                <li><a href="">Yellow HTML5 Template</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="aside-widget">
                        <header>
                            <h3>Tags</h3>
                        </header>
                        <div class="body clearfix">
                            <ul class="tags">
                                <li><a href="#">HTML5</a></li>
                                <li><a href="#">CSS3</a></li>
                                <li><a href="#">COMPONENTS</a></li>
                                <li><a href="#">TEMPLATE</a></li>
                                <li><a href="#">PLUGIN</a></li>
                                <li><a href="#">BOOTSTRAP</a></li>
                                <li><a href="#">TUTORIAL</a></li>
                                <li><a href="#">UI/UX</a></li>                            
                            </ul>
                        </div>
                    </div>
                </aside>
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
        
    </footer>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/modernizr.js"></script>

</body>
</html>