<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/5/16
  Time: 16:25
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

    <title>申请列表</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <style>
        table{
            margin: 0px;
            padding: 0px;
            width: 30%;
            border-collapse: collapse;
            table-layout: fixed;  /*不添加此样式，会全部显示    */
        }
        table td{
            border: 1px solid #eef2e9;
            /* text-overflow: ellipsis; */ /* 加上，显示省略号*/
            white-space: nowrap;
            overflow: hidden;
            text-overflow:ellipsis;
        }
        table td:hover { /* 鼠标滑过  显示隐藏的内容  伴有横向的滚动条 */
            overflow:auto;
            text-overflow:clip;
        }

    </style>
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
                <h2 class="text-center">活动审核</h2>
                </br>
                </br>
                <c:if test="${not empty pageList.dataList}">
                    <table class="table">
                        <tr class="active">
                            <td>活动编号</td>
                            <td>活动名称</td>
                            <td>活动状态</td>
                            <td>报名人数</td>
                            <td>人数上限</td>
                            <td>报名人员</td>
                            <td>可选操作</td>

                        </tr>

                        <c:forEach items="${pageList.dataList}" var ="UserApplyActivityUtil">
                            <tr class="danger">
                                <td>${UserApplyActivityUtil.activityId}</td>
                                <td>${UserApplyActivityUtil.activityName}</td>
                                <td>
                                    <c:if test="${UserApplyActivityUtil.activityState==1}">
                                        未开放报名
                                    </c:if>
                                    <c:if test="${UserApplyActivityUtil.activityState==2}">
                                        火热报名中
                                    </c:if>
                                    <c:if test="${UserApplyActivityUtil.activityState==3}">
                                        活动进行中
                                    </c:if>
                                    <c:if test="${UserApplyActivityUtil.activityState==4}">
                                        活动已结束
                                    </c:if>
                                </td>
                                <td>${UserApplyActivityUtil.activityCurrentCount}</td>
                                <td>${UserApplyActivityUtil.activityPersonCount}</td>
                                <td>姓名：${UserApplyActivityUtil.user.userName} <br/>学号：${UserApplyActivityUtil.user.userId}
                                    <br/>个人简介：${UserApplyActivityUtil.user.userIntroduction} &nbsp 个人标签：${UserApplyActivityUtil.user.userHobby}
                                </td>
                                <td>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/setUserJoinActivityState?page=${pageList.currentPage}&size=${pageList.pageSize}&userId=${UserApplyActivityUtil.user.userId}&activityId=${UserApplyActivityUtil.activityId}&state=1'">批准申请</button>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/deleteUserJoinActivity?page=${pageList.currentPage}&size=${pageList.pageSize}&userId=${UserApplyActivityUtil.user.userId}&activityId=${UserApplyActivityUtil.activityId}'">拒绝申请</button>
                                        <%--<button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/showActivityDetail?activityId=${activity.activityId}'">详情</button>--%>
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
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showUserApplyActivity?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showUserApplyActivity?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showUserApplyActivity?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showUserApplyActivity?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showUserApplyActivity?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>


                    </div>

                </c:if>
                <c:if test="${empty pageList.dataList}">
                    <h1 class="text-center">还没有学生申请活动</h1>
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
        location.href="${pageContext.request.contextPath}/ClubManager/showUserApplyActivity?page=1&size="+pageSize;
    }
    //js给所有td加上悬浮显示（title）
    //给所有的td加title
    function titleAllTd() {
        $("#ChaKanGrid tr td").each(function () {
            $(this).attr("title", $(this).text());
            $(this).css("cursor", 'pointer');
        });
    }
</script>
</html>
