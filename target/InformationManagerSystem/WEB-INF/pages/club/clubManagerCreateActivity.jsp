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

    <title>创建活动</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <script src="<%=path %>/static/js/moment-with-locales.js"></script>
    <script src="../static/js/moment.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">


    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

    <script>
        function createActivity() {
            $.ajax({
                url: '<%=path %>/ClubManager/createClubActivity',
                data: "ActivityName=" + $("#activityName").val() +
                    "&ActivityIntroduction=" + $('#activityIntroduction').val()+
                "&ActivityContent="+$('#activityContent').val()+
                "&ActivityPlace="+$('#activityPlace').val()+
                "&ActivityJoinBeginTime="+$('#activityJoinBeginTime').val()+
                "&ActivityJoinEndTime="+$('#activityJoinEndTime').val()+
                "&ActivityJoinWay="+$('#activityJoinWay').val()+
                "&ActivityPersonCount="+$('#activityPersonCount').val()+
                "&ActivityPersonMethod="+$('#activityPersonMethod').val()+
                "&ActivityType="+$('#activityType').val()+
                "&ActivityBeginTime="+$('#activityBeginTime').val()+
                "&ActivityEndTime="+$('#activityEndTime').val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("创建成功");
                        //判断跳转页面
                        /*window.self.location = "/User/showUserStation";*/
                    } else {
                        alert("提示"+ map.msg);
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
<body  style="background-image:url('<%=path%>/static/img/clubManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <!--左边菜单栏-->
        <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp"></jsp:include>
        <div class="divider"></div>
        <div class="pageContent container-fluid col-md-10">

            <div class="row" style="vertical-align: middle;">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="activityName" class="col-sm-2 control-label">活动名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="activityName" placeholder="活动名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activityIntroduction" class="col-sm-2 control-label">活动简介</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="activityIntroduction" placeholder="活动简介">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activityContent" class="col-sm-2 control-label">活动内容</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="activityContent" placeholder="活动内容">
                        </div>
                    </div>
                    <%--改成下拉菜单--%>
                    <div class="form-group">
                        <label for="activityPlace" class="col-sm-2 control-label">活动地点</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="activityPlace" placeholder="活动地点">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activityPersonCount" class="col-sm-2 control-label">可容纳人数</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="activityPersonCount" placeholder="可容纳人数">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activityJoinWay" class="col-sm-2 control-label">学生报名方式</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="activityJoinWay">
                                <option value="1">开放报名</option>
                                <option value="2">审核报名</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activityPersonMethod" class="col-sm-2 control-label">人数限制方式</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="activityPersonMethod">
                                <option value="1">先到先得</option>
                                <option value="2">抽签报名</option>

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="datetimepicker1" class="col-sm-2 control-label">报名开始时间</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' class="form-control" id="activityJoinBeginTime"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                        </div>
                    </div>


                    </div>
                    <div class="form-group">
                        <label for="datetimepicker2" class="col-sm-2 control-label">报名结束时间</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker2'>
                                <input type='text' class="form-control" id="activityJoinEndTime"/>
                                <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="datetimepicker3" class="col-sm-2 control-label">活动开始时间</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker3'>
                                <input type='text' class="form-control" id="activityBeginTime"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>


                    </div>
                    <div class="form-group">
                        <label for="datetimepicker4" class="col-sm-2 control-label">活动结束时间</label>
                        <div class="col-sm-9">
                            <div class='input-group date' id='datetimepicker4'>
                                <input type='text' class="form-control" id="activityEndTime"/>
                                <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activityType" class="col-sm-2 control-label">活动类型</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="activityType">
                                <option value="1">体育竞技</option>
                                <option value="2">艺术人生</option>

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-9">
                            <button type="button" class="btn btn-default" onclick="createActivity()">创建</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>

</div>
</div>
<!--3.页脚部分-->
<%--<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>--%>
</body>
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
        var picker3 = $('#datetimepicker3').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss',
            locale: moment.locale('zh-cn'),

            //minDate: '2016-7-1'
        });
        var picker4 = $('#datetimepicker4').datetimepicker({
            locale: moment.locale('zh-cn'),

            format : 'YYYY-MM-DD HH:mm:ss',

        });
    });
</script>
</html>
