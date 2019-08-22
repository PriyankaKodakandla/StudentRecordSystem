<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="img2.jpg">
<center>
<%   Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
String id=(String)session.getAttribute("id");
PreparedStatement st=con.prepareStatement( "select * from insertsrs where rollno = ?");
st.setString(1, id);
ResultSet rs = st.executeQuery();
 %>
<%while(rs.next()){

%>
 
<form  action="edit" method="post">
<table>
<tr><td><b>FirstName:</b></td><td><input type="text" name="fname" name="fname" value="<%=rs.getString(1)%>"/></td></tr><br> 
<tr><td><b>LastName:</b></td><td><input type="text" name="lname" name="lname" value="<%=rs.getString(2) %>"/></td></tr><br>
<tr><td><b>Gender:</b></td><td><input type="text" name="gen" name="gen" value="<%=rs.getString(3) %>"/></td></tr><br>
<tr><td><b>RollNo:</b></td><td>   <input type="text" name="rollno" name="rollno" value="<%=rs.getString(4) %>"/></td></tr><br>
<tr><td><b>Branch:</b></td><td>  <input type="text" name="branch" name="branch" value="<%=rs.getString(5) %>"/></td></tr><br>
<tr><td><b>year:</b></td><td><input type="text" name="year" value="<%=rs.getInt(6) %>"/></td></tr><br>
<tr><td><b>DOB:</b></td><td><input type="text" name="dod"  name="dod" value="<%=rs.getString(7) %>"/></td></tr><br>
<tr><td><b>Phoneno.:</b></td><td><input type="text"name="phoneno" name="phoneno" value="<%=rs.getString(8) %>"/></td></tr><br>
<tr><td><input type="submit" value="modify"/></td></tr>
</table>
</form>
<%} 
%>
</center>
</body>
</html>
