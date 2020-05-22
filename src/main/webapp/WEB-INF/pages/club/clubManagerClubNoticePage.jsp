<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/7
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String path = request.getContextPath();%>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>社团公告</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>

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
    <script>
        function changeNotice() {
            $.ajax({
                url: '<%=path %>/ClubManager/changeNotice',
                data: "clubNotice=" + $("#clubNotice").val(),
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                        location.reload();
                    } else {
                        alert("提示','修改失败" + map.msg);
                        location.reload();
                    }
                },
                error: function (xhr, status, error) {
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误" + xhr.responseText);
                    location.reload();
                }
            })
        }
    </script>

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
                </br>
                <div class="form-group">
                    <label  class="text-center col-sm-offset-3" >社团公告</label>
                </div>
                <br/>
                <div class="col-md-2 title rowHeight1x">旧公告</div>
                <div class="col-md-10 data rowHeight1x">
                    <p class="form-control" rows="3">${club.clubNotice}</p>
                </div>
                <div class="col-md-2 title rowHeight2x">新公告</div>
                <div class="col-md-10 data rowHeight2x">
                    <textarea id="clubNotice" class="form-control" rows="3" placeholder="请输入..." ></textarea>
                </div>
                <br/>
                <br/>
                <button type="button" class="btn btn-default col-sm-offset-3" onclick="changeNotice()">更改公告</button>

            </div>

            </div>
        </div>

    </div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
