package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.evoting.dao.ElectionDAO;
import com.evoting.dao.impl.ElectionDAOImpl;
import com.evoting.dto.Election;

public class LoadElectionListForCandidateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ElectionDAO dao = new ElectionDAOImpl();
        List<Election> elist = dao.getAllElections();

        // Debug
        System.out.println("ELECTION LIST SIZE = " + elist.size());

        req.setAttribute("elist", elist);
        req.getRequestDispatcher("add-candidate.jsp").forward(req, resp);
    }
}
