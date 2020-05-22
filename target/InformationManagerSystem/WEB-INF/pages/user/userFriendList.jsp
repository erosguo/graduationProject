<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/23
  Time: 10:31
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
<body id="wrapper" style="background-image:url('<%=path%>/static/img/userBack.jpg');background-repeat:no-repeat;background-size:120% 120%;background-attachment: fixed;background-position-y:-100px;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <div class="row">

        <!--左边菜单栏-->
        <jsp:include page="/WEB-INF/pages/user/userSideBar.jsp"></jsp:include>
        <div class="divider"></div>
        <div class="pageContent container-fluid col-md-10">

            <!-- 模态框1（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                添加好友
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="friendId">好友Id</label>
                                    <input type="text" class="form-control" id="friendId" placeholder="friend id">
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary" onclick="addFriend()">
                                添加好友
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            <!-- 模态框2（Modal） -->
            <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel2">
                                联系好友
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="messageContent">消息内容</label>
                                    <input type="text" class="form-control" id="messageContent" placeholder="content">
                                </div>
                                <input type="hidden" id="userId" value="" name ="userId">
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary" onclick="sendMessage()">
                                发送消息
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

            <div class="row" style="vertical-align: middle;">
                <!-- 按钮触发模态框 -->
                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    添加好友
                </button>
                </br>
                </br>
                <c:if test="${not empty pageList.dataList}">
                    <table class="table">
                        <tr class="active">
                            <td>好友id</td>
                            <td>好友名称</td>
                            <td>好友简介</td>
                            <td>可选操作</td>

                        </tr>

                        <c:forEach items="${pageList.dataList}" var ="newUser">
                            <tr class="danger">
                                <td>${newUser.userId}</td>
                                <td>${newUser.userName}</td>
                                <td>${newUser.userIntroduction}</td>
                                <td>
                                    <!-- 按钮触发模态框 -->
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2" onclick="Value(${newUser.userId})">
                                        联系好友
                                    </button>
                                    <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/User/deleteFriend?friendId=${newUser.userId}'">删除好友</button>
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
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/User/showMyFriendList?page=1&size=${pageList.pageSize}">首页</a>
                                </li>
                                <c:if test="${pageList.currentPage>1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/showMyFriendList?page=${pageList.currentPage-1}&size=${pageList.pageSize}">上一页</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="1" end="${pageList.totalPage}" var="pageNum">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/showMyFriendList?page=${pageNum}&size=${pageList.pageSize}">${pageNum}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageList.currentPage<pageList.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/User/showMyFriendList?page=${pageList.currentPage+1}&size=${pageList.pageSize}">下一页</a>
                                    </li>
                                </c:if>

                                <li>
                                    <a aria-label="Previous" href="${pageContext.request.contextPath}/User/showMyFriendList?page=${pageList.totalPage}&size=${pageList.pageSize}">尾页</a>
                                </li>
                            </ul>
                        </div>


                    </div>

                </c:if>
                <c:if test="${empty pageList.dataList}">
                    <h1 class="text-center">您还没有任何好友，请多多交友</h1>

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
        location.href="${pageContext.request.contextPath}/User/showMyFriendList?page=1&size="+pageSize;
    }
</script>
</html>
