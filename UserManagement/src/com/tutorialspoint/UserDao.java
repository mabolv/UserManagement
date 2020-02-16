package com.tutorialspoint;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;


public class UserDao { 
	private static Connection con = DB.getConnection();	
	
	public static String deleteUser(int id) throws SQLException {
		
		PreparedStatement stat = con.prepareStatement("DELETE FROM user WHERE id='"+id+"'");
	    int temp = stat.executeUpdate();
		
		return temp+" Person removed ";
	} 
	
	public static String addUser(String name,String prof) throws SQLException {
		
		PreparedStatement stat = con.prepareStatement("INSERT INTO user (name, profession) VALUES ('"+name+"', '"+prof+"')");
	    int temp = stat.executeUpdate();
		
		return temp+" Person added";
	} 
	
	 public static List<User> getAllUsers() throws SQLException{ 
     List<User> userList = null;
     
     PreparedStatement stat = con.prepareStatement("CREATE TABLE IF NOT EXISTS user (id int, name varchar(255), profession varchar(255))");
     stat.executeUpdate();
     
     PreparedStatement statm = con.prepareStatement("SELECT * FROM user");
     ResultSet rs = statm.executeQuery();
 
     if(rs.next()==false) {
    	 PreparedStatement sta = con.prepareStatement("INSERT INTO user (id, name, profession) VALUES ('1', 'Mahesh', 'Teacher')");
         sta.executeUpdate();
     }
     
     PreparedStatement sta = con.prepareStatement("SELECT * FROM user");
     ResultSet s = sta.executeQuery();
     
     int id;
     String name;
     String prof;
     
     userList = new ArrayList<User>(); 
     
	    while (s.next()){
	        id = s.getInt("id");
	        name = s.getString("name");
	        prof = s.getString("profession");

	        User user = new User(id, name, prof);
	        userList.add(user);  	        
	    	}
     
	    return userList; 
   }	 
}