<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=UTF-8">
<title>注册</title>
</head>
<table>
<td><A href="register.jsp"><font size=2>用户注册
</font></A></td>
<td><A href="login.jsp"><font size=2>用户登录
</font></A></td>
</table>

<BODY bgcolor=cyan><Font size=2><CENTER>
<FORM action="register" method="get">
<table>
 输入您的信息，带*号项必须填写。
 <tr><td>用户名称:</td><td><Input type=text
name="logname" >*</td></tr>
 <tr><td>设置密码:</td><td><Input type=password
name="password">*</td></tr>
 <tr><td><Input type=submit name="g" value="提交
"></td></tr>
</table>
</FORM>
</CENTER>
</Font>
</BODY>
</html>