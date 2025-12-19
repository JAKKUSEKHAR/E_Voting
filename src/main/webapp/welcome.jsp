<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "welcome-page");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/welcome.css">

<div class="welcome-container">

    <!-- Intro -->
    <div class="intro">
        <h1>Welcome to the E-Voting Platform</h1>
        <p>
            A secure, transparent, and reliable online voting system.
            Participate in elections with confidence and integrity.
        </p>
    </div>

    <!-- Cards -->
    <div class="card-container">

        <!-- Voter -->
        <div class="welcome-card">
            <h2>Voter</h2>
            <p>
                Register as a voter, verify your identity, and cast your vote
                in active elections.
            </p>
            <a href="login.jsp" class="btn primary">Voter Login</a>
            <a href="register.jsp" class="btn secondary">New Voter? Register</a>
        </div>

        <!-- Admin -->
        <div class="welcome-card admin">
            <h2>Administrator</h2>
            <p>
                Manage elections, approve voters, add candidates,
                and monitor voting progress.
            </p>
            <a href="admin-login.jsp" class="btn danger">Admin Login</a>
        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>
