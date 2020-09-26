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
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700" rel="stylesheet">

    <style>
        .bg-modal {
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            top: 0%;
            position: absolute;
            display: flex;
            justify-content: center;
            align-items: center;
            display: none;
        }

        .modal-content {
            width: 480px;
            height: 600px;
            background-color: #222222;
            opacity: 1;
            border-radius: 10px;
            padding: 10px;
            text-align: center;
            position: relative;
        }

        .modal-inputs {
            width: 400px;
            border-radius: 10px;
            color: #FFFFFF;
            background-color: #222222;
        }

        .close {
            position: absolute;
            top: 0%;
            right: 14px;
            font-size: 42px;
            transform: rotate(45deg);
            cursor: pointer;
            color: #FFFFFF;
        }

        .submit-btn {
            border-radius: 10px;
            background-color: #bac964;
            padding-bottom: 5px;
            padding-top: 5px;
            padding-left: 10px;
            padding-right: 10px;
        }
    </style>

</head>
<body id="advertisementspage" data-spy="scroll" data-target="#pb-navbar" data-offset="200">
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
                        <li class="nav-item"><a style="margin-left: 135%" class="nav-link" href="/user">Account</a></li>
                        <li class="nav-item"><a style="margin-left: 135%" class="nav-link" href="/logout">Logout</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a style="margin-left: 135%" class="nav-link"
                               href="${contextPath}/login.jsp">Login/SignUp</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<div style="margin-top: 8%" class="container">
    <h1 style="text-align: center; margin-bottom: 100px">Business Profile</h1>
    <div class="row">
        <div style="width: 25%">
            <p>

                Name of the Business - ${business.getName()}
            </p>
            <p>
                Email - ${business.getEmail()}
            </p>
            <p>
                Contact Number - ${business.getContactNo()}
            </p>
            <p>
                Business Category - ${business.getBusinessType()}
            </p>
            <p>
                Address - ${business.getAddress()}
            </p>
            <h5>About the Business</h5>
            <p style="font-size: 11px;margin-top: 10px; text-align: justify">
                ${business.getDescription()}
            </p>

        </div>
        <div class="col-sm">
            <section class="site-section" id="section-portfolio">
                <div class="container">
                    <div class="filters-content">
                        <div class="row grid">
                            <c:forEach var="advertisement" items="${advertisements}">
                                <c:url value="/business-owners/advertisement" var="url">
                                    <c:param name="advertisementId" value="${advertisement.getAdvertisementId()}"/>
                                </c:url>
                                <a href="${url}">
                                    <div class="single-portfolio col-sm-4 all ${advertisement.getCategory()} mockup">
                                        <div class="relative">
                                            <div class="thumb">
                                                <div class="overlay overlay-bg"></div>
                                                <img class="image img-fluid" src="${advertisement.getImage()}" alt="" style="margin-top: -30%">
                                            </div>
                                        </div>
                                        <div class="p-inner">
                                            <h4>${advertisement.getTitle()}</h4>
                                            <div class="cat">Starting from Rs.${advertisement.getStartingPrice()}</div>
                                        </div>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </section>
        </div>

    </div>
</div>


<!-- .section -->
<footer class="site-footer">
    <div class="container">

        <div class="row mb-5">
            <div class="col-md-12 text-center">
                <p>
                    <a href="#" class="social-item"><span class="icon-facebook2"></span></a>
                    <a href="#" class="social-item"><span class="icon-twitter"></span></a>
                    <a href="#" class="social-item"><span class="icon-instagram2"></span></a>
                    <a href="#" class="social-item"><span class="icon-linkedin2"></span></a>
                    <a href="#" class="social-item"><span class="icon-vimeo"></span></a>
                </p>
            </div>
        </div>

    </div>
</footer>

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