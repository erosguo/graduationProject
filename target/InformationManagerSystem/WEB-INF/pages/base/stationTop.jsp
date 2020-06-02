<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/8
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>

<!-- 页面头部 /-->

<header class="main-header ">
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>大学生课外活动</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>课外活动</b>管理系统</span>
    </a>

    <nav class="navbar navbar-inverse" role="navigation">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=path %>/logOut">安全退出</a>
            </li>
        </ul>
    </nav>

</header>

