<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<style type="text/css">
.fixed-table-container{position:relative;clear:both;border:1px solid #ddd;border-radius:4px;-webkit-border-radius:4px;-moz-border-radius:4px}
</style>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	    <div class="btn-group hidden-xs" id="toolbar" role="group">
	    	<div class="form-group">
	            <a type="button" class="btn btn-outline btn-default" onclick="$.operate.add(100)" >
                    <i class="fa fa-plus"></i> 新增
                </a>
			</div>
        </div>
        
		<table id="bootstrap-table" data-mobile-responsive="true"></table>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script type="text/javascript">
		var addFlag = false;
		var editFlag = false;
		var removeFlag = false;
		var prefix = ctx + "admin/dept"

		window.onload = function() {
			loading();
		};
		
		function loading() {
		    var options = {
		        id: "deptId",
		        parentId: "parentId",
		        url: ctx+"/DeptServlet?method=deptList",
		        createUrl: prefix + "/add.jsp",
		        updateUrl: ctx + "/DeptServlet?method=to_deptUpdate",
		        removeUrl: ctx+"/DeptServlet?method=deptRemove",
		        modalName: "部门",
		        columns: [{
		            field: 'deptName',
		            title: '部门名称',
		        },
		        {
		            field: 'orderNum',
		            title: '排序',
		            align: "center"
		        },
		        {
		            field: 'status',
		            title: '状态',
		            align: "center",
		            formatter: function(item, index) {
		                if (item.status == '0') {
		                    return '<span class="badge badge-primary">正常</span>';
		                } else if (item.status == '1') {
		                    return '<span class="badge badge-danger">停用</span>';
		                }
		            }
		        },
		        {
		            field: 'createTime',
		            title: '创建时间',
		            formatter: function(value, row, index) {
		            	return new Date().toLocaleDateString();
		            }
		        },
		        {
		            title: '操作',
		            align: 'center',
		            formatter: function(row, index) {
		                if (row.parentId != 0) {
		                    var actions = [];
		                    actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:voide(0)" onclick="$.operate.edit(\'' + row.deptId + '\')"><i class="fa fa-edit">编辑</i></a> ');
		                    actions.push('<a class="btn btn-info  btn-xs ' + addFlag + '" href="javascript:voide(0)" onclick="$.operate.add(\'' + row.deptId + '\')"><i class="fa fa-plus">新增</i></a> ');
		                    actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:voide(0)" onclick="remove(\'' + row.deptId + '\')"><i class="fa fa-remove">删除</i></a>');
		                    return actions.join('');
		                } else {
		                    return "";
		                }
		            }
		        }]
		    };
		    $.treeTable.init(options);
		}
		
		function remove(id) {
			$.modal.confirm("确定删除该条" + $.table._option.modalName + "信息吗？", function() {
				$.ajax({
					type : 'post',
					url:ctx+"/DeptServlet?method=deptRemove&ids="+ id,
					dataType:'JSON',
					success : function(result) {
						if (result.success) {
		                	$.modal.alertSuccess(result.msg);
		                	loading();
		                } else {
		                	$.modal.alertError(result.msg);
		                }
					}
				});
			});
		}
	</script>
</body>
</html>