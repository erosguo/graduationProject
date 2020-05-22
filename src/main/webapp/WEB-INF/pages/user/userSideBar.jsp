<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<div class="pageSidebar col-md-2">
    <ul class="nav nav-stacked nav-pills navbar-default">
        <!-- 开始 -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="mainFrame">
                账号设置<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/User/showPasswordPage" >修改密码</a>
                </li>
                <li>
                    <a href="<%=path %>/User/showUserInfoPage">编辑信息</a>
                </li>
                <li>
                    <a href="<%=path %>/logOut">退出系统</a>
                </li>

            </ul>
        </li>
        <li role="presentation">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="nav4.html" target="mainFrame">
                社团信息<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/User/hotClub">热门社团</a>
                </li>
                <li>
                    <a href="<%=path %>/User/myClub?page=1&size=3">我的社团</a>
                </li>
                <li>
                    <a href="<%=path %>/User/showClubDiscussInfo?page=1&size=3">社团讨论</a>
                </li>

            </ul>
        </li>
        <li role="presentation">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="" target="mainFrame">
                活动信息<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/User/showHotActivity?page=1&size=3">热门活动</a>
                </li>
                <li>
                    <a href="<%=path %>/User/showMyJoinActivity?page=1&size=3">参与的活动</a>
                </li>
                <li>
                    <a href="<%=path %>/User/showMyCreateActivity?page=1&size=3">创建的活动</a>
                </li>
                <li>
                    <a href="<%=path %>/User/showUserApplyActivity?page=1&size=3">管理活动申请</a>
                </li>
            </ul>
        </li>
        <li role="presentation">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="" target="mainFrame">
                创建活动<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="<%=path %>/User/showCreateNormalActivity">创建传统活动</a>

                </li>
                <li>
                    <a href="<%=path %>/User/showCreateMyActivity">创建自定义活动</a>
                </li>

            </ul>
        </li>

        <li role="presentation">
            <a href="<%=path %>/User/showMyFriendList?page=1&size=3" >我的好友</a>
        </li>
        <li role="presentation">
            <a href="<%=path %>/User/showMessageList?page=1&size=3" >消息中心</a>
        </li>
        <li role="presentation">
            <a href="<%=path %>/User/showMyCourse?page=1&size=3" >查看课表</a>
        </li>
    </ul>
</div>
