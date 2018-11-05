package model;


import java.util.List;

import entity.Article;
import entity.Reply;
import dao.*;

public class ReplymModel {

	
	public boolean setReply(Reply reply) {
		
		return new replyDao().setReply(reply);
	}
	
	
	public List<Reply> getReplyByArticleId(int article_id){
		
		return new replyDao().getReplyByArticleId(article_id);
	}
	
	public boolean deleteReplyByArticleId(int article_id) {
			
			return new replyDao().deletReplyByArticleId(article_id);
		}
}
