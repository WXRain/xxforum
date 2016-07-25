package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Reply;

import model.impl.ReplyImpl;
import model.inter.IReply;

public class AddReply extends HttpServlet{
	
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
		
		String topicId = request.getParameter("topicid");
		int topicid = Integer.parseInt(topicId);
		
		String userId = request.getParameter("userid");
		int userid = Integer.parseInt(userId);
		
		String toUserId = request.getParameter("touserid");
		int touserid = Integer.parseInt(toUserId);
		
		String replyId = request.getParameter("replyid");
		int replyid = Integer.parseInt(replyId);
		
		String text = request.getParameter("text");
		
		IReply ireply = new ReplyImpl();
		Reply reply = new Reply();
		
		System.out.println(replyid);
		
		reply.setDate(System.currentTimeMillis());
		reply.setText(text);
		reply.setTopicId(topicid);
		reply.setToReplyId(replyid);
		reply.setToUserId(touserid);
		reply.setUserId(userid);
		
		String result = ireply.addReply(reply);
		
		if(result == null){
			out.print(" <center><h2>回复失败</h2></center>"
					+"<center><a href="+basePath+"page/index.jsp>3秒返回主页，没有返回点击此处</a></center>");
			response.setHeader("refresh","3;url=../page/index.jsp");
		}
		else if(result.equals("true")){
			out.print(" <center><h2>回复成功</h2></center>"
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
