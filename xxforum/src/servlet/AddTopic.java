package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.impl.TopicImpl;
import model.inter.ITopic;

import vo.Topic;
import vo.User;

public class AddTopic extends HttpServlet {
	
	private static final String CONTENT_TYPE="text/html; charset=gb2312";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		request.setCharacterEncoding("gb2312");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		String topicName = request.getParameter("topicName");
		String text = request.getParameter("text");
		String sectionid = request.getParameter("sectionid");
		
		ITopic itopic = new TopicImpl();
		Topic topic = new Topic();
		
		if(request.getSession().getAttribute("user") != null){
			
			User user = (User) request.getSession().getAttribute("user");
			//int userid = user.getId();
			
			/*
			 * 在这里调用发帖的接口，有成功和失败两种情况
			 */
			topic.setClickCount(0);
			topic.setIsFine(0);
			topic.setIsTop(0);
			topic.setReleaseDate(System.currentTimeMillis());
			topic.setLastReplyDate(System.currentTimeMillis());
			topic.setSectionId(Integer.parseInt(sectionid));
			topic.setTopicName(topicName);
			topic.setTopicText(text);
			topic.setUserId(user.getId());
			
			String result = itopic.addTopic(user, topic);
			if(result == null){
				out.print(" <center><h2>发布失败</h2></center>"
						+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
				response.setHeader("refresh","3;url=../page/index.jsp");
			}
			else if(result.equals("true")){
				out.print(" <center><h2>发布成功</h2></center>"
						+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
				response.setHeader("refresh","3;url=../page/index.jsp");
			}
			else{
				out.print(" <center><h2>"+result+"</h2></center>"
						+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
				response.setHeader("refresh","3;url=../page/index.jsp");
			}
		}
		else{
			response.sendRedirect("../page/quanxian.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
}
