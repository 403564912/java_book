package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.Register;

/**
 * Servlet implementation class HandelRegister
 */
@WebServlet("/HandelRegister")
public class HandleRegister extends HttpServlet {
 private static final long serialVersionUID = 1L;

 public HandleRegister() {
 super();

 }

 public void init(ServletConfig config) throws
ServletException {
 super.init(config);
 //1.加载 JDBC 数据库驱动程序
 try {
 Class.forName("com.mysql.jdbc.Driver");
 }
 catch(Exception e){}
 }


 protected void doGet(HttpServletRequest request, 
HttpServletResponse response) throws ServletException,
IOException {
 request.setCharacterEncoding("UTF-8");

response.setContentType("text/html;charset=UTF-8");
 response.setCharacterEncoding("UTF-8");
 Connection con;
 PreparedStatement sql;
 Register reg=new Register();
 request.setAttribute("register",reg);
 String
logname=request.getParameter("logname").trim(),

password=request.getParameter("password").trim();

 if(logname==null)
 logname="";
 if(password==null)
 password="";
 boolean isLD=true;

 boolean 
boo=logname.length()>0&&password.length()>0&&isLD;
 String backNews="";
 try{
 String uri="jdbc:mysql://127.0.0.1:3306/test?"+

"user=Test&password=1008611&characterEncoding=utf-8";
 //2.建立与指定数据库 test 的连接对象 con
 con=DriverManager.getConnection(uri);
 String insertCondition="INSERT INTO user VALUES (?,?)";
 //3.利用 con 对象调用 prepareStatement 方法生成用于执行 SQL 语句的对象

sql=con.prepareStatement(insertCondition);
 if(boo){
	 sql.setString(1,logname);//利用 sql 对象调用 set 方法设置？所代表的具体值
	 sql.setString(2,password);
 //3.数据库操作对象sql调用executeUpdate()方法并返回成功的记录条数 
 int m=sql.executeUpdate();
 if(m!=0){
 backNews="注册成功";
 reg.setBackNews(backNews);
 reg.setLogname(logname);
 reg.setPassword(password);

 }
 }
 else{
 backNews="信息填写不完整或名字中有非法字符";
 reg.setBackNews(backNews);
 }
 //5.释放资源
 sql.close();
 con.close();
 }
 catch(SQLException exp){
 backNews="该名字已被使用，请您更换名字"+exp; 
 reg.setBackNews(backNews);
 }
 RequestDispatcher dispatcher=
 request.getRequestDispatcher("show.jsp");// 转发
 dispatcher.forward(request,response);
 }
 protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException,
IOException {
 doGet(request,response);
 }
}
