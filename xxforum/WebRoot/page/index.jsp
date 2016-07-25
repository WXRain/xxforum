<%@page import="model.impl.UserImpl"%>
<%@page import="model.inter.IUser"%>
<%@page import="vo.Topic"%>
<%@page import="model.impl.TopicImpl"%>
<%@page import="model.impl.SectionImpl"%>
<%@page import="vo.User"%>
<%@page import="model.inter.ITopic"%>
<%@ page language="java" pageEncoding="gb2312"%>
<%@ page import="java.util.*" %>
<%@ page import="model.inter.ISection" %>
<%@ page import="dao.impl.SectionDao" %>
<%@ page import="vo.Section" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = basePath+"page/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/style.css">
    <title>XX论坛 </title>
    <base href= "<%= basePath %>">
    	<script type="text/javascript">
	
		function show(){
				if (document.getElementById("name_text").style.display=='none'){
					document.getElementById("name_text").style.display='block'; 
					document.getElementById("introduce_text").style.display='block'; 
					document.getElementById("button").style.display='block'; 
					document.getElementById("name_message").innerHTML = "版块名：";
					document.getElementById("introduce_message").innerHTML = "介绍：";
				}
				else{
					document.getElementById("name_text").style.display='none'; 
					document.getElementById("introduce_text").style.display='none'; 
					document.getElementById("button").style.display='none'; 
					document.getElementById("name_message").innerHTML = "";
					document.getElementById("introduce_message").innerHTML = "";
				}	
			}
		
		
	</script>
    
  </head>
  
  <body>
  <jsp:include page="top.jsp"></jsp:include>

   <form action=<%=basePath %>page/search.jsp?pagintion=1 method="post">
   <input style="float:right;" id="searchButton" type="submit" name="searchButton" value="搜索">
   <input style="float:right;" id="search" type="text" name="searchText">
   </form>
   <div style="clear:both;"></div>
   <hr/>
   
   <table width="100%">
       <tr>
           <td width="50%">主题</td>
           <td width="25%">最新回复时间</td>
           <td width="25%">发帖用户</td>
           
       </tr>
       <tr>
           <td colspan="3"><hr/></td>
       </tr>
       
       <%
       
       		IUser iuser = new UserImpl();
       
       		ISection section = new SectionImpl();
       		Vector<Section> sections = section.selectAll();
       		
       		ITopic topic = new TopicImpl();
       		Vector<Topic> topics;
       		
       		if(sections == null){
       			
       			out.print("<center>没有版块</center>");
       			return;
       		}
       		
       		for(int i = 0; i < sections.size(); i++){
       			
       			out.println("<tr>");
       			out.print("<td colspan='3' align='center'><h2 align='center'><a href= "+ basePath + "page/section.jsp?sectionid="
       			+sections.get(i).getId()+"&pagintion=1>");
       			out.print(sections.get(i).getName());
       			out.println("</a></h2></td>");
       			out.println("<tr>");
       			
       			topics = topic.selectTopicBySection(sections.get(i).getId());
       			
       			if(topics == null){
	       			out.print("<center>该板块无帖子</center>");
	       			return;
       			}
       			
       			for(int j = 0; j < topics.size() && j < 3; j++){
       				
       				out.print("<tr>");
       				out.print("<td><a href="+basePath+"page/"
       				+"topic.jsp?topicid="+topics.get(j).getId()+"&pagintion=1>"
       				+topics.get(j).getTopicName()+"</a></td>");
       				out.print("<td>");
       				out.print(topics.get(j).getLastReplyDateToString());
       				out.print("</td>");
       				out.print("<td>");
       				out.print("<a href="+basePath+"page/user.jsp?userid="+topics.get(j).getUserId()+"&pagintion=1>"
       							+(iuser.findUserByAttribute("id", topics.get(j).getUserId()+"")).getName() + "</a>");
       				out.print("</td>");
       			}
       			
       			out.println("<tr><td colspan='3'><hr/></td></tr>");
       		}
        %>

   </table>
   <%
   		boolean isManager;
   		User user = (User) session.getAttribute("user");
   		if(user==null || user.getIsManager() == 0){
   			isManager = false;
   		}
   		else{
   			isManager = true;
   		}
   		if(isManager){
   			out.print("<center><a href='javascript:void(0);' onclick='show()'>添加板块</a></center>&nbsp;<br/>"
  	 					+"<form action='servlet/AddSection' method='post'>"
  	 					+"<div id='name_message'></div>"
  	 					+"<input type='text' style='display:none;' name='sectionname' id='name_text'/>&nbsp;"
  	 					+"<div id='introduce_message'></div>"
  	 					+"<input type='text' style='display:none;' name='sectionintroduce' id='introduce_text'/>&nbsp;"
  	 					+"<input type='submit' style='display:none;' id='button' value='增加'></input> "
  	 					+"</form>");
   		}
    %>
   
   
  </body>
</html>
