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

    <title>创建社团讨论</title>

    <script type="text/javascript" src="<%=path %>/static/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="<%=path %>/static/js/bootstrap.min.js"></script>
    <script>
        function createDiscuss() {
            if($('#clubDiscussName').val()==""){
                alert("提示','主题不能为空！");
                return;
            }
            $.ajax({
                url:'<%=path %>/ClubManager/createClubDiscuss',
                data:"clubDiscussName="+$("#clubDiscussName").val()+"&clubDiscussContent="+$('#clubDiscussContent').val(),
                type:'post',
                success:function(map){
                    alert("讨论创建中");
                    if(map.msg =="1"){
                        alert("创建成功");
                        //判断跳转页面
                        window.self.location="<%=path %>/ClubManager/showClubDiscussInfo";
                    }else if(map.msg =="2"){
                        alert("提示','请重新操作");
                    }
                    else{
                        alert("提示','操作失败，"+map.msg);
                    }
                },
                error:function(xhr,status,error){
                    alert("提示，服务器错误"+xhr.responseText);
                }

            });
        }
    </script>

</head>

<body class="hold-transition skin-purple sidebar-mini">


<div class="wrapper">
    <!--1.页眉部分-->
    <jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>
    <jsp:include page="/WEB-INF/pages/club/clubManagerSideBar.jsp" flush="true"></jsp:include>
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                大学生课外活动管理系统
                <small>后台管理</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 新建社团讨论</a></li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            </br>
            <ul class="nav nav-tabs">
                <li role="presentation" >
                    <a href="<%=path %>/ClubManager/showClubDiscussInfo?page=1&size=3" >社团讨论清单</a>
                </li>
                <li role="presentation" class="active">
                    <a href="#" >新建社团讨论</a>
                </li>

            </ul>
            <br/><br/>
            <div class="row" style="vertical-align: middle;">

                </br>
                <form class="form-horizontal col-sm-6 col-sm-offset-3" id="formtable">
                    <div class="form-group">
                        <label for="clubDiscussName" class="col-sm-3 control-label">讨论主题</label>
                        <div class="col-sm-9">
                            <input type="clubDiscussName" class="form-control" id="clubDiscussName" placeholder="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="clubDiscussContent" class="col-sm-3 control-label">讨论内容</label>
                        <div class="col-sm-9">
                            <input type="clubDiscussContent" class="form-control" id="clubDiscussContent" placeholder="content">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10 text-center">
                            <button type="button" class="btn btn-success" onclick="createDiscuss()">创&nbsp;&nbsp;建</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- 正文区域 /-->

    </div>
    <!--3.页脚部分-->
    <jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</div>


</body>

</html>
