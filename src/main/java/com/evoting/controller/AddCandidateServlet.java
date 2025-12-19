package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dto.Candidate;
import com.evoting.dao.CandidateDAO;
import com.evoting.dao.impl.CandidateDAOImpl;

public class AddCandidateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        Candidate c = new Candidate();
        c.setElectionId(Integer.parseInt(req.getParameter("eid")));
        c.setName(req.getParameter("name"));
        c.setDetails(req.getParameter("details"));

        CandidateDAO dao = new CandidateDAOImpl();
        boolean saved = dao.addCandidate(c);

        if(saved)
            resp.sendRedirect("candidate-add-success.jsp");
        else
            resp.getWriter().println("Failed to add candidate.");
    }
}
