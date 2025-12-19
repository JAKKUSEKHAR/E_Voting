<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.evoting.dto.Election" %>

<%
    request.setAttribute("pageName", "admin-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/addCandidate.css">

<div class="dashboard-container">

        <a href="<%= request.getContextPath() %>/admin-dashboard.jsp" class="back-link">
            ← Back to Dashboard
        </a>
    <div class="page-header">
        <h2>Add Candidate</h2>
        <p class="subtitle">Assign a candidate to an election</p>
    </div>

<%
    List<Election> elist = (List<Election>) request.getAttribute("elist");
    if (elist == null) {
%>
    <div class="error-box">
        <strong>Error:</strong> Election list not loaded.
        <br>
        Please open this page from <strong>Admin → Add Candidate</strong>.
    </div>
<%
    }
%>

    <div class="form-card">
        <form action="AddCandidateServlet" method="post">

            <div class="form-group">
                <label>Select Election</label>
                <select name="eid" required>
                    <%
                        if (elist != null && !elist.isEmpty()) {
                            for (Election e : elist) {
                    %>
                        <option value="<%= e.getElectionId() %>">
                            <%= e.getTitle() %>
                        </option>
                    <%
                            }
                        } else {
                    %>
                        <option disabled>No elections available</option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div class="form-group">
                <label>Candidate Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="form-group">
                <label>Candidate Details</label>
                <textarea name="details" rows="4" required></textarea>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn primary">
                    Add Candidate
                </button>
            </div>

        </form>
    </div>

</div>

<%@ include file="footer.jsp" %>
