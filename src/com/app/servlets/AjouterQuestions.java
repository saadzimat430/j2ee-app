package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.beans.Questionnaire;
import com.app.dao.DaoFactory;
import com.app.dao.QuestionDaoImpl;
import com.app.dao.QuestionnaireDaoImpl;


public class AjouterQuestions extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private QuestionDaoImpl questionDaoImpl;
    private DaoFactory daoFactory;

    QuestionnaireDaoImpl questionnaireDaoImpl = new QuestionnaireDaoImpl(daoFactory);

    public void init() {	
    	questionDaoImpl = new QuestionDaoImpl(daoFactory);
    }

	public AjouterQuestions() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = null ;
		String description = null ;

		try {
			titre = request.getParameter("titre");
			description = request.getParameter("description");
		} catch (Exception e) {
		}		
		Questionnaire questionnaire = new Questionnaire();
        questionnaire.setDateCreation(java.time.LocalDate.now().toString());
        questionnaire.setDescription(description);
        questionnaire.setTitre(titre);
        
        try {
        	questionnaireDaoImpl.creer(questionnaire);
        	request.setAttribute("titre", titre);
        } catch (Exception e) {
            e.printStackTrace();
        }
		this.getServletContext().getRequestDispatcher("/WEB-INF/addquestion.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String titre = request.getParameter("titre");
		
        
        try {
        	for(int i=1;i<10;i++) {
        		if(request.getParameter("question"+String.valueOf(i)) != null 
        				&& request.getParameter("question"+String.valueOf(i)) != "") {
        			String question = request.getParameter("question"+String.valueOf(i));
        			questionDaoImpl.addQuestion(question, titre);
        		} else {
        			if(i==9) {
            			this.getServletContext().getRequestDispatcher("/qsuccess.jsp").forward( request, response );
            		}
        			continue;
        		}
        	}
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addquestion.jsp").forward( request, response );
	}

}
