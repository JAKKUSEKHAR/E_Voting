<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "register-page");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="css/register.css">

<div class="register-container">
    <div class="register-card">

        <h2>User Registration</h2>
        <p class="subtitle">Create your voter account</p>

        <form action="RegisterServlet" method="post">

            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" required>
            </div>

            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Phone Number</label>
                <input type="text" name="phone" maxlength="10" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <button type="submit" class="btn primary">Register</button>
        </form>

        <div class="register-footer">
            <span>Already registered?</span>
            <a href="login.jsp">Login</a>
            <br>
            <a href="welcome.jsp" class="welcome-link">Back to Welcome</a>
        </div>

    </div>
</div>

<%@ include file="footer.jsp" %>
