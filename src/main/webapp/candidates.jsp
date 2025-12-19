<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setAttribute("pageName", "voter-dashboard");
%>

<%@ include file="header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/candidates.css">

<div class="dashboard-container">

    <div class="page-header">
        <a href="ElectionsListServlet" class="back-link">← Back to Elections</a>
        <h2>Choose a Candidate</h2>
        <p class="subtitle">Select one candidate to cast your vote</p>
    </div>

<%
java.util.List<com.evoting.dto.Candidate> clist =
    (java.util.List<com.evoting.dto.Candidate>) request.getAttribute("clist");
                   
Integer eidObj = (Integer) request.getAttribute("eid");

boolean voteBlock=(Boolean)request.getAttribute("voteBlock");

if (clist != null && !clist.isEmpty() && eidObj != null) {
    int eid = eidObj;

    for (com.evoting.dto.Candidate c : clist) {
%>

    <div class="candidate-card">
        <div class="candidate-info">
            <h3><%= c.getName() %></h3>
            <p><%= c.getDetails() %></p>
        </div>

        <div class="candidate-action">
            <form action="CastVoteServlet" method="post">
                <input type="hidden" name="eid" value="<%= eid %>">
                <input type="hidden" name="cid" value="<%= c.getCandidateId() %>">
               <% if(voteBlock==true) {
            	    %>
               <button type="submit" class="btn primary" disabled>
                    Already Voted
                </button>
                <%} else{ %>
                 <button type="submit" class="btn primary">
                    Vote
                </button>
                <%} %>
            </form>
        </div>
    </div>

<%
    }
} else {
%>

    <div class="empty-state">
        <p>No candidates available for this election.</p>
    </div>

<%
}
%>

</div>

<%@ include file="footer.jsp" %>
