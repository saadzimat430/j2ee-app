package com.app.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.app.dao.Validate;
import com.app.hash.SimpleMD5;

public class Connexion extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		if (action==null)
//			request.getRequestDispatcher("connexion.jsp").forward(request, response);
//		else if (action.equalsIgnoreCase("logout")) {
//			HttpSession session = request.getSession();
//			session.invalidate();
//			request.getRequestDispatcher("connexion.jsp").forward(request, response);
//		}
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pwd = SimpleMD5.SimpleMD5Example(password);
        String role = Validate.getRole(email);
        
        
        HttpSession session = request.getSession();
        
        if(Validate.checkUser(email, pwd) && role.contentEquals("user"))
        {
        	session.setAttribute("email", email);
        	request.setAttribute("email", email);
        	session.setAttribute("role", role);
        	
            response.sendRedirect("ChoixQuestionnaire");
            
        } else if(Validate.checkUser(email, pwd) && role.contentEquals("rh")) {
        	session.setAttribute("email", email);
        	request.setAttribute("email", email);
        	session.setAttribute("role", role);
        	
        	response.sendRedirect("AfficherReponses");
        }
        
        else if(Validate.checkUser("admin@admin.com", pwd)) {
        	session.setAttribute("email", email);
        	session.setAttribute("role", Validate.getRole(email));
        	response.sendRedirect("EspaceAdmin");
        } else {
            this.getServletContext().getRequestDispatcher("/loginerror.jsp").forward( request, response );
        }
        
    }  
}