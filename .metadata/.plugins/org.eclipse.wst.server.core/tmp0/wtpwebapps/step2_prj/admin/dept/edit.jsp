<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh" >
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp"/>
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-dept-edit" >
			<input name="deptId" type="hidden"  value="${dept.deptId }"/>
			<input id="treeId" name="parentId" type="hidden" value="${dept.parentId }"/>
			<div class="form-group">
				<label class="col-sm-3 control-label ">上级部门：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="treeName" value="${dept.parentName }" onclick="selectDeptTree()" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="deptName" value="${dept.deptName }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="orderNum" value="${dept.orderNum }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">负责人：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="leader" value="${dept.leader }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">联系电话：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="phone" value="${dept.phone }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">邮箱：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="email" value="${dept.email }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门状态：</label>
				<div class="col-sm-8" >
					<c:forEach var="item" items="${dictDatas}">
						<div class="${item.cssClass}">
								${item.dictLabel}
							<c:choose>
								<c:when test="${dept.status==item.dictValue }">
									<input type="radio" id="${item.dictCode}" name="status" value="${item.dictValue}" checked="checked"> 
								</c:when>
								<c:otherwise>
									<input type="radio" id="${item.dictCode}" name="status" value="${item.dictValue}" > 
								</c:otherwise>
							</c:choose>
							
							<label for="${item.dictCode}" >
								${item.dictLabel}
							</label>
						</div>
					</c:forEach>
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
		var prefix = ctx + "system/dept"
	
		$("#form-dept-edit").validate({
			/* rules:{
				deptName:{
					required:true,
					remote: {
		                url: prefix + "/checkDeptNameUnique",
		                type: "post",
		                dataType: "json",
		                data: {
		                	"deptId": function() {
		                        return $("input[name='deptId']").val();
		                    },
		        			"deptName": function() {
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
				$.operate.save(ctx + "/DeptServlet?method=deptUpdate", $('#form-dept-edit').serialize());
			}
		});
	
		/*部门管理-修改-选择部门树*/
		function selectDeptTree() {
			var deptId = $("#treeId").val();
		    var url = ctx + "/admin/dept/tree.jsp";
		    $.modal.open("选择部门", url, '380', '380');
		}
	</script>
</body>
</html>
