<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/3
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <link type="text/css" href="<%=path%>/static/css/main.css" />

    <link rel="stylesheet" href="<%=path%>/static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/morris/morris.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/select2/select2.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="<%=path%>/static/css/style.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="<%=path%>/static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">


    <script>
        function updateComment() {
            if($('#clubDiscussComment').val()==""){
                alert("提示','clubDiscussComment不能为空！");
                return;
            }
            var clubDiscussId=${clubDiscuss.clubDiscussId};
            $.ajax({
                url:'<%=path %>/User/addNewClubDiscussComment',
                data:"clubDiscussId="+clubDiscussId+"&clubDiscussComment="+$("#clubDiscussComment").val(),
                type:'post',
                success:function(map){
                    alert("评论中");
                    if(map.msg =="1"){
                        alert("创建成功");
                        /*//判断跳转页面
                        window.self.location="<%=path %>/ClubManager/showClubDiscussInfo";*/
                        //刷新页面
                        location.reload()

                    }else if(map.msg =="2"){
                        alert("提示','请重新操作");
                    }
                    else{
                        alert("提示','操作失败，"+map.msg);
                    }
                },
                error:function(xhr,status,error){
                    /*alert("提示",xhr.responseText);*/
                    alert("提示，服务器错误"+xhr.responseText);
                }

            });
        }
    </script>
    <title>社团讨论详情</title>
</head>

<body class="hold-transition skin-green-light sidebar-mini">



<div class="wrapper">
    <!--1.页眉部分-->
    <jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

    <aside class="main-sidebar">
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <img src="<%=path%>/static/img/discussDetail.jpg" style="width: 100%;height: 80%">
        <%--<section class="sidebar">
            <!-- Sidebar user panel -->

            <ul class="sidebar-menu">
                <li class="header">社团信息</li>

                <li id="admin-index"><a href="#"><i class="fa fa-dashboard"></i> <span>社团详情</span></a></li>

            </ul>

            <div class="row">
                <h1 class="text col-sm-offset-2 col-md-10">
                    ${club.clubName}

                </h1>
                &lt;%&ndash; <p class="col-sm-offset-2 col-md-10" style="font-size: large">
                     ${club.clubName}
                 </p>&ndash;%&gt;
                </br>
                <p class="lead col-md-offset-2 col-md-10">
                    简介：
                    </br>
                    <u>
                        ${club.clubIntroduction}
                    </u>
                </p>

                <p class="lead col-md-offset-2 col-md-10">
                    公告：
                    </br>
                    <u>
                        ${club.clubNotice}
                    </u>
                </p>
                <div class=" text-center">
                    <input class="btn-danger" type="button" name="Submit" onclick="javascript:history.back(-1);" value=”返回上一页”>

                    <input class="btn-success" type="button" name="submit" onclick="location.href='${pageContext.request.contextPath}/User/userApplyClub?clubId=${club.clubId}'" value="申请该社团">
                </div>
            </div>
        </section>--%>
        <!-- /.sidebar -->
    </aside>

    <div class="content-wrapper">

        <!-- 正文区域 -->
        <section class="content">

            <div class="col-md-offset-2 col-md-8">
                <h1 class="text-center">
                    ${clubDiscuss.clubDiscussName}
                    <%--<%= systemNotice.getSystemNoticeName()%>--%>
                </h1>
                <div class="col-md-offset-2 col-md-2">内容：</div>
                <div class="col-md-8">
                    ${clubDiscuss.clubDiscussContent}
                </div>

                </br>
                <div class="col-md-offset-2 col-md-2">最新评论：</div>
                <div class="col-md-8">
                    ${clubDiscuss.clubDiscussComment}
                </div>

                </br>
                </br>
                <div>
                    <form class="form-horizontal" id="formtable">
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <input type="clubDiscussComment" class="form-control" id="clubDiscussComment" placeholder="添加评论">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-10 text-center">
                                <button type="button" class="btn btn-success" onclick="updateComment()">评&nbsp;&nbsp;论</button>
                                <button class="btn btn-success" type="button"  onclick="javascript:history.back(-1);">返回上一页</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10 text-center">

                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>

</html>
