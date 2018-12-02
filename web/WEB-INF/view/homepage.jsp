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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" crossorigin="anonymous">
        
        
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>


        <%@include file="header.jsp" %>
        
        <div class="topButtons">
            
            &nbsp;&nbsp;
            Logged in as: <sec:authentication property="principal.username"/>
           
        </div>


        <div class="jumbotron jmb">
            <h1>Welcome To BracU Discussion Forum </h1>
            <p>Ask any queries you have! You're just a question away!</p>
        </div>


        <!--        Inserting a new post -->
        <%@include file = "insertPost.jsp" %>

        <hr>


        <!--next lines associated with editing deleting and updating posts-->

        <div class="container">

            <!--            Loop through all the posts requested-->
            <c:forEach var="tempPost" items="${allPosts}" varStatus="status">


                    <!--        when edit link is clicked show an input form      -->
                    <c:if test="${param.edit == tempPost.id}">
                        <%@include file = "editLink.jsp" %>
                    </c:if>


                    <!--   when edit link is not clicked show the post -->
                    <c:if test="${param.edit != tempPost.id}">
                        <%@include file = "editLinkNot.jsp" %>
                    </c:if>


            </c:forEach>

            <c:url var="showMore" value="/student/showMore">
                    <c:param name="flag" value="true"/>
            </c:url>
                    
            <c:url var="showLess" value="/student/showMore">
                <c:param name="flag" value="false"/>
            </c:url>
                    
            <a id = "anchor" href="${showMore}">Show More Posts</a>
            
            
            <a href="${showLess}" style="float: right">Show Less Posts</a>
        </div>





        <sec:authorize access="hasRole('TEACHER')">
            <br><br>
            <a href="${pageContext.request.contextPath}/teacher/edit">EDIT CALENDER</a>
        </sec:authorize>

        <%@include file="footer.jsp" %>

    </body>
</html>
