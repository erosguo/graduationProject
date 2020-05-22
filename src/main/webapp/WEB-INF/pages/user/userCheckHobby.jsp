<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/5/2
  Time: 19:56
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

    <title>兴趣爱好</title>

    <script>
        function addHobby() {
            $.ajax({
                url: '<%=path %>/User/addHobby',
                data: "IsSports=" + document.getElementById("IsSports").checked+"&IsLiterature="+document.getElementById("IsLiterature").checked,
                type: 'post',
                success: function (map) {
                    alert("服务器处理中");
                    if (map.msg == "1") {
                        alert("修改成功");
                        location.href="<%=path%>/User/showUserStation";
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
<body id="wrapper" style="background-image:url('<%=path%>/static/img/userBack.jpg');background-repeat:no-repeat;background-size:120% 120%;background-attachment: fixed;background-position-y:-100px;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<!--2.主体部分-->
<div class="container-fluid">
    <div class="pageContainer">

        <!-- 正文内容部分 -->

        <div class="pageContent container-fluid col-md-10">
            <div class="row">
                <form>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="IsSports"> 热爱体育
                        </label>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="IsLiterature"> 喜欢诗词
                        </label>
                    </div>
                    <button type="button" class="btn btn-default" onclick="addHobby()">Submit</button>
                </form>

            </div>


        </div>


    </div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp" flush="true"></jsp:include>
</body>
</html>
