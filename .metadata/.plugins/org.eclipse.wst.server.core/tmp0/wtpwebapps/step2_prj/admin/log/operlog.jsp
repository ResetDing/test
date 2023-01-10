<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="gray-bg">

	<div class="container-div">
		<div class="row">
			<div class="col-sm-12 select-info">
				<form id="condition-form">
					<div class="select-list gd">
						<ul>
							<li>系统模块：<input type="text" name="title" />
							</li>
							<li>操作人员：<input type="text" name="operName" />
							</li>
							<li>操作类型：<select name="action"  id="action">
									<option value="">所有</option>
							</select>
							</li>
							<li><a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a> <a class="btn btn-success btn-rounded btn-sm" onclick="$.table.exportExcel($('form').attr('id'))"><i class="fa fa-download"></i>&nbsp;下载</a></li>
						</ul>
					</div>
				</form>
			</div>

			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()"> <i class="fa fa-trash-o"></i> 删除
				</a>
			</div>

			<div class="col-sm-12 select-info order-table">
				<table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>

	<jsp:include page="/admin/footer.jsp" />
	<script>
		$.ajax({
			url : ctx + "/DataServlet?method=dictData&type=sys_oper_type",
			method : "POST",
			dataType : "json",
			success : function(data) {
				var html = "";
				$(data).each(function(i, item) {
					html += '<option  value="'+item.dictValue+'" name="action">' + item.dictLabel + '</option>';
				});
				$("#action").append(html);
			}
		});

		var detailFlag = false;
		var prefix = ctx + "/admin/log"

		$(function() {
			var options = {
				url : ctx + 'OperlogServlet?method=operLogList',
				removeUrl : prefix + "/remove",
				exportUrl : prefix + "/export",
				sortName : "operTime",
				sortOrder : "desc",
				search : false,
				showExport : false,
				columns : [ {
					checkbox : true
				}, {
					field : 'operId',
					title : '日志编号'
				}, {
					field : 'title',
					title : '系统模块'
				}, {
					field : 'action',
					title : '操作类型',
					align : 'center',
					formatter : function(value, row, index) {
						if (value == 1) {
							return '<span class="badge badge-primary">新增</span>';
						} else if (value == 2) {
							return '<span class="badge badge-primary">修改</span>';
						} else if (value == 3) {
							return '<span class="badge badge-warning">保存</span>';
						} else if (value == 4) {
							return '<span class="badge badge-danger">删除</span>';
						} else if (value == 5) {
							return '<span class="badge badge-primary">授权</span>';
						} else if (value == 6) {
							return '<span class="badge badge-warning">导出</span>';
						} else if (value == 7) {
							return '<span class="badge badge-warning">导入</span>';
						} else if (value == 8) {
							return '<span class="badge badge-danger">强退</span>';
						} else if (value == 9) {
							return '<span class="badge badge-danger">禁止访问</span>';
						} else if (value == 10) {
							return '<span class="badge badge-warning">生成代码</span>';
						}
					}
				}, {
					field : 'operName',
					title : '操作人员'
				}, {
					field : 'deptName',
					title : '部门名称'
				}, {
					field : 'operIp',
					title : '主机'
				}, {
					field : 'operLocation',
					title : '操作地点'
				}, {
					field : 'status',
					title : '操作状态',
					align : 'center',
					formatter : function(value, row, index) {
						if (value == 0) {
							return '<span class="badge badge-primary">成功</span>';
						} else if (value == 1) {
							return '<span class="badge badge-danger">异常</span>';
						}
					}
				}, {
					field : 'operTime',
					title : '操作时间'
				}, {
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						var actions = [];
						actions.push('<a class="btn btn-warning btn-xs ' + detailFlag + '" href="javascript:void(0)" onclick="detail(\'' + row.operId + '\')"><i class="fa fa-search"></i>详细</a>');
						return actions.join('');
					}
				} ]
			};
			$.table.init(options);
		});

		/*操作日志-详细*/
		function detail(id) {
			var url = ctx + '/OperlogServlet?method=operLogDetail&operId=' + id;
			$.modal.open("操作日志详细", url);
		}
	</script>
</body>
</html>