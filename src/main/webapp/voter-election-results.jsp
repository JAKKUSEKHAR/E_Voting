<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.evoting.dto.ElectionResult, com.evoting.dto.Election" %>

<!DOCTYPE html>
<html>
<head>
    <title>Election Results</title>
    <link rel="stylesheet" href="css/voterResults.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="page-container">

    <a href="ElectionsListServlet" class="back-link">← Back to Elections</a>

    <%
        Election election = (Election) request.getAttribute("election");
        List<ElectionResult> results =
            (List<ElectionResult>) request.getAttribute("results");
    %>

    <h2>Election Results</h2>
    <p class="subtitle">
        Results for <strong><%= election.getTitle() %></strong>
    </p>

    <table class="results-table">
        <tr>
            <th>Candidate</th>
            <th>Total Votes</th>
        </tr>

        <% for (ElectionResult r : results) { %>
        <tr>
            <td><%= r.getCandidateName() %></td>
            <td><%= r.getVoteCount() %></td>
        </tr>
        <% } %>
    </table>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>
