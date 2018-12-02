<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 date mygrid postHeight">
                    <div class="row">
                        <div class="col-lg-2 mygrid2">Post Here</div>
                        <div class="col-lg-10 mygrid2">
                            <form:form action="teacher/savePost" modelAttribute="posts" method="post">
                                <form:hidden path = "userTag" value="auth"/>
                                <form:textarea type = "text" path="content" class="post"/>
                                  &nbsp;&nbsp;#Tag: 
                                         <form:select path="tag" items = "${taglist}"></form:select>
                                    &nbsp;&nbsp;&nbsp;
                                <form:button class="btn btn-success" value="submit">Submit</form:button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


