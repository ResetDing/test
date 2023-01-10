<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://www.wanho.net/mytag/core_rt" prefix="wanho"%> --%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<title>用户管理</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="js/plugins/jquery-layout/jquery.layout-latest.css" rel="stylesheet" />
<link href="js/plugins/jquery-ztree/3.5/css/metro/zTreeStyle.css" rel="stylesheet" />

<body class="gray-bg">
	<div class="ui-layout-west">
		<div class="main-content">
			<div class="box box-main">
				<div class="box-header">
					<div class="box-title">
						<i class="fa icon-grid"></i> 组织机构
					</div>
					<div class="box-tools pull-right">
						<a type="button" class="btn btn-box-tool menuItem" href="#" onclick="dept()" title="管理机构"><i class="fa fa-edit"></i></a>
						<button type="button" class="btn btn-box-tool" id="btnExpand" title="展开" style="display: none;">
							<i class="fa fa-chevron-up"></i>
						</button>
						<button type="button" class="btn btn-box-tool" id="btnCollapse" title="折叠">
							<i class="fa fa-chevron-down"></i>
						</button>
						<button type="button" class="btn btn-box-tool" id="btnRefresh" title="刷新机构">
							<i class="fa fa-refresh"></i>
						</button>
					</div>
				</div>
				<div class="ui-layout-content">
					<div id="tree" class="ztree"></div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-div ui-layout-center">
		<div class="row">
			<div class="col-sm-12 select-info">
				<form id="condition-form">
					<input type="hidden" id="deptId" name="deptId"> <input type="hidden" id="parentId" name="parentId">
					<div class="select-list gd">
						<ul>
							<li>登录名称：<input type="text" name="loginName" />
							</li>
							<li>手机号码：<input type="text" name="phonenumber" />
							</li>
							<li>用户状态：<select name="status">
									<option value="">所有</option>
							</select>
							</li>
							<li><a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a></li>
						</ul>
					</div>
				</form>
			</div>

			<div class="btn-group hidden-xs" id="toolbar" role="group">

				<%-- <wanho:permission permCondition="${wanho:hasPermission('admin:user:list',currentUser.menuLst)}"> --%>
			<a class="btn btn-outline btn-success btn-rounded" onclick="$.operate.add()" > <i class="fa fa-plus"></i> 新增		
	<%-- </wanho:permission> --%>

				</a> <a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()"> <i class="fa fa-trash-o"></i> 删除
				</a>
			</div>

			<div class="col-sm-12 select-info order-table">
				<table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script src="js/plugins/jquery-layout/jquery.layout-latest.js"></script>
	<script src="js/plugins/jquery-ztree/3.5/js/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript">
		var editFlag = false;
		var removeFlag = false;
		var resetPwdFlag = false;
		var prefix = "admin/user"

		$(document).ready(function() {
			$('body').layout({
				west__size : 185
			});
			queryUserList();
			queryDeptTreeDaTa();
		});

		function queryUserList() {
			var options = {
				url : ctx + "UserServlet?method=userList",
				createUrl : ctx + "UserServlet?method=to_userAdd",
				updateUrl : ctx + "UserServlet?method=to_userUpdate",
				removeUrl : ctx + "UserServlet?method=remove",
				sortName : "createTime",
				sortOrder : "desc",
				modalName : "用户",
				search : false,
				showExport : true,
				columns : [ {
					checkbox : true
				}, {
					field : 'userId',
					title : '用户ID'
				}, {
					field : 'loginName',
					title : '登录名称'
				}, {
					field : 'userName',
					title : '用户名称'
				}, {
					field : 'dept.deptName',
					title : '部门'
				}, {
					field : 'email',
					title : '邮箱'
				}, {
					field : 'phonenumber',
					title : '手机'
				}, {
					field : 'status',
					title : '状态',
					align : 'center',
					formatter : function(value, row, index) {
						if (value == '0') {
							return '<span class="badge badge-primary">正常</span>';
						} else if (value == '1') {
							return '<span class="badge badge-danger">停用</span>';
						}
					}
				}, {
					field : 'createDateTimeStr',
					title : '创建时间'
				}, {
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						var actions = [];
						/* <wanho:permission permCondition="${wanho:hasPermission('admin:user:list',currentUser.menuLst)}"> */
								actions.push('<a class="btn find btn-success btn-xs ' + editFlag + '" href="javascript:void(0);" onclick="$.operate.edit(\'' + row.userId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
						/* </wanho:permission> */
						
						actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0);" onclick="$.operate.remove(\'' + row.userId + '\')"><i class="fa fa-remove"></i>删除</a> ');
						actions.push('<a class="btn btn-info btn-xs ' + resetPwdFlag + '" href="javascript:void(0);" onclick="resetPwd(\'' + row.userId + '\')"><i class="fa fa-key"></i>重置</a>');
						return actions.join('');
					}
				} ]
			};
			$.table.init(options);
		}

		function queryDeptTreeDaTa() {
			// 树结构初始化加载
			var setting = {
				view : {
					selectedMulti : false
				},
				data : {
					key : {
						title : "title"
					},
					simpleData : {
						enable : true
					}
				},
				callback : {
					onClick : function(event, treeId, treeNode) {
						tree.expandNode(treeNode);
						$("#deptId").val(treeNode.id);
						$("#parentId").val(treeNode.pId);
						$.table.search($('form').attr('id'));
					}
				}
			}, tree, loadTree = function() {
				$.getJSON("DeptServlet?method=deptTree", function(data) {
					tree = $.fn.zTree.init($("#tree"), setting, data); //.expandAll(true);
					// 展开第一级节点
					var nodes = tree.getNodesByParam("level", 0);
					for (var i = 0; i < nodes.length; i++) {
						tree.expandNode(nodes[i], true, false, false);
					}
					// 展开第二级节点
					nodes = tree.getNodesByParam("level", 1);
					for (var i = 0; i < nodes.length; i++) {
						tree.expandNode(nodes[i], true, false, false);
					}
				}, null, null, "正在加载，请稍后...");
			};
			loadTree();

			$('#btnExpand').click(function() {
				tree.expandAll(true);
				$(this).hide();
				$('#btnCollapse').show();
			});
			$('#btnCollapse').click(function() {
				tree.expandAll(false);
				$(this).hide();
				$('#btnExpand').show();
			});
			$('#btnRefresh').click(function() {
				loadTree();
			});
		}

		/*用户管理-部门*/
		function dept() {
			var url = ctx + "system/dept";
			createMenuItem(url, "部门管理");
		}

		/*用户管理-重置密码*/
		function resetPwd(userId) {

			var url = ctx + "UserServlet?method=resetPwd";
			var data = {
				"id" : userId
			};
			$.operate.submit(url, "post", "json", data)
		}
	</script>
</body>
</html>