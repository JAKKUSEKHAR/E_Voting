<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "admin-login");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/adminLogin.css">

<div class="login-container">
    <div class="login-card">

        <h2>Admin Login</h2>
        <p class="subtitle">Login to manage elections</p>

        <form action="AdminLoginServlet" method="post">

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
            <a href="welcome.jsp" class="welcome-link">Back to Welcome</a>
        </div>

    </div>
</div>

<%@ include file="footer.jsp" %>
