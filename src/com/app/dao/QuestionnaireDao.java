package com.app.dao;

import com.app.beans.Questionnaire;

public interface QuestionnaireDao {

	String[] findAll() throws IllegalArgumentException, DaoException;

	void creer(Questionnaire questionnaire) throws IllegalArgumentException, DaoException;

}
