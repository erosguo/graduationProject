<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>公告创建</title>
    <script>
        function createNotice() {
            $.ajax({
                url: '<%=path %>/SystemManager/saveSystemNotice',
                data: "noticeName=" + $("#noticeName").val()+"&noticeContent="+$("#noticeContent").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                    } else {
                        alert("提示','修改失败" + map.msg);
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
<body id="wrapper" style="background-image:url('<%=path%>/static/img/systemManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<div class="pageContainer container-fluid">
    <%--导航栏--%>
    <jsp:include page="/WEB-INF/pages/systemManager/systemManagerSideBar.jsp"></jsp:include>
    <div class="divider"></div>
    <!-- 正文内容部分 -->
    <div class="container-fluid col-sm-10 ">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active">
                <a href="#" >新建公告</a>
            </li>
            <li role="presentation">
                <a href="<%=path %>/SystemManager/showSystemNoticeInfo" >编辑公告</a>
            </li>
        </ul>
        </br>
        <div class=" col-sm-offset-2 col-sm-6">
            <div class="active">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="noticeName" class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="name" class="form-control" id="noticeName"
                                   placeholder="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="noticeContent" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="noticeContent"
                                   placeholder="content">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10 text-center">
                            <button type="button" class="btn btn-success" onclick="createNotice()">创&nbsp;&nbsp;建</button>
                        </div>
                    </div>
                </form>
            </div>

    </div>

</div>

<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
