<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "voter-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/voteSuccess.css">

<div class="dashboard-container">

    <div class="success-card">

        <div class="success-icon">✔</div>

        <h2>Vote Submitted Successfully</h2>

        <p class="success-message">
            Thank you for participating in the election.
            <br>
            Your vote has been recorded securely.
        </p>

        <div class="success-note">
            You cannot vote again for the same election.
        </div>

        <div class="success-actions">
            <a href="voter-dashboard.jsp" class="btn primary">
                Go to Dashboard
            </a>

            <a href="ElectionsListServlet" class="btn secondary">
                View Other Elections
            </a>
        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>
