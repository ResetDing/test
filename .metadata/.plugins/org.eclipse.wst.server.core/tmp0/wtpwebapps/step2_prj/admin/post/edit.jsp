<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh" >
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp"/>
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-post-edit" >
			<input id="postId" name="postId" type="hidden" value="${post.postId}"/>
			<div class="form-group">
				<label class="col-sm-3 control-label ">岗位编码：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="postCode" id="postCode" value="${post.postCode}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">岗位名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="postName" id="postName"  value="${post.postName}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示顺序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="postSort" id="postSort" value="${post.postSort}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">岗位状态：</label>
				<div class="col-sm-8" >
				
					<c:forEach var="item" items="${dictDatas }">
						<div class="${item.cssClass}">
							
							<c:choose>
								<c:when test="${post.status==item.dictValue }">
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
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<input id="remark" name="remark" class="form-control" type="text" value="${post.remark}">
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
		var prefix = ctx + "admin/post"
	
		$("#form-post-edit").validate({
			rules:{
				postCode:{
					required:true,
				},
				postName:{
					required:true,
				},
				postSort:{
					required:true,
					digits:true
				},
			},
			submitHandler:function(form){
				$.operate.save(ctx + "/PostServlet?method=postUpdate", $('#form-post-edit').serialize());
			}
		});
	</script>
</body>
</html>
