<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="css/plugins/iCheck/custom.css" rel="stylesheet" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-menu-edit">
			<input name="menuId" type="hidden" value="${menu.menuId}" /> <input id="treeId" name="parentId" type="hidden" value="${menu.parentId}" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">上级菜单：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" value="${menu.parentName }" onclick="selectMenuTree()" id="treeName" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单类型：</label>
				<div class="col-sm-8">
					<label class="checkbox-inline i-checks"> <c:choose>
							<c:when test="${menu.menuType=='M'}">
								<input type="radio" name="menuType" value="M" checked="checked" />
							</c:when>
							<c:otherwise>
								<input type="radio" name="menuType" value="M" />
							</c:otherwise>
						</c:choose> 目录
					</label> <label class="checkbox-inline i-checks"> <c:choose>
							<c:when test="${menu.menuType=='C'}">
								<input type="radio" name="menuType" value="C" checked="checked" />
							</c:when>
							<c:otherwise>
								<input type="radio" name="menuType" value="C" />
							</c:otherwise>
						</c:choose> 菜单
					</label> <label class="checkbox-inline i-checks"> <c:choose>
							<c:when test="${menu.menuType=='F'}">
								<input type="radio" name="menuType" value="F" checked="checked" />
							</c:when>
							<c:otherwise>
								<input type="radio" name="menuType" value="F" />
							</c:otherwise>
						</c:choose> 按钮
					</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="menuName" id="menuName" value="${menu.menuName}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">请求地址：</label>
				<div class="col-sm-8">
					<input id="url" name="url" class="form-control" type="text" value="${menu.url}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限标识：</label>
				<div class="col-sm-8">
					<input id="perms" name="perms" class="form-control" type="text" value="${menu.perms}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="orderNum" value="${menu.orderNum}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">图标：</label>
				<div class="col-sm-8">
					<input id="icon" name="icon" class="form-control" type="text" placeholder="选择图标" value="${menu.icon}">
					<div class="ms-parent" style="width: 100%;">
						<div class="icon-drop animated flipInX" style="display: none; max-height: 200px; overflow-y: auto">
							<jsp:include page="/admin/menu/icon.jsp" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单状态：</label>
				<div class="col-sm-8">
					<c:forEach var="item" items="${dictDatas }">
						<div class="${item.cssClass}"> 
							<c:choose>
								<c:when test="${menu.visible==item.dictValue }">
									<input type="radio" id="${item.dictCode}" name="visible" value="${item.dictValue}" checked="checked"> 
								</c:when>
								<c:otherwise>
									<input type="radio" id="${item.dictCode}" name="visible" value="${item.dictValue}" > 
								</c:otherwise>
							</c:choose>
							
							<label for="${item.dictCode}">${item.dictLabel}</label>
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
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script>
		var prefix = ctx + "admin/menu"

		$(document).ready(function() {
			var menuType = $('input[name="menuType"]:checked').val();
			menuVisible(menuType);
		});

		$("#form-menu-edit").validate({
			/* rules : {
				menuName : {
					required : true,
					remote : {
						url : prefix + "/checkMenuNameUnique",
						type : "post",
						dataType : "json",
						data : {
							"menuId" : function() {
								return $("input[name='menuId']").val();
							},
							"menuName" : function() {
								return $("input[name='menuName']").val();
							}
						},
						dataFilter : function(data, type) {
							if (data == "0")
								return true;
							else
								return false;
						}
					}
				},
				orderNum : {
					required : true,
					digits : true
				},
			},
			messages : {
				"menuName" : {
					remote : "菜单已经存在"
				}
			}, */
			submitHandler : function(form) {
				$.operate.save(ctx + "/MenuServlet?method=menuUpdate", $('#form-menu-edit').serialize());
			}
		});

		$(function() {
			$("input[name='icon']").focus(function() {
				$(".icon-drop").show();
			});
			$("#form-menu-edit").click(function(event) {
				var obj = event.srcElement || event.target;
				if (!$(obj).is("input[name='icon']")) {
					$(".icon-drop").hide();
				}
			});
			$(".icon-drop").find(".ico-list i").on("click", function() {
				$('#icon').val($(this).attr('class'));
			});
			$('input').on('ifChecked', function(event) {
				var menuType = $(event.target).val();
				menuVisible(menuType);
			});
		});

		function menuVisible(menuType) {
			if (menuType == "M") {
				$("#url").parents(".form-group").hide();
				$("#perms").parents(".form-group").hide();
				$("#icon").parents(".form-group").show();
			} else if (menuType == "C") {
				$("#url").parents(".form-group").show();
				$("#perms").parents(".form-group").show();
				$("#icon").parents(".form-group").hide();
			} else if (menuType == "F") {
				$("#url").parents(".form-group").hide();
				$("#perms").parents(".form-group").show();
				$("#icon").parents(".form-group").hide();
			}
		}

		/*菜单管理-修改-选择菜单树*/
		function selectMenuTree() {
			var menuId = $("#treeId").val();
			if (menuId > 0) {
				var url = ctx + "/admin/menu/tree.jsp";
				$.modal.open("选择菜单", url, '380', '380');
			} else {
				$.modal.alertError("主菜单不能选择");
			}
		}
	</script>
</body>
</html>
