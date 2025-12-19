package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.UserDAO;
import com.evoting.dao.impl.UserDAOImpl;
import com.evoting.dto.User;


public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        User u = new User();
        u.setUsername(req.getParameter("username"));
        u.setEmail(req.getParameter("email"));
        u.setPhone(req.getParameter("phone"));
        u.setPassword(req.getParameter("password"));
        u.setRole("VOTER");
        u.setApproved(false);

        UserDAO dao = new UserDAOImpl();
        boolean saved = dao.registerUser(u);

        if (saved) {
            resp.sendRedirect("registration-success.jsp");
        } else {
            resp.sendRedirect("registration-failure.jsp");
        }

    }
}
