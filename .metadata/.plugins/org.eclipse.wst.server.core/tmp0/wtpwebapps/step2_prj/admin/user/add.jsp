<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="css/plugins/iCheck/custom.css" rel="stylesheet" />
<link href="css/plugins/select/select2.css" rel="stylesheet" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-user-add">
			<input name="deptId" type="hidden" id="treeId" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">登录名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="loginName" name="loginName" value="aa"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="deptName" onclick="selectDeptTree()" readonly="true" id="treeName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">用户名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="userName" id="userName" value="aa">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">密码：</label>
				<div class="col-sm-8">
					<input class="form-control" type="password" name="password" id="password" value="aaaaa">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">邮箱：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="email" id="email" value="aa@aa.com">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">手机：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="phonenumber" id="phonenumber" value="15205170015">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">性别：</label>
				<div class="col-sm-8">
					<select id="sex" class="form-control m-b">
						<c:forEach var="gender" items="${genderDatas}">
							<option value="${gender.dictValue }">${gender.dictLabel }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<div class="onoffswitch">
						<input type="checkbox" th:checked="true" class="onoffswitch-checkbox" id="status" name="status"> <label class="onoffswitch-label" for="status"> <span class="onoffswitch-inner"></span> <span class="onoffswitch-switch"></span>
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">岗位：</label>
				<div class="col-sm-8">
					<select class="form-control js-example-basic-multiple" id="post" name="post" multiple="multiple">
						<c:forEach var="post" items="${posts }">
							<option value="${post.postId}">${post.postName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">角色：</label>
				<div class="col-sm-8">
					<c:forEach var="role" items="${roles }">
						<label class="checkbox-inline i-checks"> <input name="role" type="checkbox" value="${role.roleId}">${role.roleName}
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
		$("#form-user-add").validate({
			rules : {
				loginName : {
					required : true,
					minlength : 2,
					maxlength : 20,
					remote : {
						url : ctx + "/UserServlet?method=checkLoginNameUnique",
						type : "post",
						dataType : "json",
						data : {
							name : function() {
								return $.trim($("#loginName").val());
							}
						},
						dataFilter : function(data, type) {
							if (data == 0)
								return true;
							else
								return false;
						}
					}
				},
				userName : {
					required : true,
				},
				deptName : {
					required : true,
				},
				password : {
					required : true,
					minlength : 5,
					maxlength : 20
				},
				email : {
					required : true,
					email : true,
					remote : {
						url : ctx + "/UserServlet?method=checkEmailUnique",
						type : "post",
						dataType : "json",
						data : {
							name : function() {
								return $.trim($("#email").val());
							}
						},
						dataFilter : function(data, type) {
							if (data == 0)
								return true;
							else
								return false;
						}
					}
				},
				phonenumber : {
					required : true,
					isPhone : true,
					remote : {
						url : ctx + "/UserServlet?method=checkPhoneUnique",
						type : "post",
						dataType : "json",
						data : {
							name : function() {
								return $.trim($("#phonenumber").val());
							}
						},
						dataFilter : function(data, type) {
							if (data == 0)
								return true;
							else
								return false;
						}
					}
				},
			},
			messages : {
				"loginName" : {
					remote : "用户已经存在"
				},
				"email" : {
					remote : "Email已经存在"
				},
				"phonenumber" : {
					remote : "手机号码已经存在"
				}
			},
			submitHandler : function(form) {
				add();
			}
		});

		function add() {
			//var userId = $("input[name='userId']").val();
			var deptId = $("input[name='deptId']").val();
			var loginName = $("input[name='loginName']").val();
			var userName = $("input[name='userName']").val();
			var password = $("input[name='password']").val();
			var email = $("input[name='email']").val();
			var phonenumber = $("input[name='phonenumber']").val();
			var sex = $("#sex option:selected").val();
			var status = $("input[name='status']").is(':checked') == true ? 0 : 1;
			var roleIds = $.form.selectCheckeds("role");
			var postIds = $.form.selectSelects("post");
			 $.ajax({
				cache : true,
				type : "POST",
				url : ctx + "UserServlet?method=userAdd",
				dataType:"json",
				data : {
					//"userId" : userId,
					"deptId" : deptId,
					"loginName" : loginName,
					"userName" : userName,
					"password" : password,
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

		/*用户管理-新增-选择部门树*/
		function selectDeptTree() {
			var treeId = $("#treeId").val();
			var deptId = treeId == null || treeId == "" ? "100" : treeId;
			var url = ctx + "admin/dept/tree.jsp";
			$.modal.open("选择部门", url, '380', '380');
		}
	</script>
</body>
</html>
