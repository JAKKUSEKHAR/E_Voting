<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/success.css">

<div class="dashboard-container">

    <div class="success-card">

        <div class="success-icon">✔</div>

        <h2>Election Created Successfully</h2>

        <p class="success-message">
            The election has been created and is now available for candidate assignment.
        </p>

        <div class="success-actions">
            <a href="LoadElectionListForCandidateServlet"
               class="btn primary">
                Add Candidates
            </a>

            <a href="admin-dashboard.jsp"
               class="btn secondary">
                Go to Dashboard
            </a>
        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>
