<%@ page language="java" import="java.util.*" %>
<%@ page pageEncoding="gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>xx论坛用户注册 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" >
	
		function divValue(elementId){
			return document.getElementById(elementId).value;
		}
		
		function divId(elementId){
			return document.getElementById(elementId);
		}
		
		function checkUser(){
			var username = divValue("username");
			var usernameCue = divId("username_cue");
			
			usernameCue.innerHTML = "";
			
			var reg = /[a-zA-Z0-9]{6,20}/;
			
			if(reg.test(username) == true){
				
				return true;
			}
			else{
				usernameCue.innerHTML = "用户名不符合要求";
				usernameCue.style.color = "red";
				return false;
			}
		}
		
		function checkFirstPassword(){
			
			var firstPassword = divValue("firstPassword");
			var firstPasswordCue = divId("first_password_cue");
			
			var reg = /.{6,18}/;
			
			//检查密码难度
// 			var reg1 = /[a-z]{6,18} /;//| [0-9]{6,18} | [A-Z]{6,18}/;
// 			var reg2 = /[a-zA-Z]{6,18} | [a-z0-9]{6,18} | [0-9A-Z]{6,18}/;
// 			var reg3 = /[a-zA-Z0-9]{6,18} | [^a-zA-Z0-9]{1,18}/;
			
			if(reg.test(firstPassword) == false){
				
				firstPasswordCue.innerHTML = "密码不能为空，长度在6-18位";
				firstPasswordCue.style.color = "red";
				return false;
			}
			else{
			//检查密码难度
// 				if(reg1.test(firstPassword) == true){
// 					firstPasswordCue.innerHTML = "密码难度简单";
// 					firstPasswordCue.style.color = "blue";
// 				} 
// 				else if(reg2.test(firstPassword == true)){
// 					firstPasswordCue.innerHTML = "密码难度中等";
// 					firstPasswordCue.style.color = "blue";
// 				}
// 				else if(reg3.test(firstPassword == true)){
// 					firstPasswordCue.innerHTML = "密码难度困难";
// 					firstPasswordCue.style.color = "blue";
// 				}
// 				else
					firstPasswordCue.innerHTML = "";
			}
			return true;
		}
		
		function checkSecondPassword(){
		
			var firstPassword = divValue("firstPassword");
			var secondPassword = divValue("secondPassword");
			var secondPasswordCue = divId("second_password_cue");
			
			secondPasswordCue.innerHTML = "";
			
			if(firstPassword == secondPassword){
				return true;
			}
			else{
			
				secondPasswordCue.innerHTML = "两次输入的密码不一致";
				secondPasswordCue.style.color = "red";
				return false;
			}
			
		}
		
		function checkName(){
			
			var name = divValue("name");
			var nameCue = divId("name_cue");
			
			
			var reg = /[^\b]{1,18}/;
			
			nameCue.innerHTML = "";
			
			if(reg.test(name) == true){
				if(checkFirstPassword() == true && checkSecondPassword() == true && checkUser() == true){
					document.getElementById("submit").disabled = false;
				}
				else{
					document.getElementById("submit").disabled = "disabled";
				}
				return true;
			}
			else{
			
				nameCue.innerHTML = "昵称不符合要求";
				nameCue.style.color = "red";
				return false;
			}
		}
		
		function checkForm(){
			//检查整个表是否符合要求
			if(checkUser() && checkFirstPassword() && checkSecondPassword() && checkName()){
				document.getElementById("submit").disabled = false;
			}
			else{
				
				document.getElementById("submit").disabled = "disabled";
			}
		}
		
	</script>

  </head>
  
  <body>
    	<jsp:include page="top.jsp"></jsp:include>
    	
    	<form action = "servlet/Register" method = "post" name="registerForm">
    		<table>
	    		<tr>
					<td align="right" width="40%">用户名:</td>
					<td align="left" width="14%"><input id="username" type="text" name="username" onblur="checkForm()"></td>
					<td align="left" ><div id="username_cue" ><font color=blue>用户名由英文字母和数字组成的6-20位字符，以字母开头</font></div></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td align="left"><input id="firstPassword" type="password" name="firstPassword" onblur="checkForm()" /></td>
					<td align="left"><div id="first_password_cue"><font color=blue>密码由6-18位字符组成</font></div></td>
				</tr>
				<tr>
					<td align="right">确认密码：</td>
					<td align="left"><input id="secondPassword" type="password" name="secondPassword" onblur="checkForm()" /></td>
					<td align="left"><div id="second_password_cue"><font color=blue></font></div></td>
				</tr>
				<tr>
					<td align="right" width="40%">昵称:</td>
					<td align="left" width="14%"><input id="name" type="text" name="name" onblur="checkForm()"></td>
					<td align="left" ><div id="name_cue" ><font color=blue></font></div></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td align="left" colspan="2">&nbsp;&nbsp;男<input type="radio" name="sex" checked="checked" value="1" >
					&nbsp;&nbsp;女<input type="radio" name="sex" value="0"></td>
				</tr>
				<tr>
					<td></td>
					<td align = "center">
						<input type="submit"  value="注册" id="submit" disabled="disabled"> 
						<input type="reset" value="重置" >
					</td>
					<td></td>
				</tr>
	    	</table>
    	</form>
  </body>
</html>
