<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/5/2
  Time: 19:56
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
    <link rel="stylesheet" href="<%=path%>/static/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/morris/morris.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/select2/select2.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="<%=path%>/static/css/style.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">


    <title>兴趣爱好</title>

    <script>
        function addHobby() {
            $.ajax({
                url: '<%=path %>/User/addHobby',
                data: "IsSports=" + document.getElementById("IsSports").checked+"&IsLiterature="+document.getElementById("IsLiterature").checked,
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                        location.href="<%=path%>/User/showUserStation";
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

<body class="hold-transition skin-blue-light sidebar-mini">

<div class="wrapper">
    <!--1.页眉部分-->
    <jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>
    <aside class="main-sidebar skin-blue">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="<%=path%>/static/img/user.jpeg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p><%= request.getSession().getAttribute("account")%>
                    </p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>
            <ul class="sidebar-menu">
                <li class="header">请选择兴趣爱好</li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 兴趣爱好</a></li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <br/><br/><br/><br/>
            <div class="row col-sm-offset-5">
                <form>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="IsSports"> 热爱体育
                        </label>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="IsLiterature"> 喜欢诗词
                        </label>
                    </div>
                    <button type="button" class="btn btn-default" onclick="addHobby()">Submit</button>
                </form>

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>

</html>
