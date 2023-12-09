<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Tasks</title>
    <link href="static/Css/project.css" rel="stylesheet" type="text/css">
</head>

<body>
<h2>Add Task</h2>

<form:form action="/AddTasks" modelAttribute="task" method="post">
    <h2>Title:</h2>
    <form:input path="name" cssClass="form-input"/>
    <form:errors path="name" cssClass="error"/>
    <br/>

    <h2>Description:</h2>
    <form:input path="description" cssClass="form-input"/>
    <form:errors path="description" cssClass="error"/>
    <br/>

    <h2>Priority:</h2>
    <form:input path="priority" cssClass="form-input"/>
    <form:errors path="priority" cssClass="error"/>
    <br/>

    <h2>Start Date:</h2>
    <form:input path="startDate" cssClass="form-input" type="date"/>
    <form:errors path="startDate" cssClass="error"/>
    <br/>

    <h2>End Date:</h2>
    <form:input path="endDate" cssClass="form-input" type="date"/>
    <form:errors path="endDate" cssClass="error"/>
    <br/>

    <input type="submit" value="Add Task" class="submit-button" /><form:errors/>
</form:form>
</body>
</html>
