<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.evoting.dto.ElectionResult, com.evoting.dto.Election" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/results.css">

<div class="dashboard-container">

    <!-- Page Header -->
    <div class="page-header">
        <a href="javascript:history.back()" class="back-link">← Back</a>
        <h2>Election Results</h2>
    </div>

<%
    Election election = (Election) request.getAttribute("election");
    List<ElectionResult> results =
            (List<ElectionResult>) request.getAttribute("results");
%>

    <!-- Election Info -->
    <div class="election-info">
        <span class="election-title"><%= election.getTitle() %></span>

        <% if ("RUNNING".equals(election.getStatus())) { %>
            <span class="badge running">LIVE</span>
        <% } else { %>
            <span class="badge closed">FINAL</span>
        <% } %>
    </div>

    <p class="subtitle">
        <% if ("RUNNING".equals(election.getStatus())) { %>
            Live vote count (Admin view)
        <% } else { %>
            Final declared results
        <% } %>
    </p>

<%
    if (results == null || results.isEmpty()) {
%>

    <div class="empty-box">
        No votes recorded yet.
    </div>

<%
    } else {
        int highestVotes = results.get(0).getVoteCount();
%>

    <!-- Results Table -->
    <div class="table-wrapper">
        <table class="results-table">
            <thead>
                <tr>
                    <th>Candidate</th>
                    <th>Total Votes</th>
                    <th>Status</th>
                </tr>
            </thead>

            <tbody>
            <% for (ElectionResult r : results) { %>
              <tr class="<%= (r.getVoteCount() == highestVotes && highestVotes > 0) ? "winner-row" : "" %>">
    <td><%= r.getCandidateName() %></td>
    <td><%= r.getVoteCount() %></td>
    <td>
        <% if (r.getVoteCount() == highestVotes && highestVotes > 0) { %>
            <span class="winner">Winner</span>
        <% } else { %>
            —
        <% } %>
    </td>
</tr>

            <% } %>
            </tbody>
        </table>
    </div>

<%
    }
%>

</div>

<%@ include file="footer.jsp" %>
