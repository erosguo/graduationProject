<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/15
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<!-- 左侧导航栏 -->
<div class="pageSidebar col-md-2">
    <ul class="nav nav-stacked nav-pills navbar-default">
        <!-- 开始 -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="mainFrame">
                账号设置<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/SystemManager/showPasswordPage" >修改密码</a>
                </li>
                <li>
                    <a href="<%=path %>/SystemManager/showInfoPage">编辑信息</a>
                </li>
                <li>
                    <a href="<%=path %>/logOut">退出系统</a>
                </li>
            </ul>
        </li>
        <li role="presentation">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="mainFrame">
                申请审核<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/SystemManager/showUserApply?page=1&size=3" >学生管理</a>
                </li>
                <li>
                    <a href="<%=path %>/SystemManager/showValidClubAll?page=1&size=3" >社团管理</a>
                </li>

            </ul>
        </li>
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="mainFrame">
                系统角色<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/SystemManager/showClubAll?page=1&size=3" >全部社团</a>
                </li>
                <li>
                    <a href="<%=path %>/SystemManager/showUserAll?page=1&size=3">全部成员</a>
                </li>
            </ul>
        </li>
        <li role="presentation">
            <a href="<%=path %>/SystemManager/showCreateSystemNoticePage" >系统公告</a>
        </li>
        <li role="presentation">
            <a href="<%=path %>/SystemManager/showActivityPlaceAll" >活动地点</a>
        </li>
    </ul>
</div>
