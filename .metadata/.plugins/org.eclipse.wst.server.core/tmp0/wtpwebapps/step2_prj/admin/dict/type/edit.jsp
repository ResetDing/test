<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-dict-edit" >
			<input id="dictId" name="dictId"  type="hidden" value="${dictType.dictId }" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">字典名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictName" id="dictName" value="${dictType.dictName }" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">字典类型：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="dictType" id="dictType" value="${dictType.dictType }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8" >
					<c:forEach var="item" items="${status}">
						<div class="${item.cssClass}">
							<c:choose>
								<c:when test="${dictType.status==item.dictValue }">
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
					<input id="remark" name="remark" class="form-control" type="text" value="${dictType.remark }">
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
		var prefix = ctx + "system/dict"
	
		$("#form-dict-edit").validate({
			/* rules:{
				dictName:{
					required:true,
				},
				dictType:{
					required:true,
					minlength: 5,
					remote: {
		                url: prefix + "/checkDictTypeUnique",
		                type: "post",
		                dataType: "json",
		                data: {
		                	dictId : function() {
		                        return $.trim($("#dictId").val());
		                    },
		                	dictType : function() {
		                        return $.trim($("#dictType").val());
		                    }
		                },
		                dataFilter: function(data, type) {
		                    if (data == "0") return true;
		                    else return false;
		                }
		            }
				},
			},
			messages: {
		        "dictType": {
		            remote: "该字典类型已经存在"
		        }
		    }, */
			submitHandler:function(form){
				$.operate.save(ctx + "/DictTypeServlet?method=dictUpdate", $('#form-dict-edit').serialize());
			}
		});
	</script>
</body>
</html>
