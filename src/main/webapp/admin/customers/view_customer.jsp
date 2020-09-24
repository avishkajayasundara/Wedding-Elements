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
<body id="advertisementspage" style="background-color: #222222" data-spy="scroll" data-target="#pb-navbar"
      data-offset="200">

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
    User Profile - ${customer.getFirstName()} ${customer.getLastName()}
</div>


<div>
    <div class="box" style="margin-top: 5%">
        <div class="container">
            <div class="row">
                <div style="width: 40%" class="col-sm">
                    <h2 style="color: #0b0b0b; margin-bottom: 20px">Account Information</h2>
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
                            <div >
                                <br>
                                <button style="background-color: #B71C1C; color: #eeeeee; font-weight: 500; width: 60%"
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
                            <div>
                                <br>
                                <button style="background-color: #00695C; color: #eeeeee; font-weight: 500; width: 60%"
                                        onclick="window.location.href='${url}'">Activate Account
                                </button>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-sm">
                    <h2 style="color: #0b0b0b; margin-bottom: 20px">Posted Reviews</h2>
                    <c:forEach var="review" items="${reviews}">
                        <c:url value="/admin/delete-review" var="url">
                            <c:param name="reviewId" value="${review.getReviewId()}"/>
                            <c:param name="email" value="${review.getEmail()}"/>
                        </c:url>
                        <div>
                            <p style="color: #0b0b0b">Advertisement Id - ${review.getAdvertisementId()}</p>
                            <p style="color: #0b0b0b"> ${review.getReview()}</p>
                            <button style="background-color:red; color: #eeeeee; font-weight: 500; width: 60%"
                                    onclick="window.location.href='${url}'">
                                Remove</button>
                        </div>
                    </c:forEach>
                </div>

            </div>
        </div>

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