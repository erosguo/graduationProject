<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <link type="text/css" href="<%=path%>/static/css/main.css"/>

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
        function signInActivity() {

            $.ajax({
                url: '<%=path %>/User/signInActivity',
                data: "activityId=" + ${activity.activity.activityId},
                type: 'post',
                success: function (map) {
                    alert("申请中");
                    if (map.msg == "1") {
                        alert("申请成功");

                        //刷新页面
                        location.reload()

                    } else if (map.msg == "2") {
                        alert("提示','请重新操作");
                    } else {
                        alert("提示','操作失败，" + map.msg);
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    /*alert("提示，服务器错误" + xhr.responseText);*/
                    alert("申请成功");
                    window.self.location = "<%=path %>/User/showActivityDetail?activityId=" +${activity.activity.activityId};

                }

            });
        }

        function cancelSignInActivity() {

            $.ajax({
                url: '<%=path %>/User/cancelSignInActivity',
                data: "activityId=" + ${activity.activity.activityId},
                type: 'post',
                success: function (map) {
                    alert("取消中");
                    if (map.msg == "1") {
                        alert("取消成功");
                        //刷新页面
                        location.reload()

                    } else if (map.msg == "2") {
                        alert("提示','请重新操作");
                    } else {
                        alert("提示','操作失败，" + map.msg);
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    /*alert("提示，服务器错误" + xhr.responseText);*/
                    //刷新页面
                    window.self.location = "<%=path %>/User/showActivityDetail?activityId=" +${activity.activity.activityId};
                }

            });
        }
    </script>
    <title>活动详情</title>
</head>
<body id="wrapper"
      style="background-image:url('<%=path%>/static/img/systemBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<%--页眉部分--%>
<jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
<%--主体部分--%>
<div class="container-fluid ">
    <div class="row">
        <c:if test="${empty activity}">
            <h1>服务器出错啦</h1>
            <div class=" text-center">
                <input class="btn-danger" type="button" name="Submit" onclick="javascript:history.back(-1);"
                       value=”返回上一页”>
            </div>
        </c:if>

        <c:if test="${not empty activity}">

            <div class="col-md-8 data-type">

                <div class="col-md-2 title">活动名称</div>
                <div class="col-md-4 data">
                        ${activity.activity.activityName}
                </div>

                <div class="col-md-2 title">活动简介</div>
                <div class="col-md-4 data">
                        ${activity.activity.activityIntroduction}
                </div>

                <div class="col-md-2 title rowHeight2x">活动内容</div>
                <div class="col-md-10 data rowHeight2x">
                        ${activity.activity.activityContent}
                </div>

                <div class="col-md-2 title">活动地点</div>
                <div class="col-md-10 data">
                        ${activity.activity.activityPlace}
                </div>

                <div class="col-md-2 title">报名方式</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <c:if test="${activity.activity.activityJoinWay==1}">
                                开放报名
                            </c:if>
                            <c:if test="${activity.activity.activityJoinWay==2}">
                                需审核报名
                            </c:if>
                        </div>

                    </div>
                </div>

                <div class="col-md-2 title">活动类型</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <c:if test="${activity.activity.activityType==1}">
                                竞技活动
                            </c:if>
                            <c:if test="${activity.activity.activityType==2}">
                                文艺活动
                            </c:if>
                        </div>

                    </div>
                </div>

                <div class="col-md-2 title ">人数限制</div>
                <div class="col-md-4 data ">
                    <div class="input-group">
                            ${activity.activity.activityPersonCount}<span class="input-group-addon">人</span>
                    </div>
                </div>

                <div class="col-md-2 title">限制方式</div>
                <div class="col-md-4 data ">
                    <c:if test="${activity.activity.activityPersonMethod==1}">
                        抽签报名
                    </c:if>
                    <c:if test="${activity.activity.activityPersonMethod==2}">
                    先到先得
                </c:if>

                </div>

                <div class="col-md-2 title">报名开始时间</div>
                <div class="col-md-4 data">
                        ${activity.activity.activityJoinBeginTime}
                </div>

                <div class="col-md-2 title">报名结束时间</div>
                <div class="col-md-4 data">
                        ${activity.activity.activityJoinEndTime}
                </div>

                <div class="col-md-2 title">活动开始时间</div>
                <div class="col-md-4 data">
                        ${activity.activity.activityBeginTime}
                </div>

                <div class="col-md-2 title">活动结束时间</div>
                <div class="col-md-4 data">
                        ${activity.activity.activityEndTime}
                </div>
                <div class="col-md-2 title">活动状态</div>
                <div class="col-md-10 data">
                        <span>
                    <c:if test="${activity.activity.activityState==1}">
                        未开放报名
                    </c:if>
                    <c:if test="${activity.activity.activityState==2}">
                        火热报名中
                    </c:if>
                    <c:if test="${activity.activity.activityState==3}">
                        活动进行中
                    </c:if>
                                    <c:if test="${activity.activity.activityState==4}">
                                        活动已结束
                                    </c:if>

                </span>
                </div>


                <%--div class="col-md-2 title"></div>--%>
                <div class="col-md-offset-2 col-md-10 data text-center">
                    <c:if test="${activity.activity.activityState==2}">
                        <c:if test="${activity.isUserJoin==0}">
                            <button class="btn btn-maroon" type="button" name="submit" onclick="signInActivity()">立即报名</button>
                        </c:if>
                        <c:if test="${activity.isUserJoin==1}">
                            <button class="btn btn-maroon" type="button" name="submit" onclick="cancelSignInActivity()">取消报名</button>
                        </c:if>
                    </c:if>
                    <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                </div>
            </div>

            <div class="col-md-4">
                <img src="<%=path%>/static/img/activityDetail.jpg" alt="图片丢失啦" style="height: 80%;width: 100%">
            </div>


        </c:if>

    </div>


</div>
<%--页脚部分--%>
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
