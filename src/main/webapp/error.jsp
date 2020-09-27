<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/26/2020
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>404 HTML Template by Colorlib</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:700,900" rel="stylesheet">

    <!-- Font Awesome Icon -->
    <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css" />

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/errorstyle.css" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="notfound">
    <div class="notfound-bg"></div>
    <div class="notfound">
        <div class="notfound-404">
            <h1 style="font-size: 60px">Something Went Wrong</h1>
        </div>
        <h2>${error.getError()}</h2>
        <a href="/" class="home-btn">Homepage</a>
        <a href="#" class="contact-btn">Contact us</a>

    </div>
</div>

</body>
</html>
