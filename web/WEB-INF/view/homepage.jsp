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


        <%@include file="header.jsp" %>

        <button class="btn btn-primary" >Find Courses</button>
        <button class="btn btn-primary" >Find Faculties</button>
        <button class="btn btn-primary mytabs" >Your Topics</button>
	    <button class="btn btn-primary mytabs" >Departments</button>
        <div class="jumbotron jmb">
            <h1>Welcome To BracU Discussion Forum </h1>
            <p>Ask any queries you have! You're just a question away!</p>
        </div>
        

<div class="container">
	<div class="row">
			<div class="col-lg-8 date mygrid2 postHeight"> Name of author
			<div class="row">
				<div class="col-lg-2 mygrid2">Date</div>
                                <div class="col-lg-10 mygrid2">
                                    <form:form action="savePost" modelAttribute="posts" method="post">
                             Post:  <form:input path="content" class="post"/>
                                     <button class="btn btn-success" value="submit">Submit</button>
                                    </form:form>
                                    
                                </div>
                        </div>
		</div>
	</div>
</div>
            <br>
        <div class="container">
            <c:forEach var="tempPost" items="${allPosts}">
                  
            <div class="row ">
                <div class="col-lg-8 date mygrid2 postHeight"> Name of author
			<div class="row">
				<div class="col-lg-2 mygrid2">${tempPost.id}</div>
				<div class="col-lg-8 mygrid2">${tempPost.content}</div>
				<div class="col-lg-2 mygrid2">like/unlike</div>
			</div>
		</div>
            </div>
                                <br>   
            </c:forEach>
</div>

                <sec:authentication property="principal.username"/>
                <sec:authentication property="principal.authorities"/>
                <sec:authorize access="hasRole('MANAGER')">
                    <br><br>
                    <table>
                    <c:forEach var="tempStudent" items="${students}">
                        <tr>
                            <td>${tempStudent.name}</td>
                            <td>${tempStudent.username}</td>
                        </tr>
                    </c:forEach>
                    </table>
                    
                    
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
