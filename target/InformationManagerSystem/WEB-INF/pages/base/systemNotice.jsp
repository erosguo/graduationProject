<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 18:42
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

    <title>系统公告</title>
</head>

<body class="hold-transition skin-purple sidebar-mini">



<div class="wrapper">
    <!--1.页眉部分-->
    <header class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-inverse navbar-static-top">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.jsp" data-toggle="tab">大学生课外活动管理系统</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="<%=path %>/BackIndex" >返回首页</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
    </header>
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->

            <ul class="sidebar-menu">
                <li class="header">系统招商</li>

                <li id="admin-index"><a href="#"><i class="fa fa-dashboard"></i> <span>联系我们</span></a></li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 系统公告</a></li>
            </ol>
        </section>

        <!-- 正文区域 -->
        <section class="content">

            <div class="row">
                <div class="col-sm-offset-5 col-sm-4 invoice-col">
                    <h1>Notice</h1>
                    <address>
                        <strong>系统公告</strong><br>
                        标题：${systemNotice.systemNoticeName}<br>
                        内容：${systemNotice.systemNoticeContent}<br>
                        发布时间：${systemNotice.systemNoticeTime}<br>
                    </address>
                </div>
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>


</html>
