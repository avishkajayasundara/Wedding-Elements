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


<section class="site-hero"
         style="background-image: url(https://images.pexels.com/photos/2959192/pexels-photo-2959192.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);"
         id="section-home" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row intro-text align-items-center justify-content-center">
            <div class="col-md-10 text-center pt-5">

                <h1 class="site-heading site-animate">Your Happily Ever After Begins Here <strong class="d-block">Wedding
                    Elements</strong></h1>
                <strong class="d-block text-white text-uppercase letter-spacing">Designing your perfect day</strong>

            </div>
        </div>
    </div>
</section> <!-- section -->


<section class="site-section" id="section-portfolio">
    <div class="container">
        <div class="row">
            <div class="section-heading text-center col-md-12">
                <h2>Featured <strong>Advertisements</strong></h2>
            </div>
        </div>
        <div class="filters">
            <ul>
                <li class="active" data-filter="*">All</li>
                <li data-filter=".Venues">Venues</li>
                <li data-filter=".Music">Music</li>
                <li data-filter=".Cakes">Cakes</li>
                <li data-filter=".Food">Food</li>
                <li data-filter=".Cards">Cards</li>
                <li data-filter=".Photography">Photography</li>
                <li data-filter=".Videography">Videography</li>
            </ul>
        </div>

        <div class="filters-content">
            <div class="row grid">
                <c:forEach var="advertisement" items="${advertisements}">
                    <c:url value = "/advertisement" var = "url">
                        <c:param name = "advertisementId" value = "${advertisement.getAdvertisementId()}"/>
                    </c:url>
                    <a href="${url}">
                        <div class="single-portfolio col-sm-4 all ${advertisement.getCategory()} mockup">
                            <div class="relative">
                                <div class="thumb">
                                    <div class="overlay overlay-bg"></div>
                                    <img class="image img-fluid" src="${advertisement.getImage()}" alt="">
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
<!-- .section -->

<section class="site-section" id="section-about">
    <div class="container">
        <div class="row mb-5 align-items-center">
            <div class="col-lg-7 pr-lg-5 mb-5 mb-lg-0">
                <img src="http://www.gbehost.com/wp-content/uploads/2020/01/hd6.jpg" alt="Image placeholder"
                     class="img-fluid">
            </div>
            <div class="col-lg-5 pl-lg-5">
                <div class="section-heading">
                    <h2>About <strong>Us</strong></h2>
                </div>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                    incididunt </p>
                <p class="mb-5  ">If you have any intentions or omnipotence, it is a natural error to be accused of
                    doloremque laudantium, totally rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                    architecto beatae vitae dicta sunt explicabo.</p>

                <p>
                    <a href="#section-contact" class="btn btn-primary px-4 py-2 btn-sm smoothscroll">Get In Touch</a>
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
                    <h2>Client <strong>Testimonial</strong></h2>
                </div>
            </div>
        </div>
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
            <div class="col-md-6">

                <div class="block-47 d-flex mb-5">
                    <div class="block-47-image">
                        <img src="../images/person_2.jpg" alt="Image placeholder" class="img-fluid">
                    </div>
                    <blockquote class="block-47-quote">
                        <p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and
                            Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the
                            coast of the Semantics, a large language ocean.&rdquo;</p>
                        <cite class="block-47-quote-author">&mdash; Craig Gowen, CEO <a href="#">XYZ Inc.</a></cite>
                    </blockquote>
                </div>

            </div>

            <div class="col-md-6">

                <div class="block-47 d-flex mb-5">
                    <div class="block-47-image">
                        <img src="../images/person_3.jpg" alt="Image placeholder" class="img-fluid">
                    </div>
                    <blockquote class="block-47-quote">
                        <p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and
                            Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the
                            coast of the Semantics, a large language ocean.&rdquo;</p>
                        <cite class="block-47-quote-author">&mdash; Ethan McCown, CEO <a href="#">XYZ Inc.</a></cite>
                    </blockquote>
                </div>

            </div>
            <div class="col-md-6">

                <div class="block-47 d-flex mb-5">
                    <div class="block-47-image">
                        <img src="../images/person_4.jpg" alt="Image placeholder" class="img-fluid">
                    </div>
                    <blockquote class="block-47-quote">
                        <p>&ldquo;Far far away, behind the word mountains, far from the countries Vokalia and
                            Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the
                            coast of the Semantics, a large language ocean.&rdquo;</p>
                        <cite class="block-47-quote-author">&mdash; Craig Gowen, CEO <a href="#">XYZ Inc.</a></cite>
                    </blockquote>
                </div>

            </div>

        </div>
    </div>
</section>

<section class="site-section" id="section-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-12 mb-5">
                <div class="section-heading text-center">
                    <h2>Get <strong>In Touch</strong></h2>
                </div>
            </div>

            <div class="col-md-7 mb-5 mb-md-0">
                <form action="newInquiry" class="site-form">
                    <h3 class="mb-5">Get In Touch</h3>
                    <div class="form-group">
                        <input name="name" id="name" type="text" style="color: white" class="form-control px-3 py-4" placeholder="Your Name">
                    </div>
                    <div class="form-group">
                        <input name="email" id="email" type="email" style="color: white" class="form-control px-3 py-4"
                               placeholder="Your Email">
                    </div>
                    <div class="form-group">
                        <input name="contactNo" id="contactNo" type="number" style="color: white" maxlength="10" minlength="10"
                               class="form-control px-3 py-4" placeholder="Your Phone">
                    </div>
                    <div class="form-group">
                        <input name="subject" id="subject" type="text" style="color: white" class="form-control px-3 py-4"
                               placeholder="Subject">
                    </div>
                    <div class="form-group mb-5">
                        <textarea name="message" id="message" style="color: white" class="form-control px-3 py-4" cols="30" rows="10"
                                  placeholder="Write a Message"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary  px-4 py-3" value="Send Message">
                    </div>
                </form>
            </div>
            <div class="col-md-5 pl-md-5">
                <h3 class="mb-5">Our Contact Details</h3>
                <ul class="site-contact-details">
                    <li>
                        <span class="text-uppercase">Email</span>
                        site@gmail.com
                    </li>
                    <li>
                        <span class="text-uppercase">Phone</span>
                        +30 976 1382 9921
                    </li>
                    <li>
                        <span class="text-uppercase">Fax</span>
                        +30 976 1382 9922
                    </li>
                    <li>
                        <span class="text-uppercase">Address</span>
                        Nawala, Colombo <br>
                        4th Floor8 Lower <br>
                        Narahenpita Road, M1 50F
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>


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