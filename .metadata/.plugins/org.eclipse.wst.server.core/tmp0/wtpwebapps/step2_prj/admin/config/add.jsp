<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<body class="white-bg">
    <div class="wrapper wrapper-content animated fadeInRight ibox-content">
        <form class="form-horizontal m" id="form-config-add" name="form-config-add">
        <div class="form-group">	
            <label class="col-sm-3 control-label">参数名称：</label>
            <div class="col-sm-8">
                <input id="configName" name="configName" class="form-control" type="text">
            </div>
        </div>
        <div class="form-group">	
            <label class="col-sm-3 control-label">参数键名：</label>
            <div class="col-sm-8">
                <input id="configKey" name="configKey" class="form-control" type="text">
            </div>
        </div>
        <div class="form-group">	
            <label class="col-sm-3 control-label">参数键值：</label>
            <div class="col-sm-8">
                <input id="configValue" name="configValue" class="form-control" type="text">
            </div>
        </div>
        <div class="form-group">
			<label class="col-sm-3 control-label">系统内置：</label>
			<div class="col-sm-8" id="nz">
				
			</div>
		</div>
		<div class="form-group">	
            <label class="col-sm-3 control-label">备注：</label>
            <div class="col-sm-8">
                <textarea id="remark" name="remark" class="form-control"></textarea>
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
    
    
    $.ajax({
		url:ctx+"/DataServlet?method=jobDictData&type=sys_yes_no",
		method:"POST",
		dataType:"json",
		success:function(data){
			var html="";
			$(data).each(function(i,item){
			html+="<div  class='"+item.cssClass+"'>";
			html+="<input type='radio' id='"+item.dictCode+"' name='status' value='"+item.dictValue+"'>";
			html+="<label for='"+item.dictCode+"'>"+item.dictLabel+"</label></div>";
			});
			$("#nz").html(html);
			
			
		}
	});	
    
    
	    var prefix = ctx + "admin/config"
	
	    $("#form-config-add").validate({
	        /* rules: {
	            configKey: {
	                required: true,
	                remote: {
	                    url: prefix + "/checkConfigKeyUnique",
	                    type: "post",
	                    dataType: "json",
	                    data: {
	                        "configKey": function() {
	                            return $("input[name='configKey']").val();
	                        }
	                    },
	                    dataFilter: function(data, type) {
	                        if (data == "0") return true;
	                        else return false;
	                    }
	                }
	            },
	            configName: {
	                required: true
	            },
	            configValue: {
	                required: true
	            },
	        }, 
	        messages: {
	            "configKey": {
	                remote: "参数键名已经存在"
	            }
	        },*/
	        submitHandler: function(form) {
	        	$.operate.save(ctx + "/ConfigServlet?method=add", $('#form-config-add').serialize());
	        }
	    });
    </script>
</body>
</html>
