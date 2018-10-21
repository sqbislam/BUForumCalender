<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang= "en">
    <head>
        <meta charset="UTF-8">
        <title> BracU Calender & Forum </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href='<spring:url value="/resources/cse310.css"/>'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
    </head>
    <body>

        <!-- Main Navbar class -->

        <nav class="navbar navbar-default">
            <div class="container"> 
                <!-- Nav bar container and headet -->
                <div class="navbar-header">
                    <!-- This button is for making the three lines when the window is made small/ not necessary
                     but makes it look good-->
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-nav-demo" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- This is where the buttons start this is the main icon and brand name -->
                    <a href="#" class="navbar-brand"><i class="fas fa-book"></i> BRACU FORUM</a>
                </div>

                <!-- This is the things on right of the brand name -->
                <div class="collapse navbar-collapse" id="bs-nav-demo">
                    <ul class="nav navbar-nav">
                        <!-- anything you want to give on the right give them between <li> Your component here</li> -->
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>

                    </ul>

                    <!-- anything you want to give on the left give them between <li> Your component here</li> inside the <ul>-->
                    <ul class="nav navbar-nav navbar-right">  
                        <li>
                            <form role="search">
                                <input type="text" placeholder="Search">
                                <button type="submit" class = "btn btn-default" >Go!</button>
                            </form>
                        </li>

                        <!-- Your dropdown menu inside the li -->
                        <li>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Departments
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">ARC</a></li>
                                    <li><a href="#">BBS</a></li>
                                    <li><a href="#">BIL</a></li>
                                    <li><a href="#">CSE</a></li>
                                    <li><a href="#">EEE</a></li>
                                    <li><a href="#">ENH</a></li>
                                    <li><a href="#">ESS</a></li>
                                    <li><a href="#">PHR</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>
                        </li>
                        
                        <li>
                            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                <input class="btn btn-sml" type="submit" value="logout"/>
                            </form:form>
                        </li>
                        <!-- Add more components here as necessary -->

                    </ul>
                </div>
            </div>
        </nav>



        <button class="btn btn-primary" >Find Courses</button>
        <button class="btn btn-primary" >Find Faculties</button>
        <div class="jumbotron jmb">
            <h1>Welcome To BracU Discussion Forum </h1>
            <p>Ask any queries you have! You're just a question away!</p>
        </div>



        <div class="container">
            <div class="row">
                <div class="col-lg-8 mygrid">Post Here</div>
                <div class="col-lg-4 mygrid">Topics</div>
                <sec:authentication property="principal.username"/>
                <sec:authentication property="principal.authorities"/>
                <sec:authorize access="hasRole('MANAGER')">
                <a href="${pageContext.request.contextPath}/edit">EDIT CALENDER</a>
                </sec:authorize>
            </div>
        </div>
        
        
        <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>