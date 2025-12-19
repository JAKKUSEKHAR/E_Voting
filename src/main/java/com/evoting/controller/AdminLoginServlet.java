package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.UserDAO;
import com.evoting.dao.impl.UserDAOImpl;
import com.evoting.dto.User;

public class AdminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAOImpl();
        User u = dao.login(email, password);

        if(u == null || !u.getRole().equals("ADMIN")) {
            resp.getWriter().println("Invalid admin credentials.");
            return;
        }

        req.getSession().setAttribute("admin", u);
        resp.sendRedirect("admin-dashboard.jsp");
    }
}
