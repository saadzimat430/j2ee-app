package com.app.dao;

public interface QuestionDao {
	public String[] findBySurvey(String titre) throws DaoException;
}
