<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>主页</title>
<base href="${pageContext.request.contextPath }/">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico">
<link href="css/plugins/bootstrap/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/plugins/font-awesome/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/plugins/animate/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">

</head>

<body class="gray-bg index">

	<div class="wrapper wrapper-content">

		<!--菜单首页：显示当前用户和当前时间开始 ========================================-->

		<div class="row">
			<div class="col-sm-12">
				<div class="alert alert-success" id="nowTime"></div>
			</div>
		</div>
		<!--菜单首页：显示当前用户和当前时间结束 ========================================-->


		<!--菜单首页：显示面板开始 ========================================-->
		<div class="row">
			<div class="col-sm-4 ">
				<div class="media">
					<div class="media-left">
						<button class="btn btn-primary" type="button">
							<i class="fa fa-users fa-3x"></i>
						</button>
					</div>
					<div class="media-right">
						用户总数: <br>3
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="media">
					<div class="media-left">
						<button class="btn btn-danger" type="button">
							<i class="fa fa-life-ring fa-3x"></i>
						</button>
					</div>
					<div class="media-right">
						外部图标: <br>34

					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="media">
					<div class="media-left">
						<button class="btn btn-warning" type="button">
							<i class="fa fa-clock-o fa-3x" aria-hidden="true"></i>
						</button>
					</div>
					<div class="media-right">
						<span class="loginTime"></span> <cite>上次登录时间</cite>
					</div>
				</div>
			</div>
		</div>
		<!--菜单首页：显示面板结束 ========================================-->

		<!--菜单首页:系统基本参数和最新文章的开始=================================-->


		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							系统基本参数 <i class="fa fa-laptop" aria-hidden="true"></i>
						</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-bordered table-hover">
							<colgroup>
								<col width="150">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<td>当前版本</td>
									<td class="version">v2.0</td>
								</tr>
								<tr>
									<td>开发作者</td>
									<td class="author">驊驊龔頾</td>
								</tr>
								<tr>
									<td>网站首页</td>
									<td class="homePage">index.html</td>
								</tr>
								<tr>
									<td>服务器环境</td>
									<td class="server">windows</td>
								</tr>
								<tr>
									<td>数据库版本</td>
									<td class="dataBase">8.00.2039</td>
								</tr>
								<tr>
									<td>最大上传限制</td>
									<td class="maxUpload">2M</td>
								</tr>
								<tr>
									<td>当前用户权限</td>
									<td class="userRights">超级管理员</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="panel panel-danger">
					<div class="panel-heading ">
						<h3 class="panel-title">
							最新文章 <i class="fa fa-fire fa-1x" aria-hidden="true"></i>
						</h3>
					</div>
					<div class="panel-body">
						<table class="table table-hover table-bordered table-striped">
							<colgroup>
								<col>
								<col width="110">
							</colgroup>
							<tbody class="hot_news">
								<tr>
									<td align="left"><a href="javascript:;"> css3用transition实现边框动画效果</a></td>
									<td>2017-04-14</td>
								</tr>
								<tr>
									<td align="left"><a href="javascript:;"> 自定义的模块名称可以包含/吗</a></td>
									<td>2017-04-14</td>
								</tr>
								<tr>
									<td align="left"><a href="javascript:;"> layui.tree如何ajax加载二级菜单</a></td>
									<td>2017-04-14</td>
								</tr>
								<tr>
									<td align="left"><a href="javascript:;"> layui.upload如何带参数？像jq的data:{}那样</a></td>
									<td>2017-04-14</td>
								</tr>
								<tr>
									<td align="left"><a href="javascript:;"> 表单元素长度应该怎么调整才美观</a></td>
									<td>2017-04-14</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--菜单首页:系统基本参数和最新文章结束=================================-->

		<div class="row">
			<div class="col-sm-4">

				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>二次开发</h5>
					</div>
					<div class="ibox-content">
						<p>other.</p>
					</div>
				</div>
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>联系信息</h5>

					</div>
					<div class="ibox-content">
						<p>
							<i class="fa fa-send-o"></i> 博客：<a href="http://www.zi-han.net" target="_blank">http://www.wanho.net</a>
						</p>
						<p>
							<i class="fa fa-qq"></i> QQ：<a href="http://wpa.qq.com/msgrd?v=3&uin=516477188&site=qq&menu=yes" target="_blank">89115008</a>
						</p>
						<p>
							<i class="fa fa-weixin"></i> xx信：<a href="javascript:;">89115008@</a>
						</p>
						<p>
							<i class="fa fa-credit-card"></i> xx宝：<a href="javascript:;" class="支付宝信息">89115008@qq.com</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>更新日志</h5>
					</div>
					<div class="ibox-content no-padding">
						<div class="panel-body">
							<div class="panel-group" id="version">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h5 class="panel-title">
											<a data-toggle="collapse" data-parent="#version" href="#v41">v4.1.0</a>
											<code class="pull-right">2018.06.07</code>
										</h5>
									</div>
									<div id="v41" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="alert alert-warning">此版本是一个维护版本，主要是升级和修复bug，让我们共同期待5.0版的到来</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>其它说明</h5>
					</div>
					<div class="ibox-content">other.</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="js/plugins/jquery/jquery.min.js?v=2.1.4"></script>
	<script src="js/plugins/bootstrap/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/index.js"></script>
</body>

</html>
