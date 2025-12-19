<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/createElection.css">

<div class="dashboard-container">

        <a href="admin-dashboard.jsp" class="back-link">← Back to Dashboard</a>
    <div class="page-header">
        <h2>Create Election</h2>
        <p class="subtitle">Define election details and schedule</p>
    </div>

    <div class="form-card">
        <form action="CreateElectionServlet" method="post">

            <div class="form-group">
                <label>Election Title</label>
                <input type="text" name="title" required>
            </div>

            <div class="form-group">
                <label>Election Type</label>
                <input type="text" name="type" placeholder="e.g., Student Council, General Election" required>
            </div>

            <div class="form-group">
                <label>Description</label>
                <textarea name="description" rows="4" required></textarea>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Start Date & Time</label>
                    <input type="datetime-local" name="start" required>
                </div>

                <div class="form-group">
                    <label>End Date & Time</label>
                    <input type="datetime-local" name="end" required>
                </div>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn primary">
                    Create Election
                </button>
            </div>

        </form>
    </div>

</div>

<%@ include file="footer.jsp" %>
