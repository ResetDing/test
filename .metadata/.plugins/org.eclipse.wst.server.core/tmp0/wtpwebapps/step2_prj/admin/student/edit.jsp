<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
    <div class="wrapper wrapper-content animated fadeInRight ibox-content">
        <form class="form-horizontal m" id="form-student-edit" >
            <input id="stuId" name="stuId" value="${student.stuId}"  type="hidden">
            <div class="form-group">	
                <label class="col-sm-3 control-label">姓名：</label>
                <div class="col-sm-8">
                    <input id="stuName" name="stuName" value="${student.stuName}"  class="form-control" type="text">
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
		var prefix = ctx + "admin/student"
		$("#form-student-edit").validate({
			rules:{
				xxxx:{
					required:true,
				},
			},
			submitHandler: function(form) {
				$.operate.save(ctx + "/StudentServlet?method=saveOrUpdate", $('#form-student-edit').serialize());
			}
		});
	</script>
</body>
</html>
