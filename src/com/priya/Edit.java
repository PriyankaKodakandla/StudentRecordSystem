package com.priya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/edit")
public class Edit extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String str=(String) session.getAttribute("id");
		System.out.println(str);
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gen");
		String rollno=request.getParameter("rollno");
		String branch=request.getParameter("branch");
		int year=Integer.parseInt(request.getParameter("year"));
		String dod=request.getParameter("dod");
		String phoneno=request.getParameter("phoneno");
        Connection conn=null;
 
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", ""); 
            PreparedStatement pst1 = conn1.prepareStatement("update  insertsrs  set fname=?, lname=?, Gender=?, rollno=?,branch=?, year=?, dod=?, phoneno=? where rollno='"+str+"'");
			  pst1.setString(1,fname);  
	          pst1.setString(2,lname); 
	          pst1.setString(3, gender);
	          pst1.setString(4,rollno);
	          pst1.setString(5,branch);
	          pst1.setInt(6,year);
	          pst1.setString(7,dod);
	          pst1.setString(8,phoneno);
	          int i=pst1.executeUpdate();
	         // out.println("exectuted");
	          if(i!=0){ 
	        	  out.println("<body background='img2.jpg'>");
	      		  out.println("<center>");
	      		  out.println("<br><br><br><br>");
	              out.println( "<font size='6' color=blue><h2>updated sucessfully</h2></font>");
	         	 out.println("<a href='Home.jsp'><h1>Home Page</h1></a>");
	              out.println("</center>");
	      		  out.println("</body>");
	              }  
	          pst1.close();
			// stmt.close();
			conn1.close();
 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
