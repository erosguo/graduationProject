<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/16
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<aside class="main-sidebar skin-blue">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=path%>/static/img/user.jpeg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%= request.getSession().getAttribute("account")%>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <!-- 菜单 -->

            <ul  class="nav nav-stacked nav-pills">
                <!-- 开始 -->
                <li class="dropdown ">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="_blank">
                        <i class="fa fa-circle-o"></i>账号设置<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=path %>/User/showPasswordPage">修改密码</a>
                        </li>
                        <li>
                            <a href="<%=path %>/User/showUserInfoPage">编辑信息</a>
                        </li>
                        <li>
                            <a href="<%=path %>/logOut">退出系统</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" >
                        <i class="fa fa-circle-o"></i>社团信息<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=path %>/User/hotClub">热门社团</a>
                        </li>
                        <li>
                            <a href="<%=path %>/User/findMyClub?page=1&size=3">我的社团</a>
                        </li>
                        <li>
                            <a href="<%=path %>/User/showClubDiscussInfo?page=1&size=3">社团讨论</a>
                        </li>

                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="" target="mainFrame">
                        <i class="fa fa-circle-o"></i>活动信息<span class="caret"></span>
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
                        <li>
                            <a href="<%=path %>/User/showUserInvite">管理活动邀约</a>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="<%=path %>/User/showMyFriendList?page=1&size=3">
                        <i class="fa"></i>
                        <span>我的好友</span>
                    </a>
                </li>

                <li >
                    <a href="<%=path %>/User/showMessageList?page=1&size=3">
                        <i class="fa"></i>
                        <span>消息中心</span>
                    </a>
                </li>

                <li >
                    <a href="<%=path %>/User/showMyCourse?page=1&size=3">
                        <i class="fa"></i>
                        <span>查看课表</span>
                    </a>
                </li>
                <li >
                    <a href="<%=path %>/User/showCreateMyActivity">
                        <i class="fa"></i>
                        <span>创建自定义活动</span>
                    </a>
                </li>
            </ul>


        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

