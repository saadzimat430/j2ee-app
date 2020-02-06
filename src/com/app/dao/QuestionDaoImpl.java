package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao{
	public DaoFactory daoFactory;
    
    public QuestionDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	public String[] findBySurvey(String titre) throws DaoException {
			
			List<String> questions = new ArrayList<String>();
			String SQL_FIND = "SELECT question FROM question " + 
					"JOIN questionnaire " + 
					"ON question.id_questionnaire = questionnaire.id " + 
					"WHERE questionnaire.id = (SELECT id FROM questionnaire WHERE titre=?);";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		    try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");){
		    	
		    	PreparedStatement ps = connexion.prepareStatement(SQL_FIND);
		    	ps.setString(1, titre);
		        ResultSet rs = ps.executeQuery();
		    	
		    	while (rs.next()) {
		    		questions.add(rs.getString("question"));
		    	}
		    	
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    String[] stringArray = questions.toArray(new String[0]);
	
			return stringArray ;
			
		}
	
	public static int getIdFromTitle(String title) throws DaoException {
		
		String SQL_FIND = "SELECT id FROM question WHERE question=?";
		int id=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
		    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_FIND)) {
				preparedStatement.setString(1, title);
		    	
				ResultSet rs = preparedStatement.executeQuery() ;
				if(rs.next()) {
					id = rs.getInt("id");
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		return id ;
		
	}
	
	public void addQuestion(String question, String titre) throws DaoException {
		
		String SQL_ADD = "INSERT into question (question,id_questionnaire) "
				+ "VALUES (?,(SELECT id FROM questionnaire WHERE titre=?));";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
		    	PreparedStatement preparedStatement = connexion.prepareStatement(SQL_ADD)) {
				preparedStatement.setString(1, question);
				preparedStatement.setString(2, titre);
		    	
				preparedStatement.executeUpdate();
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	}
}
