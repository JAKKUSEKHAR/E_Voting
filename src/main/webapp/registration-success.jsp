<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "success-page");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/register.css">

<div class="register-container">
    <div class="register-card">

        <h2 class="success-title">Registration Successful</h2>

        <p class="success-message">
            Your voter account has been created successfully.
        </p>

        <p class="approval-note">
            Please wait for <strong>admin approval</strong> before logging in.
        </p>

        <div class="success-actions">
            <a href="welcome.jsp" class="btn primary">Go to Welcome Page</a>
        </div>

    </div>
</div>

<%@ include file="footer.jsp" %>
