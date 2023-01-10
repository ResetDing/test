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
							<li>角色名称：<input type="text" name="roleName" />
							</li>
							<li>权限字符：<input type="text" name="roleKey" />
							</li>
							<li>角色状态：<select name="status" id="gw" >
									<option value="">所有</option>
							</select>
							</li>
							<li><a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a> <a class="btn btn-success btn-rounded btn-sm" onclick="$.table.exportExcel($('form').attr('id'))"><i class="fa fa-download"></i>&nbsp;下载</a></li>
						</ul>
					</div>
				</form>
			</div>

			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<a class="btn btn-outline btn-success btn-rounded" onclick="$.operate.add()" shiro:hasPermission="system:role:add"> <i class="fa fa-plus"></i> 新增
				</a> <a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()" shiro:hasPermission="system:role:remove"> <i class="fa fa-trash-o"></i> 删除
				</a>
			</div>

			<div class="col-sm-12 select-info order-table">
				<table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	<jsp:include page="/admin/footer.jsp"/>
	<script >
		var editFlag = false;
		var removeFlag = false;
		var prefix = ctx + "admin/role"
		
		$.ajax({
			url:ctx+"/DataServlet?method=dictData&dictType=sys_job_status",
			method:"POST",
			dataType:"json",
			success:function(res){
				if(res.success){
					var html="";
					$(res.data).each(function(i, item) {
						html += '<option  value="'+item.dictValue+'" name="action">' + item.dictLabel + '</option>';
					});
					$("#gw").append(html);
				}else{
					alert(res.msg)
				}
			}
		});	

		$(function() {
		    var options = {
		        url: ctx+"/RoleServlet?method=roleList",
		        createUrl: prefix + "/add.jsp",
		        updateUrl: ctx + "/RoleServlet?method=to_roleUpdate",
		        removeUrl: ctx + "/RoleServlet?method=roleRemove",
		        sortName: "roleSort",
		        modalName: "角色",
		        search: false,
		        showExport: false,
		        columns: [{
		            checkbox: true
		        },
		        {
		            field: 'roleId',
		            title: '角色编号'
		        },
		        {
		            field: 'roleName',
		            title: '角色名称'
		        },
		        {
		            field: 'roleKey',
		            title: '权限字符'
		        },
		        {
		            field: 'roleSort',
		            title: '显示顺序'
		        },
		        {
		            field: 'status',
		            title: '状态',
		            align: 'center',
		            formatter: function(value, row, index) {
		                if (value == 0) {
		                    return '<span class="badge badge-primary">正常</span>';
		                } else if (value == 1) {
		                    return '<span class="badge badge-danger">停用</span>';
		                }
		            }
		        },
		        {
		            field: 'createDateTimeStr',
		            title: '创建时间'
		        },
		        {
		            title: '操作',
		            align: 'center',
		            formatter: function(value, row, index) {
		                var actions = [];
		                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.edit(\'' + row.roleId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
		                actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.roleId + '\')"><i class="fa fa-remove"></i>删除</a>');
		                return actions.join('');
		            }
		        }]
		    };
		    $.table.init(options);
		});
	</script>
</body>
</html>