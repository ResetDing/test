<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-dict-add">
			<div class="form-group">
				<label class="col-sm-3 control-label ">字典名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictName" id="dictName"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">字典类型：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictType" id="dictType">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8" id="status" >
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
	
	$.ajax({
		url:ctx+"/DataServlet?method=dictData&type=sys_normal_disable",
		method:"POST",
		dataType:"json",
		success:function(data){
			var html="";
			$(data).each(function(i,item){
			html+="<div  class='"+item.cssClass+"'>";
			html+="<input type='radio' id='"+item.dictCode+"' name='status' value='"+item.dictValue+"'>";
			html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
			});
			$("#status").html(html);
			
			
		}
	});	
	
		var prefix = ctx + "admin/dict"
	
		$("#form-dict-add").validate({
			/* rules:{
				dictName:{
					required:true,
				},
				dictType:{
					required:true,
					minlength: 5,
					remote: {
		                url: '',
		                type: "post",
		                dataType: "json",
		                data: {
		                	name : function() {
		                        return $.trim($("#dictType").val());
		                    }
		                },
		                dataFilter: function(data, type) {
		                    if (data == "0") return true;
		                    else return false;
		                }
		            }
				},
			},
			messages: {
		        "dictType": {
		            remote: "该字典类型已经存在"
		        }
		    }, */
			submitHandler:function(form){
				$.operate.save(ctx + "/DictTypeServlet?method=dictTypeAdd", $('#form-dict-add').serialize());
			}
		});
	</script>
</body>
</html>
