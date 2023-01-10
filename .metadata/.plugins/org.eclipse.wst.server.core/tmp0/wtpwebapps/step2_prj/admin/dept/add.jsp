<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-dept-add">
			<input id="treeId" name="parentId" type="hidden"   />
			<div class="form-group">
				<label class="col-sm-3 control-label ">上级部门：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" onclick="selectDeptTree()" id="treeName" readonly="true""/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="deptName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="orderNum">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">负责人：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="leader">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">联系电话：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="phone">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">邮箱：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门状态：</label>
				<div class="col-sm-8" id="status">
					
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
		url:ctx+"/DataServlet?method=dictData&dictType=sys_normal_disable",
		method:"POST",
		dataType:"json",
		success:function(res){
			var html="";
			$(res.data).each(function(i,item){
			html+="<div  class='"+item.cssClass+"'>";
			html+="<input type='radio' id='"+item.dictCode+"' name='status' value='"+item.dictValue+"'>";
			html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
			});
			$("#status").html(html);
			
			
		}
	});	
	
		var prefix = ctx + "admin/dept"
	
		$("#form-dept-add").validate({
			/* rules:{
				deptName:{
					required:true,
					remote: {
		                url: prefix + "/checkDeptNameUnique",
		                type: "post",
		                dataType: "json",
		                data: {
		                	"deptName" : function() {
		                        return $("input[name='deptName']").val();
		                    }
		                },
		                dataFilter: function(data, type) {
		                    if (data == "0") return true;
		                    else return false;
		                }
		            }
				},
				orderNum:{
					required:true,
					digits:true
				},
			},
			messages: {
		        "deptName": {
		            remote: "部门已经存在"
		        }
		    }, */
			submitHandler:function(form){
				$.operate.save(ctx + "/DeptServlet?method=deptAdd", $('#form-dept-add').serialize());
			}
		});
	
		/*部门管理-新增-选择父部门树*/
		function selectDeptTree() {
		    var deptId = $("#treeId").val();
			var url = prefix + "/tree.jsp";
			$.modal.open("选择部门", url, '380', '380');
		}
	</script>
</body>
</html>
