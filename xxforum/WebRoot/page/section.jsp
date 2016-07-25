<%@page import="servlet.SSection"%>
<%@page import="model.inter.IUser"%>
<%@page import="model.impl.UserImpl"%>
<%@page import="model.impl.TopicImpl"%>
<%@page import="model.inter.ITopic"%>
<%@page import="vo.Topic"%>
<%@page import="vo.Section"%>
<%@page import="model.impl.SectionImpl"%>
<%@page import="model.inter.ISection"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="vo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
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
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
  
  <%
  
  	User user = (User) session.getAttribute("user");
  	boolean isManager = false;
  	if(user == null || user.getIsManager() == 0){
  		isManager = false;
  	}
  	else{
  		isManager = true;
  	}
  	
  	String sectionId = request.getParameter("sectionid");
  	int sectionid = Integer.parseInt(sectionId);
  	
  	String pagintion = request.getParameter("pagintion");
  	int pages = Integer.parseInt(pagintion);
  	
  	//out.print("<center><font size=10>"++"</font>&nbsp;<font size=5><a href=");
   %>
  	
  	
  	<%
  		ISection isection = new SectionImpl();
  		Section section = isection.findSectionById(sectionid);
  		
  		out.print("<center><font size=10>"+section.getName()+"</font>&nbsp;<font size=5><a href="+basePath+"page/fatie.jsp?sectionid="+sectionid+">发帖</a></font>&nbsp;");
  		
  		if(isManager == true){
  			out.print("<font size=5><a href='javascript:void(0);' onclick='show()'>修改板块信息</a></font>&nbsp;"
  	 					+"<form action='servlet/EditSectionName' method='post'>"
  	 					+"<div id='name_message'></div>"
  	 					+"<input type='text' style='display:none;' name='name_text' id='name_text'/>&nbsp;"
  	 					+"<div id='introduce_message'></div>"
  	 					+"<input type='text' style='display:none;' name='introduce_text' id='introduce_text'/>&nbsp;"
  	 					+"<input type='submit' style='display:none;' id='button' value='修改'></input> "
  	 					+"<input type='text' style='display:none;' name='sectionid' value="+sectionid+"></input>"
  	 					+"</form>");
  		}
  	 %>
  	 &nbsp;<%=section.getIntroduce() %>
  	 </center>
    <hr/>
    
    
    <table width="100%">
       <tr>
           <td width="20%">主题</td>
           <td width="10%"></td>
           <td width="10%"></td>
           <td width="10%"></td>
           <td width="25%">最新回复时间</td>
           <td width="25%">发帖用户</td>
           
       </tr>
       <tr>
           <td colspan="6"><hr/></td>
       </tr>
       <%
       		ITopic itopic = new TopicImpl();
       		Vector<Topic> topics = itopic.selectTopicBySection(sectionid);
       		
       		SSection ssection = new SSection(sectionid);
       		
       		if(topics == null){
       			out.print("该板块暂时没有帖子");
       			return;
       		}
       		
       		for(int i = (pages - 1) * ssection.getPageSize(); i < pages*ssection.getPageSize() && i < topics.size(); i++){
       			out.print("<tr>");
       			out.print("<td><a href="+basePath+"page/topic.jsp?topicid="+topics.get(i).getId()+"&pagintion=1>"+topics.get(i).getTopicName()+"</a></td>");
       			if(user == null || user.getIsManager() != 1) out.print("<td></td>");
       			else out.print("<td><center><a href="+basePath+"servlet/Delete?topicid="+topics.get(i).getId()+"&sectionid="+sectionid+">删除</a></center></td>");
       			if(user == null || user.getIsManager() != 1){
       				if(topics.get(i).getIsFine() == 1){
       					out.print("<td><center>精华</center></td>");
       				}
       				else{
       					out.print("<td></td>");
       				}
       			}
       			else{
       				if(topics.get(i).getIsFine() == 1){
       					out.print("<td><center><a href="+basePath+"servlet/CancelTopicFine?topicid="+topics.get(i).getId()+"&sectionid="+sectionid+">取消精华</a></center></td>");
       				}
       				else{
       					out.print("<td><center><a href="+basePath+"servlet/AddTopicToFine?topicid="+topics.get(i).getId()+"&sectionid="+sectionid+">加精</a></center></td>");
       				}
       			}
       			
       			if(user == null || user.getIsManager() != 1){
       				if(topics.get(i).getIsTop() == 1){
       					out.print("<td><center>置顶</center></td>");
       				}
       				else{
       					out.print("<td></td>");
       				}
       			}
       			else{
       				if(topics.get(i).getIsTop() == 1){
       					out.print("<td><center><a href="+basePath+"servlet/CancelTopicTop?topicid="+topics.get(i).getId()+"&sectionid="+sectionid+">取消置顶</a></center></td>");
       				}
       				else{
       					out.print("<td><center><a href="+basePath+"servlet/AddTopicToTop?topicid="+topics.get(i).getId()+"&sectionid="+sectionid+">置顶</a></center></td>");
       				}
       			}
       			
       			out.print("<td>"+topics.get(i).getReleaseDateToString()+"</td>");
       			IUser iuser = new UserImpl();
       			User iuserName = iuser.findUserByAttribute("id", topics.get(i).getUserId()+"");
       			out.print("<td><a href="+basePath+"user.jsp?userid="+topics.get(i).getUserId()+"&pagintion=1.jsp>"+iuserName.getName()+"</a></td>");
       		}
       		out.print("<tr><td colspan='6'><hr/></td></tr>");
        %>
   </table>
   
   <%
   		if(pages > 1){
			out.print("<a href="+basePath+"page/section.jsp?sectionid="+sectionid+"&pagintion="+(pages-1)+">上一页</a>");
		}
		out.print("当前是第"+pages+"页,共有"+ ssection.getPageNum()+"页");
		if(pages < ssection.getPageNum()){
			out.print("<a href="+basePath+"page/section.jsp?sectionid="+sectionid+"&pagintion="+(pages+1)+">下一页</a>");
		}
    %>
    
  </body>
</html>
