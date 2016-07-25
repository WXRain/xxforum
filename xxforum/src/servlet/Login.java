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
		
		IUser iuser = new UserImpl();//�����ж������Ƿ���ȷ����
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("") || password.equals("")){
			
			//response.sendRedirect("../index.jsp");
			out.println("��½ʧ��,�û�����������Ϊ��");
			out.println("<a href='../page/index.jsp'>������ҳ</a>&nbsp;&nbsp;<a href='../page/register.jsp'>ע���û�</a>");
			
		}
		else{
			
			if((iuser.login(username, password).equals("true"))){
				
					HttpSession session = request.getSession();
					/*
					 * ����������յĽӿ����Ƹı� Ҳ����Ҫ�ı��
					 */
					user = iuser.findUserByAttribute("username", username);
					session.setAttribute("user", user);
					response.sendRedirect("../page/index.jsp");
			}
			else{
				out.println(iuser.login(username, password));
				out.println("<a href='../page/index.jsp'>������ҳ</a>&nbsp;&nbsp;<a href='../page/register.jsp'>ע���û�</a>");
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
