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

<header class="container-fluid col-md-12">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="<%=path %>/static/img/oldPool.jpg" height="100%" />
                </a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a class="icon-bar" href="#">大学生课外活动管理系统</a>
                    <%--</li>
                    <li><a href="#">分类管理</a>
                    </li>
                    <li><a href="#">城市管理</a>
                    </li>
                    <li><a href="#">商品管理</a>
                    </li>
                    <li><a href="#">订单管理</a>
                    </li>--%>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a>欢迎您,<%= request.getSession().getAttribute("account")%></a>
                    </li>
                    <li><a href="<%=path %>/logOut">安全退出</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

</header>

