<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/23
  Time: 21:39
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

    <title>好友列表</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <script>
        function addFriend() {

            $.ajax({
                url: '<%=path %>/User/addNewFriend',
                data: "friendId=" + $("#friendId").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                        $('#myModal').modal('hide');
                        //判断跳转页面
                        window.self.location = "<%=path %>/User/showMyFriendList?page=1&size=3";
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
        function Value(Id) {
            $("#userId").val(Id);
        }
        function sendMessage() {

            $.ajax({
                url: '<%=path %>/User/addNewMessage',
                data: "userId=" + $("#userId").val()+"&MessageContent="+$("#messageContent").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                        $('#myModal2').modal('hide');
                        //判断跳转页面
                        window.self.location = "<%=path %>/User/showMyFriendList?page=1&size=3";
                    } else {
                        alert("提示','添加失败" + map.msg);
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
</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/clubManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <!--左边菜单栏-->
        <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp"></jsp:include>
        <div class="divider"></div>
        <div class="pageContent container-fluid col-md-10">
            <div class="row" style="vertical-align: middle;">
                <h2 class="text-center">活动状态</h2>
                </br>
                </br>
                <c:if test="${not empty pageList.dataList}">
                    <table class="table">
                        <tr class="active">
                            <td>活动名称</td>
                            <td>活动简介</td>
                            <td>活动状态</td>
                            <td>可选操作</td>

                        </tr>

                        <c:forEach items="${pageList.dataList}" var ="activity">
                            <tr class="danger">
                                <td>${activity.activityName}</td>
                                <td>${activity.activityIntroduction}</td>
                                <td>
                                    <c:if test="${activity.activityState==1}">
                                        未开放报名
                                    </c:if>
                                    <c:if test="${activity.activityState==2}">
                                        火热报名中
                                    </c:if>
                                    <c:if test="${activity.activityState==3}">
                                        活动进行中
                                    </c:if>
                                    <c:if test="${activity.activityState==4}">
                                        活动已结束
                                    </c:if>
                                </td>
                                <td>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/cancelActivity?activityId=${activity.activityId}'">取消活动</button>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/showActivityManage?activityId=${activity.activityId}'">详情</button>
                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                    <div class="row">
                        <div class="form-group form-inline">
                            当前第${pageList.currentPage }页/共${pageList.totalPage }页,

                            每页<select class="form-control" id="changePageSize" onchange="changePageSize()">
                            <option>${pageList.pageSize}</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>条数据
                        </div>
                        <div class="col-sm-offset-5 text-right">
                            <ul class="pagination">
                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showActivityState?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showActivityState?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showActivityState?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showActivityState?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showActivityState?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>


                    </div>

                </c:if>
                <c:if test="${empty pageList.dataList}">
                    <h1 class="text-center">本社团还没有活动，请多多创建活动</h1>

                </c:if>
            </div>

        </div>
    </div>

</div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
<script>
    function changePageSize() {
        var pageSize=$("#changePageSize").val();
        //向服务器发送请求，改变每页显示条数
        location.href="${pageContext.request.contextPath}/ClubManager/showActivityState?page=1&size="+pageSize;
    }
</script>
</html>
