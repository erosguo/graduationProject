<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/7
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String path = request.getContextPath();%>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>信息修改</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <script>
        function changeName() {
            $.ajax({
                url: '<%=path %>/ClubManager/changeName',
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
                url: '<%=path %>/ClubManager/changeTel',
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
                url: '<%=path %>/ClubManager/changeEmail',
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
<body style="background-image:url('<%=path%>/static/img/paperBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <!--左边菜单栏-->
        <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp"></jsp:include>
        <div class="divider"></div>
        <div class="pageContent container-fluid col-md-10">
            <div class="row col-sm-offset-3" style="vertical-align: middle;">
                </br>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="userName">对外称呼</label>
                        <input type="text" class="form-control" id="userName"
                               placeholder ="${clubManager.clubManagerName}">
                    </div>
                    <button type="button" class="btn btn-default" onclick="changeName()">更改称呼</button>
                </form>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="email">联系邮箱</label>
                        <input type="text" class="form-control" id="email"
                               placeholder="${clubManager.clubManagerEmail}">
                    </div>
                    <button type="button" class="btn btn-default" onclick="changeEmail()">更改邮箱</button>
                </form>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="tel">联系手机</label>
                        <input type="text" class="form-control" id="tel"
                               placeholder="${clubManager.clubManagerTel}">
                    </div>
                    <button type="button" class="btn btn-default" onclick="changeTel()">更改手机</button>
                </form>
            </div>

        </div>
    </div>

</div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
