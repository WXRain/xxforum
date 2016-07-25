package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.impl.TopicImpl;
import model.inter.ITopic;
import vo.User;

public class CancelTopicTop extends HttpServlet{
private static final String CONTENT_TYPE="text/html; charset=gb2312";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		request.setCharacterEncoding("gb2312");
		response.setContentType(CONTENT_TYPE);
		
		String topicid = request.getParameter("topicid");
		String sectionid = request.getParameter("sectionid");
		User user = (User) request.getSession().getAttribute("user");
		
		ITopic itopic = new TopicImpl();
		
		String result = itopic.updateTopic(user, new TopicImpl().selectTopicByTopicId(Integer.parseInt(topicid)), 0, -1);
		
		PrintWriter out = response.getWriter();
		out.print(topicid + " " + sectionid);
		
		if(result == null){
			out.print("<center><h2>程序运行出错</h2></center>"
	                +"<center><a href="+basePath+"page/index.jsp>3秒之后返回主页，没有跳转点击此处</a></center>");
				response.setHeader("refresh","3;url=../page/index.jsp");
		}
		
		else if(result.equals("true")){
			out.print("<center><h2>取消置顶成功</h2></center>"
	                  +"<center><a href="+basePath+"page/index.jsp>3秒之后返回主页，没有跳转点击此处</a></center>");
			response.setHeader("refresh","3;url=../page/index.jsp");
		}
		else{
			out.print("<center><h2>"+result+"</h2></center>"
	                  +"<center><a href="+basePath+"page/index.jsp>3秒之后返回主页，没有跳转点击此处</a></center>");
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
