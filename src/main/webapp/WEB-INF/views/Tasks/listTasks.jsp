<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="static/Css/project.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List of Tasks</title>

</head>
<body>
<c:choose>
    <c:when test="${empty tasks}">
        <h1><span>${message}</span></h1>
    </c:when>
    <c:otherwise>
        <c:forEach items="${tasks}" var="task" varStatus="status">
            <br>
            <h2>${status.count}.</h2>
            <h2>Title:</h2> <p>${task.name}</p>
            <h2>Description:</h2> <p>${task.description} </p>
            <h2>Priority:</h2> <p>${task.priority} </p>
            <h2>Start Date:</h2> <p>${task.startDate} </p>
            <h2>End Date:</h2> <p>${task.endDate} </p>
            <a href="${pageContext.request.contextPath}/Complete?taskId=${task.id}" class="link-style">[Mark As Completed]</a>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
