<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "voter-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/elections.css">

<div class="dashboard-container">

    <div class="page-header">
        <a href="voter-dashboard.jsp" class="back-link">← Back to Dashboard</a>
        <h2>Active Elections</h2>
        <p class="subtitle">Choose an election to view candidates and vote</p>
    </div>

<%
java.util.List<com.evoting.dto.Election> list =
    (java.util.List<com.evoting.dto.Election>) request.getAttribute("elist");

if (list != null && !list.isEmpty()) {
    for (com.evoting.dto.Election e : list) {
%>

    <div class="election-card">
        <div class="election-info">
            <h3><%= e.getTitle() %></h3>
            <p><strong>Election ID:</strong> <%= e.getElectionId() %></p>
        </div>

        <div class="election-action">
            <a href="CandidatesListServlet?eid=<%= e.getElectionId() %>"
               class="btn primary">
                View Candidates
            </a>
        </div>
    </div>

<%
    }
} else {
%>

    <div class="empty-state">
        <p>No active elections available at the moment.</p>
    </div>

<%
}
%>

</div>

<%@ include file="footer.jsp" %>
