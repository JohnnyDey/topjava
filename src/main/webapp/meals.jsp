<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <h2>Meals</h2>
    <c:forEach items="${meals}" var="meal" >
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealWithExceed" />
        <c:choose>
            <c:when test="${meal.exceed=='true'}">
                <span style="color: red; ">
            </c:when>
            <c:otherwise>
                <span style="color: green;">
            </c:otherwise>
        </c:choose>
        ${meal.dateTime} -
        ${meal.description} на
        ${meal.calories} калорий<br>
        </span>
    </c:forEach>
</body>
</html>