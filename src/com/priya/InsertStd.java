package com.priya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/InsertStdFrom")
public class InsertStd extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String fname=request.getParameter("fname");
		PrintWriter out=response.getWriter();
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gen");
		String rollno=request.getParameter("rollno");
		String branch=request.getParameter("branch");
		int year=Integer.parseInt(request.getParameter("year"));
		String dob=request.getParameter("dob");
		String phoneno=request.getParameter("phoneno");
	
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", ""); 
			//Statement stmt = conn.createStatement();
			//stmt.executeUpdate("insert into insertsrs  value(fame,lname,rollno,branch,year,dob,phoneno)");
			 PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into insertsrs values(?,?,?,?,?,?,?,?)");
			 pst.setString(1,fname);  
	          pst.setString(2,lname); 
	          pst.setString(3, gender);
	          pst.setString(4,rollno);
	          pst.setString(5,branch);
	          pst.setInt(6,year);
	          pst.setString(7,dob);
	          pst.setString(8,phoneno);
	          int i=pst.executeUpdate(); 
	          if(i!=0){ 
	        	  out.println("<body background='img2.jpg'>");
	      		  out.println("<center>");
	      		  out.println("<br><br><br><br>");
	              out.println( "<font size='6' color=blue><h2>Record has been inserted</h2></font>");
	              out.println("</center>");
	      		  out.println("</body>");
	              } 
	          out.println("<br><center>");
	        	 out.println("<a href='Home.jsp'><h1>Home Page</h1></a>");
	        	 out.println("</center>");
	          pst.close();
			// stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
