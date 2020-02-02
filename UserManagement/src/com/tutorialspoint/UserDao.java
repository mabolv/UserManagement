package com.tutorialspoint;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;


public class UserDao { 
	private static Connection con = DB.getConnection();
	
	 public static List<User> getAllUsers() throws SQLException{ 
     List<User> userList = null;  
     
     
     PreparedStatement stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS user (id int, name varchar(255), profession varchar(255))");
     stat.executeUpdate();
     
     PreparedStatement statm = con.prepareStatement("SELECT * FROM user");
     ResultSet rs = statm.executeQuery();
 
     
     if(rs.next()==false) {
    	 PreparedStatement sta = con.prepareStatement("INSERT INTO user (id, name, profession) VALUES ('1', 'Mahesh', 'Teacher')");
         sta.executeUpdate();
         System.out.println("h");
     }
     
     PreparedStatement sta = con.prepareStatement("SELECT * FROM user");
     ResultSet s = sta.executeQuery();
     
	    while (s.next()){
	        int id = s.getInt("id");
	        String name = s.getString("name");
	        String prof = s.getString("profession");

	        User user = new User(id, name, prof);
	        userList = new ArrayList<User>(); 
	        userList.add(user);  	        
	    	}
     
	    return userList;
     
   }
	 
}