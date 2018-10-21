
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>List
        </title>
    </head>
    <body>
List
<c:forEach var="temp" items="${students}">
    ${temp.name}
    ${temp.username}
</c:forEach>
    </body>
</html>

