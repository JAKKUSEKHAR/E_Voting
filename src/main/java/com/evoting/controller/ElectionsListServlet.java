package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.evoting.dao.ElectionDAO;
import com.evoting.dao.impl.ElectionDAOImpl;
import com.evoting.dto.Election;

public class ElectionsListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    ElectionDAO dao = new ElectionDAOImpl();
	    List<Election> elist = dao.getAllElections();

	    req.setAttribute("elist", elist);

	    String forAdmin = req.getParameter("for");

	    if ("admin".equals(forAdmin)) {
	    	System.out.println("SERVLET HIT: ElectionsListServlet");
	    	System.out.println("ELIST = " + elist);
	    	System.out.println("SIZE = " + elist.size());

	        req.getRequestDispatcher("admin-elections.jsp").forward(req, resp);
	    } else {
	        req.getRequestDispatcher("elections.jsp").forward(req, resp);
	    }
	}

}
