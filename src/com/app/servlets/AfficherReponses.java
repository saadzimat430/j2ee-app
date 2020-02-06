package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.Answer;
import com.app.beans.Utilisateur;
import com.app.dao.DaoFactory;
import com.app.dao.ReponsesDaoImpl;


public class AfficherReponses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReponsesDaoImpl reponsesDaoImpl;
    private DaoFactory daoFactory;

    public void init() {
    	reponsesDaoImpl = new ReponsesDaoImpl(daoFactory);
    }   

    public AfficherReponses() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Utilisateur> names = reponsesDaoImpl.UsersWhoAnswered();

		request.setAttribute("names", names);

		HttpSession session = request.getSession();
		
		if(request.getParameter("id")!=null) {
			ArrayList<Answer> values = reponsesDaoImpl
					.GetAnswersByUser(Integer.valueOf(request.getParameter("id")));
			
			request.setAttribute("answers", values);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/showuseranswers.jsp").forward( request, response );
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/showanswers.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/showanswers.jsp").forward( request, response );
		
	}

}
