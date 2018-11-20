<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    <%@include file="header.jsp" %>
    Id: ${customerDTO.id}
    <br/>
    First name: ${customerDTO.firstName}
    <br/>
    Last name: ${customerDTO.lastName}
    <br/>
    Phone: ${customerDTO.phone}
    <br/>
    Email: ${customerDTO.email}
    <br/>
    Tours: ?
</body>
</html>
