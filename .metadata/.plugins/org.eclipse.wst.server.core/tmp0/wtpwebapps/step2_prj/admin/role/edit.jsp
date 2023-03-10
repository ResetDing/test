<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh" >
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp"/>
<link href="js/plugins/jquery-ztree/3.5/css/metro/zTreeStyle.css" rel="stylesheet"/>
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-role-edit" >
			<input id="roleId" name="roleId" type="hidden" value=${role.roleId } />
			<div class="form-group">
				<label class="col-sm-3 control-label ">角色名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleName" id="roleName"  value="${role.roleName}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限字符：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleKey" id="roleKey"  value="${role.roleName}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示顺序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleSort" id="roleSort" value="${role.roleSort}" >
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<div class="onoffswitch">
                        <c:choose>
							<c:when test="${role.status == 0}">
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
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<input id="remark" name="remark" class="form-control" type="text" value="${role.remark}" >
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单权限</label>
				<div class="col-sm-8">
					<div id="menuTrees" class="ztree"></div>
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
	<script src="js/plugins/jquery-ztree/3.5/js/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript">
		// 树结构初始化加载
		var setting = {
			check:{enable:true,nocheckInherit:true,chkboxType:{"Y":"ps","N":"ps"}},
			view:{selectedMulti:false,nameIsHTML: true},
			data:{simpleData:{enable:true},key:{title:"title"}},
			callback:{
				beforeClick: function (treeId, treeNode, clickFlag) {
					var menuTrees = $.fn.zTree.getZTreeObj(treeId);
					menuTrees.checkNode(treeNode, !treeNode.checked, true, true);
					return false;
				}
			}
		}, menuTrees, loadTree = function(){
			$.getJSON(ctx + "/MenuServlet?method=zTree&roleId=" + $("#roleId").val(), function(data) {
				menuTrees = $.fn.zTree.init($("#menuTrees"), setting, data); //.expandAll(true);
			}, null, null, "正在加载，请稍后...");
		};loadTree();
	
		$("#form-role-edit").validate({
			/* rules:{
				roleName:{
					required:true,
					remote: {
		                url: ctx + "json/menuData.json",
		                type: "post",
		                dataType: "json",
		                data: {
							"roleId": function() {
							    return $("input[name='roleId']").val();
							},
							"roleName": function() {
							    return $("input[name='roleName']").val();
							}
		                },
		                dataFilter: function(data, type) {
		                    if (data == "0") return true;
		                    else return false;
		                }
		            }
				},
				roleKey:{
					required:true,
				},
				roleSort:{
					required:true,
					digits:true
				},
			},
			messages: {
		        "roleName": {
		            remote: "角色已经存在"
		        }
		    }, */
			submitHandler:function(form){
				edit();
			}
		});
	
		function selectCheckeds() {
		    var menuIds = "";
		    var treeNodes = menuTrees.getCheckedNodes(true);
		    for (var i = 0; i < treeNodes.length; i++) {
		        if (0 == i) {
		        	menuIds = treeNodes[i].id;
		        } else {
		        	menuIds += ("," + treeNodes[i].id);
		        }
		    }
		    return menuIds;
		}
	
		function edit() {
			var roleId = $("input[name='roleId']").val();
			var roleName = $("input[name='roleName']").val();
			var roleKey = $("input[name='roleKey']").val();
			var roleSort = $("input[name='roleSort']").val();
			var status = $("input[name='status']").is(':checked') == true ? 0 : 1;
			var remark = $("input[name='remark']").val();
			var menuIds = selectCheckeds();
			$.ajax({
				cache : true,
				type : "POST",
				url : ctx + "RoleServlet?method=roleUpdate",
				dataType:"json",
				data : {
					"roleId": roleId,
					"roleName": roleName,
					"roleKey": roleKey,
					"roleSort": roleSort,
					"status": status,
					"remark": remark,
					"menuIds": menuIds
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
	</script>
</body>
</html>
