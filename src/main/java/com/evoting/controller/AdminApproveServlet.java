package com.evoting.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.evoting.dao.UserDAO;
import com.evoting.dao.impl.UserDAOImpl;
import com.evoting.util.EmailUtil;
import com.evoting.util.TokenGenerator;
import com.evoting.util.VoterCardGenerator;

public class AdminApproveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("user_id"));
        String token = TokenGenerator.generateToken();
         String name= req.getParameter("name");
         String email= req.getParameter("email");
        UserDAO dao = new UserDAOImpl();
        boolean done = dao.approveUser(userId, token);

        if(done) {
        	 String cardPath = VoterCardGenerator.generateCard(name, token);
        	
//        	EmailUtil.sendEmail(
//        	    email,
//        	    "Approval Successful",
//        	    "Congratulations! You are approved.\nYour voter token: " + token
//        	);
//          
        	 EmailUtil.sendEmailWithAttachment(
        		        email,
        		        "Your Voter Card",
        		        "Congratulations! You are approved.\nYour card is attached.",
        		        cardPath
        		    );
        	
        	 resp.sendRedirect("approval-success.jsp");

        }
        else
        	resp.sendRedirect("approval-failure.jsp");
    }
}
