package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.beans.Questionnaire;
import com.app.beans.Utilisateur;
import com.app.dao.DaoFactory;
import com.app.dao.QuestionnaireDaoImpl;
import com.app.dao.UtilisateurDaoImpl;
import com.app.mail.SendMail;


public class AjoutQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AjoutQuestionnaire() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/addsurvey.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addsurvey.jsp").forward( request, response );
	}

}
