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
<h1><b>Insert Student Record</b></h1>
<br><br>
<form action="InsertStdFrom" method="post">
<table>
<tr>
<td><b>FirstName</b></td><td><input type="text" name="fname"></td></tr>
<tr><td><b>LastName</b></td><td><input type="text" name="lname"></td></tr>
<tr><td><b>Gender</b></td><td><input type="radio" name="gen" value="Female" > Female<br/>
<input type="radio" name="gen" value="Male">Male </td></tr>
<tr><td><b>RollNo</b></td><td><input type="text" name="rollno"></td></tr>
<tr><td><b>Branch</b></td><td><input type="text" name="branch"></td></tr>
<tr><td><b>year</b></td><td><input type="text" name="year"></td></tr>
<tr><td><b>DOB</b></td><td> <input type="text" placeholder="dd-mm-yyy" name="dob"></td></tr>
<tr><td><b>Phone no.</b></td><td><input type="text" name="phoneno"></td></table></tr><br><br>
<tr><td><input type="submit" value="ADD"></td></tr>
</table>
</form>
</center>
</body>
</html>
