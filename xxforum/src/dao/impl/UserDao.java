package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.User;
import dao.inter.IUser;

public class UserDao implements IUser{

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try { 
			Statement st = con.createStatement();
			rs = st.executeQuery("select username from user " +
					"where username = '" + user.getUsername() + "' or name = '" + user.getName() + "'");
			if(!rs.next()){
				st.executeUpdate("insert into user (username, password, name, sex, level, exp, isManager) values " +
						"('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "'," +
						" '" + user.getSex() + "', '" + user.getLevel() +"', '" + user.getExp() + "', '" + user.getIsManager() + "')");
				
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		
		
		return result;
	}

	public User selectUser(String attribute, String value) {
		// TODO Auto-generated method stub
		
		User user = new User();
		
		Connection con = tools.DBUtil.getInstance().getConnection();
		ResultSet rs;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from user where " + attribute + " = '" + value + "'");
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setSex(rs.getInt(5));
				user.setLevel(rs.getInt(6));
				user.setExp(rs.getInt(7));
				user.setIsManager(rs.getInt(8));
			} else {
				user = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return user;
	}

	public boolean updateUser(String username, String attribute, String value) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		Connection con = tools.DBUtil.getInstance().getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update user set " + attribute + " = '" + value + "' where username = '" + username + "'");
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con != null)
				tools.DBUtil.getInstance().release(con);
		}
		return result;
	}
	
	public static void main(String[] args) {
//		User u = new User();
//		UserDao ud = new UserDao();
		
		//添加用户测试
//		u.setUsername("aaaaa");
//		u.setPassword("123456");
//		u.setName("i am 1");
//		System.out.println(ud.addUser(u));
		
		//通过用户名查询用户测试
//		u = ud.selectUser("username", "aaa");
//		if(u != null)
//			System.out.println("" + u.getId() + u.getUsername() + u.getPassword() + u.getName() + 
//					u.getSex() + u.getLevel() + u.getExp() + u.getIsManager());
//		else System.out.println("result is null");
		
		//通过用户名修改密码测试
//		ud.updateUser("ccc", "password", "001");
	}
}
