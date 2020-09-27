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

    <script src="https://kit.fontawesome.com/yourcode.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>

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
<body style="background-color:#263238">

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
    Dashboard
</div>
<div class="container">
    <div class="row">
        <div style="background-color: #222222;padding:3%;color: white;text-align: center" class="col-sm">
            <h1>Number of Registered Customer</h1>
            <h2 style="color: #bbf72f;margin-top: 2%">123</h2>
        </div>
        <div style="background-color: #222222;padding:3%;color: white;text-align: center" class="col">
            <h1>Number of Registered Businesses</h1>
            <h2 style="color: #bbf72f;margin-top: 2%">123</h2>

        </div>
    </div>
    <div class="row">
        <div style="background-color: #222222;padding:3%;color: white;text-align: center" class="col">
            <h1>Number of <br>
                Advertisements Published</h1>
            <h2 style="color: #bbf72f;margin-top: 2%">123</h2>

        </div>
        <div style="background-color: #222222;padding:3%;color: white;text-align: center" class="col">
            <h1>Number of Reviews</h1>
            <h2 style="color: #bbf72f;margin-top: 2%">123</h2>

        </div>
    </div>
    <div class="row">
        <div style="background-color: #222222;padding:3%;color: white;text-align: center" class="col">
            <h1>Currently Active Users</h1>
            <h2 style="color: #bbf72f;margin-top: 2%">123</h2>
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
