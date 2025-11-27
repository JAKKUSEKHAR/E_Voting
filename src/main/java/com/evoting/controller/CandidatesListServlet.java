package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.evoting.dao.CandidateDAO;
import com.evoting.dao.impl.CandidateDAOImpl;
import com.evoting.dto.Candidate;

public class CandidatesListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        int eid = Integer.parseInt(req.getParameter("eid"));

        CandidateDAO dao = new CandidateDAOImpl();
        List<Candidate> list = dao.getCandidatesByElection(eid);

        req.setAttribute("clist", list);
        req.setAttribute("eid", eid);

        RequestDispatcher rd = req.getRequestDispatcher("candidates.jsp");
        rd.forward(req, resp);
    }
}
