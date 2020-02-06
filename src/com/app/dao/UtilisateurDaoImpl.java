package com.app.dao;

import java.sql.*;
import java.util.ArrayList;

import com.app.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
//	private static final String SQL_INSERT = "INSERT INTO user (email, password, nom) VALUES (?, ?, ?)";
	
    public DaoFactory daoFactory;
    

    public UtilisateurDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }


	@Override
	public int creer(Utilisateur utilisateur) throws IllegalArgumentException, DaoException {
		String SQL_INSERT = "INSERT INTO user" +
	            "  (login, motdepasse, nom, prenom) VALUES " +
	            " (?,?,?,?);";
		
	    int result = 0;
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {
			preparedStatement.setString(1, utilisateur.getEmail());
			preparedStatement.setString(2, utilisateur.getPassword());
			preparedStatement.setString(3, utilisateur.getNom());
			preparedStatement.setString(4, utilisateur.getPrenom());
	    	
			result = preparedStatement.executeUpdate() ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	    return result;
	}
	
	public void supprimer(int id) throws IllegalArgumentException, DaoException {
		String SQL_DELETE = "DELETE FROM user WHERE id=?";

	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_DELETE)) {
			preparedStatement.setInt(1, id);
	    	
			preparedStatement.executeUpdate() ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
    
	public static int getIdByEmail(String email) throws IllegalArgumentException, DaoException {
		String SQL_ID = "SELECT id from user WHERE login=?";
		int id = 0;
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_ID)) {
			preparedStatement.setString(1, email);
	    	
			ResultSet rs = preparedStatement.executeQuery() ;
			if(rs.next()) {
				id = rs.getInt("id");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return id;
	}
	
	public ArrayList<Utilisateur> AllUsers() throws IllegalArgumentException, DaoException {
		String SQL_USERS = "SELECT id, nom, prenom, login, role FROM user "
				+ "WHERE NOT role='admin';";
		
		ArrayList<Utilisateur> all = new ArrayList<Utilisateur>();
			    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_USERS)) {
			
	    	
	    	ResultSet rs = preparedStatement.executeQuery();
	    	
	    	while (rs.next()) {
	    		Utilisateur usr = new Utilisateur();
	    		usr.setId(rs.getInt("id"));
	    		usr.setNom(rs.getString("nom"));
	    		usr.setPrenom(rs.getString("prenom"));
	    		usr.setEmail(rs.getString("login"));
	    		usr.setRole(rs.getString("role"));
	    		all.add(usr);
	    	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return all ;
	    
	}


	@Override
	public void supprimer(Utilisateur utilisateur) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	
    
}