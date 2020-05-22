<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
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
    <title>管理员信息页</title>
    <script>
        function changeName() {
            $.ajax({
                url: '<%=path %>/SystemManager/changeName',
                data: "userName=" + $("#userName").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                    } else {
                        alert("提示','修改失败" + map.msg);
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误" + xhr.responseText);
                }
            })
        }
        function changeTel() {
            $.ajax({
                url: '<%=path %>/SystemManager/changeTel',
                data: "userTel=" + $("#tel").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                    } else {
                        alert("提示','修改失败" + map.msg);
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误" + xhr.responseText);
                }
            })
        }
        function changeEmail() {
            $.ajax({
                url: '<%=path %>/SystemManager/changeEmail',
                data: "userEmail=" + $("#email").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                    } else {
                        alert("提示','修改失败" + map.msg);
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误" + xhr.responseText);
                }
            })
        }
    </script>
</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/systemManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<div class="pageContainer container-fluid">
    <%--导航栏--%>
    <jsp:include page="/WEB-INF/pages/systemManager/systemManagerSideBar.jsp"></jsp:include>
    <div class="divider"></div>
    <!-- 正文内容部分 -->
    <div class="col-sm-6 col-sm-offset-3">

        <form class="form-inline">
            <div class="form-group">
                <label for="userName">对外称呼</label>
                <input type="text" class="form-control" id="userName"
                       placeholder ="${systemManager.systemManagerName}">
            </div>
            <button type="button" class="btn btn-default" onclick="changeName()">更改称呼</button>
        </form>
        <form class="form-inline">
            <div class="form-group">
                <label for="email">联系邮箱</label>
                <input type="text" class="form-control" id="email"
                       placeholder="${systemManager.systemManagerEmail}">
            </div>
            <button type="button" class="btn btn-default" onclick="changeEmail()">更改邮箱</button>
        </form>
        <form class="form-inline">
            <div class="form-group">
                <label for="tel">联系手机</label>
                <input type="text" class="form-control" id="tel"
                       placeholder="${systemManager.systemManagerTel}">
            </div>
            <button type="button" class="btn btn-default" onclick="changeTel()">更改手机</button>
        </form>
    </div>

</div>

<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
