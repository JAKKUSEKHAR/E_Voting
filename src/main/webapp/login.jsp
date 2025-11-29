<%@ include file="header.jsp" %>

<div class="container">

    <a href="welcome.jsp" class="back-button">⬅ Back</a>

    <h2>Voter Login</h2>

    <form action="LoginServlet" method="post">

        Email:
        <input type="text" name="email">

        Password:
        <input type="password" name="password">

        <button class="button" type="submit">Login</button>
    </form>

</div>

<%@ include file="footer.jsp" %>
