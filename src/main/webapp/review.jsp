<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/15/2020
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Review</title>
</head>
<body>
<h1>Add Review</h1>
<form action="addReview">
    <input type="text" name="reviewId"><br>
    <input type="text" name="name"><br>
    <input type="text" name="email"><br>
    <input type="text" name="review"><br>
    <input type="number" name="score" max="10" min="0">
    <input type="submit"><br>
</form>

</body>
</html>
