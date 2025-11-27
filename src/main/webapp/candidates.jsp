<%@ include file="header.jsp" %>

<div class="container">

<a href="ElectionsListServlet" class="back-button">⬅ Back</a>

<h2>Choose a Candidate</h2>

<%
java.util.List<com.evoting.dto.Candidate> clist =
 (java.util.List<com.evoting.dto.Candidate>) request.getAttribute("clist");

int eid = (int) request.getAttribute("eid");

for(com.evoting.dto.Candidate c : clist) {
%>

<div class="card">
    <b><%=c.getName()%></b><br>
    <%=c.getDetails()%><br><br>

    <form action="CastVoteServlet" method="post">
        <input type="hidden" name="eid" value="<%=eid%>">
        <input type="hidden" name="cid" value="<%=c.getCandidateId()%>">
        <button class="button" type="submit">Vote</button>
    </form>
</div>

<% } %>

</div>

<%@ include file="footer.jsp" %>
