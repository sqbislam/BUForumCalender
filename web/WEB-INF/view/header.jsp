<!DOCTYPE html>
<html lang= "en">
    <head>
        <meta charset="UTF-8">
        <title> BracU Calender & Forum </title>

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

                        <li>
                        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                            <form action="{pageContext.request.contextPath}/logout" method="POST">
                                <input class="btn btn-sml" type="submit" value="logout"/>
                        </form:form>
                        </form>
                        </li>
                        <!-- Add more components here as necessary -->

                    </ul>
                </div>
            </div>
        </nav>