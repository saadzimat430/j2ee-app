package com.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.DaoFactory;
import com.app.dao.QuestionDaoImpl;
import com.app.dao.ReponsesDaoImpl;
import com.app.dao.UtilisateurDaoImpl;
import com.app.dao.Validate;

public class Reponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDaoImpl questionDaoImpl;
    private DaoFactory daoFactory;

    public void init() {
    	questionDaoImpl = new QuestionDaoImpl(daoFactory);
    }   

    public Reponse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("title").toString();
		String[] questions = questionDaoImpl.findBySurvey(titre);
		request.setAttribute("questions", questions);
		
		String[] reponses = {"true", "false"};
		request.setAttribute("reponses", reponses);
		
		HttpSession session = request.getSession();
		String complet = Validate.getName((String) session.getAttribute("email"));
		request.setAttribute("complet", complet);
		
		int id = UtilisateurDaoImpl.getIdByEmail((String) session.getAttribute("email"));
		String str = Integer.toString(id);
		request.setAttribute("id_user", str);

//		try {
//			String[] answers = request.getParameterValues("reponse");
//			
//			for(int i = 0; i < answers.length; i++)
//			{
//				ReponsesDaoImpl.creer(Boolean.parseBoolean(answers[i]), java.time.LocalDate.now().toString(), 1, id);
//			}
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/answer.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = UtilisateurDaoImpl.getIdByEmail((String) session.getAttribute("email"));
		
		try {
			String titre = request.getParameter("title").toString();
			String[] questions = questionDaoImpl.findBySurvey(titre);
			String[] answers = request.getParameterValues("reponse");
			
			for(int i = 0; i < answers.length; i++)
			{
				if(ReponsesDaoImpl.creer(answers[i], java.time.LocalDate.now().toString(),
						QuestionDaoImpl.getIdFromTitle(questions[i]), id) == 0) {
						this.getServletContext().getRequestDispatcher("/WEB-INF/answer.jsp").forward( request, response );
				}
				else {
					if (i==answers.length-1) {
						this.getServletContext().getRequestDispatcher("/success.jsp").forward( request, response );
					}
				}
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

}
