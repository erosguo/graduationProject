<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/15
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<%--左侧导航栏--%>
<div class="col-sm-2">

    <a href="<%=path %>/ClubManager/showClubManagerStation" class="list-group-item active"><span class="glyphicon glyphicon-home"></span>功能导航
    </a>
    <a href="<%=path %>/ClubManager/showClubManagerPasswordInfo" class="list-group-item">
        <!-- 小图标样式设置 -->
        <span class="glyphicon glyphicon-edit" aria-hidden="true">
                    </span>修改密码</a>
    <a href="<%=path %>/ClubManager/showClubManagerInfo" class="list-group-item">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true">
                    </span>信息修改</a>
    <a href="<%=path %>/ClubManager/showClubManagerUserApplyManageInfo?page=1&size=3" class="list-group-item">
                        <span class="glyphicon glyphicon-user" aria-hidden="true">
                    </span>入社申请</a>
    <a href="<%=path %>/ClubManager/showClubManagerUserManageInfo?page=1&size=3" class="list-group-item">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">
                    </span>成员管理</a>
    <a href="<%=path %>/ClubManager/showClubNoticePage" class="list-group-item">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">
                    </span>社团公告</a>
    <a href="<%=path %>/ClubManager/showClubDiscussInfo?page=1&size=3" class="list-group-item">
                        <span class="glyphicon glyphicon-align-left" aria-hidden="true">
                    </span>社团讨论</a>
    <a href="<%=path %>/ClubManager/showCreateActivityPage" class="list-group-item">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true">
                    </span>活动创建</a>
    <a href="<%=path %>/ClubManager/showUserApplyActivity" class="list-group-item">
                        <span class="glyphicon glyphicon-fire" aria-hidden="true">
                    </span>活动审核</a>
    <a href="<%=path %>/ClubManager/showActivityState" class="list-group-item">
                        <span class="glyphicon glyphicon-fire" aria-hidden="true">
                    </span>活动状态</a>


</div>

