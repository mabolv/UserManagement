package com.tutorialspoint;  

import java.sql.SQLException;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;  
@Path("/UserService") 

public class UserService {  
   UserDao userDao = new UserDao();  
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsers() throws SQLException{ 
      return UserDao.getAllUsers(); 
   }  
   
   @GET 
   @Path("/add") 
   public String addUser(@QueryParam("name") String name,@QueryParam("prof") String prof) throws SQLException{ 
      return UserDao.addUser(name,prof); 
   }  
   
   @GET 
   @Path("/delete") 
   public String deleteUser(@QueryParam("id") int id) throws SQLException{ 
      return UserDao.deleteUser(id); 
   } 
}