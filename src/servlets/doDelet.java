package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

import dao.userDao;

/**
 * Servlet implementation class doDelet
 */
@WebServlet("/doDelet")
public class doDelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入doDELET");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		int Id = Integer.parseInt(id);
		System.out.println("进入doDELET的get"
				+Id);
		userDao  userdao= new userDao();
		if(userdao.deletUser(Id)) {
			response.sendRedirect("user_list");
		}
		else {
			System.out.println("在doDelet界面出错");
			out.println("出现错误请重新登录");
			
		  response.setHeader("refresh", "1;url=login.jsp");
		}
		
	}



}
