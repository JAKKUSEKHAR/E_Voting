package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.evoting.dao.UserDAO;
import com.evoting.dao.impl.UserDAOImpl;
import com.evoting.dto.User;

public class PendingVotersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserDAO dao = new UserDAOImpl();
        List<User> list = dao.getPendingUsers();

        req.setAttribute("pendingList", list);
        RequestDispatcher rd = req.getRequestDispatcher("pending-voters.jsp");
        rd.forward(req, resp);
    }
}
