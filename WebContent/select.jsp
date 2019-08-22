<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/student";
String database = "insertsrs";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<body background="img2.jpg">
<center><br><br><br><br>

<%-- <table border="4">
<tr>
<h1><td>first name</td>
<td>last name</td>
<td>roll NO</td>
<td>branch</td>
<td>year</td>
<td>dob</td>
<td>phone no</td></h1>
</tr> --%> 
<%
try{
String id = request.getParameter("id");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
statement=connection.createStatement();
PreparedStatement ps = connection.prepareStatement("SELECT * FROM insertsrs where rollno='"+id+"'");
resultSet = ps.executeQuery();
while(resultSet.next()){
%>
<tr>
<h2>first name :<%=resultSet.getString("fname") %><br>
last name  :<%=resultSet.getString("lname") %><br>
Gender:<%=resultSet.getString("Gender") %><br>
roll NO :<%=resultSet.getString("rollno") %><br>
branch :<%=resultSet.getString("branch") %><br>
year :<%=resultSet.getInt("year") %><br>
dob :<%=resultSet.getString("dod") %><br>
phone no :<%=resultSet.getString("phoneno") %><br>
</h2>
</tr>
 

<%
}

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
String id = request.getParameter("id");
session.setAttribute("id", id); 
out.println("<a href='modifyform.jsp'><h1>modify</h1></a>");
out.println("<a href='Home.jsp'><h1>Home Page</h1></a>");
%>
 <%-- </table>--%>
 
</center>
</body>
</html>