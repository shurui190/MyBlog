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
@WebServlet("/doEditIssue")
public class doEditIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doEditIssue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
	     int articleId =Integer.parseInt(request.getParameter("articleId"));
	    
	    Article article = new Article();
	    article.setPicture(part.getSubmittedFileName());
	    article.setTitle(request.getParameter("title"));
	    article.setContent(request.getParameter("content"));
	    article.setPut_date(TimeFormatUtil.getFormatDatetime(put_date));
	    article.setId(articleId);
	    System.out.println("-------"+TimeFormatUtil.getFormatDatetime(put_date));
	    
	    article.setPicture(part.getSubmittedFileName());
	    
	    
	    
	    ArticleModel articleModel = new ArticleModel();
	    if(articleModel.editArticle(article)) {
	    	
	    	System.out.println("更新成功");
	    	 out.println("发布成功，1秒后返回");
	    	 response.setHeader("refresh", "1;url=home.view");
	    	 
	    }
	    else {
	    System.out.println("更新失败");
   	    out.println("发布失败，1秒后返回");
     	response.setHeader("refresh", "1;url=home.view");
	    }
	    }
	    else {
	    	out.println("您还未登录 请先登录");
			response.setHeader("refresh", "1;url=index.view");
	    	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	     
	}

}
