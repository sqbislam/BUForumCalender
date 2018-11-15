<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
    <body>
        
        <c:if test="${param.edit != tempPost.id}">
                    <!-- make url for update -->
                    <c:url var="tagLink" value="/student">
                        <c:param name="tag" value="${tempPost.tag}"/>
                    </c:url> 
                    <c:url var="deleteLink" value="student/deletePost">
                        <c:param name="postID" value="${tempPost.id}"/>
                    </c:url> 
                    <c:url var="editLink" value="/student?edit=${tempPost.id}&showMore=true#edit">
                       
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
                                <br>
                                <form:form action="student/test" modelAttribute="tempComment" method="post">
                                    <input name="postID" type="hidden" value="${tempPost.id}"/>
                                    <form:textarea type = "text" path="content" class="post"/>
                                    <form:button class="btn btn-outline-primary" value="submit">Submit</form:button> 
                                </form:form>
                                    
                                     <br>
                    Comments: 
                                        <c:forEach var="tempComment" items="${tempPost.comments}" varStatus="index">
                                            <br>
                                            ${index.index}&nbsp;&nbsp;&nbsp;${tempComment.student.name}&nbsp;&nbsp;&nbsp;${tempComment.content}
                                            
                                        </c:forEach>
                        </div>
                    </div>
                    <br>
                   
                </c:if>

    </body>
</html>
