<%--
  Created by IntelliJ IDEA.
  User: shivani
  Date: 09/01/21
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Your registration of courses is confirmed successfully. Please, re-check the details.</p>

<ul>
    <c:forEach items="${list}" var="list">
        ${list}
    </c:forEach>
</ul>
</body>
</html>
