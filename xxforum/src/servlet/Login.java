package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.impl.UserImpl;
import model.inter.IUser;

import vo.User;

public class Login extends HttpServlet{
	
	private static final String CONTENT_TYPE="text/html; charset=gb2312";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("gb2312");
		response.setContentType(CONTENT_TYPE);
		
		User user = new User();
		PrintWriter out = response.getWriter();
		
		IUser iuser = new UserImpl();//用来判断密码是否正确的类
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("") || password.equals("")){
			
			//response.sendRedirect("../index.jsp");
			out.println("登陆失败,用户名或者密码为空");
			out.println("<a href='../page/index.jsp'>返回主页</a>&nbsp;&nbsp;<a href='../page/register.jsp'>注册用户</a>");
			
		}
		else{
			
			if((iuser.login(username, password).equals("true"))){
				
					HttpSession session = request.getSession();
					/*
					 * 这里如果最终的接口名称改变 也是需要改变的
					 */
					user = iuser.findUserByAttribute("username", username);
					session.setAttribute("user", user);
					response.sendRedirect("../page/index.jsp");
			}
			else{
				out.println(iuser.login(username, password));
				out.println("<a href='../page/index.jsp'>返回主页</a>&nbsp;&nbsp;<a href='../page/register.jsp'>注册用户</a>");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stubs
		
		doGet(req,resp);
	}
	
}
