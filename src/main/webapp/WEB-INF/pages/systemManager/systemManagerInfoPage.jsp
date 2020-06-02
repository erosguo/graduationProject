<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String path = request.getContextPath();%>
<%response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
    response.flushBuffer();%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<%=path %>/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/morris/morris.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/select2/select2.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="<%=path %>/static/css/style.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="<%=path %>/static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">


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
                        location.reload();
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
                        location.reload();
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
                        location.reload();
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

<body class="hold-transition skin-purple-light sidebar-mini">



<div class="wrapper">
    <!--1.页眉部分-->
    <jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>
    <jsp:include page="/WEB-INF/pages/systemManager/systemManagerSideBar.jsp"></jsp:include>
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">账号设置</a></li>
                <li class="active">编辑信息</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="pageContent container-fluid">
                <div class="tab-pane active" id="tab-label">
                    <br/>
                    <br/>
                    <h5 class="col-sm-offset-4">个人信息</h5>
                    <div class="row data-type">

                        <div class="col-md-2 title">对外称呼</div>
                        <div class="col-md-4 data text">
                            ${systemManager.systemManagerName}
                        </div>
                        <div class="col-md-2 title">新称呼</div>
                        <div class="col-md-4 data text">
                            <form class="form-inline ">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="userName">
                                </div>
                                <button type="button" class="btn btn-default" onclick="changeName()">更改称呼</button>
                            </form>
                        </div>


                        <div class="col-md-2 title">绑定邮箱</div>
                        <div class="col-md-4 data text">
                            ${systemManager.systemManagerEmail}
                        </div>
                        <div class="col-md-2 title">新邮箱</div>
                        <div class="col-md-4 data text">
                            <form class="form-inline">
                                <div class="form-group">

                                    <input type="text" class="form-control" id="email">
                                </div>
                                <button type="button" class="btn btn-default" onclick="changeEmail()">更改邮箱</button>
                            </form>
                        </div>

                        <div class="col-md-2 title">联系手机</div>
                        <div class="col-md-4 data text">
                            ${systemManager.systemManagerTel}
                        </div>
                        <div class="col-md-2 title">新手机号</div>
                        <div class="col-md-4 data text">
                            <form class="form-inline">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="tel">
                                </div>
                                <button type="button" class="btn btn-default" onclick="changeTel()">更改手机</button>
                            </form>
                        </div>

                    </div>


                </div>
                <%--<div class="row col-sm-offset-3">

                    <br/><br/><br/>

                    <br/>
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="email">联系邮箱</label>
                        </div>
                    </form>
                    <br/>

                    <br/>
                </div>--%>
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>

</html>
