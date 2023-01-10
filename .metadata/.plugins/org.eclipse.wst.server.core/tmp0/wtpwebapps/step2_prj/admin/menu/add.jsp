<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="css/plugins/iCheck/custom.css" rel="stylesheet" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-menu-add">
			<input id="treeId" name="parentId" type="hidden" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">上级菜单：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" onclick="selectMenuTree()" id="treeName" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单类型：</label>
				<div class="col-sm-8">
					<label class="checkbox-inline i-checks"> <input type="radio" name="menuType" value="M" /> 目录
					</label> <label class="checkbox-inline i-checks"> <input type="radio" name="menuType" value="C" /> 菜单
					</label> <label class="checkbox-inline i-checks"> <input type="radio" name="menuType" value="F" /> 按钮
					</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="menuName" id="menuName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">请求地址：</label>
				<div class="col-sm-8">
					<input id="url" name="url" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限标识：</label>
				<div class="col-sm-8">
					<input id="perms" name="perms" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="orderNum">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">图标：</label>
				<div class="col-sm-8">
					<input id="icon" name="icon" class="form-control" type="text" placeholder="选择图标">
					<div class="ms-parent" style="width: 100%;">
						<div class="icon-drop animated flipInX" style="display: none; max-height: 200px; overflow-y: auto">
							<jsp:include page="/admin/menu/icon.jsp" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单状态：</label>
				<div class="col-sm-8" id="ms">
						
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
		$.ajax({
			url:ctx+"/DataServlet?method=menuDictData",
			method:"POST",
			dataType:"json",
			success:function(data){
				var html="";
				$(data).each(function(i,item){
				html+="<div  class='"+item.cssClass+"'>";
				html+="<input type='radio' id='"+item.dictCode+"' name='visible' value='"+item.dictValue+"'";
				if(item.isDefault=='Y')
					html+="checked";
				html+=">";
				html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
					
				});
				$("#ms").html(html);
				
				
			}
		});	
	
		var prefix = ctx + "admin/menu"
		$("#form-menu-add").validate({
			/* rules : {
				menuName : {
					required : true,
					remote : {
						url : prefix + "/checkMenuNameUnique",
						type : "post",
						dataType : "json",
						data : {
							"menuName" : function() {
								return $.trim($("#menuName").val());
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
				$.operate.save(ctx + "/MenuServlet?method=menuAdd", $('#form-menu-add').serialize());
			}
		});

		$(function() {
			$("input[name='icon']").focus(function() {
				$(".icon-drop").show();
			});
			$("#form-menu-add").click(function(event) {
				var obj = event.srcElement || event.target;
				if (!$(obj).is("input[name='icon']")) {
					$(".icon-drop").hide();
				}
			});
			$(".icon-drop").find(".ico-list i").on("click", function() {
				$('#icon').val($(this).attr('class'));
			});
			$('input').on('click', function(event) {
				var menuType = $(event.target).val();
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
			});
		});

		/*菜单管理-新增-选择菜单树*/
		function selectMenuTree() {
			var menuId = $("#treeId").val();
			if (menuId > 0) {
				var url = prefix + "/tree.jsp";
				$.modal.open("选择菜单", url, '380', '380');
			} else {
				var url = prefix + "/tree.jsp";
				$.modal.open("选择菜单", url, '380', '380');
			}
		}
	</script>
</body>
</html>
