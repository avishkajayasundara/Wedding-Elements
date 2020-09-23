<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2020
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table V02</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../css/tableutil.css">
    <link rel="stylesheet" type="text/css" href="../css/tablemain.css">
    <!--===============================================================================================-->
</head>
<body style="background-color:#263238" >

<div class="limiter">
    <div style="background-color: black" class="container-table100">
        <div class="wrap-table100" style="margin-top: -21%">
            <div class="table">
                <div class="row header" style="background-color: #1A237E">
                    <div class="cell" style="width:12%">
                        First Name
                    </div>
                    <div class="cell">
                        Last Name
                    </div>
                    <div class="cell">
                        Email
                    </div>
                    <div class="cell">
                        Address
                    </div>
                    <div class="cell">
                        Contact Number
                    </div>
                    <div class="cell">
                        Date of Birth
                    </div>
                    <div class="cell">
                        Status
                    </div>
                    <div class="cell" style="width: 6%; margin-right: 1%">
                        View
                    </div>
                </div>

                <c:forEach var="customer" items="${customers}">
                    <c:url value = "/admin/customers/" var = "url">
                        <c:param name = "email" value = "${customer.getEmail()}"/>
                    </c:url>
                    <div class="row" style="background-color: #E3F2FD; color: black">
                        <div style="color: black" class="cell" data-title="Full Name">
                                ${customer.getFirstName()}
                        </div>
                        <div style="color: black" class="cell" data-title="Type">
                                ${customer.getLastName()}
                        </div>
                        <div style="color: black" class="cell" data-title="Email">
                                ${customer.getEmail()}
                        </div>
                        <div style="color: black" class="cell" data-title="Location">
                                ${customer.getAddress()}

                        </div>
                        <div style="color: black" class="cell" data-title="Contact Number">
                                ${customer.getContactNo()}
                        </div>
                        <div style="color: black" class="cell" data-title="Status">
                                ${customer.getDob()}

                        </div>
                        <div style="color: black" class="cell" data-title="Status">
                                ${customer.getStatus()}

                        </div>
                        <div class="cell" data-title="link">
                            <a href="${url}"> View </a>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
</div>




<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="../js/tablemain.js"></script>

</body>
</html>
