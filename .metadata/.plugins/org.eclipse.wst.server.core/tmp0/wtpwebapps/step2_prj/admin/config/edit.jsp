<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-config-edit" >
			<input id="configId" name="configId" value="${config.configId}" type="hidden">
			<div class="form-group">
				<label class="col-sm-3 control-label">参数名称：</label>
				<div class="col-sm-8">
					<input id="configName" name="configName"   value="${config.configName}"class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">参数键名：</label>
				<div class="col-sm-8">
					<input id="configKey" name="configKey" value="${config.configKey}"  class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">参数键值：</label>
				<div class="col-sm-8">
					<input id="configValue" name="configValue" value="${config.configValue}"   class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">系统内置：${config.configType}</label>
				<div class="col-sm-8" >
					<c:forEach var="item" items="${dictDatas}">
						<div class="${item.cssClass}">
								${item.dictLabel}
							<c:choose>
								<c:when test="${config.configType==item.dictValue }">
									<input type="radio" id="${item.dictCode}" name="configType" value="${item.dictValue}" checked="checked"> 
								</c:when>
								<c:otherwise>
									<input type="radio" id="${item.dictCode}" name="configType" value="${item.dictValue}" > 
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
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<textarea id="remark" name="remark" class="form-control">${config.remark }</textarea>
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
		var prefix = ctx + "admin/config";

		$("#form-config-edit").validate(
				{
					/* rules : {
						configKey : {
							required : true,
							remote : {
								url : ctx + "/ConfigServlet?method=configUpdate",
								type : "post",
								dataType : "json",
								data : {
									"configId" : function() {
										return $("input[name='configId']")
												.val();
									},
									"configKey" : function() {
										return $("input[name='configKey']")
												.val();
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
						configName : {
							required : true
						},
						configValue : {
							required : true
						},
					},
					messages : {
						"configKey" : {
							remote : "参数键名已经存在"
						}
					}, */
					submitHandler : function(form) {
						$.operate.save( ctx + "/ConfigServlet?method=update", $('#form-config-edit')
								.serialize());
					}
				});
	</script>
</body>
</html>
