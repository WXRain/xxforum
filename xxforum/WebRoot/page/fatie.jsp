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
	
	function checkTopic(){
		var topic = document.getElementById("topic").value;
		if(topic.length == 0){
			alert("���ⲻ��Ϊ��");
			return false;
		}
		else if(topic.length > 15){
			alert("���ⲻ�ܴ���15����");
			return false;
		}
		else{
			return true;
		}
	}
	
	function checkText(){
		var text = document.getElementById("text").value;
		if(text.length > 1000){
			alert("���ݲ��ܳ���1000��");
			return false;
		}
		else{
			return true;
		}
	}
	function checkForm(){
		if(checkText() && checkTopic()){
			document.getElementById("submit").disabled=false;
		}
		else{
			document.getElementById("submit").disabled="disabled";
		}
	}
	</script>
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
    	String sectionid = request.getParameter("sectionid");
     %>
    <jsp:include page="top.jsp"></jsp:include>
    
    <form action="servlet/AddTopic" method="post">
    <center>����&nbsp;<input type="text" id="topic" name="topicName" onblur="checkTopic()"></input></center>
    	����������������<br/>
    	<textarea  style="resize:none" cols="150" rows="30" name="text" id="text" onblur="checkForm()"></textarea>
    		<center><input type="submit" value="��������" disabled="disabled" id="submit">&nbsp;
    			<input type="reset" value="����">
    			<input type='text' style='display:none;' name='sectionid' value=<%=sectionid%>></input></center>
    </form>
  </body>
</html>
