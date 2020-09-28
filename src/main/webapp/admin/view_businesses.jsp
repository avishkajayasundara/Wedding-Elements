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
            font-size: 18px;
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
            /*height: 100%;*/
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
<body>
<div class="sidebar">
    <header>Admin Panel</header>
    <ul>
        <li><a href="#"> DASHBOARD</a></li>
        <li><a href="/admin/business-owners"> Business Owners </a></li>
        <li><a href="/admin/customers"> Customers </a></li>
        <li><a href="#"> Inquiries </a></li>
        <li><a href="/logout"> Logout </a></li>
    </ul>
</div>

<div class="boxTop">
    All Customers
</div>

<div style="background-color: #222222" class="limiter">
    <div style="background-color: black" class="container-table100">
        <div class="wrap-table100">
            <div class="table">
                <div style="background-color: #1A237E; font-size: 12px" class="row header">
                    <div class="cell" style="width: 20%;padding-right: 10px">
                        Business Name
                    </div>
                    <div class="cell" style="width: 10%;padding-right: 10px">
                        Type
                    </div>
                    <div class="cell" style="width: 12%;padding-right: 10px">
                        Email
                    </div>
                    <div class="cell"  style="width: 10%;padding-right: 10px">
                        Location
                    </div>
                    <div class="cell" style="width: 13%;padding-right: 10px">
                        Contact Number
                    </div>
                    <div class="cell"  style="width: 10%;padding-right: 10px">
                        Status
                    </div>
                    <div class="cell"  style="width: 10%;padding-right: 10px">
                        ......
                    </div>
                </div>

                <c:forEach var="business" items="${businesses}">
                    <c:url value = "/admin/business-owners/" var = "url">
                        <c:param name = "email" value = "${business.getEmail()}"/>
                    </c:url>
                    <div class="row">
                        <div class="cell" data-title="Full Name">
                            ${business.getName()}
                        </div>
                        <div class="cell" data-title="Type">
                                ${business.getBusinessType()}
                        </div>
                        <div class="cell" data-title="Email">
                                ${business.getEmail()}
                        </div>
                        <div class="cell" data-title="Location">
                                ${business.getAddress()}

                        </div>
                        <div class="cell" data-title="Contact Number">
                                ${business.getContactNo()}
                        </div>
                        <div class="cell" data-title="Status">
                                ${business.getStatus()}

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
