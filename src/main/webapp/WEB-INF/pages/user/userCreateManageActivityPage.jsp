<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/22
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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

    <title>创建活动</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <script src="<%=path %>/static/js/moment-with-locales.js"></script>
    <script src="<%=path %>/static/js/moment.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet">



    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

    <link rel="stylesheet" href="<%=path %>/static/plugins/bootstrap/css/bootstrap.min.css">
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
        function createActivity() {
            var value = $('#friendList').val();

            $.ajax({
                url: '<%=path %>/User/createManageActivity',
                data: "ActivityName=" + $("#activityName").val() +
                    "&ActivityIntroduction=" + $('#activityIntroduction').val() +
                    "&ActivityContent=" + $('#activityContent').val() +
                    "&ActivityJoinBeginTime=" + $('#activityJoinBeginTime').val() +
                    "&ActivityJoinEndTime=" + $('#activityJoinEndTime').val() +
                    "&ActivityJoinWay=" + $('#activityJoinWay').val() +
                    "&ActivityPersonCount=" + $('#activityPersonCount').val() +
                    "&ActivityPersonMethod=" + $('#activityPersonMethod').val() +
                    "&ActivityType=" + $('#activityType').val() + "&ActivityJoinPerson=" + value,
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("创建成功");
                        window.location.href="<%=path%>/User/showActivityManage?activityId="+map.activityId;
                    } else {
                        alert("系统提示"+map.msg);

                    }
                },
                error: function (xhr, status, error) {
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
    <jsp:include page="/WEB-INF/pages/user/userSideBar.jsp"></jsp:include>
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 创建活动</a></li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            </br>
            </br>
            </br>
            <div class="row data-type">

                <div class="col-md-2 title">活动名称</div>
                <div class="col-md-4 data">
                    <input type="text" class="form-control" id="activityName" placeholder="活动名称">
                </div>

                <div class="col-md-2 title">活动简介</div>
                <div class="col-md-4 data">
                    <input type="text" class="form-control" id="activityIntroduction" placeholder="活动简介">
                </div>

                <div class="col-md-2 title rowHeight2x">活动内容</div>
                <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" id="activityContent" rows="3"
                                      placeholder="请输入活动内容..."></textarea>
                </div>


                <div class="col-md-2 title">报名方式</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <select id="activityJoinWay" class="form-control select2" style="width: 100%;">
                                <option selected="selected" value="1">开放报名</option>
                                <option value="2">审核报名</option>
                                <option disabled="disabled">不允许报名</option>

                            </select>
                        </div>

                    </div>
                </div>

                <div class="col-md-2 title">活动类型</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <select id="activityType" class="form-control select2" style="width: 100%;">
                                <option selected="selected" value="1">体育竞技</option>
                                <option value="2">艺术人生</option>
                                <option disabled="disabled">无类型</option>
                            </select>
                        </div>

                    </div>
                </div>

                <div class="col-md-2 title">报名开始时间</div>
                <div class="col-md-4 data" id='datetimepicker1'>
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="activityJoinBeginTime">
                    </div>
                </div>

                <div class="col-md-2 title">报名结束时间</div>
                <div class="col-md-4 data" id='datetimepicker2'>
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="activityJoinEndTime">
                    </div>
                </div>

                <div class="col-md-2 title ">人数限制</div>
                <div class="col-md-4 data ">
                    <div class="input-group">
                        <input type="text" class="form-control" id="activityPersonCount" placeholder="可容纳人数">
                        <span class="input-group-addon">人</span>
                    </div>
                </div>

                <div class="col-md-2 title">限制方式</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <select id="activityPersonMethod" class="form-control select2" style="width: 100%;">
                                <option selected="selected" value="1">先到先得</option>
                                <option value="2">抽签报名</option>
                            </select>
                        </div>

                    </div>

                </div>

                <div class="col-md-2 title rowHeight2x">邀请好友</div>
                <div class="col-md-10 data line-height36 rowHeight2x ">
                    <select id="friendList" multiple="multiple" data-placeholder="可多选"
                            class="form-control select2" style="width: 100%;">
                        <c:if test="${not empty friendList}">
                            <c:forEach items="${friendList}" var="friend">
                                <option value="${friend.relationshipFriendId}">${friend.relationshipFriendId}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty friendList}">
                            <option value="20160000">默认参与人员</option>
                        </c:if>
                    </select>

                </div>

                <<%--div class="col-md-2 title"></div>--%>
                <div class="col-md-offset-2 col-md-10 data text-center">
                    <button type="button" class="btn bg-maroon" onclick="createActivity()">自动生成</button>
                    <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                </div>
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>
<%--<script src="<%=path%>/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="<%=path%>/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>--%>
<script>

    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss',
            locale: moment.locale('zh-cn'),
            //minDate: '2016-7-1'
        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            locale: moment.locale('zh-cn'),
            format : 'YYYY-MM-DD HH:mm:ss',

        });

    });
</script>
</html>
