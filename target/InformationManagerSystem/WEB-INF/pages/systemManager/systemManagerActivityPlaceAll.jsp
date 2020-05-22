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

    <title>活动地点</title>
</head>

<body id="wrapper" style="background-image:url('<%=path%>/static/img/systemManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<div class="pageContainer container-fluid">
    <%--导航栏--%>
    <jsp:include page="/WEB-INF/pages/systemManager/systemManagerSideBar.jsp"></jsp:include>
    <div class="divider"></div>
    <!-- 正文内容部分 -->
    <div class="container-fluid col-sm-10 ">
        <div class="row">
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
            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                添加地点
            </button>
            <h3 class="text-center">全部地点</h3>
            <c:if test="${not empty pageList.dataList}">
                <table class="table">
                    <tr class="active">
                        <td>地点名称</td>
                        <td>地点周次</td>
                        <td>地点日期</td>
                        <td>地点课次</td>
                        <td>地点状态</td>
                        <td>可用操作</td>
                    </tr>
                    <c:forEach items="${pageList.dataList}" var ="activityPlace">
                        <tr class="danger">
                            <td>${activityPlace.activityPlaceName}</td>
                            <td>${activityPlace.activityPlaceWeek}</td>
                            <td>${activityPlace.activityPlaceWeekDay}</td>
                            <td>${activityPlace.activityPlaceIsEnable}</td>
                            <td>
                                <c:if test="${activityPlace.activityPlaceIsEnable==1}">
                                    <span>未使用</span>
                                </c:if>
                                <c:if test="${activityPlace.activityPlaceIsEnable==0}">
                                    <span>已使用</span>
                                </c:if>
                            </td>
                            <td>
                                    <%--<button class="btn btn-default"></button>--%>
                                <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/SystemManager/deleteClub?clubId=${newClub.clubId}'">下载</button>
                                <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/SystemManager/deleteClub?clubId=${newClub.clubId}'">通过</button>
                                <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/SystemManager/deleteClub?clubId=${newClub.clubId}'">拒绝</button>
                            </td>
                        </tr>

                    </c:forEach>
                </table>
                <div class="row">
                    <div class="form-group form-inline col-sm-offset-1">
                        当前第${pageList.currentPage }页/共${pageList.totalPage }页,

                        每页<select class="form-control" id="changePageSize" onchange="changePageSize()">
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>条数据
                    </div>
                    <div class="col-sm-offset-5 text-right">
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

            </c:if>
            <c:if test="${empty pageList.dataList}">
                <h1 class="text-center">地点列表空空如也。。。</h1>
            </c:if>
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
