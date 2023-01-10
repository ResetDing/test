<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="css/plugins/summernote/summernote.css" rel="stylesheet" />
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-notice-edit">
			<input id="noticeId" name="noticeId" type="hidden" value="${notice.noticeId}">
			<div class="form-group">
				<label class="col-sm-3 control-label">公告标题：</label>
				<div class="col-sm-8">
					<input id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle}" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公告类型：</label>
				<div class="col-sm-8">
					<select name="noticeType" id="noticeType" class="form-control m-b">
						<c:forEach var="item" items="${type}">
							<c:choose>
								<c:when test="${notice.noticeType==item.dictValue}">
									<option value="${item.dictValue}" selected="selected">${item.dictLabel}</option>
								</c:when>
								<c:otherwise>
									<option value="${item.dictValue}">${item.dictLabel}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公告内容：</label>
				<div class="col-sm-8">
					<input id="noticeContent" name="noticeContent" type="hidden" value="${notice.noticeContent}">
					<div id="editor" class="summernote"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公告状态：</label>
				<div class="col-sm-8" id="status">
					<c:forEach var="item" items="${status }">
						<div class="${item.cssClass}">
							<c:choose>
								<c:when test="${notice.status==item.dictValue }">
									<input type="radio" id="${item.dictCode}" name="status" value="${item.dictValue}" checked="checked">
								</c:when>
								<c:otherwise>
									<input type="radio" id="${item.dictCode}" name="status" value="${item.dictValue}">
								</c:otherwise>
							</c:choose>

							<label for="${item.dictCode}"> ${item.dictLabel} </label>
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
	<script src="js/plugins/summernote/summernote.min.js"></script>
	<script src="js/plugins/summernote/summernote-zh-CN.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.summernote').summernote({
				height : '220px',
				lang : 'zh-CN'
			});
			var content = $("#noticeContent").val();
			$('#editor').code(content);
		});

		var prefix = ctx + "system/notice"
		$("#form-notice-edit").validate({
			rules : {
				xxxx : {
					required : true,
				},
			},
			submitHandler : function(form) {
				var sHTML = $('.summernote').code();
				$("#noticeContent").val(sHTML);
				$.operate.save(ctx + "/NoticeServlet?method=postUpdate", $('#form-notice-edit').serialize());
			}
		});
	</script>
</body>
</html>
