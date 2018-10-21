
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>List
        </title>
    </head>
    <body>
List
<br>
<c:forEach var="temp" items="${students}">
    Name: ${temp.name} <br>
    Username: ${temp.username} <br><br>
</c:forEach>
    </body>
</html>

