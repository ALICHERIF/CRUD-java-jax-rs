package com.adem.demoresttt;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import com.mysql.*;



public class Alienrepository {

	
	
	Connection con = null;
	
	public Alienrepository(){
		
		//String url = "jdbc:mysql://localhost:3306/restdb";
		//String username = "root";
		//String password ="";
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/restdb?user=root&password=ALICHERIFalichikh08082004");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("aaaaaaaaaaaaaaaa");
			e.printStackTrace();
		}
	    
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("ssssssssssssssss");
				e.printStackTrace();
			}
	    	
		
	}
   public List<Alien> getAliens() {
	   List<Alien> aliens = new ArrayList<>();
	   String sql = "select * from user";
	   try {
		   Statement  st = con.createStatement();
	      ResultSet rs = st.executeQuery(sql);
		 while(rs.next()) {
			 Alien a = new Alien();
			 a.setId(rs.getInt(1));
			 a.setFirstname(rs.getString(2));
			 a.setLastname(rs.getString(3));
			 a.setEmail(rs.getString(4));
			 aliens.add(a);
			 
		 }
	      
	      
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("mmmmmmmmmmmm");
	}
	  
	   
	   
	   
	   return aliens;
	
}
public Alien getAlien(int id) {
		
		
	   String sql = "select * from user where id="+id;
	   Alien a = new Alien();
	   try {
		   java.sql.Statement  st = con.createStatement();
	      ResultSet rs = st.executeQuery(sql);
	      
		 if(rs.next()) {
			 
			 a.setId(rs.getInt(1));
			 a.setFirstname(rs.getString(2));
			 a.setLastname(rs.getString(3));
			 a.setEmail(rs.getString(4));
			 
			 
		 }
	      
	      
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("gggggggg");
	}
	  
	   return a;
		
	}

public void create(Alien a1) {
	String sql = "insert into user values(?,?,?,?)";
	  try {
		  // java.sql.Statement  st = con.createStatement();
		  PreparedStatement st = con.prepareStatement(sql);
		 st.setInt(1, a1.getId());
		 st.setString(2, a1.getFirstname());
		 st.setString(3, a1.getLastname());
		 st.setString(4, a1.getEmail());
	      st.executeUpdate();
		
	      
	      
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("vvvvvvvv");
	}
}


public void update(Alien a1) {
	String sql1 = "update user set firstname=?,lastname=?,email=? where id=?;";
	  try {
		 
		  PreparedStatement st = con.prepareStatement(sql1);
		 st.setInt(4, a1.getId());
		 st.setString(1, a1.getFirstname());
		 st.setString(2, a1.getLastname());
		 st.setString(3, a1.getEmail());
		
	      st.executeUpdate();
		
	      
	      
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("uuuuuuuuuv");
	}
}
public void delete(int id) {
	// delete
	String sql2 = "delete from user where id=?";
	  try {
		 
		  PreparedStatement st = con.prepareStatement(sql2);
		 st.setInt(1, id);
		
		
	      st.executeUpdate();
		
	      
	      
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("deleteproblem");
	}
}
}
