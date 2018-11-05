package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import entity.User;
import dao.userDao;
import entity.User;

public class UserModel {
	
	public boolean registerUser(User user) {
		userDao userdao=new userDao();
		if(!userdao.checkUser(user)) {
			
			if(userdao.setUser(user)) {
				return true;
			}
		
		}

		return false;
		
		
	}
	
	public boolean updateUser(User user) {
		userDao userdao=new userDao();
		
		
		
		return userdao.updateUser(user);
		
	}
	
	public User loginCheck(String userName,String pwd) {
		userDao userdao=new userDao();
		if(userdao.checkUserName(userName, pwd)) {
			if(userdao.getUser(userName)!=null)
			{
				return userdao.getUser(userName);
			}
		}
		return null;
	}
	
	
	
	public boolean registerUser(File userFile,User user) throws IOException{
		if (userFile.exists()) {
			return false;
		}else{
			userFile.createNewFile();
			Properties properties = new Properties();
			OutputStream outputStream = new FileOutputStream(userFile);
			properties.setProperty("userName", user.getUserName());
			properties.setProperty("pwd",user.getPwd());
			properties.setProperty("gender",user.getGender());
			properties.setProperty("category",user.getCategory());
			properties.setProperty("interest", user.getInterest());
			properties.setProperty("photo", user.getPhoto());
			properties.store(outputStream, "suowang@cuit.edu.cn");
			outputStream.close();
			return true;
		}
	}
	
	/**
	 * ���û�ע���ļ�����֤�û��ĵ�¼���������Ƿ�ƥ��
	 * @param userFile �û�ע���ļ�
	 * @param pwd �û���¼ʱ�ύ������
	 * @return ���δ�ҵ���¼�ļ� ��ʾ���û���δע�ᣬ����false������û��������벻ƥ�䷵��false����֮����true
	 * @throws IOException
	 */
	public boolean loginCheck(File userFile,String pwd) throws IOException{
		if (userFile.exists()) {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(userFile);
			properties.load(fis);
			if (properties.getProperty("pwd").equals(pwd)) {
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	public static void main(String[] args) throws IOException {
		User user = new User();
		user.setCategory("student");
		user.setGender("male");
		user.setInterest("football");
		user.setPwd("123");
		user.setUserName("tomcat");
		user.setPhoto("afsd");
		UserModel userModel = new UserModel();
		userModel.registerUser(user);
	}
}
