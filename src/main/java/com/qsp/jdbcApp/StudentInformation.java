package com.qsp.jdbcApp;

	import java.io.IOException;
    import java.sql.*;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;

	public class StudentInformation extends GenericServlet {

		@Override
		public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException, NumberFormatException {
			// Logic To Take Request And Send Response
			
            String Id= req.getParameter("nu");
            int sid = Integer.parseInt(Id);
			
	        
		    String Name=req.getParameter("nm");
			String Place=req.getParameter("pl");
			String Address=req.getParameter("ad");
			PrintWriter output=resp.getWriter();
			output.print("<html><body bgcolor='orange'>"+"<h1>Student Information:->"+
			sid+" "+Name+" "+Place+" "+Address+""+"</h1></body></html>");
			
		   String qry="insert into studentinfo.student values(?,?,?,?)";
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement(qry);

			
			pstmt.setInt(1,sid);
			pstmt.setString(2,Name);
			pstmt.setString(3,Place);
			pstmt.setString(4,Address);
			pstmt.executeUpdate();
			System.out.println("Information Inserted");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	}



