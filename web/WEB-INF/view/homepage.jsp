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
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" crossorigin="anonymous">
    </head>
    <body>


        <%@include file="header.jsp" %>
        <div class="topButtons">
            <button class="btn btn-primary" >Find Courses</button>
            <button class="btn btn-primary" >Find Faculties</button>
            <button class="btn btn-primary mytabs" >Your Posts</button>
            <button class="btn btn-primary mytabs" >Departments</button>
            &nbsp;&nbsp;Logged in as: <sec:authentication property="principal.username"/>
            <sec:authentication property="principal.authorities"/>
        </div>


        <div class="jumbotron jmb">
            <h1>Welcome To BracU Discussion Forum </h1>
            <p>Ask any queries you have! You're just a question away!</p>
        </div>

                    <!--        Inserting a new post -->
        <div class="container">
            <div class="row">
                <div class="col-lg-10 date mygrid postHeight">
                    <div class="row">
                        <div class="col-lg-2 mygrid2">Post Here</div>
                        <div class="col-lg-10 mygrid2">
                            <form:form action="student/savePost" modelAttribute="posts" method="post">
                                <form:textarea type = "text" path="content" class="post"/>
                                  &nbsp;&nbsp;#Tag: 
                                         <form:select path="tag" items = "${taglist}">
                                        </form:select>
                                    &nbsp;&nbsp;&nbsp;
                                <form:button class="btn btn-success" value="submit">Submit</form:button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <hr>

        
        <!--next 90 lines associated with editing deleting and updating posts-->

        <div class="container">
            <!--            Loop through all the posts requested-->
            <c:forEach var="tempPost" items="${allPosts}" varStatus="status">


                <!--        when edit link is clicked show an input form-->
                <c:if test="${param.edit == tempPost.id}">


                    <c:url var="deleteLink" value="student/deletePost">
                        <c:param name="postID" value="${tempPost.id}"/>
                    </c:url> 


                    <div id="edit" class="row ">
                        <div class="col-lg-10 date mygrid postHeight">
                            <div class="row">
                                <form:form action="student/editPost" modelAttribute="temp" method="post">
                                    <form:hidden path = "id" />
                                    <div class="col-lg-2 mygrid2">${tempPost.student.name}</div>
                                    <div class="col-lg-6 mygrid2">
                                        <form:textarea path="content" class="post"></form:textarea> 
                                    </div>
                                    <div class="col-lg-2 mygrid2"> 

                                        <form:select path="tag" items = "${taglist}">
                                        </form:select>


                                    </div>
                                    <div class="col-lg-1 mygrid2">${tempPost.timestamp}</div>
                                    <div class="col-lg-1 mygrid2">
                                        <c:if test = "${tempPost.student.users.username eq username}">
                                            <a href=${deleteLink}>Delete</a>
                                        </c:if>
                                        <form:button class="btn btn-outline-primary btn-sm" value="submit">
                                            Submit
                                        </form:button>
                                    </form:form>
                                    </div>

                            </div>
                        </div>
                    </div>
                    <br>
                </c:if>


                <!--                    when edit link is not clicked show the post -->

                <c:if test="${param.edit != tempPost.id}">
                    <!-- make url for update -->
                    <c:url var="tagLink" value="/student">
                        <c:param name="tag" value="${tempPost.tag}"/>
                    </c:url> 
                    <c:url var="deleteLink" value="student/deletePost">
                        <c:param name="postID" value="${tempPost.id}"/>
                    </c:url> 
                    <c:url var="editLink" value="/student?edit=${tempPost.id}#edit">
                       
                    </c:url> 

                    <div class="row ">
                        <div class="col-lg-10 date mygrid ">
                            <div class="row">
                                <div class="col-lg-2 mygrid2">${tempPost.student.name}</div>
                                <div class="col-lg-6 mygrid2">${tempPost.content}</div>
                                <div class="col-lg-2 mygrid2"><a href="${tagLink}">#${tempPost.tag}</a></div>
                                <div class="col-lg-1 mygrid2">${tempPost.timestamp}</div>
                                <div class="col-lg-1 mygrid2">
                                    <c:if test = "${tempPost.student.users.username eq username}">
                                        <a href=${deleteLink}>Delete</a>
                                        <a href=${editLink}>Edit</a>

                                    </c:if>
                                </div>

                            </div>
                        </div>
                    </div>
                    <br>
                </c:if>

                    
                    
            </c:forEach>
        </div>


        <sec:authorize access="hasRole('TEACHER')">
            <br><br>
            <a href="${pageContext.request.contextPath}/teacher/edit">EDIT CALENDER</a>
        </sec:authorize>

        <%@include file="footer.jsp" %>

        <script
        src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
