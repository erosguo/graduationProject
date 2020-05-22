<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/7
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


    <title>用户工作台</title>
</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/userBack.jpg');background-repeat:no-repeat;background-size:120% 120%;background-attachment: fixed;background-position-y:-100px;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<!--2.主体部分-->
<div class="container-fluid">
    <div class="pageContainer">
        <!-- 左侧导航栏 -->

        <jsp:include page="/WEB-INF/pages/user/userSideBar.jsp" flush="true"></jsp:include>
        <!-- 左侧导航和正文内容的分隔线 -->
        <div class="divider"></div>
        <!-- 正文内容部分 -->

        <div class="pageContent container-fluid col-md-10">
            <div class="row">

                    <br/>
                    <br/>
                    <p class="lead text-center outer">欢迎使用大学生课外活动管理系统</p>
                    <p class="lead text-center outer">用户版</p>
                    <p class="lead text-center">用户：<%= request.getSession().getAttribute("account")%>
                    </p>


            </div>


        </div>


    </div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp" flush="true"></jsp:include>
</body>
</html>
