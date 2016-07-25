package dao.inter;

import vo.*;

public interface IUser {
	public boolean addUser(User user); //添加用户
	public boolean updateUser(String username, String attribute, String value); //通过提供的用户 属性 和属性的值修改
	public User selectUser(String attribute, String value); //通过属性和属性的值查询用户
}
