<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="css/plugins/iCheck/custom.css" rel="stylesheet" />
<link href="css/plugins/select/select2.css" rel="stylesheet" />

<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-user-edit">
			<input name="userId" type="hidden" value="${user.userId}" /> <input name="deptId" type="hidden" value="${user.deptId}" id="treeId" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">登录名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" readonly="true" name="loginName" value="${user.loginName}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门名称：</label>
				<div class="col-sm-8">
					<input class="form-control" value="${user.dept.deptName }" type="text" name="deptName" onclick="selectDeptTree()" readonly="true" id="treeName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">用户名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="userName" id="userName" value="${user.userName}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">邮箱：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="email" id="email" value="${user.email}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">手机：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="phonenumber" id="phonenumber" value="${user.phonenumber}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">性别：</label>
				<div class="col-sm-8">
					<select id="sex" class="form-control m-b">
						<c:forEach var="gender" items="${genderDatas}">
							<c:choose>
								<c:when test="${user.sex== gender.dictValue}">
									<option value="${gender.dictValue }" name="sex" selected="selected">${gender.dictLabel }</option>
								</c:when>
								<c:otherwise>
									<option value="${gender.dictValue }" name="sex">${gender.dictLabel }</option>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<div class="onoffswitch">
						<c:choose>
							<c:when test="${user.status == 0}">
								<input type="checkbox" checked="checked" class="onoffswitch-checkbox" id="status" name="status">
							</c:when>
							<c:otherwise>
								<input type="checkbox" class="onoffswitch-checkbox" id="status" name="status">
							</c:otherwise>
						</c:choose>
						<label class="onoffswitch-label" for="status"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">岗位：</label>
				<div class="col-sm-8">
					<select class="form-control js-example-basic-multiple" id="post" name="post" multiple="multiple">
						<c:forEach var="post" items="${posts }">
							<c:choose>
								<c:when test="${fn:contains(fn:join(user.postIds,','),post.postId)}">
									<option value="${post.postId}" selected="selected">${post.postName}</option>
								</c:when>
								<c:otherwise>
									<option value="${post.postId}">${post.postName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">角色：</label>
				<div class="col-sm-8">
					<c:forEach var="role" items="${roles }">
						<label class="checkbox-inline i-checks"> 
						<c:choose>
							<c:when test="${fn:contains(fn:join(user.roleIds,','),role.roleId)}">
								<input name="role" checked="checked" type="checkbox" value="${role.roleId}">${role.roleName}
							</c:when>
							<c:otherwise>
								<input name="role"  type="checkbox" value="${role.roleId}">${role.roleName}
							</c:otherwise>
						</c:choose>
						
						</label>
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
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script src="js/plugins/select2/select2.js"></script>
	<script>
		$("#post").select2();
		$("#form-user-edit").validate({
			rules : {
				userName : {
					required : true,
				},
				deptName : {
					required : true,
				},
				email : {
					required : true,
					email : true,
				},
				phonenumber : {
					required : true,
					isPhone : true,
				},
			},
			messages : {
				"email" : {
					required : "Email不能为空"
				},
				"phonenumber" : {
					required : "手机号码不能为空"
				}
			},
			submitHandler : function(form) {
				edit();
			}
		});

		function edit() {
			var userId = $("input[name='userId']").val();
			var deptId = $("input[name='deptId']").val();
			var userName = $("input[name='userName']").val();
			var email = $("input[name='email']").val();
			var phonenumber = $("input[name='phonenumber']").val();
			var sex = $("#sex option:selected").val();
			var status = $("input[name='status']").is(':checked') == true ? 0 : 1;
			var roleIds = $.form.selectCheckeds("role");
			var postIds = $.form.selectSelects("post");
			 $.ajax({
				cache : true,
				type : "POST",
				url : ctx + "UserServlet?method=userUpdate",
				dataType:"json",
				data : {
					"userId" : userId,
					"deptId" : deptId,
					"userName" : userName,
					"email" : email,
					"phonenumber" : phonenumber,
					"sex" : sex,
					"status" : status,
					"roleIds" : roleIds,
					"postIds" : postIds
				},
				async : false,
				error : function(request) {
					$.modal.alertError("系统错误");
				},
				success : function(data) {
					$.operate.saveSuccess(data);
				}
			}); 
		}

		/*用户管理-修改-选择部门树*/
		function selectDeptTree() {
			var deptId = $("#treeId").val();
			var url = ctx + "admin/dept/tree.jsp";
			$.modal.open("选择部门", url, '380', '380');
		}
	</script>
</body>
</html>
