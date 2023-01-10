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
						    <li>
								字典类型：
								<select id="dictType" name="dictType" ></select>
							</li>
							<li>
								字典标签：<input type="text" name="dictLabel"/>
							</li>
							<li>
								数据状态：<select name="status" id="status" >
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
	            <a class="btn btn-outline btn-success btn-rounded" onclick="$.operate.add()" >
	                <i class="fa fa-plus"></i> 新增
	            </a>
				<a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()" shiro:hasPermission="system:dict:remove">
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
		url : ctx + "/DictTypeServlet?method=selectDictTypeList",
		method : "POST",
		dataType : "json",
		async:true,
		success : function(data) {
			
			var html = "";
			$(data).each(function(i, item) {
				html += '<option  value="'+item.dictType+'" name="action">' + item.dictName + '</option>';
			});
			$("#dictType").append(html);
			$("#dictType").val("${param.dictType}");
		}
	});
	
	$.ajax({
		url : ctx + "/DataServlet?method=dictData&type=sys_normal_disable",
		method : "POST",
		dataType : "json",
		async:true,
		success : function(data) {
			
			var html = "";
			$(data).each(function(i, item) {
				html += '<option  value="'+item.dictValue+'" name="action">' + item.dictLabel + '</option>';
			});
			$("#status").append(html);
			
		}
	
	});
	
		var editFlag = false;
		var removeFlag = false;
		var prefix = ctx + "/admin/dict/data"

		$(function() {
			var options = {
				url: ctx + "/DataServlet?method=dictDataList&dictType=${param.dictType}",
				createUrl: prefix + "/add.jsp?dictType="+$('#dictType').val(),
				updateUrl: ctx + "/DataServlet?method=to_dictDataUpdate",
				removeUrl: ctx + "/DataServlet?method=dictDataRemove",
				exportUrl: prefix + "/export",
				//queryParams: queryParams,
				sortName: "createTime",
		        sortOrder: "desc",
				modalName: "数据",
				search: false,
		        showExport: false,
				columns: [{
						checkbox: true
					},
					{
						field: 'dictCode',
						title: '字典编码'
					},
					{
						field: 'dictLabel',
						title: '字典标签'
					},
					{
						field: 'dictValue',
						title: '字典键值'
					},
					{
						field: 'dictSort',
						title: '字典排序'
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
						field: 'remark',
						title: '备注'
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
							actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.edit(\'' + row.dictCode + '\')"><i class="fa fa-edit"></i>编辑</a> ');
							actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.dictCode + '\')"><i class="fa fa-remove"></i>删除</a>');
							return actions.join('');
						}
					}]
				};
			$.table.init(options);
		});
		
		/* function queryParams(params) {
			return {
				dictType:       $("#dictType").val()
			};
		} */
	</script>
</body>
</html>