<%@ page import="java.util.List" %>
<%@ page import="com.evoting.dto.Election" %>

<%@ include file="header.jsp" %>

<div class="container">

<a href="<%=request.getContextPath()%>/admin-dashboard.jsp" class="back-button">
    &lt; Back
</a>



    <h2>Add Candidate</h2>

    <%
        List<Election> elist = (List<Election>) request.getAttribute("elist");
    %>

    <!-- If election list is null → ERROR -->
    <%
        if (elist == null) {
    %>
        <div style="background:#ffdddd; padding:10px; border-radius:6px; margin-bottom:15px;">
            <b style="color:#a00;">Error:</b> Election list is not loaded.
            <br>Open this page ONLY from: <b>Add Candidate</b> button in Admin Dashboard.
        </div>
    <%
        }
    %>

    <form action="AddCandidateServlet" method="post">

        <label>Select Election:</label>
        <select name="eid" style="padding:12px; width:100%; margin-bottom:20px; border-radius:8px; border:1px solid #bbb;">
            <%
            if (elist != null && !elist.isEmpty()) {
                for (Election e : elist) {
            %>
                <option value="<%= e.getElectionId() %>"><%= e.getTitle() %></option>
            <%
                }
            } else {
            %>
                <option disabled>No elections available</option>
            <%
            }
            %>
        </select>

        <label>Candidate Name:</label>
        <input type="text" name="name">

        <label>Details:</label>
        <textarea name="details" rows="4"></textarea>

        <button type="submit" class="button">Add Candidate</button>
    </form>

</div>

<%@ include file="footer.jsp" %>
