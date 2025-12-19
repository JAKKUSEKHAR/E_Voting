<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/pendingVoters.css">

<div class="dashboard-container">

    <div class="page-header">
        <a href="admin-dashboard.jsp" class="back-link">← Back to Dashboard</a>
        <h2>Pending Voters</h2>
        <p class="subtitle">Approve voter registration requests</p>
    </div>

<%
java.util.List<com.evoting.dto.User> list =
    (java.util.List<com.evoting.dto.User>) request.getAttribute("pendingList");

if (list != null && !list.isEmpty()) {
    for (com.evoting.dto.User u : list) {
%>

    <div class="voter-card">
        <div class="voter-info">
            <h3><%= u.getUsername() %></h3>
            <p><strong>Email:</strong> <%= u.getEmail() %></p>
            <p><strong>User ID:</strong> <%= u.getUserId() %></p>
        </div>

        <div class="voter-action">

    <form action="AdminApproveServlet" method="post" style="display:inline;">
        <input type="hidden" name="user_id" value="<%= u.getUserId() %>">
        <input type="hidden" name="email" value="<%= u.getEmail() %>">
        <input type="hidden" name="name" value="<%= u.getUsername() %>">
        <button type="submit" class="approve-btn">Approve</button>
    </form>

    <form action="AdminRejectServlet" method="post" style="display:inline;">
        <input type="hidden" name="user_id" value="<%= u.getUserId() %>">
        <button type="submit" class="reject-btn">Reject</button>
    </form>

</div>

    </div>

<%
    }
} else {
%>

    <div class="empty-state">
        <p>No pending voter requests at the moment.</p>
    </div>

<%
}
%>

</div>

<%@ include file="footer.jsp" %>
