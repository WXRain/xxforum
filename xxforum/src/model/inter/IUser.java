package model.inter;

import vo.User;

public interface IUser {

	public String login(String username, String password);//用户登录 如果成功返回true， 如果失败返回返回原因
	public String register(User user);//用户注册 
	public String changePassword(String username, String password, String oldPassword);//用户修改密码 
	public User findUserByAttribute(String attribute, String value); //通过username返回User对象
}
