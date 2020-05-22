<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 21:15
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
    <link rel="stylesheet" href="<%=path%>/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/iCheck/square/blue.css">
    <%--
        表单校验
        1.账号 8位数字
        2.密码 单词 字符 6~8位
        3.姓名 非空
        4.联系方式 手机号 11位 正则
    --%>

    <script>

        //校验账号

        function checkAccount() {
            /*alert("校验账号")*/
            //获取值
            var account = $("#account").val();

            //定义正则
            //普通用户
            var reg_account = /^2\w{7}$/;

            //判断并提示
            var flag = reg_account.test(account);

            if (flag) {
                //校验通过
                $("#account").css("border", "");
            } else {
                //用户名非法
                $("#account").css("border", "1px solid red");
            }
            return flag;
        }

        function checkPassword() {
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
                //非法
                $("#password").css("border", "1px solid red");
            }
            return flag;

        }
        //非空
        function checkName() {
            var name = $("#name").val();

            var flag = false;
            if(name!="") {
                flag=true;
            }
            if (flag) {
                //校验通过
                $("#name").css("border", "");
            } else {
                //用户名非法
                $("#name").css("border", "1px solid red");
            }
            return flag;
        }

        function checkEmail() {
            //获取值
            var email = $("#email").val();

            //定义正则
            //邮箱
            //只允许英文字母、数字、下划线、英文句号、以及中划线组成
            var reg_email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;

            //判断并提示
            var flag = reg_email.test(email);

            if (flag) {
                //校验通过
                $("#email").css("border", "");
            } else {
                //用户名非法
                $("#email").css("border", "1px solid red");
            }
            return flag;
        }

        /*$(function(){
            //表单提交时，调用所有的校验方法
            $("#registerForm").submit(function () {
                //发送数据到服务器
                if(checkAccount()&&checkName()&&checkPassword()&&checkEmail()){
                    //校验通过，发送ajax请求，提交表单数据
                    $.ajax({
                        url:'/User/askSignIn',
                        data:"account="+$("#account").val()+"&userPassword="+$('#password').val()+"&userName="+$('#name').val()+"&userEmail="+$('#email').val(),
                        type:'post',
                        success:function(map){
                            if(map.msg=="1"){
                                alert("提示:请不要重复注册");
                            }
                            if(map.msg=="2"){
                                alert("提示：请等待管理员审核");
                                //转回首页
                                window.self.location="/BackIndex";
                            }


                        },
                        error:function(xhr,status,error){
                            /!*alert("提示",xhr.responseText);*!/
                            alert("提示，服务器错误"+xhr.responseText);
                        }

                    });
                }
                //跳转页面

                /!*return checkAccount() && checkName() && checkPassword() && checkEmail();*!/
                //如果这个方法没有返回值或者返回true，则表单提交
            });
            $("#account").blur(checkAccount);
            $("#password").blur(checkPassword);
            $("#name").blur(checkName);
            $("#email").blur(checkEmail);
            //当一个组件失去焦点时，调用对应的校验方法
        })*/

        function signIn() {
            checkAccount();
            checkName();
            checkPassword();
            checkEmail();

            $.ajax({
                url:'<%=path %>/userApplyAccount',
                data:"account="+$("#account").val()+"&userPassword="+$('#password').val()+"&userName="+$('#name').val()+"&userEmail="+$('#email').val(),
                type:'post',
                success:function(map){
                    alert("申请注册中");
                    if(map.msg =="1"){
                        alert("成功申请，请等待管理员审核");
                        //判断跳转页面
                        window.self.location="<%=path %>/BackIndex";
                    }
                    else{
                        alert("提示','注册失败，"+map.msg);
                    }
                },
                error:function(xhr,status,error){
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误"+xhr.responseText);
                }

            });
        }

    </script>
    <title>注册</title>
</head>
<body id="wrapper"style="background-image:url('<%=path%>/static/img/systemBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
<!--2.主体部分-->
<div  class="container-fluid " >

    <div class="row">
        <div class="login-box">
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">用户注册</p>
                <form class="form-horizontal" id="registerForm" >
                    <div class="form-group">
                        <label for="account" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="account" class="form-control" id="account" placeholder="Student Id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="name" class="form-control" id="name" placeholder="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">绑定邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" placeholder="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10  text-center">
                            <button type="button" class="btn btn-success" onclick="signIn()">注册</button>
                        </div>
                    </div>
                </form>

                <!-- /.social-auth-links -->

                <span>已有账号，立即<a href="<%=path %>/showLogIn" class="text-center"><b class="btn btn-info">登录</b></a></span>

            </div>
        </div>


    </div>


</div>

<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp" flush="true"></jsp:include>
</body>
<script>
    $("#account").blur(checkAccount);
    $("#password").blur(checkPassword);
    $("#name").blur(checkName);
    $("#email").blur(checkEmail);
    //当一个组件失去焦点时，调用对应的校验方法
</script>
</html>
