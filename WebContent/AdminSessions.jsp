<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String uname=request.getParameter("uname");
	String pwd=request.getParameter("pwd");
	if(pwd.equals("priyanka")) {
		out.println("<body background='cool.jpg'>");
		out.println("<center>");
		out.println("<br><br><br><br>");
		out.println("<br><br><br><br>");
		out.println("<h2>successfully Login</h2>");
		out.println("<a href='Home.jsp'><h1>Click Here</h1></a><br><br>");
		out.println("</center>");
		out.println("</body>");
	}
	else {
		out.println("<body background='img2.jpg'>");
		out.println("<center>");
		out.println("<br><br><br><br>");
		out.println("<h2>wrong password!!!</h2>");
		out.println("<a href='AdminLogin.jsp'><h1>Try again</h1></a><br><br>");
		out.println("</center>");
		out.println("</body>");
	}
%>
