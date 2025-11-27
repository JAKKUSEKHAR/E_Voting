<%@ include file="header.jsp" %>

<div class="container">

<a href="voter-dashboard.jsp" class="back-button">⬅ Back</a>

<h2>Active Elections</h2>

<%
java.util.List<com.evoting.dto.Election> list =
 (java.util.List<com.evoting.dto.Election>) request.getAttribute("elist");

for(com.evoting.dto.Election e : list) {
%>

<div class="card">
    <b><%=e.getTitle()%></b><br><br>

    <a class="button" href="CandidatesListServlet?eid=<%=e.getElectionId()%>">
        View Candidates
    </a>
</div>

<% } %>

</div>

<%@ include file="footer.jsp" %>
