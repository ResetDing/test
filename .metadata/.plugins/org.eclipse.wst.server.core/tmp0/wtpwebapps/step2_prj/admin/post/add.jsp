<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-post-add">
			<div class="form-group">
				<label class="col-sm-3 control-label ">岗位编码：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="postCode" id="postCode"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">岗位名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="postName" id="postName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示顺序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="postSort" id="postSort">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">岗位状态：</label>
				<div class="col-sm-8" id="gw">
				</div>
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
		var prefix = ctx + "admin/post"
		
		$.ajax({
			url:ctx+"/DataServlet?method=dictData&dictType=sys_job_status",
			method:"POST",
			dataType:"json",
			success:function(res){
				var html="";
				$(res.data).each(function(i,item){
				html+="<div  class='"+item.cssClass+"'>";
				html+="<input type='radio' id='"+item.dictCode+"' name='status' value='"+item.dictValue+"'>";
				html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
				});
				$("#gw").html(html);
				
				
			}
		});	
	
		$("#form-post-add").validate({
			rules:{
				postCode:{
					required:true,
				},
				postName:{
					required:true,
				},
				postSort:{
					required:true,
					digits:true
				},
			},
			submitHandler:function(form){
				$.operate.save(ctx + "/PostServlet?method=postAdd", $('#form-post-add').serialize());
			}
		});
		
		
	</script>
</body>
</html>
