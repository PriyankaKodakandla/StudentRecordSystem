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
@WebServlet("/deletestd")
public class DeleteStd extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 PrintWriter out = response.getWriter();
		 String id = request.getParameter("id");
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", ""); 
		 PreparedStatement ps = conn.prepareStatement("delete FROM insertsrs where rollno='"+id+"'");
		 int i = ps.executeUpdate();
		 if(i!=0){ 
       	      out.println("<body background='img.jpg'>");
     		  out.println("<center>");
     		  out.println("<br><br><br><br>");
              out.println( "<font size='6' color=blue>"+"<h2> has been deleted successfully.</h2></font>");
              out.println("<a href='Home.jsp'><h1>Home Page</h1></a>");
              out.println("</center>");
     		  out.println("</body>");
             }  
		 else {
				 out.println("<body background='img.jpg' color='#00bfff'>");
	    		 out.println("<center>");
	    		 out.println("<br><br><br><br><br><br>");
		         out.println( "<font size='6' color=red>"+"<h2>\tdata is not found</h2></font>");
		       	 out.println("<a href='Home.jsp'><h1>Home Page</h1></a>");
	             out.println("</center>");
	    		 out.println("</body>");
		 }
	        ps.close();
			conn.close();
		 }catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

