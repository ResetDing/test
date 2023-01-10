<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="css/plugins/summernote/summernote.css" rel="stylesheet"/>
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet"/>
<body class="white-bg">
    <div class="wrapper wrapper-content animated fadeInRight ibox-content">
        <form class="form-horizontal m" id="form-notice-add">
			<div class="form-group">	
				<label class="col-sm-3 control-label">公告标题：</label>
				<div class="col-sm-8">
					<input id="noticeTitle" name="noticeTitle" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公告类型：</label>
				<div class="col-sm-8">
					<select name="noticeType" id="noticeType" class="form-control m-b">
	                </select>
				</div>
			</div>
			<div class="form-group">	
				<label class="col-sm-3 control-label">公告内容：</label>
				<div class="col-sm-8">
				    <input id="noticeContent" name="noticeContent" type="hidden">
				    <div class="summernote"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">公告状态：</label>
				<div class="col-sm-8" id="status">
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
    
    $.ajax({
		url : ctx + "/DataServlet?method=dictData&type=sys_notice_type",
		method : "POST",
		dataType : "json",
		success : function(data) {
			var html = "";
			$(data).each(function(i, item) {
				html += '<option  value="'+item.dictValue+'" name="noticeType">' + item.dictLabel + '</option>';
			});
			$("#noticeType").append(html);
		}
	});
    
    $.ajax({
		url : ctx + "/DataServlet?method=dictData&type=sys_notice_status",
		method : "POST",
		dataType : "json",
		success : function(data) {
			var html="";
			$(data).each(function(i,item){
			html+="<div  class='"+item.cssClass+"'>";
			html+="<input type='radio' id='"+item.dictCode+"' name='status' value='"+item.dictValue+"'>";
			html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
			});
			$("#status").append(html);
		}
	});
    
	    $('.summernote').summernote({
			height : '220px',
			lang : 'zh-CN'
		});
	    
		var prefix = ctx + "system/notice"
		$("#form-notice-add").validate({
			rules:{
				noticeTitle:{
					required:true,
				}
			},
			submitHandler: function(form) {
				var sHTML = $('.summernote').code();
				$("#noticeContent").val(sHTML);
				$.operate.save(ctx + "/NoticeServlet?method=noticeAdd", $('#form-notice-add').serialize());
			}
		});
	</script>
</body>
</html>
