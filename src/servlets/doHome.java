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
 * Servlet implementation class doHome
 */
@WebServlet("/home.view")
public class doHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doHome() {
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
	
		
		
		if(request.getSession().getAttribute("user")==null) {
			out.println("您还未登录 请先登录");
			response.setHeader("refresh", "1;url=index.view");
		}
		else {
			List<Article> list = new ArrayList<>();
			
			
			ArticleModel at = new ArticleModel();
			
			HttpSession session = request.getSession();
			
			list=at.getByOnesNameArticle(((User)session.getAttribute("user")).getUserName());
			
			
			
			session.setAttribute("user_nameArticleList", list);
			request.getRequestDispatcher("home.jsp").forward(request, response);
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
