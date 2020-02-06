package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.app.beans.Answer;
import com.app.beans.Utilisateur;

public class ReponsesDaoImpl implements ReponsesDao {

	public DaoFactory daoFactory;
    
    public ReponsesDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	public static int creer(String reponse, String date_reponse, int id_question, int id_user) throws IllegalArgumentException, DaoException {
		String SQL_INSERT = "INSERT INTO reponse" +
	            "  (reponse, date_reponse, id_question, id_user) VALUES " +
	            " (?,?,?,?);";
		
		int result=0;
			    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {
			preparedStatement.setString(1, reponse);
			preparedStatement.setString(2, date_reponse.toString());
			preparedStatement.setInt(3, id_question);
			preparedStatement.setInt(4, id_user);
	    	
			result = preparedStatement.executeUpdate() ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return result;
	}
	
	public ArrayList<Utilisateur> UsersWhoAnswered() throws IllegalArgumentException, DaoException {
		String SQL_USERS = "SELECT id, nom, prenom FROM user "
				+ "WHERE id IN (SELECT DISTINCT id_user FROM reponse);";
		
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
	    		all.add(usr);
	    	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return all ;
	    
	}
	
	public ArrayList<Answer> GetAnswersByUser(int id) throws IllegalArgumentException, DaoException {
		String SQL_ANS = "SELECT r.reponse , r.date_reponse , q.question FROM reponse r " + 
				"JOIN question q ON r.id_question=q.id WHERE r.id_user=?;";
		
		ArrayList<Answer> all = new ArrayList<Answer>();
			    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_ANS)) {
	    	preparedStatement.setInt(1, id);
	    	
	    	ResultSet rs = preparedStatement.executeQuery();
	    	
	    	
	    	while (rs.next()) {
	    		Answer ans = new Answer();
	    		ans.setAnswer(rs.getString("reponse"));
	    		ans.setDate(rs.getString("date_reponse"));
	    		ans.setQuestion(rs.getString("question"));
	    		all.add(ans);
	    	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return all ;
	    
	}
}
