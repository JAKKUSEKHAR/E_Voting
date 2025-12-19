<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "login-page");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="css/login.css">

<div class="login-container">
    <div class="login-card">

        <h2>Voter Login</h2>
        <p class="subtitle">Sign in to cast your vote</p>

        <form action="LoginServlet" method="post">

            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <button type="submit" class="btn primary">Login</button>
        </form>

        <div class="login-footer">
    <span>Don't have an account?</span>
    <a href="register.jsp">Register</a>
    <br>
    <a href="welcome.jsp" class="welcome-link">Back to Welcome</a>
</div>


    </div>
</div>

<%@ include file="footer.jsp" %>
