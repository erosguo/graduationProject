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

    <title>密码修改</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <script>
        function checkPassword() {
            //获取值
            var password = $("#userPassword2").val();

            //定义正则
            //密码
            var reg_password = /^[a-zA-z0-9]{6,8}$/;

            //判断并提示
            var flag = reg_password.test(password);

            if (flag) {
                //校验通过
                $("#userPassword2").css("border", "");
            } else {
                //非法
                $("#userPassword2").css("border", "1px solid red");
            }
            return flag;

        }
        function changePassword() {
            $.ajax({
                url: '<%=path %>/ClubManager/changePassword',
                data: "userPassword1=" + $("#userPassword1").val() + "&userPassword2=" + $('#userPassword2').val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                        //判断跳转页面
                        /*window.self.location = "/User/showUserStation";*/

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
<body id="wrapper" style="background-image:url('<%=path%>/static/img/paperBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
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
                <form class="form-horizontal col-sm-6 col-sm-offset-1">
                    <div class="form-group">
                        <label for="userPassword1" class="col-sm-3 control-label">旧密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="userPassword1"
                                   placeholder="old password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userPassword2" class="col-sm-3 control-label">新密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="userPassword2"
                                   placeholder="new password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10 text-center">
                            <button type="button" class="btn btn-success" onclick="changePassword()">更&nbsp;&nbsp;改</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>

</div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
<script>
    $("#userPassword2").blur(checkPassword);
</script>
</html>
