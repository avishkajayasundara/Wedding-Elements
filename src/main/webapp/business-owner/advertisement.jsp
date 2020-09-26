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
    <link rel="stylesheet" href="../css/flexslider.css">
    <link rel="stylesheet" href="../fonts/icomoon/style.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">

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
                <li class="nav-item"><a class="nav-link" href="<c:url value="/advertisements" />">Advertisements</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="#section-contact">Contact Us</a></li>

                <c:set var="user" value="${user}"/>
                <c:choose>
                    <c:when test="${user != null}">
                        <li class="nav-item"><a class="nav-link" href="#section-contact">Logged in
                            as ${user}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="/login">Login/SignUp</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<section>
    <div class="container">
        <div class="row intro-text align-items-center justify-content-center">
            <div class="col-md-10 text-center pt-5">
                <br><br>
                <h1 style="font-size: 54px; font-weight: bolder" class="site-heading site-animate"><strong
                        class="d-block">
                    ${advertisement.getTitle()} - ${advertisement.getScore()}/10</strong></h1>
                <br>
                <div style="text-align: center">
                    <p id="updateButton" class="submit-btn">
                        Update Advertisement Details
                    </p>
                </div>
            </div>
            <img class="image img-fluid" src="${advertisement.getImage()}" alt="">
        </div>
    </div>
</section> <!-- section -->
<section class="site-section" id="section-about">
    <div class="container">
        <div class=" align-items-center">
            <div>
                <p class="mb-5" style="text-align: center">${advertisement.getDescription()}</p>
                <div style="text-align: center">
                    <p class="btn btn-primary px-4 py-2 btn-sm smoothscroll">
                        Starting from LKR.${advertisement.getStartingPrice()}
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="site-section">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-12">
                <div class="section-heading text-center">
                    <h2 style="text-align: center">Client <strong>Reviews</strong></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach var="review" items="${reviews}">
                <div class="col-md-6">
                    <div class="block-47 d-flex mb-5">
                        <div style="text-align: center;padding-top: 10px; border-color: aqua ; background-color: #0b0b0b;height: 50px;border-radius: 50%" class="block-47-image">
                                ${review.getScore()}/10
                        </div>
                        <blockquote class="block-47-quote">
                            <p>${review.getReview()}</p>
                            <cite class="block-47-quote-author">${review.getName()} - <a
                                    href="#">${review.getEmail()}</a></cite>
                        </blockquote>
                    </div>
                </div>
            </c:forEach>
        </div>
</section>

<!-- .Modal section -->
<div class="bg-modal">
    <div class="modal-content">
        <div class="close">+</div>
        <h3> Update Account Details</h3>
        <form action="/business-owners/update-advertisement" method="post">
            <input type="hidden" name="advertisementId" id="advertisementId" value="${advertisement.getAdvertisementId()}">
            <input class="modal-inputs" name="startingPrice" id="startingPrice" value="${advertisement.getStartingPrice()}">
            <label style="margin-top: 10px">Description</label><br>
            <textarea class="modal-inputs" id="description" name="description" >
                ${advertisement.getDescription()}
            </textarea><br>
            <input style="margin-top: 20px;" class="submit-btn" type="submit" value="Update Details">
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

<script src="../js/vendor/jquery.min.js"></script>
<script src="../js/vendor/jquery-migrate-3.0.1.min.js"></script>
<script src="../js/vendor/popper.min.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>

<script src="../js/vendor/jquery.easing.1.3.js"></script>

<script src="../js/vendor/jquery.stellar.min.js"></script>
<script src="../js/vendor/jquery.waypoints.min.js"></script>

<script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>
<script src="https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js"></script>
<script src="../js/custom.js"></script>

<!-- Google Map -->
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="js/google-map.js"></script> -->

</body>
</html>