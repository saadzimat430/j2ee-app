package com.app.dao;

import java.sql.*;


public class Validate {
    public static boolean checkUser(String email,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
            PreparedStatement ps = con.prepareStatement("select * from user where login=? and motdepasse=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }
    
    public static String getName(String email) throws IllegalArgumentException, DaoException {
		String SQL_NAME = "SELECT nom,prenom from user WHERE login=?";

	    String complet=null;
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_NAME)) {
			preparedStatement.setString(1, email);
	    	
			ResultSet rs = preparedStatement.executeQuery();
	    	
	    	if (rs.next()) {
		    	complet = rs.getString("nom") + " " + rs.getString("prenom");
	    	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	    return complet;
	}
    
    public static String getRole(String email) throws IllegalArgumentException, DaoException {
		String SQL_ROLE = "SELECT role from user WHERE login=?";

	    String role=null;
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_ROLE)) {
			preparedStatement.setString(1, email);
	    	
			ResultSet rs = preparedStatement.executeQuery();
	    	
	    	if (rs.next()) {
		    	role = rs.getString("role");
	    	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	    return role;
	}
}
