package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.beans.Utilisateur;
import com.app.dao.DaoFactory;
import com.app.dao.UtilisateurDaoImpl;


public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUser() {
        super();
    }
    
    private UtilisateurDaoImpl utilisateurDaoImpl;
    private DaoFactory daoFactory;

    public void init() {
    	utilisateurDaoImpl = new UtilisateurDaoImpl(daoFactory);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Utilisateur> names = utilisateurDaoImpl.AllUsers();

		request.setAttribute("names", names);
		
		String id = request.getParameter("id");
		if (id != null) {
			try {
	        	utilisateurDaoImpl.supprimer(Integer.parseInt(id));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edituser.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edituser.jsp").forward( request, response );
	}

}
