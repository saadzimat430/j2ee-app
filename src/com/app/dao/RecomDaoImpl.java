package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.app.beans.Recommandation;

public class RecomDaoImpl {
	public DaoFactory daoFactory;
    

    public RecomDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	public void creer(Recommandation recom, int id) throws IllegalArgumentException, DaoException {
		String SQL_INSERT = "INSERT INTO recommandation (description, date_envoi,id_user)"
				+ "VALUES (?,?,?);";
		
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {
			preparedStatement.setString(1, recom.getDescription());
			preparedStatement.setString(2, recom.getDateEnvoi());
			preparedStatement.setInt(3, id);
	    	
			preparedStatement.executeUpdate() ;
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static ArrayList<Recommandation> usersRecom(String email) throws IllegalArgumentException, DaoException {
		String SQL_SELECT = "SELECT description, date_envoi FROM recommandation "
				+ "WHERE id_user=(SELECT id FROM user WHERE login=?);";
		ArrayList<Recommandation> recom = new ArrayList<Recommandation>();
		
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_SELECT)) {
			preparedStatement.setString(1, email);
	    	
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				Recommandation rec = new Recommandation();
				rec.setDescription(rs.getString("description"));
				rec.setDateEnvoi(rs.getString("date_envoi"));
				recom.add(rec);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recom;	
	}
}
