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
							<li>参数名称：<input type="text" name="configName" />
							</li>
							<li>参数键名：<input type="text" name="configKey" />
							</li>
							<li>系统内置：<select name="configType"  id="nz">
									<option value="">所有</option>
							</select>
							</li>
							<li><a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a></li>
						</ul>
					</div>
				</form>
			</div>

			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<a class="btn btn-outline btn-success btn-rounded" onclick="$.operate.add()" > <i class="fa fa-plus"></i> 新增
				</a> <a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()" > <i class="fa fa-trash-o"></i> 删除
				</a>
			</div>
			<div class="col-sm-12 select-info order-table">
				<table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script >
	
	$.ajax({
		url:ctx+"/DataServlet?method=dictData&type=sys_yes_no",
		method:"POST",
		dataType:"json",
		success:function(data){
			var html="";
			$(data).each(function(i,item){
				html+='<option  value="'+item.dictValue+'" name="configType">'+item.dictLabel+'</option>';
			});
			$("#nz").append(html);
		}
	});	
	
	
        var editFlag = false;
        var removeFlag =false;
        var prefix = ctx + "admin/config"

        $(function() {
            var options = {
                url: ctx+"/ConfigServlet?method=list",
                createUrl: prefix + "/add.jsp",
                updateUrl:  ctx+"/ConfigServlet?method=to_update",
                removeUrl: ctx+"/ConfigServlet?method=remove",
                sortName: "createTime",
		        sortOrder: "desc",
                modalName: "参数",
                search: false,
		        showExport: false,
                columns: [{
                    checkbox: true
                },
                {
                    field: 'configId',
                    title: '参数主键'
                },
                {
                    field: 'configName',
                    title: '参数名称'
                },
                {
                    field: 'configKey',
                    title: '参数键名'
                },
                {
                    field: 'configValue',
                    title: '参数键值'
                },
                {
                    field: 'configType',
                    title: '系统内置',
                    align: 'center',
                    formatter: function(value, row, index) {
                        if (value == 'Y') {
                            return '<span class="badge badge-primary">是</span>';
                        } else if (value == 'N') {
                            return '<span class="badge badge-danger">否</span>';
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
                        actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.edit(\'' + row.configId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                        actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.configId + '\')"><i class="fa fa-remove"></i>删除</a>');
                        return actions.join('');
                    }
                }]
            };
            $.table.init(options);
        });
    </script>
</body>
</html>