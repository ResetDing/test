<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-dict-add">
			<div class="form-group">
				<label class="col-sm-3 control-label ">字典标签：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictLabel" id="dictLabel" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label ">字典键值：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictValue" id="dictValue" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">字典类型：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="dictType" name="dictType" readonly="true" value="${param.dictType }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">样式属性：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="cssClass" name="cssClass">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">系统默认：</label>
				<div class="col-sm-8" id="isDefault"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">字典排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictSort">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8" id="status"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<input id="remark" name="remark" class="form-control" type="text">
				</div>
			</div>

			<div class="form-group">
				<div class="form-control-static col-sm-offset-9">
					<button type="submit" class="btn btn-primary">提交</button>
					<button onclick="$.modal.close()" class="btn btn-danger" type="button">关闭</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script type="text/javascript">
	
	$.ajax({
		url:ctx+"/DataServlet?method=dictDatas",
		method:"POST",
		dataType:"json",
		success:function(data){
			var html="";
			var htmlIsDefault="";
			$(data).each(function(i,item){
				if(item.dictType=='sys_normal_disable'){
					html+="<div  class='"+item.cssClass+"'>";
					html+="<input type='radio' id='"+item.dictCode+"' name='status' value='"+item.dictValue+"'>";
					html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
				}else if(item.dictType=='sys_yes_no'){
					htmlIsDefault+="<div  class='"+item.cssClass+"'>";
					htmlIsDefault+="<input type='radio' id='"+item.dictCode+"' name='isDefault' value='"+item.dictValue+"'>";
					htmlIsDefault+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
				}
			});
			$("#status").html(html);
			$("#isDefault").html(htmlIsDefault);
			
		}
	});	

		var prefix = ctx + "admin/dict/data"

		$("#form-dict-add").validate({
			rules : {
				dictLabel : {
					required : true,
				},
				dictValue : {
					required : true,
				},
				dictSort : {
					required : true,
					digits : true
				},
			},
			submitHandler : function(form) {
				$.operate.save(ctx + "/DataServlet?method=dictDataAdd", $('#form-dict-add').serialize());
			}
		});
	</script>
</body>
</html>
