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

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700" rel="stylesheet">
    <style>
        .bg-modal{
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.7);
            top: 0%;
            position: absolute;
            display: flex;
            justify-content: center;
            align-items: center;
            display: none;
        }
        .modal-content{
            width: 480px;
            height: 400px;
            background-color: #222222;
            opacity: 1;
            border-radius: 10px;
            padding: 10px;
            text-align: center;
            position: relative;
        }
        .modal-inputs{
            width: 400px;
            border-radius: 10px;
            color: #FFFFFF;
            background-color: #222222;
        }
        .close{
            position: absolute;
            top: 0%;
            right: 14px;
            font-size: 42px;
            transform: rotate(45deg);
            cursor: pointer;
            color: #FFFFFF;
        }
        .submit-btn{
            border-radius: 10px;
            background-color: #bac964;
            padding-bottom: 5px;
            padding-top: 5px;
            padding-left: 10px;
            padding-right: 10px;
        }
    </style>

</head>
<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">
<nav class="navbar navbar-expand-lg site-navbar navbar-light bg-light" id="pb-navbar">

    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09"
                aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample09">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="#section-home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#section-portfolio">About Us</a></li>
                <li class="nav-item"><a class="nav-link" href="${contextPath}/advertisements">Advertisements</a></li>
                <li class="nav-item"><a class="nav-link" href="#section-contact">Contact Us</a></li>

                <c:set var="user" value="${user}"/>
                <c:choose>
                    <c:when test="${user != null}">
                        <li  class="nav-item"><a style="margin-left: 135%" class="nav-link" href="/user">Account</a></li>
                        <li class="nav-item"><a style="margin-left: 135%" class="nav-link" href="/logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a style="margin-left: 135%" class="nav-link" href="${contextPath}/login.jsp">Login/SignUp</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<div style="margin-top: 200px" class="container">
    <h1 style="margin-bottom: 100px; text-align: center">My Account</h1>

    <div class="row">
        <div style="width: 40%" class="col-sm">
            <h2 style="margin-bottom: 20px">Account Details</h2>

            <p>
                First Name - ${customer.getFirstName()}
            </p>
            <p>
                Last Name - ${customer.getLastName()}
            </p>
            <p>
                ContactNumber - ${customer.getContactNo()}
            </p>
            <p>
                Email - ${customer.getEmail()}
            </p>
            <p>
                Address - ${customer.getAddress()}
            </p>
            <p>
                Date Of Birth - ${customer.getDob()}
            </p>
            <div class="form-group">
                <BUTTON type="submit" id="updateButton" class="btn btn-primary submit-btn  px-4 py-3" value="Send Message">
                    Update Details
                </BUTTON>
            </div>
        </div>
        <div style="width: 60%" class="col-sm">
            <h2 style="margin-bottom: 20px">Posted Reviews</h2>
            <c:forEach var="review" items="${reviews}">
                <div style="border-radius: 5px; border-color: #FFFFFF; border-width: 3px">
                    <p style="margin-bottom: 10px;margin-top: 10px">Advertisement Id - ${review.getAdvertisementId()}</p>
                    <p > ${review.getReview()}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
    <!-- .Modal section -->
    <div class="bg-modal">
        <div class="modal-content">
            <div class="close">+</div>
            <h3> Update Account Details</h3>
            <form action="/customer/update-profile" method="post">
                <input type="hidden" value="${customer.getEmail()}" name="email">
                <label style="margin-top: 10px">Contact Number</label><br>
                <input class="modal-inputs" type="text" id="number" name="contactNo" value="${customer.getContactNo()}"><br>
                <label style="margin-top: 10px">Address</label><br>
                <input class="modal-inputs" type="text" id="bAddress" name="address" value="${customer.getAddress()}"><br>
                <label style="margin-top: 10px">Password</label><br>
                <input class="modal-inputs" type="password" id="password" name="password" value="${customer.getAddress()}"><br>
                <input style="margin-top: 20px;" class="submit-btn" type="submit" value="Update Profile">
            </form>
        </div>

    </div>


    <script>
        document.getElementById("updateButton").addEventListener('click',function () {
            document.querySelector('.bg-modal').style.display = "flex";
        });
        document.querySelector('.close').addEventListener('click',function () {
            document.querySelector('.bg-modal').style.display = "none"
        });
    </script>
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