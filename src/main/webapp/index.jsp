<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/3/29
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" buffer="8kb" %>
<%@ page errorPage="WEB-INF/pages/base/Error.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

    <title>首页</title>
</head>
<body id="wrapper" class="bg-success">

<!--1.页眉部分-->
<header class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp" data-toggle="tab">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=path %>/showSystemNotice">系统公告</a></li>
                        <li><a href="<%=path %>/showLogIn">登录/注册</a></li>
                        <li><a href="<%=path %>/showCreateClub">社团创建</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</header>

<!--导航栏-->

<!--2.主体部分-->
<div class="container-fluid">
    <div class="row">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="<%=path%>/static/img/clubBlurImg.jpg" alt="全校社团，一网打尽"
                     style="width: 100%;height: 100%;object-fit:cover;">
                <div class="carousel-caption">
                    <p style="font-size: xx-large">全校社团，一网打尽</p>
                </div>
            </div>
            <div class="item">
                <img src="<%=path%>/static/img/activityBlurImg.jpg" alt="热门活动，一键参与"
                     style="width: 100%;height: 100%;object-fit:cover;">
                <div class="carousel-caption">
                    <p style="font-size: xx-large">热门活动，一键参与</p>
                </div>
            </div>
            <div class="item">
                <img src="<%=path%>/static/img/friendBlurImg.jpg" alt="聊天交友，一次解决"
                     style="width: 100%;height: 100%;object-fit:cover;">
                <div class="carousel-caption">
                    <p style="font-size: xx-large">聊天交友，一次解决</p>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    </div>


</div>
<!--3.页脚部分-->
<jsp:include page="WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
