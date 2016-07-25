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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
	function checkTopic(){
		var topic = document.getElementById("topic").value;
		if(topic.length == 0){
			alert("标题不能为空");
			return false;
		}
		else if(topic.length > 15){
			alert("标题不能大于15个字");
			return false;
		}
		else{
			return true;
		}
	}
	
	function checkText(){
		var text = document.getElementById("text").value;
		if(text.length > 1000){
			alert("内容不能超过1000字");
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
    <center>标题&nbsp;<input type="text" id="topic" name="topicName" onblur="checkTopic()"></input></center>
    	请在下面输入内容<br/>
    	<textarea  style="resize:none" cols="150" rows="30" name="text" id="text" onblur="checkForm()"></textarea>
    		<center><input type="submit" value="发布帖子" disabled="disabled" id="submit">&nbsp;
    			<input type="reset" value="重置">
    			<input type='text' style='display:none;' name='sectionid' value=<%=sectionid%>></input></center>
    </form>
  </body>
</html>
