<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/3/29
  Time: 22:12
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
    <script>
        var time = 5; //时间,秒
        function Redirect() {
            window.location = "javascript:history.back(-1)";
        }
        var i = 0;
        function dis() {
            document.all.s.innerHTML = "还剩" + (time - i) + "秒";
            i++;
        }
        timer = setInterval('dis()', 1000); //显示时间
        timer = setTimeout('Redirect()', time * 1000); //跳转
    </script>
    <title>社团详情</title>
</head>
<body class="bg-success">
<%--页眉部分--%>
<jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
<%--主体部分--%>
<div class="container-fluid ">
    <div class="row">
        <div class="text-center">
            <span id="s" ></span>
        </div>

        <h1 class="text-center">
            提示：${tips}
            <%--<%= systemNotice.getSystemNoticeName()%>--%>
        </h1>

    </div>


</div>
<%--页脚部分
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>--%>
</body>
</html>
