<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="register" type="mybean.Register" scope="request"/> 
<!DOCTYPE html>
<html>
<title>注册成功</title>
<head>
<table>
<td><A href="register.jsp"><font size=2>用户注册
</font></A></td>
<td><A href="Login.jsp"><font size=2>用户登录
</font></A></td>
</table>
<meta http-equiv="Content-Type" content="text/html;
charset=UTF-8">
<title>注册成功</title>
</head>
<body bgcolor=yellow><CENTER>
<Font size=4 color=blue >
 <BR><jsp:getProperty name="register"
property="backNews"/>
 </Font>
 <table>
<tr><td>用户名:</td>
 <td><jsp:getProperty name="register"
property="logname"/></td>
</tr>
</table>
</body>
</html>