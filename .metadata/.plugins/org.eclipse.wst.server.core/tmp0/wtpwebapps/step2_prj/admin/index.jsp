<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>


<title>后台首页</title>
<base href="${pageContext.request.contextPath }/">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link href="css/plugins/bootstrap/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/plugins/font-awesome/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/animate/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow: hidden">
	<input type="hidden" name="userId" value="${currentUser.userId}" id="userId">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span>
							<img alt="image" class="img-circle " src="img/3.jpg" height="64px" width="64px" />
							</span> 
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
							<span class="clear"> 
							<span class="block m-t-xs">
								<strong class="font-bold">${currentUser.userName}</strong></span> 
								<span class="text-muted text-xs block">${currentUser.remark}<b class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a class="J_menuItem" href="form_avatar.html">修改头像</a></li>
								<li><a class="J_menuItem" href="profile.html">个人资料</a></li>
								<li><a class="J_menuItem" href="contacts.html">联系我们</a></li>
								<li><a class="J_menuItem" href="mailbox.html">信箱</a></li>
								<li class="divider"></li>
								<li><a href="login.html">安全退出</a></li>
							</ul>
						</div>
						<div class="logo-element">WAN</div>
					</li>

					<li class="active"><a href="admin/Ïßault.jsp" class="J_menuItem"> <i class="fa fa-home"></i> <span class="nav-label ">后台首页</span>
					</a></li>


					<script type="text/x-jquery-tmpl" id="menuTmpl">
                    <li class="secMenu">
                        <a href="${pageContext.request.contextPath }${'${url}'}" class="J_menuItem">
                            <i class="fa ${'${icon}'}"></i>
                            <span class="nav-label">
                                ${'${menuName}'}
                            </span>

                            {{if  children.length>0 }}

                             <span class="fa arrow"></span>
                            {{/if}}

                        </a>

                        <ul class="nav nav-second-level">
                             {{each children}}
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath }${'${url}'}">
                                 <i class="fa  ${'${icon}'}"></i>
                                 ${'${menuName}'}</a>
                            </li>
                            {{/each}}

                        </ul>
                    </li>

                </script>

				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
					<div class="navbar-header ">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"> <i class="fa fa-bars"></i>
						</a>
					</div>
					<!-- 一级菜单 -->
					<ul class="nav navbar-top-links navbar-left " id="topMenu">
					</ul>
					<ul class="nav navbar-top-links navbar-right">
						<li class="hidden-xs"><a href="javascript:;" class="clearCache"> <i class="fa fa-trash-o" aria-hidden="true"></i> <sapn>清除缓存</sapn>
						</a></li>
						<li class="hidden-xs"><a href="javascript:;" class="lockcms"> <i class="fa fa-lock" aria-hidden="true"></i> <sapn>锁屏</sapn>
						</a></li>
						<li class="dropdown hidden-xs"><a class="right-sidebar-toggle" aria-expanded="false"> <i class="fa fa-tasks"></i> 主题
						</a></li>
					</ul>
				</nav>
			</div>
			<div class="row content-tabs">
				<button class="roll-nav roll-left J_tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<nav class="page-tabs J_menuTabs">
					<div class="page-tabs-content">
						<a href="javascript:;" class="active J_menuTab" data-id="admin/default.jsp">后台首页</a>
					</div>
				</nav>
				<button class="roll-nav roll-right J_tabRight">
					<i class="fa fa-forward"></i>
				</button>
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown J_tabClose" data-toggle="dropdown">
						页面操作<span class="caret"></span>
					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>刷新当前</a></li>
						<li class="divider"></li>
						<li class="J_tabCloseOther"><a>关闭其他</a></li>
						<li class="J_tabCloseAll"><a>关闭全部</a></li>
					</ul>
				</div>
			</div>
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="admin/default.jsp?v=4.0" frameborder="0" data-id="admin/default.jsp" seamless></iframe>
			</div>
			<div class="footer">
				<div class="pull-right">
					&copy; 2018-2020 <a href="http://www.zi-han.net/" target="_blank">wanho</a>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<div class="sidebar-container">
				<ul class="nav nav-tabs navs-3">
					<li class="active"><a data-toggle="tab" href="#tab-1"> <i class="fa fa-gear"></i> 主题
					</a></li>
				</ul>
				<div class="tab-content">
					<div id="tab-1" class="tab-pane active">
						<div class="sidebar-title">
							<h3>
								<i class="fa fa-comments-o"></i> 主题设置
							</h3>
							<small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
						</div>
						<div class="skin-setttings">
							<div class="title">主题设置</div>
							<div class="setings-item">
								<span>收起左侧菜单</span>
								<div class="switch">
									<div class="onoffswitch">
										<input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu"> <label class="onoffswitch-label" for="collapsemenu"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
										</label>
									</div>
								</div>
							</div>
							<div class="setings-item">
								<span>固定顶部</span>

								<div class="switch">
									<div class="onoffswitch">
										<input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar"> <label class="onoffswitch-label" for="fixednavbar"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
										</label>
									</div>
								</div>
							</div>
							<div class="setings-item">
								<span> 固定宽度 </span>

								<div class="switch">
									<div class="onoffswitch">
										<input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout"> <label class="onoffswitch-label" for="boxedlayout"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
										</label>
									</div>
								</div>
							</div>
							<div class="title">皮肤选择</div>
							<div class="setings-item default-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-0"> 默认皮肤 </a>
								</span>
							</div>
							<div class="setings-item blue-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-1"> 蓝色主题 </a>
								</span>
							</div>
							<div class="setings-item yellow-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-3"> 黄色/紫色主题 </a>
								</span>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--右侧边栏结束-->
	</div>

	<!-- 全局js -->
	<script src="js/plugins/jquery/jquery.min.js?v=2.1.4"></script>
	<script src="js/plugins/bootstrap/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/hplus.js?v=4.1.0"></script>
	<script type="text/javascript" src="js/contabs.js"></script>

	<!-- 第三方插件 -->
	<script src="js/plugins/pace/pace.min.js"></script>
	<script src="js/plugins/hullabaloo/hullabaloo.js"></script>
	<script src="js/plugins/jquery-tmpl/jquery.tmpl.js"></script>

	<!--自定义js-->
	<script src="js/main.js"></script>


</body>

</html>
