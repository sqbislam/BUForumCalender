<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html lang= "en">
    <head>
        <meta charset="UTF-8">
        <title>Login </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
        <style>
            
            .buttonDesign{
                text-align: center;
                margin:100px;



            }
            h1{
                padding:50px;
                background-color: #BBDEFB;
                text-align: center;
            }
            body{
                background-color:rgba(187,222,251,0.5) ;

            }
            form{
                margin:100px;
            }
            .fyp{
                text-align: right;

            }
            .logout{
                color: green;
                /*margin-top: 100px;
                margin-left: 100px;*/
            }
            .wrongpass{
                color:red;
                /*margin-left: 100px;
                margin-top: 100px;*/

            }



        </style>
    </head>
    <body>
        <h1> WELCOME TO BRACU CALENDER & FORUM</h1>

        <form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/authenticate">
            <div class="container">
                
                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label" for="formGroupInputLarge">Username</label>
                    <div class="col-xs-7">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input class="form-control" type="text" name="username" placeholder="******">
                    </div>
                        
                </div>
                <div class="form-group form-group-lg">
                    <label class="col-sm-2 control-label" for="formGroupInputLarge">Password</label>
                    <div class="col-xs-7">
                        <input class="form-control" type="password" name="password" placeholder="atleast 6 characters">
                    </div>
                    <div class="buttonDesign">
                        <button class="btn btn-primary" value="submit">Login</button>
                    </div>


                    <div class="container">
                        <c:if test="${param.logout != null}">
                        <div class="logout">Successfully Logged Out </div>
                        </c:if>
                        <c:if test="${param.error != null}">
                        <div class="wrongpass">Invalid Username or Password</div>
                        </c:if>
                    </div>
                    <div class="fyp">
                        <button class="btn btn-default btn-lg active">Forgot your password?</button>
                    </div>
                </div>

            </div>

        </form>
    </body>