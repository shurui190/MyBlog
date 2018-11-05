package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.utils.TimeFormatUtil;

import model.ArticleModel;
import model.ReplymModel;
import entity.*;

/**
 * Servlet implementation class doReplay
 */
@WebServlet("/doReply")
public class doReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doReply() {
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
	    
	    if(request.getSession().getAttribute("user")!=null) {
	    
	    
	    
	    ArticleModel at = new ArticleModel();
	    int articleId =Integer.parseInt(request.getParameter("articleId"));
	    
	    String content = request.getParameter("reply");
	    int userId = ((User)request.getSession().getAttribute("user")).getId();
	    String time = TimeFormatUtil.getFormatDatetime(new Date());
	    		
	    Reply reply = new Reply();
	    reply.setArticle_id(articleId);
	    reply.setUser_id(userId);
	    reply.setTime(time);
	    reply.setContent(content);
		
		ReplymModel re = new ReplymModel();
		
		
	    
	 
	    
	    
	    System.out.println(articleId);
	    
	    if( re.setReply(reply)) {
	    	System.out.println("评论成功----");
	    	replyList=re.getReplyByArticleId(articleId);
	    	
	    }
	    else {
	    	System.out.println("评论失败--------");
	    }
	    request.setAttribute("replyList", replyList);
	    request.setAttribute("article", at.getArticleById(articleId));
	    request.getRequestDispatcher("single.jsp").forward(request, response);
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
