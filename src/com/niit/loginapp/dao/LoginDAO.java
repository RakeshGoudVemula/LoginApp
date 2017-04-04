package com.niit.loginapp.dao;

import java.sql.*;

import com.niit.loginapp.config.DBConnection;

public class LoginDAO {

	// write simple method which taken two parameters and return true or false


	public boolean  isValidCredentials(String USERID,String password){

		//Get the connection
		Connection con=DBConnection.getDBConnection();
		//write query
	try {
		PreparedStatement pStatement=	con.prepareStatement("select * from TUSER1 where id=? and password=? ");
		pStatement.setString(1, USERID);
		pStatement.setString(2, password);
		// execute query
		ResultSet resultset=pStatement.executeQuery();
		if(resultset.next()){
			return true;
		}
		else{
			return false;
		}
		
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
		
		
	

		//Temporarily assuming id and pass is niit

	}
}