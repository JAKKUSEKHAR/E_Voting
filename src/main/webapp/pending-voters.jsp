<%@ include file="header.jsp" %>

<div class="container">

    <a href="admin-dashboard.jsp" class="back-button">⬅ Back</a>

    <h2>Pending Voters</h2>

<%
java.util.List<com.evoting.dto.User> list =
    (java.util.List<com.evoting.dto.User>) request.getAttribute("pendingList");

if(list != null) {
    for(com.evoting.dto.User u : list) {
%>

<div class="card">
    <b><%=u.getUsername()%></b><br>
    <%=u.getEmail()%><br><br>

    <form action="AdminApproveServlet" method="post">
        <input type="hidden" name="user_id" value="<%=u.getUserId()%>">
        <button class="button" type="submit">Approve</button>
    </form>
</div>

<%
    }
} else {
%>
No pending users found.
<%
}
%>

</div>

<%@ include file="footer.jsp" %>
