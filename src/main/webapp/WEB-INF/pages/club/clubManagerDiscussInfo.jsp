<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/7
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

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


    <title>社团讨论清单</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

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
                <li><a href="#"><i class="fa fa-dashboard"></i> 社团讨论清单</a></li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            </br>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active">
                    <a href="#" >社团讨论清单</a>
                </li>
                <li role="presentation" >
                    <a href="<%=path %>/ClubManager/showCreateClubDiscuss" >新建社团讨论</a>
                </li>

            </ul>
            <br/><br/>
            <c:if test="${empty pageInfo.list}">
                <h1 class="text-center">您的社团还没有任何讨论发生，请立即创建一个</h1>
                <button class="btn btn-success col-sm-offset-5" onclick="location.href='<%=path %>/ClubManager/showCreateClubDiscuss'">新建讨论</button>
            </c:if>

            <c:if test="${not empty pageInfo.list}">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">讨论清单</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">


                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th>讨论名称</th>
                                    <td>讨论内容</td>
                                    <td>点击数</td>
                                    <td>最新评论</td>
                                </tr>

                                </thead>

                                <tbody>

                                    <c:forEach items="${pageInfo.list}" var ="clubDiscuss">
                                        <tr>
                                            <td>${clubDiscuss.clubDiscussName}</td>
                                            <td>${clubDiscuss.clubDiscussContent}</td>
                                            <td>${clubDiscuss.clubDiscussClickNumber}</td>
                                            <td>
                                                <c:if test="${not empty clubDiscuss.clubDiscussComment}">
                                                    ${clubDiscuss.clubDiscussComment}
                                                </c:if>
                                                <c:if test="${empty clubDiscuss.clubDiscussComment}">
                                                    暂无神评
                                                </c:if>
                                            </td>
                                                <%--<td>
                                                        &lt;%&ndash;<button class="btn btn-default"></button>&ndash;%&gt;
                                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/showClubDiscussDetail?clubDiscussId=${clubDiscuss.clubDiscussId}'" disabled="disabled">详情</button>
                                                </td>--%>
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
                            <div class="form-group form-inline">
                                每页<select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <option>${pageInfo.pageSize}</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>条数据
                            </div>
                        </div>

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=1&size=${pageInfo.pageSize}">首页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                                </li>
                                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <li>
                                    <a href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                                </li>
                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=${pageInfo.pages}&size=${pageInfo.pageSize}">尾页</a>
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
        location.href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=1&size="+pageSize;
    }
</script>
</html>
