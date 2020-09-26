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
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/flexslider.css">
    <link rel="stylesheet" href="../fonts/icomoon/style.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/style.css">

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,700" rel="stylesheet">


</head>
<body id="advertisementspage" data-spy="scroll" data-target="#pb-navbar" data-offset="200">

<h1>Business Profile</h1>
<h3>
    Name - ${business.getName()}
</h3>
<h3>
    Email - ${business.getEmail()}
</h3>
<h3>
    Contact Number - ${business.getContactNo()}
</h3>
<h3>
    ${business.getBusinessType()}
</h3>
<h3>
    ${business.getAddress()}
</h3>
<h3>
    ${business.getDescription()}
</h3>

<c:set var="status" value="${business.getStatus()}"/>
<c:choose>
    <c:when test="${status == 'ACTIVE'}">
        <c:url value = "/admin/business-owners/update-status" var = "url">
            <c:param name = "status" value = "DISABLE"/>
            <c:param name = "email" value = "${business.getEmail()}"/>
        </c:url>
        <a href="${url}">Deactivate Account</a>
    </c:when>
    <c:otherwise>
        <c:url value = "/admin/business-owners/update-status" var = "url">
            <c:param name = "status" value = "ACTIVE"/>
            <c:param name = "email" value = "${business.getEmail()}"/>
        </c:url>
        <a href="${url}">Activate Account</a>
    </c:otherwise>
</c:choose>
<section class="site-section" id="section-portfolio">
    <div class="container">
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

</body>
</html>