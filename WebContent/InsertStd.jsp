<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String rollno=request.getParameter("rollno");
	String branch=request.getParameter("branch");
	String year=request.getParameter("year");
	String dob=request.getParameter("dob");
	String phoneno=request.getParameter("phoneno");
	System.out.println(fname);
	Class.forName("com.mysql.jdbc.Driver"); 
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","",""); 
	Statement st= con.createStatement(); 
	st.executeUpdate("insert in to insertsrs  values(fname,lname,rollno,branch,year,dob,phoneno)"); 
	st.close();
	con.close();
%>