<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageName", "voter-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="css/voterDashboard.css">

<div class="dashboard-container">

    <h2 class="dashboard-title">Voter Dashboard</h2>
    <p class="dashboard-subtitle">Welcome to the E-Voting System</p>

    <!-- Voter Info -->
  <div class="info-card">
    <p><strong>Voter Name:</strong> ${sessionScope.user.username}</p>
    <p><strong>Email:</strong> ${sessionScope.user.email}</p>
    <p><strong>Phone:</strong> ${sessionScope.user.phone}</p>
    <p>
        <strong>Approval Status:</strong>
        <span class="status approved">
            ${sessionScope.user.approved ? "Approved" : "Pending"}
        </span>
    </p>
    <p>
        <strong>Voter Token:</strong>
        <span class="token">
            ${sessionScope.user.voterToken}
        </span>
    </p>
</div>


    <!-- Actions -->
    <div class="action-grid">

        <a href="ElectionsListServlet" class="action-card">
            <h3>View Elections</h3>
            <p>See available elections and cast your vote</p>
        </a>

        <a href="ResultsServlet" class="action-card" >
            <h3>View Results</h3>
            <p>Results will be available after election ends</p>
        </a>
 
    </div>

    <!-- Logout -->
    <div class="logout-section">
        <a href="<%=request.getContextPath()%>/LogoutServlet" class="logout-btn">
            Logout
        </a>
    </div>

</div>

<%@ include file="footer.jsp" %>
