<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New tour</title>
</head>
<body>
    Add new tour
    <form:form method="post" modelAttribute="tourForm">
        <form:input path="destination" placeholder="destinantion"/>
        <form:errors path="destination"/>
        <br/>
        <form:input path="departureTime" placeholder="departureTime"/>
        <form:errors path="departureTime"/>
        <br/>
        <form:input path="arrivalTime" placeholder="arrivalTime"/>
        <form:errors path="arrivalTime"/>
        <br/>
        <form:input path="distance" placeholder="distance"/>
        <form:errors path="distance"/>
        <br/>
        <form:input path="price" placeholder="price"/>
        <form:errors path="price"/>
        <br/>
        <input type="submit" value="Check coach"/>
        <input type="reset" value="Clear"/>
    </form:form>
    <br/>
    <a href="/home">Home</a>
</body>
</html>