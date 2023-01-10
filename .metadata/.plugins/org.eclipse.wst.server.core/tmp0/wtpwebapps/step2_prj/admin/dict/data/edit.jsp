<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-dict-edit">
			<input name="dictCode" type="hidden" value="${dictData.dictCode }" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">字典标签：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictLabel" id="dictLabel" value="${dictData.dictLabel }" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label ">字典键值：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictValue" id="dictValue" value="${dictData.dictValue }" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">字典类型：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" readonly="true" name="dictType" value="${dictData.dictType}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">样式属性：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="cssClass" name="cssClass" value="${dictData.cssClass }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">系统默认：</label>
				<div class="col-sm-8">
					<c:forEach var="item" items="${dictDatas}">

						<c:if test="${item.dictType=='sys_yes_no' }">
							<div class="${item.cssClass}">
								<c:choose>
									<c:when test="${dictData.isDefault==item.dictValue }">
										<input type="radio" id="${item.dictCode}" name="isDefault" value="${item.dictValue}" checked>
									</c:when>
									<c:otherwise>
										<input type="radio" id="${item.dictCode}" name="isDefault" value="${item.dictValue}">
									</c:otherwise>
								</c:choose>

								<label for="${item.dictCode}"> ${item.dictLabel} </label>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">字典排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictSort" value="${dictData.dictSort }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<c:forEach var="item" items="${dictDatas}">
						<c:if test="${item.dictType=='sys_normal_disable'}">
							<div class="${item.cssClass}">
								<c:choose>
									<c:when test="${dictData.status==item.dictValue }">
										<input type="radio" id="${item.dictCode}" name="status" value="${item.dictValue}" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" id="${item.dictCode}" name="status" value="${item.dictValue}">
									</c:otherwise>
								</c:choose>

								<label for="${item.dictCode}"> ${item.dictLabel} </label>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<input id="remark" name="remark" class="form-control" type="text" value="${dictData.remark }">
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
		var prefix = ctx + "admin/dict/data"

		$("#form-dict-edit").validate({
			rules : {
				dictLabel : {
					required : true,
				},
				dictValue : {
					required : true,
				},
				dictSort : {
					required : true,
					digits : true
				},
			},
			submitHandler : function(form) {
				$.operate.save(ctx + "/DataServlet?method=dictUpdate", $('#form-dict-edit').serialize());
			}
		});
	</script>
</body>
</html>
