<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
    <body>

                
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
    </body>
</html>

