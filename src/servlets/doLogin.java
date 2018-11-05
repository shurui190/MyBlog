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

import dao.articleDao;
import dao.userDao;
import entity.Article;
import entity.User;
import model.ArticleModel;
import model.UserModel;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String userName=request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		
		UserModel usermodel = new UserModel();
		User user = usermodel.loginCheck(userName, pwd);
		
	
		
		if(user!=null){
			if(user.getCategory().equals("admin"))
			{
				System.out.println("管理员登录成功");
				
				request.setAttribute("admin", user);
				request.getRequestDispatcher("user_list").forward(request, response);
				
			}
			
			List<Article> list = new ArrayList<>();
			ArticleModel at = new ArticleModel();
			list = at.getByOnesNameArticle(userName);
			System.out.println("登录成功");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("user_nameArticleList", list);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			System.out.println("登录失败");
			response.sendRedirect("login.jsp");
		}
		
		
 
		
		
	}

}
