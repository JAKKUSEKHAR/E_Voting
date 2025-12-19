<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/adminDashboard.css">

<div class="dashboard-container">

    <h2 class="dashboard-title">Admin Dashboard</h2>
    <p class="dashboard-subtitle">Manage elections and voters</p>

    <!-- Admin Info -->
    <div class="info-card">
        <p><strong>Admin Name:</strong> ${sessionScope.admin.username}</p>
        <p><strong>Email:</strong> ${sessionScope.admin.email}</p>
        <p>
            <strong>Role:</strong>
            <span class="status admin">Administrator</span>
        </p>
    </div>

    <!-- Admin Actions -->
    <div class="action-grid">

        <a href="PendingVotersServlet" class="action-card">
            <h3>Approve Voters</h3>
            <p>Approve or reject voter registration requests</p>
        </a>

        <a href="create-election.jsp" class="action-card">
            <h3>Create Election</h3>
            <p>Start a new election for voters</p>
        </a>

        <a href="LoadElectionListForCandidateServlet" class="action-card">
            <h3>Add Candidate</h3>
            <p>Add candidates to existing elections</p>
        </a>

        <a href="ElectionsListServlet?for=admin" class="action-card">
            <h3>View Elections</h3>
            <p>View, monitor, or close elections</p>
        </a>

    </div>

    <!-- Logout -->
    <div class="logout-section">
        <a href="<%= request.getContextPath() %>/LogoutServlet" class="logout-btn">
            Logout
        </a>
    </div>

</div>

<%@ include file="footer.jsp" %>
