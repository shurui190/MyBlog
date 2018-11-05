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

import entity.Reply;
import model.ArticleModel;
import model.ReplymModel;

/**
 * Servlet implementation class doSingle
 */
@WebServlet("/single.view")
public class doSingle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSingle() {
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
	    List<Reply> replyList = new ArrayList<>();
	    ArticleModel at = new ArticleModel();
	    int articleId =Integer.parseInt(request.getParameter("articleId"));
	    ReplymModel re = new ReplymModel();
		
	    replyList=re.getReplyByArticleId(articleId);
	    
	    System.out.println(articleId);
	    
	    if("1".equals(request.getParameter("click_num"))&&at.updateClickNum(articleId)) {
	    	System.out.println("点赞成功");
	    	
	    	
	    }
	    
	    
	   
	    request.setAttribute("replyList", replyList);
	    request.setAttribute("article", at.getArticleById(articleId));
	    request.getRequestDispatcher("single.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
