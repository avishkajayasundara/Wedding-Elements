<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2020
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/registerstyle.css">
</head>
<body>
<%--<div class="main" id="background">--%>
<div class="main">
    <H1 style="color: white;font-size: 60px;padding: 10%"></H1>
    <section class="signup">
        <div class="container" style="margin-left: 54%; width: 45%; margin-top: -12%">
            <div class="signup-content">
                <form action="addCustomer" method="post" id="signup-form" class="signup-form">
                    <h2 class="form-title">Create account</h2>
                    <div class="form-group">
                        First Name
                        <input type="text" class="form-input" name="firstName" id="firstName" placeholder="First Name" required="required"/>
                    </div>
                    <div class="form-group">
                        Last Name
                        <input type="text" class="form-input" name="lastName" id="lastName" placeholder="Last Name" required="required"/>
                    </div>
                    <div class="form-group">
                        Email
                        <input type="email" class="form-input" name="email" id="email" placeholder="Your Email" required="required"/>
                    </div>
                    <div class="form-group">
                        Address
                        <input type="text" aria-multiline="true"  class="form-input" name="address" id="address" placeholder="your Address" required="required"/>
                    </div>
                    <div class="form-group">
                        Gender<br>
                        <select class="form-input" id="gender" name="gender" required="required">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div class="form-group">
                        Contact Number
                        <input type="number" maxlength="10" minlength="10" aria-multiline="true"  class="form-input" name="contactNo" id="contactNo" placeholder="Contact Number" required="required"/>
                    </div>
                    <div class="form-group">
                        Date Of Birth
                        <input type="date" aria-multiline="true"  class="form-input" name="dob" id="dob" required="required"/>
                    </div>
                    Password
                    <div class="form-group">
                        <input type="password" minlength="6" class="form-input" name="password" id="password" placeholder="Password" required="required"/>
                        <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term"  required="required"/>
                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                    </div>
                </form>
                <p class="loginhere">
                    Have already an account ? <a href="login.jsp" class="loginhere-link">Login here</a>
                </p>
            </div>
        </div>
    </section>
</div>

<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
