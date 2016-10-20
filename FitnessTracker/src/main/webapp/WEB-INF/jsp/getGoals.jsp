<%--
  Created by IntelliJ IDEA.
  User: mdmytriaha
  Date: 18.10.16
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Goals Report</title>
</head>
<body>

    <table>
        <tr>
            <th>ID</th><th>Minutes</th>
        </tr>
        <c:forEach items="${goals}" var="goal">
            <tr>
                <td>${goal.id}</td><td>${goal.minutes}</td>
                <td>
                    <table>
                        <tr>
                            <th>Exercise ID</th><th>Exercise Minutes</th><th>Exercise Activity</th>
                        </tr>
                        <c:forEach items="${goal.exercises}" var="exercise">
                            <tr>
                                <td>${exercise.id}</td><td>${exercise.minutes}</td><td>${exercise.activity}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
