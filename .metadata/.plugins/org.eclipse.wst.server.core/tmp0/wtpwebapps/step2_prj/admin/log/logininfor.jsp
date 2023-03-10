<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<li>
								登录地址：<input type="text" name="ipaddr"/>
							</li>
							<li>
								登录名称：<input type="text" name="loginName"/>
							</li>
							<li>
								登录状态：<select id="status" name="status">
									<option value="">所有</option>
								</select>
							</li>
							<li>
								<a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a>
								<a class="btn btn-success btn-rounded btn-sm" onclick="$.table.exportExcel($('form').attr('id'))"><i class="fa fa-download"></i>&nbsp;下载</a>
							</li>
						</ul>
					</div>
				</form>
			</div>
			
			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()" shiro:hasPermission="monitor:logininfor:remove">
		            <i class="fa fa-trash-o"></i> 删除
		        </a>
	        </div>
        
	        <div class="col-sm-12 select-info order-table">
			    <table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	
	<jsp:include page="/admin/footer.jsp" />
	<script type="text/javascript">
	
	$.ajax({
		url : ctx + "/DataServlet?method=dictData&type=sys_common_status",
		method : "POST",
		dataType : "json",
		success : function(data) {
			var html = "";
			$(data).each(function(i, item) {
				html += '<option  value="'+item.dictValue+'" name="status">' + item.dictLabel + '</option>';
			});
			$("#status").append(html);
		}
	});
	
		var prefix = ctx + "monitor/logininfor"
	
		$(function() {
		    var options = {
		        url: ctx + "/LogininforServlet?method=logininforList",
		        removeUrl: prefix + "/remove",
		        exportUrl: prefix + "/export",
		        sortName: "loginTime",
		        sortOrder: "desc",
		        search: false,
		        showExport: false,
		        columns: [{
		            checkbox: true
		        },
		        {
		            field: 'infoId',
		            title: '访问编号'
		        },
		        {
		            field: 'loginName',
		            title: '登录名称'
		        },
		        {
		            field: 'ipaddr',
		            title: '登录地址'
		        },
		        {
		            field: 'loginLocation',
		            title: '登录地点'
		        },
		        {
		            field: 'browser',
		            title: '浏览器'
		        },
		        {
		            field: 'os',
		            title: '操作系统'
		        },
		        {
		            field: 'status',
		            title: '登录状态',
		            align: 'center',
		            formatter: function(value, row, index) {
		                if (value == 0) {
		                    return '<span class="badge badge-primary">成功</span>';
		                } else if (value == 1) {
		                    return '<span class="badge badge-danger">失败</span>';
		                }
		            }
		        },
		        {
		            field: 'msg',
		            title: '操作信息'
		        },
		        {
		            field: 'loginTime',
		            title: '登录时间'
		        }]
		    };
		    $.table.init(options);
		});
	</script>
</body>
</html>