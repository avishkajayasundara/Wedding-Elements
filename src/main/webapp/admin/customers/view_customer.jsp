<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/3/2020
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Rezume Free Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="..css/animate.css">
    <link rel="stylesheet" href="../../css/flexslider.css">
    <link rel="stylesheet" href="../../fonts/icomoon/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="https://kit.fontawesome.com/yourcode.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700" rel="stylesheet">

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
            background: #AA00FF;
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
            background: #4A148C;
            margin-top: 0%;
        }

        .sidebar header {
            font-size: 22px;
            color: #eeeeee;
            text-align: center;
            line-height: 70px;
            background: #AA00FF;
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
<body id="advertisementspage" style="background-color: #E0E0E0" data-spy="scroll" data-target="#pb-navbar"
      data-offset="200">

<div class="sidebar">
    <header>FUCK THIS</header>
    <ul>
        <li><a href="#"><i class="fas fa-satellite"></i> DASHBOARD</a></li>
        <li><a href="#"><i class="fab fa-sass"></i> FUCK</a></li>
        <li><a href="#"><i class="fas fa-battery-full"></i> OFF</a></li>
        <li><a href="#"><i class="fas fa-bell"></i> MATE</a></li>
        <li><a href="#"><i class="fas fa-birthday-cake"></i> AVISHKA</a></li>
    </ul>
</div>

<div class="boxTop">
    LOL PUT A TOPIC
</div>


<div>
    <div class="box" style="margin-top: 5%">
        <div>
            <h1 style="text-align: center; color: #1A237E; font-weight: 500">User Profile</h1>
        </div>
        <br>
        <h3 style="font-weight: 400">
            First Name - ${customer.getFirstName()}
        </h3>
        <h3 style="margin-top: 2%">
            Last Name - ${customer.getLastName()}
        </h3>
        <h3 style="margin-top: 2%">
            ContactNumber - ${customer.getContactNo()}
        </h3>
        <h3 style="margin-top: 2%">
            Email - ${customer.getEmail()}
        </h3>
        <h3 style="margin-top: 2%">
            Address - ${customer.getAddress()}
        </h3>
        <h3 style="margin-top: 2%">
            Date Of Birth - ${customer.getDob()}
        </h3>
        <c:set var="status" value="${customer.getStatus()}"/>
        <c:choose>
            <c:when test="${status == 'ACTIVE'}">
                <c:url value="/admin/customers/update-status" var="url">
                    <c:param name="email" value="${customer.getEmail()}"/>
                    <c:param name="status" value="DISABLE"/>
                </c:url>
                <%--        <a style="color: #000000 " href="${url}">Deactivate Account</a>--%>
                <div style="margin-left: 70%">
                    <br>
                    <button style="background-color: #B71C1C; color: #eeeeee; font-weight: 500; width: 100%"
                            onclick="window.location.href='${url}'">Deactivate Account
                    </button>
                </div>
            </c:when>
            <c:otherwise>
                <c:url value="/admin/customers/update-status" var="url">
                    <c:param name="status" value="ACTIVE"/>
                    <c:param name="email" value="${customer.getEmail()}"/>
                </c:url>
                <%--            <a href="${url}">Activate Account</a>--%>
                <div style="margin-left: 70%">
                    <br>
                    <button style="background-color: #00695C; color: #eeeeee; font-weight: 500; width: 100%"
                            onclick="window.location.href='${url}'">Activate Account
                    </button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<script src="../../js/vendor/jquery.min.js"></script>
<script src="../../js/vendor/jquery-migrate-3.0.1.min.js"></script>
<script src="../../js/vendor/popper.min.js"></script>
<script src="../../js/vendor/bootstrap.min.js"></script>

<script src="../../js/vendor/jquery.easing.1.3.js"></script>

<script src="../../js/vendor/jquery.stellar.min.js"></script>
<script src="../../js/vendor/jquery.waypoints.min.js"></script>

<script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
<script src="https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js"></script>
<script src="../../js/custom.js"></script>

</body>
</html>