package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.ElectionDAO;
import com.evoting.dao.impl.ElectionDAOImpl;

public class CloseElectionServlet extends HttpServlet {

 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Security check
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect("welcome.jsp");
            return;
        }

        int electionId = Integer.parseInt(req.getParameter("election_id"));

        ElectionDAO dao = new ElectionDAOImpl();
        boolean closed = dao.closeElection(electionId);

        if (closed) {
            resp.sendRedirect("ElectionsListServlet?for=admin");
        } else {
            resp.getWriter().println("Failed to close election");
        }
    }
}
