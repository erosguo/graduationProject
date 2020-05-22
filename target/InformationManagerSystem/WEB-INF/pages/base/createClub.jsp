<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 18:53
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
    <script>
        function createClub() {
            var formData= new FormData();
            formData.append("file",document.getElementById("file").files[0]);
            formData.append("clubName",$("#clubName").val());
            formData.append("introduction",$("#introduction").val());

            $.ajax({
                url:'<%=path %>/clubApplyAccount',
                type:"post",
                dataType:'json',
                async:false,
                processData:false,
                contentType:false,
                data:formData,
                success:function(map){
                    if(map.msg=="1"){
                        alert("申请成功，请耐性等待审核完成");
                    }

                    else{
                        alert("申请失败，原因是："+map.msg);
                    }

                },
                error:function (xhr,status,error) {
                    alert("提示，服务器错误"+xhr.responseText);
                }

            })

        }
    </script>
    <title>创建社团</title>
</head>
<body id="wrapper" class="bg-success">
    <jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
    <div class="container-fluid ">
        <div class="row">
            <div class="login-box">
                <!-- /.login-logo -->
                <div class="login-box-body">
                    <p class="login-box-msg">创建社团</p>
                    <form id="formtable" class="form-horizontal " method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="clubName" class="col-sm-2 control-label">社团名称</label>
                            <div class="col-sm-10">
                                <input type="clubName" class="form-control" id="clubName" placeholder="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="introduction" class="col-sm-2 control-label">社团简介</label>
                            <div class="col-sm-10">
                                <input type="introduction" class="form-control" id="introduction" placeholder="introduction">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="file" class="col-sm-2 control-label">上传文件</label>
                            <div class="col-sm-10">
                                <input type="file"   id="file"  name="file"><%--上传文件信息--%>
                            </div>

                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10 text-center">
                                <button type="button" class="btn btn-success" onclick="createClub()">申&nbsp;&nbsp;请</button>
                            </div>
                        </div>
                    </form>

                    <!-- /.social-auth-links -->

                </div>
            </div>


        </div>

    </div>
    <jsp:include page="/WEB-INF/pages/base/footer.jsp" flush="true"></jsp:include>
</body>
<script>
    function checkClubName() {

        //获取值
        var clubName = $("#clubName").val();

        var flag = false;
        if(clubName!="") {
            flag=true;
        }

        if (flag) {
            //校验通过
            $("#clubName").css("border", "");
        } else {
            //用户名非法
            $("#clubName").css("border", "1px solid red");
        }
        return flag;
    }
    function checkIntroduction() {

        //获取值
        var introduction = $("#introduction").val();

        var flag = false;
        if(introduction!="") {
            flag=true;
        }

        if (flag) {
            //校验通过
            $("#introduction").css("border", "");
        } else {
            //用户名非法
            $("#introduction").css("border", "1px solid red");
        }
        return flag;
    }
    $("#clubName").blur(checkClubName);
    $("#introduction").blur(checkIntroduction);
</script>
</html>
