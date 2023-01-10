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
	            <a type="button" class="btn btn-outline btn-default" onclick="$.operate.add(0)" shiro:hasPermission="system:menu:add">
                    <i class="fa fa-plus"></i> 新增
                </a>
			</div>
        </div>
        
	    <table id="bootstrap-table" data-mobile-responsive="true"></table>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script >
		var addFlag = false;
		var editFlag = false;
		var removeFlag = false;
		var prefix = ctx + "admin/menu"

		window.onload = function() {
			loading();
		};
		
		function loading() {
		    var options = {
		        id: "menuId",
		        parentId: "parentId",
		        expandAll: false,
		        url: ctx+"/MenuServlet?method=menuList",
		        createUrl: prefix + "/add.jsp",
		        updateUrl: ctx+"MenuServlet?method=to_menuUpdate",
		        removeUrl: prefix + "/remove.jsp",
		        modalName: "菜单",
		        columns: [{
		            title: '菜单名称',
		            field: 'menuName',
		            width: '20%',
		            formatter: function(row, index) {
		                if (row.icon == null || row == "") {
		                    return row.menuName;
		                } else {
		                    return '<i class="' + row.icon + '"></i> <span class="nav-label">' + row.menuName + '</span>';
		                }
		            }
		        },
		        {
		            field: 'orderNum',
		            title: '排序',
		            width: '10%',
		            align: "center"
		        },
		        {
		            field: 'url',
		            title: '请求地址',
		            width: '15%',
		            align: "center"
		        },
		        {
		            title: '类型',
		            field: 'menuType',
		            width: '10%',
		            align: "center",
		            formatter: function(item, index) {
		                if (item.menuType == 'M') {
		                    return '<span class="label label-success">目录</span>';
		                }
		                else if (item.menuType == 'C') {
		                    return '<span class="label label-primary">菜单</span>';
		                }
		                else if (item.menuType == 'F') {
		                    return '<span class="label label-warning">按钮</span>';
		                }
		            }
		        },
		        {
		            field: 'visible',
		            title: '可见',
		            width: '10%',
		            align: "center",
		            formatter: function(row, index) {
		                if (row.visible == 0) {
		                    return '<span class="badge badge-primary">显示</span>';
		                } else if (row.visible == 1) {
		                    return '<span class="badge badge-danger">隐藏</span>';
		                }
		            }
		        },
		        {
		            field: 'perms',
		            title: '权限标识',
		            width: '15%',
		            align: "center",
		        },
		        {
		            title: '操作',
		            width: '20%',
		            align: "center",
		            formatter: function(row, index) {
		                var actions = [];
		                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:voide(0)" onclick="$.operate.edit(\'' + row.menuId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
		                actions.push('<a class="btn btn-info btn-xs ' + addFlag + '" href="javascript:voide(0)" onclick="$.operate.add(\'' + row.menuId + '\')"><i class="fa fa-plus"></i>新增</a> ');
		                actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:voide(0)" onclick="remove(\'' + row.menuId + '\')"><i class="fa fa-remove"></i>删除</a>');
		                return actions.join('');
		            }
		        }]
		    };
		    $.treeTable.init(options);
		}
		
		function remove(id) {
			$.modal.confirm("确定删除该条" + $.table._option.modalName + "信息吗？", function() {
				$.ajax({
					type : 'post',
					url: ctx + "/MenuServlet?method=menuRemove&id=" + id,
					dataType:"json",
					success : function(result) {
						if (result.code == web_status.SUCCESS) {
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