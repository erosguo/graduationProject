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

    <title>社团工作台</title>

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
                <ul class="nav nav-tabs">
                    <li role="presentation" >
                        <a href="<%=path %>/ClubManager/showClubDiscussInfo?page=1&size=3" >社团讨论清单</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="#" >新建社团讨论</a>
                    </li>

                </ul>
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

        </div>
    </div>

</div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
