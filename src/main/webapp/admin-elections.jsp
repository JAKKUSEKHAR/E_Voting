<%@ page import="java.util.List" %>
<%@ page import="com.evoting.dto.Election" %>

<%@ include file="header.jsp" %>

<div class="container">

<a href="admin-dashboard.jsp" class="back-button">← Back</a>

<h2>All Elections</h2>

<%
List<Election> list = (List<Election>) request.getAttribute("elist");

if (list == null || list.isEmpty()) {
%>
    <p>No Elections Available</p>
<%
} else {
    for (Election e : list) {
%>

<div class="card">
    <b><%= e.getTitle() %></b><br>
    Type: <%= e.getType() %><br>
    Start: <%= e.getStartDate() %><br>
    End: <%= e.getEndDate() %><br><br>

    <!-- In future we can add Edit/Delete buttons here -->
</div>

<%
    }
}
%>

</div>

<%@ include file="footer.jsp" %>
