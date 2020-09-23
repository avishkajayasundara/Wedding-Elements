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
                        <li class="nav-item"><a class="nav-link" href="/login">Logged in
                            as ${user}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="${contextPath}/login.jsp">Login/SignUp</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<section >
    <div class="container">
        <div class="row intro-text align-items-center justify-content-center">
            <div class="col-md-10 text-center pt-5">
                <h1 style="font-size: 42px; font-weight: bolder" class="site-heading site-animate"><strong class="d-block">
                    ${advertisement.getTitle()}</strong></h1>
            </div>
            <img class="image img-fluid" src="${advertisement.getImage()}" alt="">
        </div>
    </div>
</section> <!-- section -->
<section class="site-section" id="section-about">
    <div class="container">
        <div class=" align-items-center">
            <div>
                <p class="mb-5  ">${advertisement.getDescription()}</p>
                <p  class="btn btn-primary px-4 py-2 btn-sm smoothscroll">
                    Starting from LKR.${advertisement.getStartingPrice()}
                </p>
            </div>
        </div>
    </div>
</section>
<section class="site-section">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-12">
                <div class="section-heading text-center">
                    <h2>Client <strong>Reviews</strong></h2>
                </div>
            </div>
        </div>
        <c:forEach var="reviews" items="${reviews}">
        <div class="row">
            <div class="col-md-6">

                <div class="block-47 d-flex mb-5">
                    <div class="block-47-image">
                        <img src="../images/person_1.jpg" alt="Image placeholder" class="img-fluid">
                    </div>
                    <blockquote class="block-47-quote">
                        <p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and
                            Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the
                            coast of the Semantics, a large language ocean.&rdquo;</p>
                        <cite class="block-47-quote-author">&mdash; Ethan McCown, CEO <a href="#">XYZ Inc.</a></cite>
                    </blockquote>
                </div>
            </div>
        </div>
        </c:forEach>

</section>


<section class="site-section" id="section-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-12 mb-5">
                <div class="section-heading text-center">
                    <h2>Add your <strong>Review</strong></h2>
                </div>
            </div>

            <div class="col-md-7 mb-5 mb-md-0">
                <form action="/user/addReview" method="post" class="site-form">
                    <input name="advertisementId" id="advertisementId" type="hidden" value="${advertisement.getAdvertisementId()}">
                    <div class="form-group">
                        <input name="score" id="score" type="number" max="10" min="1" class="form-control px-3 py-4"
                               placeholder="Rate out of 10">
                    </div>
                    <div class="form-group mb-5">
                        <textarea name="review" id="review" class="form-control px-3 py-4" cols="30" rows="10"
                                  placeholder="Write your Feedback"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary  px-4 py-3" value="Submit Review">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<footer class="site-footer">
    <div class="container">
        <div class="row mb-5">
            <p class="col-12 text-center">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;
                <script>document.write(new Date().getFullYear());</script>
                All rights reserved | This template is made with <i class="icon-heart text-danger"
                                                                    aria-hidden="true"></i> by <a
                    href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
        </div>

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