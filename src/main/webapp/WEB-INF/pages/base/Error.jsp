<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/6
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <script>
        setTimeout("javascript:location.href='//index'", 3000);
    </script>
    <title>Error</title>
</head>
<body id="wrapper" class="bg-success">
<div align="center">
    <br/>
    <br/>
    <br/>
    <h4>${error}</h4>
    <h4><a href="//BackIndex" >立即跳转</a></h4>
</div>

</body>
</html>
