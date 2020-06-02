<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/5/2
  Time: 16:16
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


    <title>活动地点</title>
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
                <li class="active">活动地点</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <br/><br/>
            <!-- 模态框1（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                添加活动地点
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="activityPlaceName">地点名称</label>
                                    <input type="text" class="form-control" id="activityPlaceName" placeholder="activityPlace Name">
                                </div>
                            </form>
                            <form>
                                <div class="form-group">
                                    <label for="activityPlaceWeek">地点周次</label>
                                    <input type="text" class="form-control" id="activityPlaceWeek" placeholder="activityPlace Week">
                                </div>
                            </form>
                            <form>
                                <div class="form-group">
                                    <label for="activityPlaceWeekDay">地点周日期</label>
                                    <input type="text" class="form-control" id="activityPlaceWeekDay" placeholder="activityPlace Weekday">
                                </div>
                            </form>
                            <form>
                                <div class="form-group">
                                    <label for="activityPlaceTeach">地点课次</label>
                                    <input type="text" class="form-control" id="activityPlaceTeach" placeholder="activityPlace Teach">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary" onclick="addActivityPlace()">
                                添加地点
                            </button>

                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">全部地点</h3>
                    </div>
                    <button class="btn btn-default" data-toggle="modal" data-target="#myModal">
                        <i class="fa fa-file-o"></i>添加地点
                    </button>
                    <div class="box-tools pull-right">
                        <div class="has-feedback">
                            <input type="text" class="form-control input-sm" placeholder="搜索" disabled="disabled">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </div>
                    <!--工具栏/-->

                    <c:if test="${empty pageList.dataList}">
                        <h1 class="text-center">地点列表空空如也。。。</h1>
                    </c:if>
                    <c:if test="${not empty pageList.dataList}">
                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">




                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="sorting_desc">地点名称[降序]</th>
                                    <td>地点周次</td>
                                    <td>地点日期</td>
                                    <td>地点课次</td>
                                    <td>地点状态</td>
                                    <td>可用操作</td>

                                </tr>

                                </thead>

                                <tbody>

                                    <c:forEach items="${pageList.dataList}" var ="activityPlace">
                                        <tr>
                                            <td>${activityPlace.activityPlaceName}</td>
                                            <td>${activityPlace.activityPlaceWeek}</td>
                                            <td>${activityPlace.activityPlaceWeekDay}</td>
                                            <td>${activityPlace.activityPlaceIsEnable}</td>
                                            <td>
                                                <c:if test="${activityPlace.activityPlaceIsEnable==0}">
                                                    <span>已使用</span>
                                                </c:if>
                                                <c:if test="${activityPlace.activityPlaceIsEnable==1}">
                                                    <span>未使用</span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${activityPlace.activityPlaceIsEnable==1}">
                                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/SystemManager/cancelActivityPlace?page=${pageList.currentPage}&size=${pageList.pageSize}&activityPlaceId=${activityPlace.activityPlaceId}'">取消</button>
                                                </c:if>


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
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/SystemManager/showActivityPlaceAll?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/SystemManager/showActivityPlaceAll?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/SystemManager/showActivityPlaceAll?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/SystemManager/showActivityPlaceAll?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/SystemManager/showActivityPlaceAll?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
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
        location.href="${pageContext.request.contextPath}/SystemManager/showActivityPlaceAll?page=1&size="+pageSize;
    }
    function addActivityPlace() {

        $.ajax({
            url: '<%=path %>/SystemManager/createActivityPlace',
            data: "activityPlaceName=" + $("#activityPlaceName").val()+"&activityPlaceWeek="+$("#activityPlaceWeek").val() +"&activityPlaceWeekDay="+$("#activityPlaceWeekDay").val()+"&activityPlaceTeach="+$("#activityPlaceTeach").val(),
            type: 'post',
            success: function (map) {
                alert("服务器处理中");
                if (map.msg == "1") {
                    alert("修改成功");
                    $('#myModal').modal('hide');
                    //判断跳转页面
                    location.reload();
                } else {
                    alert("提示','添加失败" + map.msg);
                    $('#myModal').modal('hide');
                }
            },
            error: function (xhr, status, error) {
                /*alert("提示",xhr.responseText);*/
                alert("提示，服务器错误" + xhr.responseText);
                $('#myModal').modal('hide');
            }
        })
    }
</script>
</html>
