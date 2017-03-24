package com.niit.loginapp.dao;

public class LoginDAO {
	
		// write simple method which taken two parameters and return true or false
	
	
	public boolean  isValidCredentials(String USERID,String password){
		
		//Get the connection, and write query, and execute query
		
		//Temporarily assuming id and pass is niit
		
		if(USERID.equals("niit")&& password.equals("niit")){
			 return true;		 
		}
		else
		{
		return	false;
		}
		
		
		
		
	}
	
	

}
