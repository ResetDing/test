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
							<li>字典名称：<input type="text" name="dictName" />
							</li>
							<li>字典类型：<input type="text" name="dictType" />
							</li>
							<li>字典状态：<select name="status" id="status">
									<option value="">所有</option>
							</select>
							</li>
							<li><a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a> <a class="btn btn-success btn-rounded btn-sm" onclick="$.table.exportExcel($('form').attr('id'))"><i class="fa fa-download"></i>&nbsp;下载</a></li>
						</ul>
					</div>
				</form>
			</div>

			<div class="btn-group hidden-xs" id="toolbar" role="group">
				<a class="btn btn-outline btn-success btn-rounded" onclick="$.operate.add()"> <i class="fa fa-plus"></i> 新增
				</a> <a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()"> <i class="fa fa-trash-o"></i> 删除
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
			url : ctx + "/DataServlet?method=dictData&type=sys_normal_disable",
			method : "POST",
			dataType : "json",
			success : function(data) {
				var html = "";
				$(data).each(function(i, item) {
					html += '<option  value="'+item.dictValue+'" name="action">' + item.dictLabel + '</option>';
				});
				$("#status").append(html);
			}
		});

		var editFlag = false;
		var listFlag = false;
		var removeFlag = false
		var prefix = ctx + "admin/dict/type"

		$(function() {
			var options = {
				url : ctx + "/DictTypeServlet?method=dictTypeList",
				createUrl : prefix + "/add.jsp",
				updateUrl : ctx + "/DictTypeServlet?method=to_dictTypeUpdate",
				removeUrl : ctx + "/DictTypeServlet?method=dictTypeRemove",
				exportUrl : prefix + "/export",
				sortName : "createTime",
				sortOrder : "desc",
				modalName : "类型",
				search : false,
				showExport : false,
				columns : [ {
					checkbox : true
				}, {
					field : 'dictId',
					title : '字典主键'
				}, {
					field : 'dictName',
					title : '字典名称'
				}, {
					field : 'dictType',
					title : '字典类型',
					formatter : function(value, row, index) {
						return '<a href="#" onclick="detail(\'' + row.dictId + '\')">' + value + '</a>';
					}
				}, {
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
				}, {
					field : 'remark',
					title : '备注'
				}, {
					field : 'createDateTimeStr',
					title : '创建时间'
				}, {
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						var actions = [];
						actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.edit(\'' + row.dictId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
						actions.push('<a class="btn btn-info btn-xs ' + listFlag + '" href="javascript:void(0)" onclick="detail(\'' + row.dictType + '\')"><i class="fa fa-list-ul"></i>列表</a> ');
						actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.dictId + '\')"><i class="fa fa-remove"></i>删除</a>');
						return actions.join('');
					}
				} ]
			};
			$.table.init(options);
		});

		/*字典列表-详细*/
		function detail(dictType) {
			var url = ctx + "admin/dict/data/list.jsp?dictType=" + dictType
			createMenuItem(url, "字典数据");
		}

		/** 创建选项卡 */
		function createMenuItem(dataUrl, menuName) {
			dataIndex = $.common.random(1, 100), flag = true;
			if (dataUrl == undefined || $.trim(dataUrl).length == 0)
				return false;
			var topWindow = $(window.parent.document);
			// 选项卡菜单已存在

			$('.J_menuTab', topWindow).each(function() {
				if ($(this).data('id') == dataUrl) {
					 $(this).addClass("active").siblings('.J_menuTab').removeClass("active");
					flag=false
					return;
				}
			});

			// 选项卡菜单不存在
			if (flag) {
				var str = '<a href="javascript:;" class="active J_menuTab" data-id="' + dataUrl + '">' + menuName + ' <i class="fa fa-times-circle"></i></a>';
				$('.J_menuTab', topWindow).removeClass('active');

				// 添加选项卡对应的iframe
				var str1 = '<iframe class="J_iframe" name="iframe' + dataIndex + '" width="100%" height="100%" src="' + dataUrl + '" frameborder="0" data-id="' + dataUrl + '" seamless></iframe>';
				$('.J_mainContent', topWindow).find('iframe.J_iframe').hide().parents('.J_mainContent').append(str1);
				// 添加选项卡
				//$('.menuTabs .page-tabs-content', topWindow).append(str);
				$('.J_menuTabs .page-tabs-content', topWindow).append(str);
			}
		}
	</script>
</body>
</html>