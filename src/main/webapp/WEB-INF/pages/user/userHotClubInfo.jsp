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


    <title>热门社团</title>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">

<div class="wrapper">
    <!--1.页眉部分-->
    <jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>
    <jsp:include page="/WEB-INF/pages/user/userSideBar.jsp" flush="true"></jsp:include>
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 社团信息</a></li>
                <li class="active">热门社团</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">热门社团</h3>
                </div>
                <c:if test="${empty pageList.dataList}">
                    <h1 class="text-center">社团查询失败，请重新查询</h1>
                </c:if>

                <c:if test="${not empty pageList.dataList}">
                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">




                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="sorting_desc">社团编号[降序]</th>
                                    <td>社团名称</td>
                                    <td>社团简介</td>
                                    <td>社团公告</td>
                                    <td>可选操作</td>

                                </tr>

                                </thead>

                                <tbody>

                                <c:forEach items="${pageList.dataList}" var ="club">
                                    <tr>
                                        <td>${club.clubId}</td>
                                        <td>${club.clubName}</td>
                                        <td>${club.clubIntroduction}</td>
                                        <td>${club.clubNotice}</td>
                                        <td>
                                                <%--<button class="btn btn-default"></button>--%>
                                            <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/User/findClubDetail?clubId=${club.clubId}'">详情</button>
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
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/User/hotClub?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/hotClub?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/hotClub?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/hotClub?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/User/hotClub?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /.box-footer-->


                </c:if>
            </div>
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
        location.href="${pageContext.request.contextPath}/User/hotClub?page=1&size="+pageSize;
    }
</script>
</html>
