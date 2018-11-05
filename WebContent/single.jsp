<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"   import ="model.*"   import="entity.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Single Post</title>
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
                    <span class="separator">&#x2F;</span>
                    <a href="#">Bootstrap</a>
                    <span class="separator">&#x2F;</span>
                    <a href="#">HTML Template</a>
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
                    <article class="blog-post">
                        <header>
                           
                            <div class="lead-image">
                                <img src="article_image/${requestScope.article.picture}" alt="" class="img-responsive">
                                
                            </div>
                        </header>
                        <div class="body">
                            <h1>${requestScope.article.title} </h1>
                            <div class="meta">
                                <i class="fa fa-user"></i> ${requestScope.article.user_name} <i class="fa fa-calendar"></i>${requestScope.article.put_date}<i class="fa fa-comments"></i><span class="data"><a href="single.view?articleId=${requestScope.article.id }&click_num=1">${requestScope.article.clickNum} Like</a></span>
                                <span class="data"><a href="#create-comment">Reply</a></span>
                            </div>
                            <p> ${requestScope.article.content} </p>
<!-- --------------------------------------------------------------------------- -->
                        </div>
                    </article>

                    <aside class="social-icons clearfix">
                        <h3>Share on </h3> 
                        <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-google"></i></a>
                    </aside>

                    <aside class="comments" id="comments">
                        <hr>

                        <h2><i class="fa fa-comments"></i> Comments</h2>
						
						
						
						
					
						<c:forEach var ="replyList" items="${requestScope.replyList}">
                        <article class="comment">
                            <header class="clearfix">
                                <img src="upload1/${replyList.user_photo}" alt="A Smart Guy" class="avatar">
                                <div class="meta">
                                    <h3><a href="#">${replyList.user_name}</a></h3>
                                    <span class="date">
                                       ${replyList.time}
                                    </span>
                                    <span class="separator">
                                        -
                                    </span>
                                    
                                    <a href="#create-comment" class="reply-link">Reply</a>                
                                </div>
                            </header>
                             <div class="body">
                               ${replyList.content}
                            </div>
                        </article>
                        </c:forEach>
                        
                         <article class="comment">
                            <header class="clearfix">
                                <img src="img/avatar.png" alt="A Smart Guy" class="avatar">
                                <div class="meta">
                                    <h3><a href="#">John Doe</a></h3>
                                    <span class="date">
                                        24 August 2015
                                    </span>
                                    <span class="separator">
                                        -
                                    </span>
                                    
                                    <a href="#create-comment" class="reply-link">Reply</a>                
                                </div>
                            </header>
                             <div class="body">
                               Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis, vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsam similique sapiente obcaecati tenetur beatae voluptatibus.
                            </div>
                        </article>

	
                    </aside>
                    <!-- -------------------------------- -->

                    <aside class="create-comment" id="create-comment">
                        <hr>    

                        <h2><i class="fa fa-pencil"></i> Add Comment</h2>

                        <form action="doReply?articleId=${requestScope.article.id }" method="post" accept-charset="utf-8">
                            

                         

                            <textarea rows="10" name="reply" id="comment-body" placeholder="Your Message" class="form-control input-lg"></textarea>

                            <div class="buttons clearfix">
                                <button type="submit" class="btn btn-xlarge btn-clean-one">Submit</button>
                            </div>
                        </form>
                    </aside>
                </div>
                <aside class="col-md-4 blog-aside">
                    
                    <div class="aside-widget">
                        <header>
                            <h3>Featured Post</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                                <li><a href="">Clean - Responsive HTML5 Template</a></li>
                                <li><a href="">Responsive Pricing Table</a></li>
                                <li><a href="">Yellow HTML5 Template</a></li>
                                <li><a href="">Blackor Responsive Theme</a></li>
                                <li><a href="">Portfolio Bootstrap Template</a></li>
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
                        <h3> <i class="fa fa-envelope"></i>Contact Me</h3>

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