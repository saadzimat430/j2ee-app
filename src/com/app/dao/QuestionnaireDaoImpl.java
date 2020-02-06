package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.beans.Questionnaire;
import com.app.beans.Utilisateur;


public class QuestionnaireDaoImpl implements QuestionnaireDao {
	public DaoFactory daoFactory;
    
    public QuestionnaireDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public String[] findAll() throws DaoException {
		
		List<String> all = new ArrayList<String>();
		String SQL_FINDALL = "SELECT titre FROM questionnaire";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");){
	    	
	    	PreparedStatement ps = connexion.prepareStatement(SQL_FINDALL);
	        ResultSet rs = ps.executeQuery();
	    	
	    	while (rs.next()) {
	    	    all.add(rs.getString("titre"));
	    	}
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    String[] stringArray = all.toArray(new String[0]);

		return stringArray ;
		
	}

    public void creer(Questionnaire questionnaire) throws IllegalArgumentException, DaoException {
		String SQL_INSERT = "INSERT INTO questionnaire(titre, description, date_creation) VALUES(?,?,?);";
		ResultSet rs = null;
		
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	   
	    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
	    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_INSERT)) {
			preparedStatement.setString(1, questionnaire.getTitre());
			preparedStatement.setString(2, questionnaire.getDescription());
			preparedStatement.setString(3, questionnaire.getDateCreation());
	    	
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
