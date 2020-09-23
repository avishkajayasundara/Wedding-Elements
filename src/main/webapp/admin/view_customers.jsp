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
    <style>
        .box {
            background-color: #ffffff;
            width: 60%;
            margin-left: 400px ;
            padding: 50px;
            /*margin: auto;*/
        }

        .boxTop {
            width: 81%;
            height: 71.5px;
            margin-top: 0%;
            margin-left: 252px;
            font-size: 22px;
            color: #eeeeee;
            text-align: center;
            line-height: 70px;
            background: #202833;
            user-select: none;
        }

        h3 {
            color: #000000;
            font-weight: 400;
            font-size: 21px;
        }

        body {
            font-family: 'Roboto', sans-serif;
        }

        * {
            margin: 0;
            padding: 0;
            list-style: none;
            text-decoration: none;
        }

        .sidebar {
            position: fixed;
            left: 0;
            width: 250px;
            height: 100%;
            background: #202833;
            margin-top: 0%;
        }

        .sidebar header {
            font-size: 22px;
            color: #eeeeee;
            text-align: center;
            line-height: 70px;
            background: #106466;
            user-select: none;
        }

        .sidebar ul a {
            display: block;
            height: 100%;
            width: 100%;
            line-height: 65px;
            font-size: 20px;
            color: white;
            padding-left: 40px;
            box-sizing: border-box;
            border-top: 1px solid rgba(255, 255, 255, .1);
            border-bottom: 1px solid black;
            transition: .4s;
        }

        ul li:hover a {
            padding-left: 60px;
        }

        ul li:hover a i {
            margin-right: 8px;
        }

    </style>
</head>
<body style="background-color:#263238" >

<div class="sidebar">
    <header>Admin Panel</header>
    <ul>
        <li><a href="#"><i ></i>DASHBOARD</a></li>
        <li><a href="/admin/business-owners"><i class="fab fa-sass"></i> Business Owners </a></li>
        <li><a href="/admin/customers"><i class="fas fa-battery-full"></i> Registered Customers </a></li>
        <li><a href="#"><i class="fas fa-bell"></i> Inquiries </a></li>
        <li><a href="/logout"><i class="fas fa-birthday-cake"></i> Logout </a></li>
    </ul>
</div>

<div class="boxTop">
    All Customers
</div>

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
