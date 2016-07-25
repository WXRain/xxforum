package model.impl;

import vo.User;
import model.inter.*;
import dao.impl.*;

public class UserImpl implements IUser{

	public String login(String username, String password) {
		// TODO Auto-generated method stub
		String result = null;
		UserDao ud = new UserDao();
		User u = ud.selectUser("username", username);
		if(u == null)
			result = "���û���������";
		else if(!u.getPassword().equals(password))
			result = "�û����������";
		else if(u.getPassword().equals(password))
			result = "true";
		else result = "err";
		return result;
	}

	public String register(User user) {
		// TODO Auto-generated method stub
		String result = null;
		UserDao ud = new UserDao();
		boolean b = ud.addUser(user);
		if(b == true)
			result = "true";
		else result = "�û����Ѵ���";
		
		return result;
	}

	public User findUserByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDao();
		return ud.selectUser(attribute, value);
	}

	public String changePassword(String username, String password,
			String oldPassword) {
		// TODO Auto-generated method stub
		String result = null;
		UserDao ud = new UserDao();
		if(oldPassword.equals(ud.selectUser("username", username).getPassword())){
			ud.updateUser(username, "password", password);
			result = "true";
		}else {
			result = "�û����������";
		}
		return result;
	}
	
	public static void main(String[] args) {
//		UserImpl ui = new UserImpl();
//		System.out.println(ui.login("abcd", "1234"));
//		System.out.println(ui.changePassword("aaaa", "1234", "123"));
	}
}
