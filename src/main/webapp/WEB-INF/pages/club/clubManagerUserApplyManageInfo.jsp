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
    <title>入社申请</title>
</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/clubManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<!--2.主体部分-->
<div class="container-fluid">
    <div class="pageContainer">
        <!-- 左侧导航栏 -->

        <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp" flush="true"></jsp:include>
        <div class="divider"></div>
        <!-- 正文内容部分 -->

        <div class="pageContent container-fluid col-md-10">
            <div class="row">
                <h3 class="text-center">入社申请</h3>
                <br/>
                <c:if test="${not empty pageList.dataList}">
                    <table class="table">
                        <tr class="active">
                            <td>学生名称</td>
                            <td>学生学号</td>
                            <td>学生简介</td>
                            <td>可用操作</td>
                        </tr>
                        <c:forEach items="${pageList.dataList}" var ="newUser">
                            <tr class="danger">
                                <td>${newUser.userName}</td>
                                <td>${newUser.userId}</td>
                                <td>${newUser.userIntroduction}</td>
                                <td>
                                        <%--<button class="btn btn-default"></button>--%>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/passUserApply?userId=${newUser.userId}'">通过</button>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/ClubManager/rejectUserApply?userId=${newUser.userId}'">拒绝</button>
                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                    <div class="row">
                        <div class="form-group form-inline ">
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
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>


                    </div>
                </c:if>
                <c:if test="${empty pageList.dataList}">
                    <h1 class="text-center">你的社团还没任何申请</h1>
                </c:if>

            </div>
        </div>
    </div>
</div>
<div class="row">
    <br/>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>

</body>
<script>
    function changePageSize() {
        var pageSize=$("#changePageSize").val();
        //向服务器发送请求，改变每页显示条数
        location.href="${pageContext.request.contextPath}/ClubManager/showClubManagerUserApplyManageInfo?page=1&size="+pageSize;
    }
</script>
</html>