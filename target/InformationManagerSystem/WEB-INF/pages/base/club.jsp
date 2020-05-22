<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <link type="text/css" href="<%=path%>/static/css/main.css" />

    <title>社团详情</title>
</head>
<body style="background-image:url('<%=path%>/static/img/transparentBack.jpeg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<%--页眉部分--%>
<jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
<%--主体部分--%>
<div class="container-fluid ">
    <div class="col-md-4">
        <img src="<%=path%>/static/img/clubDetail.jpg" style="width: 600px;height:400px;">
    </div>
    <div class="row col-md-offset-6">
        <h1 class="text-center">
            ${club.clubName}

        </h1>
        <p class="text-center " style="font-size: large">
            ${club.clubName}
        </p>
        </br>
        <p class="lead col-md-offset-4">
            简介：
            </br>
            <u>
                ${club.clubIntroduction}
            </u>
        </p>

        <p class="lead col-md-offset-4">
            公告：
            </br>
            <u>
                ${club.clubNotice}
            </u>
        </p>
        <div class=" text-center">
            <input class="btn-danger" type="button" name="Submit" onclick="javascript:history.back(-1);" value=”返回上一页”>

            <input class="btn-success" type="button" name="submit" onclick="location.href='${pageContext.request.contextPath}/User/userApplyClub?clubId=${club.clubId}'" value="申请该社团">
        </div>
    </div>


</div>
<%--页脚部分--%>
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
