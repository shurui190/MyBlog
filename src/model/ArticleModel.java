package model;

import java.util.List;

import dao.articleDao;
import entity.*;
import model.*;

public class ArticleModel {
	
	
	public boolean setArticle(Article article) {
		
		
		return new articleDao().setArticle(article);
	}
	
	public boolean editArticle(Article article) {
		
		
		return new articleDao().editArticle(article);
	}
	
	
	public List<Article> getAllArticle(){
		
		return new articleDao().getAllArticle();
	}
	
	public Article getArticleById(int id) {
		
		return new articleDao().getArticleById(id);
	}
	
	public boolean updateClickNum(int id) {
		
		return new articleDao().updateClickNum(id);
	}
	
	public List<Article> getByOnesNameArticle(String user_name){
			
			return new articleDao().getOnesNameArticle(user_name);
		}
	
	public boolean deletArticleById(int id) {
		
		if((new ReplymModel().deleteReplyByArticleId(id))&&new articleDao().deletArticleById(id))
		{
			return true;
			
		}
		
		
		return false;
	}



}
