package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;

import com.evoting.dto.Election;
import com.evoting.dao.ElectionDAO;
import com.evoting.dao.impl.ElectionDAOImpl;

public class CreateElectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String start = req.getParameter("start"); // 2025-01-01T10:00
        String end   = req.getParameter("end");

        // Convert datetime-local → Timestamp
        Timestamp startTs = Timestamp.valueOf(start.replace("T", " ") + ":00");
        Timestamp endTs   = Timestamp.valueOf(end.replace("T", " ") + ":00");

        Election e = new Election();
        e.setTitle(req.getParameter("title"));
        e.setType(req.getParameter("type"));
        e.setDescription(req.getParameter("description"));
        e.setStartDate(startTs);
        e.setEndDate(endTs);
        e.setCreatedBy(1); // temporary admin ID

        ElectionDAO dao = new ElectionDAOImpl();
        boolean saved = dao.createElection(e);

        if(saved)
//            resp.getWriter().println("Election Created Successfully!");
        resp.sendRedirect("election-add-success.jsp");
        	else
            resp.getWriter().println("Failed to Create Election.");
    }
}
