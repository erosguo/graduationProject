<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        function Value(Id) {
            $("#userId").val(Id);
        }
        function sendMessage() {
            $.ajax({
                url: '<%=path %>/ClubManager/addNewMessage',
                data: "userId=" + $("#userId").val()+"&MessageContent="+$("#messageContent").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("发送成功");
                        $('#myModal2').modal('hide');
                        location.reload();

                        /*//判断跳转页面
                        window.self.location = "<%=path %>/User/showMyFriendList?page=1&size=3";*/
                    } else {
                        alert("提示','发送失败" + map.msg);
                        $('#myModal2').modal('hide');
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误" + xhr.responseText);
                    $('#myModal2').modal('hide');
                }
            })
        }
    </script>
    <title>成员管理</title>
</head>

<body class="hold-transition skin-purple sidebar-mini">


<div class="wrapper">
    <!--1.页眉部分-->
    <jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>
    <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp" flush="true"></jsp:include>
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 成员管理</a></li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <!-- 模态框2（Modal） -->
            <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel2">
                                联系成员
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="messageContent">消息内容</label>
                                    <input type="text" class="form-control" id="messageContent" placeholder="content">
                                </div>
                                <input type="hidden" id="userId" value="" name ="userId">
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary" onclick="sendMessage()">
                                发送消息
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

            </br>
            <br/><br/>
            <c:if test="${empty pageList.dataList}">
                <h1 class="text-center">你还没任何成员，请立即审核您的成员</h1>
                <button class="btn btn-success col-sm-offset-5" onclick="location.href='${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=1&size=3'">入社申请</button>
            </c:if>

            <c:if test="${not empty pageList.dataList}">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">成员管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">


                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="sorting_asc">学生名称[升序]</th>
                                    <td>学生学号</td>
                                    <td>学生简介</td>
                                    <td>可用操作</td>
                                </tr>

                                </thead>

                                <tbody>

                                <c:forEach items="${pageList.dataList}" var ="newUser">
                                    <tr >
                                        <td>${newUser.userName}</td>
                                        <td>${newUser.userId}</td>
                                        <td>${newUser.userIntroduction}</td>
                                        <td>
                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2" onclick="Value(${newUser.userId})">
                                                通知
                                            </button>
                                            <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/deleteUser?userId=${newUser.userId}'">开除</button>
                                        </td>
                                    </tr>

                                </c:forEach>


                                </tbody>
                                <!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
                            </table>
                            <!--数据列表/-->

                        </div>
                        <!-- 数据表格 /-->


                    </div>
                    <!-- /.box-body -->

                    <!-- .box-footer-->
                    <div class="box-footer">
                        <div class="pull-left">
                            <div class="form-group form-inline ">
                                当前第${pageList.currentPage }页/共${pageList.totalPage }页,

                                每页<select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>条数据
                            </div>
                        </div>

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserManageInfo?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserManageInfo?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserManageInfo?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserManageInfo?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserManageInfo?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /.box-footer-->



                </div>

            </c:if>
        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>

<script>
    function changePageSize() {
        var pageSize=$("#changePageSize").val();
        //向服务器发送请求，改变每页显示条数
        location.href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserManageInfo?page=1&size="+pageSize;
    }
</script>
</html>
