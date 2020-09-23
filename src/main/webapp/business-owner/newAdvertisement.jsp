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
    <link rel="stylesheet" href="../fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="../css/registerstyle.css">
</head>
<body>

<div class="main" id="background">
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <form action="addAdvertisement" method="post" id="signup-form" class="signup-form">
                    <h2 class="form-title">Create account</h2>
                    <div class="form-group">
                        Title
                        <input type="text" class="form-input" name="title" id="title" placeholder="Advertisement Title"/>
                    </div>
                    <div class="form-group">
                        Description
                        <input type="text" class="form-input" name="description" id="description" placeholder="Advertisement Description"/>
                    </div>
                    <div class="form-group">
                        Image Url
                        <input type="url" class="form-input" name="image" id="image" placeholder="Image URl"/>
                    </div>
                    <div class="form-group">
                        Category<br>
                        <select class="form-input" id="category" name="category">
                            <option value="Cakes">Cakes</option>
                            <option value="Cards">Cards</option>
                            <option value="Food">Food</option>
                            <option value="Venues">Venues</option>
                            <option value="Dancers">Dancers</option>
                            <option value="Music">Music</option>
                            <option value="Videography">Liquor</option>
                            <option value="Photography">Liquor</option>
                        </select>
                    </div>
                    <div class="form-group">
                        Starting Price(LKR)
                        <input type="number" class="form-input" name="startingPrice" id="startingPrice" placeholder="Starting Price"/>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit" value="Post Advertisement"/>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<!-- JS -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
