<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/28/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/newAdmin" method="post">
    String email, String password, String address, String contactNo, String userRole,
    String status, String firstName, String lastName, String dob, String gender, String nicNo, String employeeId
    Email
    <input type="text" name ="email">
    password
    <input minlength="6" type="text" name ="password">
    address
    <input type="text" name ="address">
    contactNo
    <input type="text" name ="contactNo">
    firstName
    <input type="text" name ="firstName">
    lastName
    <input type="text" name ="lastName">
    dob
    <input type="date" name ="dob">
    gender
    <input type="text" name ="gender">
    nicNo
    <input type="text" name ="nicNo">
    employeeId
    <input type="text" name ="employeeId">
    <input type="submit" value="Submit">

</form>

</body>
</html>
