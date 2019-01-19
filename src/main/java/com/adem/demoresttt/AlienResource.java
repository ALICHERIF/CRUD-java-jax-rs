package com.adem.demoresttt;

import java.util.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




@Path("users")
public class AlienResource 
{
	
	
	Alienrepository repo = new Alienrepository();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	
	public List<Alien> getAliens() 
	{
		System.out.println("getAlien called");
		
	    
	  
	return repo.getAliens();
	}
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien(@PathParam("id") int id)
	{
		return repo.getAlien(id);
	}
	
	
	@POST
	@Path("user")
	public Alien createAlien(Alien a1) {
		
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("user")
	public Alien updateAlien(Alien a1) {
		
		System.out.println(a1);
		if (repo.getAlien(a1.getId()).getId()==0) {
			repo.create(a1);
		}
		else {
		repo.update(a1);
		}
		return a1;
	}
	
	@DELETE
	@Path("user/{id}")
	public Alien killAlien(@PathParam("id") int id) {
		
		Alien a = repo.getAlien(id);
		if (a.getId()!=0) {
			repo.delete(id);
		}
		
		return a;
	}
}
