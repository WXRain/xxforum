<%@page import="servlet.SReply"%>
<%@page import="vo.Reply"%>
<%@page import="model.impl.ReplyImpl"%>
<%@page import="model.inter.IReply"%>
<%@page import="model.impl.UserImpl"%>
<%@page import="vo.User"%>
<%@page import="model.impl.TopicImpl"%>
<%@page import="model.inter.ITopic"%>
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
<script type="text/javascript">
	function show(i){
				if (document.getElementById("text"+i).style.display=='none'){
					document.getElementById("text"+i).style.display='block'; 
					document.getElementById("button"+i).style.display='block'; 
					document.getElementById("reply_message"+i).innerHTML = "�ظ���";
				}
				else{
					document.getElementById("text"+i).style.display='none'; 
					document.getElementById("button"+i).style.display='none'; 
					document.getElementById("reply_message"+i).innerHTML = "";
				}	
			}
</script>
  </head>
  
  <body>
  	<jsp:include page="top.jsp"></jsp:include>
  	
  	<%
  		String topicId = request.getParameter("topicid");
  		int topicid = Integer.parseInt(topicId);
  		
  		String pagintion = request.getParameter("pagintion");
  		int pages = Integer.parseInt(pagintion);
  		
  		User user = (User) request.getSession().getAttribute("user");
  		
  		Topic topic = new TopicImpl().selectTopicByTopicId(topicid);
  		
  		User topicUser = new UserImpl().findUserByAttribute("id", topic.getUserId() + "");
  		
  		if(topic == null){
  			out.print(" <center><h2>�����ӿ����Ѿ���ɾ��</h2></center>"
						+"<center><a href="+basePath+"page/index.jsp>3�뷵����ҳ��û�з��ص���˴�</a></center>");
				response.setHeader("refresh","3;url=../page/index.jsp");
  			return;
  		}
  		out.print("<center><font size=5><B>���⣺"+topic.getTopicName()+"</B></font>&nbsp;<font size=3>����ʱ�䣺"+topic.getReleaseDateToString()+"</font></center>");
  		out.print("<hr/>");
  	 %>
    
    
    <table width="100%">

    	<tr>
    		<td width="25%"><a href=<%=basePath %>page/user.jsp?userid=<%=topic.getUserId() %>&pagintion=1><%=topicUser.getName() %></a>��</td>
    		<td width="50%"></td>
    		<td width="25%"></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><%=topic.getTopicText() %></td>
    		<%
    			if(user == null) out.print("<td></td>");
    			else {
    				out.print("<td><a href='javascript:void(0);' onclick='show(0)'>�ظ�</a>&nbsp;</td>"
  	 					+"<form action='servlet/AddReply' method='post'>"
  	 					+"<div id='reply_message'></div>"
  	 					+"<textarea type='text' style='display:none;' name='text' id='text0' cols='150' rows='5'></textarea>&nbsp;"
  	 					+"<input type='submit' style='display:none;' id='button0' value='�ظ�'></input> "
  	 					+"<input type='text' style='display:none;' name='topicid' value="+topic.getId()+"></input>"
  	 					+"<input type='text' style='display:none;' name='userid' value="+user.getId()+"></input>"
  	 					+"<input type='text' style='display:none;' name='touserid' value='0'></input>"
  	 					+"<input type='text' style='display:none;' name='replyid' value=0></input>"
  	 					+"</form>");
    			}
    		 %>
    		
    	</tr>
    </table>
    <hr/>
    
<style type="text/css"> 
.AutoNewline 
{ 
  Word-break: break-all;/*����*/ 
} 
</style> 
    <table width="100%">
    <tr>
    	<td width="10%"></td>
    	<td width="15%"></td>
    	<td width="50%"></td>
    	<td width="10%"></td>
    	<td width="15%"></td>
    </tr>
    <%
    
    	IReply ireply = new ReplyImpl();
    	Vector<Reply> replys = ireply.selectReplyByTopicId(topic.getId());
    	
    	SReply sreply = new SReply(topic.getId());
    	
    	if(replys == null){
    		out.print("��������ʱû�лظ�");
    		return;
    	}
    	
    	for(int i = (pages - 1) * sreply.getPageSize(); i < replys.size() && i < pages * sreply.getPageSize(); i++){
    	
    		User nowUser = new UserImpl().findUserByAttribute("id", replys.get(i).getUserId()+"");
    		if(nowUser == null){
    			//System.out.println(replys.get(i).getUserId());
    		}
    		else{
    		//System.out.println(nowUser.getId());
    		out.print("<tr>");
    		out.print("<td>"+(i+1)+"¥��</td>");
    		out.print("<td><a href="+basePath+"page/user.jsp?userid="+nowUser.getId()+"&pagintion=1>"+nowUser.getName()+"</a>" );
    		if(replys.get(i).getTopicId() == 0) out.print("</td>");
    		else{
    			for(int j = 0; j < replys.size(); j ++){
    				if(replys.get(j).getId() == replys.get(i).getToReplyId()){
    					out.print("�ظ�" + (j+1) + "¥:");
    					break;
    				}
    				
    			}
    			out.print("</td>");
    		}
    		out.print("<td>"+replys.get(i).getText()+"</td>");
    		out.print("<td>"+replys.get(i).getDateToString()+"</td>");
    		if(user == null) out.print("<td></td>");
    		else{
    		
    		System.out.println("i:"+i);
    		System.out.println("toReplyId:"+replys.get(i).getId());
    		
	    		out.print("<td align='center'><a href='javascript:void(0);' onclick='show("+(i+1)+")'>�ظ�</a>&nbsp;</td>");
	    		out.print("<form action='servlet/AddReply' method='post'>"
	  	 					+"<div id='reply_message'></div>"
	  	 					+"<textarea type='text' style='display:none;' name='text' id='text"+(i+1)+"' cols='150' rows='5'></textarea>&nbsp;"
	  	 					+"<input type='submit' style='display:none;' id='button"+(i+1)+"' value='�ظ�'></input> "
	  	 					+"<input type='text' style='display:none;' name='topicid' value="+topic.getId()+"></input>"
	  	 					+"<input type='text' style='display:none;' name='userid' value="+user.getId()+"></input>"
	  	 					+"<input type='text' style='display:none;' name='touserid' value="+nowUser.getId()+"></input>"
	  	 					+"<input type='text' style='display:none;' name='replyid' value="+replys.get(i).getId()+"></input>"
	  	 					+"</form>");
	  	 	}
	  	 	out.print("</tr>");
  	 		out.print(" <tr><td colspan='5'><hr style='border: 1px dashed #ccc; width: 100%; height: 1px;' /></td></tr>");
  	 		}
    	}
     %>
<!--     <tr> -->
<!--     	<td colspan="5"><hr style="border: 1px dashed #ccc; width: 100%; height: 1px;" /></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--     	<td>2¥</td> -->
<!--     	<td><a href="user.jsp">��</a>�ظ�1¥��</td> -->
<!--     	<td class=AutoNewLine>zsokdfjlzksjdfoeijglsdhglsdlkfjzslkdjglsdzkjflkszjdflkszzsdlkgjzsldkdjflzskdjflzksjdflkzsjdflkzjsdlkfjzslkdfjlzksdjflkzsjdflkzsjdflkzjsdlkfjzslkdjflzskdjflzksdjflzksjdflkzsdjflkzsdfklzjjldkfjzlskdjflzskdjflzksjdflkzsjkhjszfoihjqwpijfwelakjlkszjdf</td> -->
<!--     	<td><center>2016-05-17 11:49:26</center></td> -->
<!--     	<td align="center"><a href=<%=basePath %>page/huifu.jsp>�ظ�</a></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--     	<td colspan="5"><hr style="border: 1px dashed #ccc; width: 100%; height: 1px;" /></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--     	<td>3¥</td> -->
<!--     	<td><a href="user.jsp">��</a>:</td> -->
<!--     	<td>djlkgjdmnbvokjg</td> -->
<!--     	<td><center>2016-05-17 11:49:26</center></td> -->
<!--     	<td align="center"><a href=<%=basePath %>page/huifu.jsp>�ظ�</a></td> -->
<!--     </tr> -->
    </table>
    <% 
    if(pages > 1){
		out.print("<a href="+basePath+"page/topic.jsp?topicid="+topic.getId()+"&pagintion="+(pages-1)+">��һҳ</a>");
	}
	out.print("��ǰ�ǵ�"+pages+"ҳ,����"+ sreply.getPageNum()+"ҳ");
	if(pages < sreply.getPageNum()){
		out.print("<a href="+basePath+"page/topic.jsp?topicid="+topic.getId()+"&pagintion="+(pages+1)+">��һҳ</a>");
	}
	%>
    <hr/>
  </body>
</html>
