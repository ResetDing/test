<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh" >
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="gray-bg">
    
    <div class="container-div">
		<div class="row">
			<div class="col-sm-12 select-info">
				<form id="condition-form">
					<div class="select-list gd">
						<ul>
							<li>
								表名称：<input type="text" name="tableName"/>
							</li>
							<li>
								表描述：<input type="text" name="tableComment"/>
							</li>
							<li>
								<a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a>
							</li>
						</ul>
					</div>
				</form>
			</div>
			
			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<a class="btn btn-outline btn-success btn-rounded" onclick="javascript:batchGenCode()" shiro:hasPermission="tool:gen:code">
			        <i class="fa fa-download"></i> 批量生成
			    </a>
		    </div>
		
		    <div class="col-sm-12 select-info order-table">
			    <table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	 <jsp:include page="/admin/footer.jsp" />
	<script type="text/javascript">
		var prefix = ctx + "admin/tool/gen"
	
		$(function() {
		    var options = {
		        url: ctx + "/GenServlet?method=list",
		        sortName: "createTime",
		        sortOrder: "desc",
		        search: false,
		        columns: [{
		            checkbox: true
		        },
		        {
		            field: 'tableName',
		            title: '表名称'
		        },
		        {
		            field: 'tableComment',
		            title: '表描述'
		        },
		        {
		            field: 'createDateTimeStr',
		            title: '创建时间'
		        },
		        {
		            field: 'updateDateTimeStr',
		            title: '更新时间'
		        },
		        {
		            title: '操作',
		            align: 'center',
		            formatter: function(value, row, index) {
		                var msg = '<a class="btn btn-primary btn-xs" href="javascript:void(0)" onclick="genCode(\'' + row.tableName + '\')"><i class="fa fa-bug"></i>生成代码</a> ';
		                return msg;
		            }
		        }]
		    };
		    $.table.init(options);
		});
	
		// 生成代码
		function genCode(tableName) {
		    $.modal.confirm("确定要生成" + tableName + "表代码吗？", function() {
		        location.href = ctx + "/GenServlet?method=genCode&tableName=" + tableName;
		        layer.msg('执行成功,正在生成代码请稍后…', { icon: 1 });
		    })
		}
	
		//批量生成代码
		function batchGenCode() {
		    var rows = $.table.selectColumns("tableName");
		    if (rows.length == 0) {
		        $.modal.alertWarning("请选择要生成的数据");
		        return;
		    }
		    $.modal.confirm("确认要生成选中的" + rows.length + "条数据吗?", function() {
		        location.href = prefix + "/batchGenCode?tables=" + JSON.stringify(rows);
		        layer.msg('执行成功,正在生成代码请稍后…', { icon: 1 });
		    });
		}
	</script>
</body>
</html>