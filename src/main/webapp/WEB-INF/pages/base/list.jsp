<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/3/30
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="SystemManager">
        ${SystemManager.systemManagerId}
        ${SystemManager.systemManagerName}
        ${SystemManager.systemManagerContact}
    </c:forEach>

</body>
</html>
