package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArticleModel;

/**
 * Servlet implementation class forEditIssueSessionNum
 */
@WebServlet("/editIssue.view")
public class forEditIssueSessionNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forEditIssueSessionNum() {
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
	    int articleId =Integer.parseInt(request.getParameter("articleId"));
		
		ArticleModel at = new ArticleModel();
		 if(at.getArticleById(articleId)!=null) {
			 System.out.println("article_id---------"+articleId);
			 request.setAttribute("editArticle", at.getArticleById(articleId));
			 
			 request.getRequestDispatcher("editIssue.jsp").forward(request, response);
		 }
		 else {
			 out.println("error in editIssue.view ");
			 response.setHeader("refresh", "1;url=home.view");
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
