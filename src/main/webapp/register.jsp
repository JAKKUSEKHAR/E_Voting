<%@ include file="header.jsp" %>

<div class="container">

    <a href="welcome.jsp" class="back-button">⬅ Back</a>

    <h2>User Registration</h2>

    <form action="RegisterServlet" method="post">

        Username:
        <input type="text" name="username">

        Email:
        <input type="text" name="email">

        Phone:
        <input type="text" name="phone">

        Password:
        <input type="password" name="password">

        <button class="button" type="submit">Register</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
