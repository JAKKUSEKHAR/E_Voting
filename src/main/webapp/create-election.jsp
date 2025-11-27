<%@ include file="header.jsp" %>

<div class="container">

<a href="admin-dashboard.jsp" class="back-button">⬅ Back</a>

<h2>Create Election</h2>

<form action="../CreateElectionServlet" method="post">

    Title:
    <input type="text" name="title">

    Type:
    <input type="text" name="type">

    Description:
    <textarea name="description"></textarea>

    Start Date:
    <input type="datetime-local" name="start">

    End Date:
    <input type="datetime-local" name="end">

    <button class="button" type="submit">Create</button>
</form>

</div>

<%@ include file="footer.jsp" %>
