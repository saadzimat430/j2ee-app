package com.app.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.beans.Recommandation;
import com.app.dao.DaoFactory;
import com.app.dao.RecomDaoImpl;


public class VoirRecom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecomDaoImpl recomDaoImpl;
    private DaoFactory daoFactory;

    public void init() {
    	recomDaoImpl = new RecomDaoImpl(daoFactory);
    }   

    public VoirRecom() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		ArrayList<Recommandation> recom = new ArrayList<Recommandation>();
		recom = RecomDaoImpl.usersRecom(email);
		request.setAttribute("recom", recom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/voirrecom.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/voirrecom.jsp").forward( request, response );
		
	}

}
