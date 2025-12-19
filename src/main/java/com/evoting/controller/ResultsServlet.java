package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.evoting.dao.*;
import com.evoting.dao.impl.*;
import com.evoting.dto.*;

public class ResultsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession(false);
	    if (session == null) {
	        resp.sendRedirect("welcome.jsp");
	        return;
	    }

	    String eid = req.getParameter("election_id");
	    if (eid == null) {
	    	System.out.println("eid is null ");
	        resp.sendRedirect("ElectionsListServlet");
	        return;
	    }

	    int electionId = Integer.parseInt(eid);

	    ElectionDAO electionDAO = new ElectionDAOImpl();
	    Election election = electionDAO.getElectionById(electionId);

	    boolean isAdmin = session.getAttribute("admin") != null;
	    boolean isVoter = session.getAttribute("voter") != null;

	    // voter cannot see running results
	    if (isVoter && !"CLOSED".equals(election.getStatus())) {
	        req.setAttribute("message",
	            "Results will be available after election ends.");
	        req.getRequestDispatcher("message.jsp").forward(req, resp);
	        return;
	    }

	    ResultDAO resultDAO = new ResultDAOImpl();
	    List<ElectionResult> results =
	        resultDAO.getResultsByElection(electionId);

	    req.setAttribute("election", election);
	    req.setAttribute("results", results);

	    // 🔑 ROLE-BASED JSP
	    if (isAdmin) {
	        req.getRequestDispatcher("results.jsp").forward(req, resp);
	    } else {
	        req.getRequestDispatcher("voter-election-results.jsp").forward(req, resp);
	    }
	}

}
