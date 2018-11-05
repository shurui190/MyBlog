package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.utils.TimeFormatUtil;

import entity.Article;
import entity.User;
import model.ArticleModel;

/**
 * Servlet implementation class doIssue
 */
@MultipartConfig(location="F:\\Tomact_work\\2016121067\\WebContent\\article_image")
@WebServlet("/doIssue")
public class doIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doIssue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    System.out.println(request.getParameter("title"));
	    if(request.getSession().getAttribute("user")!=null) {
		Date put_date = new Date();
		Part part =request.getPart("picture");
	     System.out.println(part.getSubmittedFileName());
	
	     part.write(part.getSubmittedFileName());
		
		
	    
	    Article article = new Article();
	    article.setTitle(request.getParameter("title"));
	    article.setContent(request.getParameter("content"));
	    article.setPut_date(TimeFormatUtil.getFormatDatetime(put_date));
	    System.out.println("-------"+TimeFormatUtil.getFormatDatetime(put_date));
	    
	    article.setPicture(part.getSubmittedFileName());
	    article.setArticletype_id(Integer.parseInt(request.getParameter("articletype_id")));
	    article.setUser_id(((User)request.getSession().getAttribute("user")).getId());
	    article.setUser_name(((User)request.getSession().getAttribute("user")).getUserName());
	    
	    ArticleModel articleModel = new ArticleModel();
	    if(articleModel.setArticle(article)) {
	    	
	    	System.out.println("发布成功");
	    	 out.println("发布成功，1秒后返回");
	    	 response.setHeader("refresh", "1;url=issue.jsp");
	    	 
	    }
	    else {
	    System.out.println("发布失败");
   	    out.println("发布失败，1秒后返回");
     	response.setHeader("refresh", "1;url=issue.jsp");
	    }
	    }
	    else {
	    	out.println("您还未登录 请先登录");
			response.setHeader("refresh", "1;url=index.view");
	    	
	    }
	     
	}

}
