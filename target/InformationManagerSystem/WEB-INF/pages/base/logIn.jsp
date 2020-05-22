<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<%=path%>/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/iCheck/square/blue.css">

    <script>

        function logIn() {
            var Path;
            $("#loading").html("<img src='<%=path%>/static/img/loading.gif' />"); //在后台返回success之前显示loading图标
            if($('#account').val()==""){
                alert("提示','用户名不能为空！");
                $("#loading").empty(); //ajax返回成功，清除loading图标
                return;
            }
            else {
                //获取值
                var account = $("#account").val();

                //定义正则
                //普通用户
                var reg_account1 = /^2\w{7}$/;
                //club用户
                var reg_account2= /^8\w{7}$/;
                //system用户
                var reg_account3= /^9\w{7}$/;

                //更改请求路径
                if(reg_account1.test(account)){
                    Path='<%=path %>/User/judgeLogIn';
                }
                if(reg_account2.test(account)){
                    Path='<%=path %>/ClubManager/judgeLogIn';
                }
                if(reg_account3.test(account)){
                    Path='<%=path %>/SystemManager/judgeLogIn';
                }

                //判断并提示
                var flag = reg_account1.test(account)||reg_account2.test(account)||reg_account3.test(account);

                if (flag) {
                    //校验通过
                    $("#account").css("border", "");
                } else {
                    //用户名非法
                    $("#account").css("border", "1px solid red");
                    $("#loading").empty(); //ajax返回成功，清除loading图标
                    alert("用户名非法");
                    return;
                }
            }

            if($('#password').val()==""){
                alert("提示','密码不能为空！");
                $("#loading").empty(); //ajax返回成功，清除loading图标
                return;
            }
            else {
                //获取值
                var password = $("#password").val();

                //定义正则
                //密码
                var reg_password = /^[a-zA-z0-9]{6,8}$/;

                //判断并提示
                var flag = reg_password.test(password);

                if (flag) {
                    //校验通过
                    $("#password").css("border", "");
                } else {
                    //用户名非法
                    $("#password").css("border", "1px solid red");
                    $("#loading").empty(); //ajax返回成功，清除loading图标
                    alert("用户名非法");
                    return;
                }
            }
            $.ajax({
                url:Path,
                data:"account="+$("#account").val()+"&userPassword="+$('#password').val(),
                type:'post',
                success:function(map){
                    if(map.msg =="1"){
                        $("#loading").empty(); //ajax返回成功，清除loading图标
                        alert("登录成功");
                        //判断跳转页面
                        if(Path =='<%=path %>/User/judgeLogIn'){
                            window.self.location="<%=path %>/User/showUserStation";
                        }
                        if(Path == '<%=path %>/ClubManager/judgeLogIn' ){
                            window.self.location="<%=path %>/ClubManager/showClubManagerStation";
                        }
                        if(Path == '<%=path %>/SystemManager/judgeLogIn'){
                            window.self.location="<%=path %>/SystemManager/showSystemManagerStation";
                        }

                    }else if(map.msg =="2"){
                        $("#loading").empty(); //ajax返回成功，清除loading图标
                        alert("提示','请等待管理员审核");
                    }
                    else{
                        $("#loading").empty(); //ajax返回成功，清除loading图标
                        alert("提示','登陆失败，"+map.msg);
                    }
                },
                error:function(xhr,status,error){
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误"+xhr.responseText);
                }

            });
        }
    </script>
    <title>登录</title>
</head>

<body style="background-image:url('<%=path%>/static/img/systemBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
    <jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>


    <div class="container-fluid ">
        <div class="row">

            <div class="login-box" >

                <!-- /.login-logo -->
                <div class="login-box-body">
                    <p class="login-box-msg">用户登录</p>

                    <form class="form-horizontal " id="formtable">
                        <div class="form-group" >
                            <label for="account" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-10">
                                <input type="account" class="form-control" id="account" placeholder="account">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div id="loading" class="col-sm-2"></div>
                            <div class="col-sm-offset-2 col-sm-10 text-center">
                                <button type="button" class="btn btn-success" onclick="logIn()">登&nbsp;&nbsp;录</button>
                            </div>
                        </div>

                    </form>

                    <!-- /.social-auth-links -->

                    <a href="<%=path %>/showSignIn" class="text-center">新用户注册</a>

                </div>
            </div>


        </div>

    </div>

    <jsp:include page="/WEB-INF/pages/base/footer.jsp" flush="true"></jsp:include>
</body>
</html>
