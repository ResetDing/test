<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m-t" id="signupForm">
			<div class="form-group">
				<label class="col-sm-2 control-label">操作模块：</label>
				<div class="form-control-static">${operLog.title}/${operLog.action}</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">登录信息：</label>
				<div class="form-control-static">${operLog.operName}/${operLog.deptName}/${operLog.operIp}/${operLog.operLocation}</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">请求地址：</label>
				<div class="form-control-static">${operLog.operUrl}</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">操作方法：</label>
				<div class="form-control-static">${operLog.method}</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">请求参数：</label>
				<div class="form-control-static">${operLog.operParam}</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">状态：</label>
				<c:choose>
					<c:when test="${operLog.status == 0}">
						<div class="label label-primary">正常</div>
					</c:when>
					<c:otherwise>
						<div class="label label-danger">异常</div>
					</c:otherwise>
				</c:choose>
			</div>
			<c:choose>
				<c:when test="${operLog.status == 0}">
					<div class="form-group" style="display: none">
						<label class="col-sm-2 control-label">异常信息：</label>
						<div class="form-control-static">${operLog.errorMsg}</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="form-group" style="display: block">
						<label class="col-sm-2 control-label">异常信息：</label>
						<div class="form-control-static">${operLog.errorMsg}</div>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="form-group">
				<div class="form-control-static col-sm-offset-9">
					<button onclick="$.modal.close()" class="btn btn-danger" type="button">关闭</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/admin/footer.jsp" />
</body>
</html>