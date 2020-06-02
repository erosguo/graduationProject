<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/15
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<!-- 左侧导航栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=path%>/static/img/clubManager.jpeg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%= request.getSession().getAttribute("account")%>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index">
                <a href="<%=path %>/ClubManager/showClubManagerStation">
                    <i class="fa fa-dashboard"></i>
                    <span>首页</span>
                </a>
            </li>


            <li>
                <a href="<%=path %>/ClubManager/showClubManagerPasswordInfo">
                    <!-- 小图标样式设置 -->
                    <span class="glyphicon glyphicon-edit" aria-hidden="true">
                    </span>修改密码</a>
            </li>
            <li>
                <a href="<%=path %>/ClubManager/showClubManagerInfo">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true">
                    </span>信息修改</a>
            </li>
            <li>
                <a href="<%=path %>/ClubManager/showClubManagerUserApplyManageInfo?page=1&size=3" >
                <span class="glyphicon glyphicon-user" aria-hidden="true">
                    </span>入社申请</a>
            </li>

            <li>
                <a href="<%=path %>/ClubManager/showClubManagerUserManageInfo?page=1&size=3" >
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">
                    </span>成员管理</a>
            </li>

            <li>
                <a href="<%=path %>/ClubManager/showClubNoticePage" >
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">
                    </span>社团公告</a>
            </li>

            <li>
                <a href="<%=path %>/ClubManager/showClubDiscussInfo?page=1&size=3" >
                <span class="glyphicon glyphicon-align-left" aria-hidden="true">
                    </span>社团讨论</a>
            </li>

            <li>
                <a href="<%=path %>/ClubManager/showCreateActivityPage" >
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">
                    </span>活动创建</a>
            </li>

            <li>
                <a href="<%=path %>/ClubManager/showUserApplyActivity" >
                        <span class="glyphicon glyphicon-fire" aria-hidden="true">
                    </span>活动审核</a>
            </li>

            <li>
                <a href="<%=path %>/ClubManager/showActivityState" >
                        <span class="glyphicon glyphicon-fire" aria-hidden="true">
                    </span>活动状态</a>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<%--左侧导航栏
<div class="col-sm-2">




</div>--%>

