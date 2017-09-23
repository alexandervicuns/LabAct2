<%-- 
    Document   : listusers
    Created on : 09 21, 17, 1:44:59 PM
    Author     : Bacon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${request.view}" var = "user">
            <c:out value="${user.firstName}"/>
        </c:forEach>
    </body>
</html>
