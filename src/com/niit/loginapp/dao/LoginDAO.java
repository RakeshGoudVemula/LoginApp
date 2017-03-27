package com.niit.loginapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import com.niit.loginapp.config.DBConnection;

public class LoginDAO {

	// write simple method which taken two parameters and return true or false


	public boolean  isValidCredentials(String USERID,String password){

		//Get the connection, and write query, and execute query

		//Temporarily assuming id and pass is niit

		Connection con=DBConnection.getDBConnection();
		try{
			PreparedStatement pst=	con.prepareStatement("selct * from TUSER where id= ? and password=?");
			pst.setString(1, USERID);
			pst.setString(2, password);
			ResultSet resultset= pst.executeQuery();
			if(resultset.next()){
				return true;

			}
			else{
				return false;
			}

		}

		catch(SQLException e){
			e.printStackTrace();

		}
		return false;

	}


public void getAllUsers(){
	Connection con=DBConnection.getDBConnection();
	try{
		Statement stmt=con.createStatement();
		ResultSet resultset=stmt.executeQuery("execute * from tuser");
		while(resultset.next()){
			System.out.println(resultset.getString(1)+"/t");
			System.out.println(resultset.getString(2));
		}
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
}
}
