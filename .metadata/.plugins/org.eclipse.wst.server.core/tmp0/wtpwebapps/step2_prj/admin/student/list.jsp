<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="btn-group hidden-xs" id="toolbar" role="group">
	        <button class="btn btn-outline btn-default" onclick="$.operate.add()" >
	            <i class="fa fa-plus"></i> 新增
	        </button>
	        <button class="btn btn-outline btn-default" onclick="$.operate.batRemove()" >
	            <i class="fa fa-trash-o"></i> 删除
	        </button>
        </div>
        <table id="bootstrap-table" data-mobile-responsive="true">
        </table>
    </div>
    <jsp:include page="/admin/footer.jsp" />
    <script >
        var editFlag = false;
        var removeFlag = false;
        var prefix = ctx + "adin/student"

        $(function() {
            var options = {
                url: ctx + "/StudentServlet?method=list",
                createUrl:  ctx + "/StudentServlet?method=to_add",
                updateUrl:  ctx + "/StudentServlet?method=to_update",
                removeUrl:  ctx + "/StudentServlet?method=remove",
                modalName: "学生",
                columns: [{
		            checkbox: true
		        },
				{
					field : 'stuId', 
					title : '学号 ' 
				},
				{
					field : 'stuName', 
					title : '姓名' 
				},
				{
					field : 'createBy', 
					title : '创建人' 
				},
				{
					field : 'createTime', 
					title : '创建时间' 
				},
				{
					field : 'updateBy', 
					title : '' 
				},
				{
					field : 'updateTime', 
					title : '' 
				},
		        {
		            title: '操作',
		            align: 'center',
		            formatter: function(value, row, index) {
		            	var actions = [];
		            	actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.edit(\'' + row.stuId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                        actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.stuId + '\')"><i class="fa fa-remove"></i>删除</a>');
						return actions.join('');
		            }
		        }]
            };
            $.table.init(options);
        });
    </script>
</body>
</html>