package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Section;
import vo.User;

import model.impl.SectionImpl;
import model.inter.ISection;

public class AddSection extends HttpServlet{

	private static final String CONTENT_TYPE="text/html; charset=gb2312";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		request.setCharacterEncoding("gb2312");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		String sectionName = request.getParameter("sectionname");
		String sectionIntroduce = request.getParameter("sectionintroduce");
		
		User user = (User) request.getSession().getAttribute("user");
		
		ISection isection = new SectionImpl();
		
		Section section = new Section();
		
		section.setIntroduce(sectionIntroduce);
		section.setName(sectionName);
		
		System.out.println(sectionName + " " + sectionIntroduce + " ");
		
		String result = isection.addSection(user, section);
		
		if(result == null){
			out.print(" <center><h2>增加板块失败</h2></center>"
					+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
			response.setHeader("refresh","3;url=../page/index.jsp");
		}
		else if(result.equals("true")){
			out.print(" <center><h2>增加板块成功</h2></center>"
					+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
			response.setHeader("refresh","3;url=../page/index.jsp");
		}
		else{
			out.print(" <center><h2>"+result+"</h2></center>"
					+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
			response.setHeader("refresh","3;url=../page/index.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
