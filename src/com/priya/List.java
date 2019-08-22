package com.priya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/list")
public class List extends HttpServlet{
	private Object resultSet;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body background='img2.jpg'><center><br><br><br><br>");
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
			 PreparedStatement pst =(PreparedStatement) conn.prepareStatement("select *from insertsrs");
			 ResultSet rs= pst.executeQuery();
			 out.println("<table border=3");
			 out.println("<tr><th>FirstName</th><th>LastName</th><th>Gender</th><th>Rollno.</th><th>Branch</th><th>Year</th><th>DOB</th><th>Phoneno.</th><tr>");
			 while (rs.next()) {
                 String fn = rs.getString("fname");
                 String ln = rs.getString("lname");
                 String g=rs.getString("Gender");
                 String roll=rs.getString("rollno");
                 String br=rs.getString("branch");
                 int y = rs.getInt("year"); 
                 String dob=rs.getString("dod");
                 String ph=rs.getString("phoneno");
                 out.println("<tr><td>" + fn + "</td><td>" + ln + "</td><td>"+ g + "</td><td>" + roll + "</td><td>"+ br + "</td><td>" + y + "</td><td>" + dob + "</td><td>"+ph + "</td></tr>"); 
             }
			
        	 out.println("</table></center>");
        	 out.println("<br><center>");
        	 out.println("<a href='Home.jsp'><h1>Home Page</h1></a>");
        	 out.println("</center>");
             out.println("</html></body>");
             
             pst.close();
             conn.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
