<%@page import="vo.Topic"%>
<%@page import="servlet.SUser"%>
<%@page import="model.impl.UserImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="vo.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>xx论坛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	User user = new User();
    	if(session.getAttribute("user") == null){
    		
    		response.sendRedirect("quanxian.jsp");
    		return;
    	}
    	else{
    		user = (User) session.getAttribute("user");
    	}
     %>
     <jsp:include page="top.jsp"></jsp:include>
     
     <%
     	String userid = request.getParameter("userid");
     	user = new UserImpl().findUserByAttribute("id", userid);
     	
     	String pagintion = request.getParameter("pagintion");
     	int pages = Integer.parseInt(pagintion);
     	
     	Vector<Topic> topics;
      %>
     
     <table border="0" style="text-align: center;" cellspacing="3">
			<tr>
				<td align="center">等级：<%=user.getLevel() %></td>
			</tr>
			<tr>
				<td align="center">积分：<%=user.getExp() %></td>
			</tr>
			<tr>
				<td align="center"><%= user.getName()%>的帖子</td>
			</tr>
		</table>
		<hr/>
		<%
			SUser suser = new SUser(Integer.parseInt(userid));
			topics = suser.getTopics();
			if(topics == null){
				out.print("<center>该用户暂时没有发布任何帖子</center><br/>");
			}
			else{
			
				out.print("<table width='100%'>");
				out.print("<tr><td width='50%'><center>主题</center></td>"
           				+"<td width='50%'><center>最新回复时间</center></td></tr>");
           		out.print("<tr><td colspan='2'><hr/></td></tr>");
				
				for(int i = (pages-1) * suser.getPageSize(); i < pages*suser.getPageSize() && i < topics.size(); i++){
						
					out.print("<tr><td width='50%'><center><a href="+basePath+"page/topic.jsp?topicid="+topics.get(i).getId()+"&pagintion=1>"+topics.get(i).getTopicName()+"</a></center></td>"
							+"<td width='50%'><center>"+topics.get(i).getLastReplyDateToString()+"</center></td></tr>");
				}
				out.print("<tr><td colspan='2'><hr/></td></tr>");
				out.print("</table>");
				if(pages > 1){
					out.print("<a href="+basePath+"page/user.jsp?userid="+user.getId()+"&pagintion="+(pages-1)+">上一页</a>");
				}
				out.print("当前是第"+pages+"页,共有"+ suser.getPageNum()+"页");
				if(pages < suser.getPageNum()){
					out.print("<a href="+basePath+"page/user.jsp?userid="+user.getId()+"&pagintion="+(pages+1)+">下一页</a>");
				}
			}
		 %>
		
		 
  </body>
</html>
