<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2020
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/registerstyle.css">
</head>
<body>

<div class="main" id="background">

    <h1 style="color:white;">LOLOLOLOLOLOLOL</h1>

    <section class="signup">
        <%--        <div class="container">--%>
        <div class="container" style="margin-left: 54%; width: 45%; margin-top: -12%">
            <div class="signup-content">
                <form action="addBusiness" method="post" id="signup-form" class="signup-form">
                    <h2 class="form-title">Create account</h2>
                    <div class="form-group">
                        Name Of Business
                        <input type="text" class="form-input" name="name" id="name" placeholder="Name"/>
                    </div>
                    <div class="form-group">
                        Description
                        <input type="text" class="form-input" name="description" id="description"
                               placeholder="Few Words about the business"/>
                    </div>
                    <div class="form-group">
                        Email
                        <input type="email" class="form-input" name="email" id="email" placeholder="Your Email"/>
                    </div>
                    <div class="form-group">
                        Address
                        <input type="text" aria-multiline="true" class="form-input" name="address" id="address"
                               placeholder="Few Words about the business"/>
                    </div>
                    <div class="form-group">
                        Business Type<br>
                        <select class="form-input" id="businessType" name="businessType">
                            <option value="Cakes">Cakes</option>
                            <option value="Cards">Cards</option>
                            <option value="Food">Food</option>
                            <option value="Venues">Venues</option>
                            <option value="Dancers">Dancers</option>
                            <option value="Music">Music</option>
                            <option value="Liquor">Liquor</option>
                            <option value="Dancers">Dancers</option>
                        </select>
                    </div>
                    <div class="form-group">
                        Country<br>
                        <select class="form-input" id="country" name="country">
                            <option value="Sri Lanka">Sri Lanka</option>
                            <option value="India">India</option>
                        </select>
                    </div>
                    Password
                    <div class="form-group">
                        <input type="text" class="form-input" name="password" id="password" placeholder="Password"/>
                        <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                    </div>
                    Repeat Password
                    <div class="form-group">
                        <input type="password" class="form-input" name="re_password" id="re_password"
                               placeholder="Repeat your password"/>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term"/>
                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all
                            statements in <a href="#" class="term-service">Terms of service</a></label>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                    </div>
                </form>
                <p class="loginhere">
                    Have already an account ? <a href="#" class="loginhere-link">Login here</a>
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
