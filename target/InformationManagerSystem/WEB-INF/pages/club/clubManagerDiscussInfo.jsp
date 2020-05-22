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

    <title>社团讨论</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

</head>
<body style="background-image:url('<%=path%>/static/img/clubManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <!--左边菜单栏-->
        <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp"></jsp:include>
        <div class="divider"></div>
        <div class="pageContent container-fluid col-md-10">

            <div class="row" style="vertical-align: middle;">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="#" >社团讨论清单</a>
                    </li>
                    <li role="presentation" >
                        <a href="<%=path %>/ClubManager/showCreateClubDiscuss" >新建社团讨论</a>
                    </li>

                </ul>
                </br>
                <c:if test="${not empty pageInfo.list}">
                    <table class="table">
                    <tr class="active">
                        <td>讨论名称</td>
                        <td>讨论内容</td>
                        <td>点击数</td>
                        <td>最新评论</td>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var ="clubDiscuss">
                        <tr class="danger">
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
                    </table>
                    <div class="row">
                        <div class="form-group form-inline col-sm-offset-1">
                            每页<select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <option>${pageInfo.pageSize}</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>条数据
                        </div>
                        <div class="col-sm-offset-5 text-right">
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

                </c:if>
                <c:if test="${empty pageInfo.list}">
                    <h1 class="text-center">您的社团还没有任何讨论发生，请立即创建一个</h1>
                    <button class="btn btn-success col-sm-offset-5" onclick="location.href='<%=path %>/ClubManager/showCreateClubDiscuss'">新建讨论</button>
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
        location.href="${pageContext.request.contextPath}/ClubManager/showClubDiscussInfo?page=1&size="+pageSize;
    }
</script>
</html>
