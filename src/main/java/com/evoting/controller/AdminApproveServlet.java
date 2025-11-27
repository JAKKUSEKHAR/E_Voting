package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.UserDAO;
import com.evoting.dao.impl.UserDAOImpl;
import com.evoting.util.TokenGenerator;

public class AdminApproveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("user_id"));
        String token = TokenGenerator.generateToken();

        UserDAO dao = new UserDAOImpl();
        boolean done = dao.approveUser(userId, token);

        if(done)
            resp.getWriter().println("User approved.");
        else
            resp.getWriter().println("Approval failed.");
    }
}
