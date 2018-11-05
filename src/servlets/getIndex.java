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

import com.mysql.fabric.xmlrpc.base.Array;

import dao.articleDao;
import entity.Article;
import model.ArticleModel;

/**
 * Servlet implementation class getIndex
 */
@WebServlet("/index.view")
public class getIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getIndex() {
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
		List<Article> articlelist = new ArrayList<>();
		ArticleModel am = new ArticleModel();
		articlelist = am.getAllArticle();
		
		
		if(articlelist!=null) {
			
			request.getSession().setAttribute("articlelist", articlelist);
			System.out.println("在index.view成功取得文章数据");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
		System.out.println("在index.view未能成功取得文章数据");
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
