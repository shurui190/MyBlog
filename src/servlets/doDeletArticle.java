package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.*;
import model.*;

/**
 * Servlet implementation class doDeletArticle
 */
@WebServlet("/doDeletArticle")
public class doDeletArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDeletArticle() {
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
		if(at.deletArticleById(articleId)) {
			System.out.println("删除id为"+articleId+"成功");
			out.println("删除成功");
		}
		else {
			System.out.println("删除id为"+articleId+"---------失败");
			out.println("删除失败");
			response.setHeader("refresh", "1;url=home.view");
		}
		
		response.sendRedirect("home.view");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
