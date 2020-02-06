package com.app.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.beans.Utilisateur;
import com.app.dao.DaoFactory;
import com.app.dao.UtilisateurDaoImpl;
import com.app.mail.SendMail;

public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurDaoImpl utilisateurDaoImpl;
    private DaoFactory daoFactory;

    public void init() {	
        utilisateurDaoImpl = new UtilisateurDaoImpl(daoFactory);
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
		String dt = ft.format(d);
		request.setAttribute("dt", dt);
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward( request, response );

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Utilisateur user = new Utilisateur();
        user.setEmail(email);
        user.setPassword(password);
        user.setNom(nom);
        user.setPrenom(prenom);
        
        try {
        	utilisateurDaoImpl.creer(user);
        	SendMail.SendTo(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward( request, response );

	}


}
