package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.evoting.dao.CandidateDAO;
import com.evoting.dao.VoteDAO;
import com.evoting.dao.impl.CandidateDAOImpl;
import com.evoting.dao.impl.VoteDAOImpl;
import com.evoting.dto.Candidate;

public class CandidatesListServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        int eid = Integer.parseInt(req.getParameter("eid"));

        CandidateDAO dao = new CandidateDAOImpl();
        List<Candidate> list = dao.getCandidatesByElection(eid);

        req.setAttribute("clist", list);
        req.setAttribute("eid", eid);
   HttpSession session=req.getSession();
   String token=(String) session.getAttribute("token");
   System.out.println(token);
   
     VoteDAO vdao=new VoteDAOImpl();
     boolean voteBlock=vdao.hasVoted(eid, token);
     req.setAttribute("voteBlock", voteBlock);
        RequestDispatcher rd = req.getRequestDispatcher("candidates.jsp");
        rd.forward(req, resp);
    }
}
