<%@page import="vo.User"%>
<%@page import="model.impl.UserImpl"%>
<%@page import="model.inter.IUser"%>
<%@page import="servlet.Search"%>
<%@page import="model.impl.TopicImpl"%>
<%@page import="vo.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>xx��̳</title>
    
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
  
    <jsp:include page="top.jsp"></jsp:include>
    
    <%
    	String pagintion = request.getParameter("pagintion");
    	String searchText = new String(request.getParameter("searchText").getBytes("ISO-8859-1"),"gb2312"); 
    	int pages = Integer.parseInt(pagintion);

    	Search search = new Search(searchText);
    	
    	
     %>
     <table width="100%">
     	<tr>
     		<td width="40%">����</td>
     		<td width="40%">���»ظ�ʱ��</td>
     		<td width="20%">�����û�</td>
     	</tr>
     	<tr>
           <td colspan="3"><hr/></td>
       </tr>
       <% 
       Vector<Topic> topics = search.getTopics();
    	
    	if(topics == null){
    		out.print("<p><center>û�з��ϵ�����</center></p>");
    		return;
    	}
    	
    	
    	for(int i = (pages - 1) * search.getPageSize(); i < pages*search.getPageSize() && i < topics.size(); i++){
       			out.print("<tr>");
       			out.print("<td><a href="+basePath+"page/topic.jsp?topicid="+topics.get(i).getId()+"&pagintion=1>"+topics.get(i).getTopicName()+"</a></td>");
       			
       			out.print("<td>"+topics.get(i).getReleaseDateToString()+"</td>");
       			IUser iuser = new UserImpl();
       			User iuserName = iuser.findUserByAttribute("id", topics.get(i).getUserId()+"");
       			out.print("<td><a href="+basePath+"user.jsp?userid="+topics.get(i).getUserId()+"&pagintion=1.jsp>"+iuserName.getName()+"</a></td>");
       		}
       		out.print("<tr><td colspan='3'><hr/></td></tr>");
       %>
     </table>
		<% 
				if(pages > 1){
					out.print("<a href="+basePath+"page/search.jsp?searchText="+searchText+"&pagintion="+(pages-1)+">��һҳ</a>");
				}
				out.print("��ǰ�ǵ�"+pages+"ҳ,����"+ search.getPageNum()+"ҳ");
				if(pages < search.getPageNum()){
					out.print("<a href="+basePath+"page/search.jsp?searchText="+searchText+"&pagintion="+(pages+1)+">��һҳ</a>");
				}
		 %>
    
  </body>
</html>
