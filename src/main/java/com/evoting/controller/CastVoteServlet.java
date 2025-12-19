package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.VoteDAO;
import com.evoting.dao.impl.VoteDAOImpl;
import com.evoting.dto.User;

public class CastVoteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        int eid = Integer.parseInt(req.getParameter("eid"));
        int cid = Integer.parseInt(req.getParameter("cid"));

        User u = (User) req.getSession().getAttribute("user");
        String token = u.getVoterToken();

        VoteDAO dao = new VoteDAOImpl();

        if(dao.hasVoted(eid, token)) {
            resp.getWriter().println("You have already voted.");
            return;
        }

        boolean saved = dao.castVote(eid, token, cid);

        if(saved)
            resp.sendRedirect("vote-success.jsp");
        else
            resp.getWriter().println("Failed to vote.");
    }
}
