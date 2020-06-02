
<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script>
        function deleteNotice() {
            $.ajax({
                url: '<%=path %>/SystemManager/deleteSystemNotice',
                data: "noticeId=" + ${systemNotice.systemNoticeId},
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
        function updateNotice() {
            $.ajax({
                url: '<%=path %>/SystemManager/updateSystemNotice',
                data: "noticeId=" + ${systemNotice.systemNoticeId}+"&noticeName="+$("#noticeName").val()+"&noticeContent="+$("#noticeContent").val(),
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
    <title>更改公告</title>
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
                <li class="active">更改公告</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <div class="container-fluid col-sm-10 ">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="<%=path %>/SystemManager/showCreateSystemNoticePage" >新建公告</a>
                    </li>
                    <li role="presentation"class="active">
                        <a href="#" >编辑公告</a>
                    </li>
                </ul>
                <br/><br/><br/>
                <div class="col-sm-offset-2 col-sm-6">
                    <div class="active">
                        <c:if test="${empty systemNotice}">
                            <h3 class="text-center">无系统公告</h3>
                        </c:if>
                        <c:if test="${not empty systemNotice}">
                            <table class="table">
                                <tr class="active">
                                    <td>公告编号</td>
                                    <td>公告名称</td>
                                    <td>公告内容</td>
                                </tr>
                                <tr class="info">
                                    <td>${systemNotice.systemNoticeId}</td>
                                    <td>${systemNotice.systemNoticeName}</td>
                                    <td>${systemNotice.systemNoticeContent}</td>
                                </tr>

                            </table>
                            </br>
                            </br>
                            <button class="btn btn-default col-sm-offset-3" type="button" data-toggle="modal" data-target="#update">更新</button>

                            <button class="btn btn-danger col-sm-offset-1" type="button"  title="警告：删除后不可恢复"
                                    data-container="body" data-toggle="popover" data-placement="top"
                                    data-content="删除后不可恢复" onclick="deleteNotice()">删除</button>
                        </c:if>

                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <!--头部-->
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            ×
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">
                                            更改当前公告
                                        </h4>
                                    </div>
                                    <!--中间部分(from表单)-->
                                    <div class="modal-body">
                                        <form class="form-horizontal" role="form">

                                            <div class="form-group">
                                                <label for="noticeName" class="col-sm-2 control-label">公告名称</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="noticeName" placeholder="notice name" required="required">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="noticeContent" class="col-sm-2 control-label" >公告内容</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="noticeContent" placeholder="notice content" required="required">
                                                </div>
                                            </div>

                                            <!--按钮-->
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="button" class="btn btn-default" onclick="updateNotice()">更改</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

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
