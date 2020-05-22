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
<body id="wrapper" style="background-image:url('<%=path%>/static/img/transparentBack.jpeg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<%--页眉部分--%>
<jsp:include page="/WEB-INF/pages/base/baseTop.jsp"></jsp:include>
<%--主体部分--%>
<div class="container-fluid ">

    <div class="row">
        <div class="col-md-4">
            <img src="<%=path%>/static/img/discussDetail.jpg" style="width: 100%;height: 80%">
        </div>
        <div class="col-md-8">
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

    </div>


</div>
<%--页脚部分--%>
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
