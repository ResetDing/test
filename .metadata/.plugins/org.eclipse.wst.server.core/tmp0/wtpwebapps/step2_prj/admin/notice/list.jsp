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
								公告标题：<input type="text" name="noticeTitle"/>
							</li>
							<li>
								操作人员：<input type="text" name="createBy"/>
							</li>
							<li>
								公告类型：<select name="noticeType" id="noticeType" >
									<option value="">所有</option>
									<option ></option>
								</select>
							</li>
							<li>
								<a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search($('form').attr('id'))"><i class="fa fa-search"></i>&nbsp;搜索</a>
							</li>
						</ul>
					</div>
				</form>
			</div>
			
	        <div class="btn-group hidden-xs" id="toolbar" role="group">
		        <a class="btn btn-outline btn-success btn-rounded" onclick="$.operate.addFull()">
		            <i class="fa fa-plus"></i> 新增
		        </a>
		        <a class="btn btn-outline btn-danger btn-rounded" onclick="$.operate.batRemove()" s>
		            <i class="fa fa-trash-o"></i> 删除
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
		url : ctx + "/DataServlet?method=dictData&type=sys_notice_type",
		method : "POST",
		dataType : "json",
		success : function(data) {
			var html = "";
			$(data).each(function(i, item) {
				html += '<option  value="'+item.dictValue+'" name="action">' + item.dictLabel + '</option>';
			});
			$("#noticeType").append(html);
		}
	});
    
        var editFlag = false;
        var removeFlag = false;
        var prefix = ctx + "admin/notice"

        $(function() {
            var options = {
                url: ctx+"/NoticeServlet?method=noticeList",
                createUrl: prefix + "/add.jsp",
                updateUrl:  ctx+"/NoticeServlet?method=to_noticUpdate",
                removeUrl: ctx+"/NoticeServlet?method=noticRemove",
                modalName: "公告",
                search: false,
                columns: [{
		            checkbox: true
		        },
				{
					field : 'noticeId', 
					title : '序号' 
				},
				{
					field : 'noticeTitle', 
					title : '公告标题' 
				},
				{
		            field: 'noticeType',
		            title: '公告类型',
		            align: 'center',
		            formatter: function(value, row, index) {
		                if (value == '1') {
		                	return '<span class="label label-warning">通知</span>';
		                } else if (value == '2') {
		                    return '<span class="badge badge-success">公告</span>';
		                }
		            }
		        },
				{
		            field: 'status',
		            title: '状态',
		            align: 'center',
		            formatter: function(value, row, index) {
		                if (value == '0') {
		                    return '<span class="badge badge-primary">正常</span>';
		                } else if (value == '1') {
		                    return '<span class="badge badge-danger">关闭</span>';
		                }
		            }
		        },
				{
					field : 'createBy', 
					title : '创建者' 
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
		            	actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.editFull(\'' + row.noticeId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                        actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.noticeId + '\')"><i class="fa fa-remove"></i>删除</a>');
						return actions.join('');
		            }
		        }]
            };
            $.table.init(options);
        });
    </script>
</body>
</html>