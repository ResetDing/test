<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.wanho.net/mytag/core_rt" prefix="wanho"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="gray-bg">

	<div class="container-div">
		<div class="row">
			<div class="col-sm-12 select-info">
				<form id="condition-form" method="post">
					<div class="select-list gd">
						<ul>
							<li>岗位编码：<input type="text" name="postCode" />
							</li>
							<li>岗位名称：<input type="text" name="postName" />
							</li>
							<li>岗位状态：<select name="status" id="gw">
									<option value="">所有</option>
							</select>
							</li>
							<li><a class="btn btn-primary btn-rounded btn-sm"
								onclick="$.table.search($('form').attr('id'))"><i
									class="fa fa-search"></i>&nbsp;搜索</a> <a
								class="btn btn-success btn-rounded btn-sm"
								onclick="$.table.exportExcel($('form').attr('id'))"><i
									class="fa fa-download"></i>&nbsp;下载</a></li>
						</ul>
					</div>
				</form>
			</div>

			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<wanho:permission permCondition="${wanho:hasPermission('admin:post:add',currentUser.menus)}">
				<button class="btn btn-outline btn-success btn-rounded" onclick="$.operate.add()" shiro:hasPermission="system:post:add">
	                <i class="fa fa-plus"></i> 新增
	            </button>
				</wanho:permission>

				<wanho:permission permCondition="${wanho:hasPermission('admin:post:remove',currentUser.menus)}">
				<button class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()" shiro:hasPermission="system:post:remove">
		            <i class="fa fa-trash-o"></i> 删除
		        </button>
				</wanho:permission>
			</div>

			<div class="col-sm-12 select-info order-table">
				<table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script>
		var editFlag = "${wanho:hasPermission('admin:post:edit1',currentUser.menus)}"
		var removeFlag ="${wanho:hasPermission('admin:post:remove',currentUser.menus)}"
		var prefix = ctx + "admin/post"

		$.ajax({
					url : ctx
							+ "/DataServlet?method=dictData&dictType=sys_job_status",
					method : "POST",
					dataType : "json",
					success : function(res) {
						if (res.success) {
							var html = "";
							$(res.data)
									.each(
											function(i, item) {
												html += '<option  value="'+item.dictValue+'" name="action">'
														+ item.dictLabel
														+ '</option>';
											});
							$("#gw").append(html);
						} else {
							alert(res.msg)
						}
					}
				});

		$(function() {
			var options = {
				url : "PostServlet?method=postList",
				createUrl : prefix + "/add.jsp",
				updateUrl : ctx + "/PostServlet?method=to_postUpdate",
				removeUrl : ctx + "/PostServlet?method=postRemove",
				sortName : "postSort",
				modalName : "岗位",
				search : false,
				showExport : false,
				columns : [
						{
							checkbox : true
						},
						{
							field : 'postId',
							title : '岗位编号'
						},
						{
							field : 'postCode',
							title : '岗位编码'
						},
						{
							field : 'postName',
							title : '岗位名称'
						},
						{
							field : 'postSort',
							title : '显示顺序'
						},
						{
							field : 'status',
							title : '状态',
							align : 'center',
							formatter : function(value, row, index) {
								if (value == 0) {
									return '<span class="badge badge-primary">正常</span>';
								} else if (value == 1) {
									return '<span class="badge badge-danger">停用</span>';
								}
							}
						},
						{
							field : 'createTime',
							title : '创建时间',
							formatter : function(value, row, index) {
								return new Date(row.createTime)
										.toLocaleDateString();
							}
						},
						{
							title : '操作',
							align : 'center',
							formatter : function(value, row, index) {
								var actions = [];
								if(editFlag=="true")
									actions.push('<a class="btn btn-success btn-xs '
												+ editFlag
												+ '" href="javascript:voide(0)" onclick="$.operate.edit(\''
												+ row.postId
												+ '\')"><i class="fa fa-edit"></i>编辑</a> ');
								if(removeFlag=="true")
									actions.push('<a class="btn btn-danger btn-xs '
												+ removeFlag
												+ '" href="javascript:voide(0)" onclick="$.operate.remove(\''
												+ row.postId
												+ '\')"><i class="fa fa-remove"></i>删除</a>');
								return actions.join('');
							}
						} ]
			};
			$.table.init(options);
		});
	</script>
</body>
</html>