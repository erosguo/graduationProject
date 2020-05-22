<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/5/16
  Time: 22:21
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


    <title>活动详情</title>
</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/systemBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<%--页眉部分--%>
<jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
<%--主体部分--%>
<div class="container-fluid ">
    <div class="row">
        <c:if test="${empty activityUserList}">
            <h1>服务器出错啦</h1>
            <div class=" text-center">
                <input class="btn-danger" type="button" name="Submit" onclick="javascript:history.back(-1);"
                       value=”返回上一页”>
            </div>
        </c:if>

        <c:if test="${not empty activityUserList}">

            <div class="col-md-8 data-type">

                <div class="col-md-2 title">活动名称</div>
                <div class="col-md-4 data">
                        ${activityUserList.activity.activityName}
                </div>

                <div class="col-md-2 title">活动简介</div>
                <div class="col-md-4 data">
                        ${activityUserList.activity.activityIntroduction}
                </div>

                <div class="col-md-2 title rowHeight2x">活动内容</div>
                <div class="col-md-10 data rowHeight2x">
                        ${activityUserList.activity.activityContent}
                </div>

                <div class="col-md-2 title">活动地点</div>
                <div class="col-md-10 data">
                        ${activityUserList.activity.activityPlace}
                </div>

                <div class="col-md-2 title">报名方式</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <c:if test="${activityUserList.activity.activityJoinWay==1}">
                                开放报名
                            </c:if>
                            <c:if test="${activityUserList.activity.activityJoinWay==2}">
                                需审核报名
                            </c:if>
                        </div>

                    </div>
                </div>

                <div class="col-md-2 title">活动类型</div>
                <div class="col-md-4 data line-height36">
                    <div class="form-group form-inline">
                        <div class=" data">
                            <c:if test="${activityUserList.activity.activityType==1}">
                                竞技活动
                            </c:if>
                            <c:if test="${activityUserList.activity.activityType==2}">
                                文艺活动
                            </c:if>
                        </div>

                    </div>
                </div>

                <div class="col-md-2 title ">人数限制</div>
                <div class="col-md-4 data ">
                    <div class="input-group">
                            ${activityUserList.activity.activityPersonCount}<span class="input-group-addon">人</span>
                    </div>
                </div>

                <div class="col-md-2 title">限制方式</div>
                <div class="col-md-4 data ">
                    <c:if test="${activityUserList.activity.activityPersonMethod==1}">
                        抽签报名
                    </c:if>
                    <c:if test="${activityUserList.activity.activityPersonMethod==2}">
                        先到先得
                    </c:if>

                </div>

                <div class="col-md-2 title">报名开始时间</div>
                <div class="col-md-4 data">
                        ${activityUserList.activity.activityJoinBeginTime}
                </div>

                <div class="col-md-2 title">报名结束时间</div>
                <div class="col-md-4 data">
                        ${activityUserList.activity.activityJoinEndTime}
                </div>

                <div class="col-md-2 title">活动开始时间</div>
                <div class="col-md-4 data">
                        ${activityUserList.activity.activityBeginTime}
                </div>

                <div class="col-md-2 title">活动结束时间</div>
                <div class="col-md-4 data">
                        ${activityUserList.activity.activityEndTime}
                </div>
                <div class="col-md-2 title">活动状态</div>
                <div class="col-md-10 data">
                    <span>
                        <c:if test="${activityUserList.activity.activityState==1}">
                            未开放报名
                        </c:if>
                        <c:if test="${activityUserList.activity.activityState==2}">
                            火热报名中
                        </c:if>
                        <c:if test="${activityUserList.activity.activityState==3}">
                            活动进行中
                        </c:if>
                        <c:if test="${activityUserList.activity.activityState==4}">
                            活动已结束
                        </c:if>

                    </span>
                </div>


                    <%--div class="col-md-2 title"></div>--%>
                <div class="col-md-offset-2 col-md-10 data text-center">
                    <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                </div>
            </div>

            <div class="col-md-4" style="overflow:scroll;height: 80%">
                <br/>
                <br/>
                <br/>
                <br/>
                <h3 class="text-center">报名名单</h3>
                <c:if test="${empty activityUserList.userApplyActivityUtilList}">
                    <h4 class="text-center">
                        暂无成员报名
                    </h4>
                </c:if>
                <c:if test="${not empty activityUserList.userApplyActivityUtilList}">
                    <table class="table col-md-4" style="min-width:100px;">
                        <tr class="active">
                            <td>用户id</td>
                            <td>用户名</td>
                            <td>报名状态</td>
                            <td>可选操作</td>
                        </tr>

                        <c:forEach items="${activityUserList.userApplyActivityUtilList}" var="user">
                            <tr class="active">
                                <td>${user.user.userId}</td>
                                <td>${user.user.userName}</td>
                                <td>
                                    <c:if test="${user.joinState==1}">
                                        报名成功
                                    </c:if>
                                    <c:if test="${user.joinState==0}">
                                        等待审核
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${user.joinState==0}">
                                        <button type="button" class="btn btn-success" onclick="setUserState('${user.user.userId}','${activityUserList.activity.activityId}',1)">一键批准</button>
                                        <button type="button" class="btn btn-success" onclick="deleteUserJoinActivity('${user.user.userId}','${activityUserList.activity.activityId}')">一键拒绝</button>
                                    </c:if>

                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                </c:if>

            </div>


        </c:if>

    </div>


</div>
<%--页脚部分--%>
<%--<jsp:include page="<%=path%>/WEB-INF/pages/base/footer.jsp"></jsp:include>--%>
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
<script>
    function setUserState(userId,activityId,state) {

        $.ajax({
            url:'<%=path %>/ClubManager/setUserJoinActivityStateNew',
            data:"userId="+userId+"&activityId="+activityId+"&state="+state,
            type:'post',
            success:function(returnNum){
                if(returnNum=="1"){
                   /* alert("success");*/
                   location.reload();
                }
                else{
                    alert("提示','操作失败，");
                }
            },
            error:function(xhr,status,error){
                /*alert("提示",xhr.responseText);*/
                alert("提示，服务器错误"+xhr.responseText);
            }
        })
    }
    function deleteUserJoinActivity(userId,activityId) {

        $.ajax({
            url:'<%=path %>/ClubManager/deleteUserJoinActivityNew',
            data:"userId="+userId+"&activityId="+activityId,
            type:'post',
            success:function(returnNum){
                if(returnNum=="1"){
                    /* alert("success");*/
                    location.reload();
                }
                else{
                    alert("提示','操作失败，");
                }
            },
            error:function(xhr,status,error){
                /*alert("提示",xhr.responseText);*/
                alert("提示，服务器错误"+xhr.responseText);
            }
        })
    }
</script>
</html>
