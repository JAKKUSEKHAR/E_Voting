package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.UserDAO;
import com.evoting.dao.impl.UserDAOImpl;
import com.evoting.dto.User;

public class LoginServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAOImpl();
        User u = dao.login(email, password);

        if(u == null) {
            resp.getWriter().println("Invalid credentials.");
            return;
        }

        if(!u.isApproved()) {
//            resp.getWriter().println("Your account is not approved by admin.");
        	resp.sendRedirect("registration-success.jsp");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", u);
        session.setAttribute("token", u.getVoterToken());
        resp.sendRedirect("voter-dashboard.jsp");
    }
}
