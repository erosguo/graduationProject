<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/8
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>

<header class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" title="大学生课外活动管理系统" href="#">大学生课外活动管理系统</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<%=path %>/BackIndex" >返回首页</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->

        </div>
    </nav>
</header>

