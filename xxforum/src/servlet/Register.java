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

public class Register extends HttpServlet {
	
	private static final String CONTENT_TYPE="text/html; charset=gb2312";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		IUser iuser = new UserImpl();
		
		request.setCharacterEncoding("gb2312");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		User user = new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("secondPassword");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(Integer.parseInt(sex));
		
		HttpSession session = request.getSession();
		
		String result = iuser.register(user);
		
		if(result == null){
			out.print("<center><h2>程序运行出错</h2></center>"
	                +"<center><a href="+basePath+"page/index.jsp>3秒之后返回主页，没有跳转点击此处</a></center>");
				response.setHeader("refresh","3;url=../page/index.jsp");
		}
		
		else if(result.equals("true")){    
			
			user = new UserImpl().findUserByAttribute("username", username);
			session.setAttribute("user", user);
			response.sendRedirect("../page/index.jsp");
		}
		else{
			out.print("<center><h2>" + iuser.register(user) + "</h2><br/></center><center><a href=" + basePath + "page/index.jsp>3秒之后返回主页，没有跳转点击此处</a></center>");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
}
