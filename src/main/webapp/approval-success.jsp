<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/approval.css">

<div class="status-container">
    <div class="status-card success">

        <h2>Voter Approved Successfully</h2>

        <p>
            The voter has been approved and their voter card
            has been generated and emailed successfully.
        </p>

        <div class="status-actions">
            <a href="PendingVotersServlet" class="btn primary">Back to Pending Voters</a>
            <a href="admin-dashboard.jsp" class="btn secondary">Admin Dashboard</a>
        </div>

    </div>
</div>

<%@ include file="footer.jsp" %>
