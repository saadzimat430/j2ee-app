package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.Recommandation;
import com.app.dao.DaoFactory;
import com.app.dao.RecomDaoImpl;
import com.app.dao.ReponsesDaoImpl;
import com.app.dao.Validate;
import com.app.mail.SendMail;


public class Recommander extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RecomDaoImpl recomDaoImpl;
    private DaoFactory daoFactory;

    public void init() {
    	recomDaoImpl = new RecomDaoImpl(daoFactory);
    }   

    public Recommander() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/recommandation.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String recom = request.getParameter("recom");
		
		Recommandation recommandation = new Recommandation();
		recommandation.setDescription(recom);
		recommandation.setDateEnvoi(java.time.LocalDate.now().toString());
		
		try {
        	recomDaoImpl.creer(recommandation,Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/recommandation.jsp").forward( request, response );
		
	}

}
