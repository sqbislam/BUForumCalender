<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        
    
    </head>
    <body>


        <!-- make url for update -->
        <c:url var="tagLink" value="/teacher">
            <c:param name="tag" value="${tempPost.tag}"/>
        </c:url> 
        <c:url var="deleteLink" value="teacher/deletePost">
            <c:param name="postID" value="${tempPost.id}"/>
        </c:url> 
   

        <div class="row ">
            <div class="col-lg-10 date mygrid ">
                <div class="row">
                    <div class="col-lg-2 mygrid2">${tempPost.student.name}</div>
                    <div class="col-lg-6 mygrid2">${tempPost.content}</div>
                    <div class="col-lg-2 mygrid2"><a href="${tagLink}">#${tempPost.tag}</a></div>
                    <div class="col-lg-1 mygrid2">${tempPost.timestamp} ${tempPost.userTag}</div>
                    <div class="col-lg-1 mygrid2">
                        <c:if test = "${tempPost.student.users.username eq username}">
                            <a href="${deleteLink}"> Delete</a>
                        </c:if>

                    </div>

                </div>
                <br>
                <form:form action="teacher/test" modelAttribute="tempComment" method="post">
                    <input name="postID" type="hidden" value="${tempPost.id}"/>
                    <form:textarea type = "text" path="content" class="post"/>
                    <form:button class="btn btn-outline-primary" value="submit">Submit</form:button> 
                </form:form>

                <br>
                
                
                <c:if test="${fn:length(tempPost.comments) gt 0}">
                         <button class="showMoreBtn" onClick="showComments(${status.index}, this)">Show Comments</button>
                </c:if>
                        
                <div id="commentBox" class="commentglobal">
                 
                    <c:forEach var="tempComment" items="${tempPost.comments}" varStatus="index">
                        
                    <c:url var="deleteCmtLink" value="teacher/deleteComment">
                        <c:param name="commentID" value="${tempComment.id}"/>
                    </c:url> 
                        
                        <br>
                        <div class="commentlocal">
                            <table class="commentTBL">
                            <tr>
                                <td class="comment">${index.index}</td>
                                <td class="comment">${tempComment.student.name}</td>
                                <td class="comment">${tempComment.content}</td>
                                <td class="comment">${tempComment.timestamp}</td>
                                
                                <td class="comment">
                                <c:if test = "${tempComment.student.users.username eq username}">
                                    <a href="${deleteCmtLink}"> Delete</a>
                                </c:if>
                                </td>
                                
                            </tr>
                            </table>
                        </div>

                    </c:forEach>
                 
                </div>
                
                
            </div>
        </div>
        <br>

            <script type="text/javascript" src="<spring:url value="/resources/script.js"/>"></script>
    </body>
</html>

