package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.User;
import model.UserModel;

/**
 * Servlet implementation class doRegister
 */
@MultipartConfig(location="F:\\Tomact_work\\2016121067\\WebContent\\upload1")
@WebServlet("/doRegister")
public class doRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    System.out.println(request.getParameter("userName"));
	   /* if(!request.getParameter("pwd").equals(request.getParameter("pwdConfirm"))) {
	    	 System.out.println("注册失败");
	    	 out.println("两次输入的密码不一样，1秒后跳到注册页面");
	    	 response.setHeader("refresh", "3;url=register.jsp");
	    }
	    */
	  User user = new User();
		
	     user.setUserName(request.getParameter("userName"));
	     user.setPwd(request.getParameter("pwd"));
	    //out.println(user.getUserName());
	     user.setGender(request.getParameter("gender"));
	     user.setCategory(request.getParameter("category"));
	     user.setEmail(request.getParameter("email"));
	     user.setInfo(request.getParameter("info"));
	     user.setPhone(request.getParameter("phone"));
	     user.setQq(request.getParameter("qq"));
	     
	     
	     
	     String[] interest =request.getParameterValues("interest");
	     user.setInterest(Arrays.toString(interest));
	    
	     Part part =request.getPart("photo");
	     System.out.println(part.getSubmittedFileName());
	     user.setPhoto(part.getSubmittedFileName());
	     part.write(part.getSubmittedFileName());
	     UserModel usermodel = new UserModel();
	     
	     if(usermodel.registerUser(user)) {
	    	 System.out.println("注册成功");
	    	 out.println("注册成功，3秒后跳到登录页面");
	    	 response.setHeader("refresh", "3;url=login.jsp");
	     }
	     else {
	    	 System.out.println("注册失败");
	    	 out.println("注册失败，1秒后跳到注册页面");
	    	 response.setHeader("refresh", "3;url=register.jsp");
	     }
	}

}
