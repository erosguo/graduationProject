<%--
  Created by IntelliJ IDEA.
  User: 10983
  Date: 2020/4/15
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<script>
    function prohibit() {
        alert("系统管理员禁止更改默认信息");
    }
</script>
<!-- 左侧导航栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=path%>/static/img/systemManager.jpeg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%= request.getSession().getAttribute("account")%>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

<%--
            <li id="admin-index"><a href="#"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>
--%>

            <!-- 菜单 -->

            <ul  class="nav nav-stacked nav-pills">
                <!-- 开始 -->
                <li class="dropdown ">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="_blank">
                        <i class="fa fa-circle-o"></i>账号设置<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=path %>/SystemManager/showPasswordPage">修改密码</a>
                        </li>
                        <li>
                            <%--<%=path %>/SystemManager/showInfoPage--%>
                            <a href="javascript:void(0);" onclick="prohibit()">编辑信息</a>
                        </li>
                        <li>
                            <a href="<%=path %>/logOut">退出系统</a>
                        </li>
                    </ul>
                </li>
                <li role="presentation">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="mainFrame">
                        <i class="fa fa-circle-o"></i>申请审核<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=path %>/SystemManager/showUserApply?page=1&size=3">学生管理</a>
                        </li>
                        <li>
                            <a href="<%=path %>/SystemManager/showValidClubAll?page=1&size=3">社团管理</a>
                        </li>

                    </ul>
                </li>
                </li>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" target="mainFrame">
                        <i class="fa fa-circle-o"></i>系统角色<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=path %>/SystemManager/showClubAll?page=1&size=3">全部社团</a>
                        </li>
                        <li>
                            <a href="<%=path %>/SystemManager/showUserAll?page=1&size=3">全部成员</a>
                        </li>
                    </ul>
                </li>
                <li role="presentation">
                    <a href="<%=path %>/SystemManager/showCreateSystemNoticePage">系统公告</a>
                </li>
                <li role="presentation">
                    <a href="<%=path %>/SystemManager/showActivityPlaceAll">活动地点</a>
                </li>
            </ul>


        </ul>
    </section>
    <!-- /.sidebar -->
</aside>


