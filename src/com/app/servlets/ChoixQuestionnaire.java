package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.DaoFactory;
import com.app.dao.QuestionnaireDaoImpl;
import com.app.dao.Validate;

public class ChoixQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private QuestionnaireDaoImpl questionnaireDaoImpl;
    private DaoFactory daoFactory;

    public void init() {
    	questionnaireDaoImpl = new QuestionnaireDaoImpl(daoFactory);
    }
	
    public ChoixQuestionnaire() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] titles = questionnaireDaoImpl.findAll();
		request.setAttribute("titles",titles);
		
		HttpSession session = request.getSession();
		String complet = Validate.getName((String) session.getAttribute("email"));
		request.setAttribute("complet", complet);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/survey.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/survey.jsp").forward( request, response );
	}

}
