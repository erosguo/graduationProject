<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/5/4
  Time: 23:03
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

    <title>课表</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/userBack.jpg');background-repeat:no-repeat;background-size:120% 120%;background-attachment: fixed;background-position-y:-100px;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <!--左边菜单栏-->
        <jsp:include page="/WEB-INF/pages/user/userSideBar.jsp"></jsp:include>
        <div class="divider"></div>
        <div class="pageContent container-fluid col-md-10">

            <div class="row" style="vertical-align: middle;">


                <c:if test="${not empty pageList.dataList}">
                    <h3 class="col-sm-offset-4">我的课表</h3>
                    <table class="table">
                        <tr class="active">
                            <td>地点</td>
                            <td>周次</td>
                            <td>日期</td>
                            <td>课次</td>

                        </tr>
                        <c:forEach items="${pageList.dataList}" var ="course">
                            <tr class="danger">
                                <td>${course.coursePlace}</td>
                                <td>${course.courseWeek}</td>
                                <td>${course.courseWeekDay}</td>
                                <td>${course.courseTeach}</td>
                            </tr>

                        </c:forEach>
                    </table>
                    <div class="row">
                        <div class="form-group form-inline col-sm-offset-1">
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
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/User/showMyCourse?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/showMyCourse?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/showMyCourse?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/showMyCourse?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/User/showMyCourse?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>


                    </div>

                </c:if>
                <c:if test="${empty pageList.dataList}">
                    <h1 class="text-center">请联系管理员刷新数据库</h1>
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
        location.href="${pageContext.request.contextPath}/User/showMyCourse?page=1&size="+pageSize;
    }
</script>
</html>