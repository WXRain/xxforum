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
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript">
	function nowTime(){
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth() + 1;
		var date = today.getDate();
		var hour = today.getHours();
		var minute = today.getMinutes();
		var second = today.getSeconds();
		
		var weekday = 0;
		switch(today.getDay()){
			case 0:
			weekday = "������";break;
			case 1:
			weekday = "����һ";break;
			case 2:
			weekday = "���ڶ�";break;
			case 3:
			weekday = "������";break;
			case 4:
			weekday = "������";break;
			case 5:
			weekday = "������";break;
			case 6:
			weekday = "������";break;
		}
		document.getElementById("time").innerHTML = "" + year + "��" + month + "��"+ date + "��&nbsp" 
												  + hour + ":" + minute + ":" + second + "&nbsp" 
												  + weekday;
		setTimeout("nowTime()", 1000);
	}
	</script>

  </head>
  
  <body onload="nowTime()">
    <%
    	String str = "";
    	if(session.getAttribute("user") == null){
    		str = "<form action = 'servlet/Login'  method = 'post' name = 'loginForm'>"
    		 +"<td >  �û��� &nbsp;</td>"
    		 + "<td ><input type='text' name=username>&nbsp;</td>"
    		 +"<td >���� &nbsp;</td>"
    		 +"<td ><input type='password' name=password>&nbsp;</td>"
    		 +"<td ><input type='submit' value='��¼'>&nbsp;</td>"
    		 +"<td ><a href='page/register.jsp'>ע��</a> &nbsp;</td>"
    		 +"</form>";
    	}
    	else{
    		User user = (User)(session.getAttribute("user"));
    		String name = user.getName();
    		str="<td> ��ӭ  <a href=page/user.jsp?userid="+user.getId()+"&pagintion=1>"+name+"</a>  | <a href='servlet/Exit'>�˳���¼</a> &nbsp;</td>";
    	}
     %>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30%">
					<a href="http:\\localhost:8080\xxforum\page\index.jsp">XX��̳</a><%=str %>
				</td>
				<td align="right"><div id="time"></div></td>
			</tr>
		</table>
     <hr/>
  </body>
</html>
