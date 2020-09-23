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


</head>
<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">
<h1>My Account</h1>
<h3>
    First Name - ${customer.getFirstName()}
</h3>
<h3>
    Last Name - ${customer.getLastName()}
</h3>
<h3>
    ContactNumber - ${customer.getContactNo()}
</h3>
<h3>
    Email - ${customer.getEmail()}
</h3>
<h3>
    Address - ${customer.getAddress()}
</h3>
<h3>
    Date Of Birth - ${customer.getDob()}
</h3>
<section class="site-section" id="section-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-12 mb-5">
                <div class="section-heading text-center">
                    <h2><strong>My Account</strong></h2>
                    <br>
                </div>
            </div>
            <div class="col-md-7 mb-5 mb-md-0">
                <form action="newInquiry" class="site-form">
                    <div class="form-group">
                        <label>First Name</label>
                        <input name="name" disabled="disabled" type="text" class="form-control px-3 py-4" value="${customer.getFirstName()}">
                    </div>
                    <div class="form-group">
                        <input name="email" id="email" type="email" class="form-control px-3 py-4"
                               placeholder="Your Email">
                    </div>
                    <div class="form-group">
                        <input name="contactNo" id="contactNo" type="number" maxlength="10" minlength="10"
                               class="form-control px-3 py-4" placeholder="Your Phone">
                    </div>
                    <div class="form-group">
                        <input name="subject" id="subject" type="text" class="form-control px-3 py-4"
                               placeholder="Subject">
                    </div>
                    <div class="form-group mb-5">
                        <textarea name="message" id="message" class="form-control px-3 py-4" cols="30" rows="10"
                                  placeholder="Write a Message"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary  px-4 py-3" value="Send Message">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


        <c:url value = "/admin/customers/update-status" var = "url">
            <c:param name = "email" value = "${customer.getEmail()}"/>
        </c:url>
        <a href="${url}">Delete Account</a>

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