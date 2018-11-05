package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.User;
import model.UserModel;

/**
 * Servlet implementation class doAbout
 */
@WebServlet("/doAbout")
public class doAbout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAbout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    System.out.println(request.getParameter("userName"));
	 
	  User user = new User();
	     user=(User) request.getSession().getAttribute("user");
	  
	     user.setUserName(request.getParameter("userName"));
	     user.setPwd(request.getParameter("pwd"));
	    //out.println(user.getUserName());
	    
	     
	     user.setEmail(request.getParameter("email"));
	     user.setInfo(request.getParameter("info"));
	     user.setPhone(request.getParameter("phone"));
	     user.setQq(request.getParameter("qq"));
	     
	     System.out.println("info+++++++++---------:"+request.getParameter("info"));

	    
	    
	     
	     UserModel usermodel = new UserModel();
	     
	     if(usermodel.updateUser(user)) {
	    	 System.out.println("更新成功");
	    	 out.println("更新成功，3秒后将自动返回");
	    	 response.setHeader("refresh", "3;url=about.jsp");
	     }
	     else {
	    	 System.out.println("更新失败");
	    	 out.println("更新失败，1秒后将自动返回");
	    	 response.setHeader("refresh", "3;url=about.jsp");
	     }
	
	}

}
