<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.evoting.dto.Election" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/adminElections.css">

<div class="dashboard-container">

    <!-- Page Header -->
        <a href="admin-dashboard.jsp" class="back-link">← Back to Dashboard</a>
    <div class="page-header">
        <h2>Manage Elections</h2>
        <p class="subtitle">
            View all elections, monitor status, close elections and view results.
        </p>
    </div>

<%
    List<Election> list = (List<Election>) request.getAttribute("elist");
    if (list == null || list.isEmpty()) {
%>

    <div class="empty-box">
        No elections available.
    </div>

<%
    } else {
%>

    <!-- Elections Table -->
    <div class="table-wrapper">
        <table class="data-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Election Title</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
            <% for (Election e : list) { %>
                <tr>
                    <td><%= e.getElectionId() %></td>
                    <td><%= e.getTitle() %></td>
                    <td><%= e.getType() %></td>

                    <td>
                        <% if ("RUNNING".equals(e.getStatus())) { %>
                            <span class="badge running">RUNNING</span>
                        <% } else { %>
                            <span class="badge completed">COMPLETED</span>
                        <% } %>
                    </td>

                    <td class="actions">

                        <a class="btn secondary"
                           href="ResultsServlet?election_id=<%=e.getElectionId()%>">
                            View Results
                        </a>

                        <% if ("RUNNING".equals(e.getStatus())) { %>
                            <form action="CloseElectionServlet"
                                  method="post" class="inline-form">
                                <input type="hidden"
                                       name="election_id"
                                       value="<%=e.getElectionId()%>">
                                <button class="btn danger"
                                    onclick="return confirm('Close this election?');">
                                    Close Election
                                </button>
                            </form>
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
