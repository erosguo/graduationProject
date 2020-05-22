<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/6
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
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

    <title>系统管理员工作台</title>
</head>
<body id="wrapper" style="background-image:url('<%=path%>/static/img/systemManagerBack.jpg');background-repeat:no-repeat;background-size:100% 100%;background-attachment: fixed;">
<!--1.页眉部分-->
<jsp:include page="/WEB-INF/pages/base/stationTop.jsp" flush="true"></jsp:include>

<!--2.主体部分-->
<div class="container-fluid">
    <div class="pageContainer">
        <%--导航栏--%>
        <jsp:include page="/WEB-INF/pages/systemManager/systemManagerSideBar.jsp"></jsp:include>
        <!-- 左侧导航和正文内容的分隔线 -->
        <div class="divider"></div>
        <!-- 正文内容部分 -->
        <div class="pageContent container-fluid col-md-10">
            <div class="row">
                <div class="tab-content ">
                    <div>
                        <p class="lead text-center outer">欢迎使用大学生课外活动管理系统</p>
                        <p class="lead text-center outer">系统管理员版</p>
                        <p class="lead text-center">管理员：<%= request.getSession().getAttribute("account")%></p>
                    </div>

                    <div class="tab-pane col-sm-6 col-sm-offset-3" id="studentInfo">
                        <h3>111</h3>
                    </div>
                    <div class="tab-pane col-sm-6 col-sm-offset-3" id="clubInfo">
                        <h2>11</h2>
                    </div>
                    <div class="tab-pane container-fluid" id="systemNotice">
                        <div class="tabbable">

                                <div class="row tab-pane " id="operateSystemNotice">

                                    <table class="table">
                                        <tr>
                                            <td class="active">公告编号</td>
                                            <td class="active">公告名称</td>
                                            <td class="active">公告内容</td>
                                        </tr>


                                        <tr>
                                            <%--<td><%= systemNotice.getSystemNoticeId()%></td>
                                            <td><%= systemNotice.getSystemNoticeName()%></td>
                                            <td><%= systemNotice.getSystemNoticeContent()%></td>--%>
                                        </tr>
                                    </table>
                                </div>
                            </div>

                        </div>



                    </div>

                </div>
            </div>
        </div>



    </div>
</div>
<!--3.页脚部分-->
<jsp:include page="/WEB-INF/pages/base/footer.jsp"></jsp:include>
</body>
</html>
