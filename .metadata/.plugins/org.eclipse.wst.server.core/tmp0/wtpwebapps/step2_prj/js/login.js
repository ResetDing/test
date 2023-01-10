// 登录页面开始========================================

$(function() {
	//验证
	validateRule();
	// 验证码单击
	$('#kaptchaImage').click(
			function() {
				$(this).hide().attr('src',
						'/prj2/captcha?' + Math.floor(Math.random() * 100))
						.fadeIn();
			});
});

//验证通过后要调用的函数
$.validator.setDefaults({
	submitHandler : function() {
		login();
	}
});

function login() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var loginName = $("input[name='loginName']").val().trim();
	var password = $("input[name='password']").val().trim();
	var validateCode = $("input[name='validateCode']").val();

	 $.ajax({
	        type: "post",
	        url: "UserServlet",
	        dataType:"json",
	        data: {
	        	"method":"login",
	            "loginName": loginName,
	            "password": password,
	            "validateCode" : validateCode
	        },
	        success: function(r) { 
	            if (r.success) {
	                location.href = 'admin/index.jsp';
	            } else {
	            	$.modal.closeLoading();
	            	$('#kaptchaImage').click();
	            	$.modal.msg(r.msg);
	            }
	        }
	    });
	
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			loginName : {
				required : true
			},
			password : {
				required : true
			},
			validateCode : {
				required : true
			}
		},
		messages : {
			loginName : {
				required : icon + "请输入您的用户名",
			},
			password : {
				required : icon + "请输入您的密码",
			},
			validateCode : {
				required : icon + "请输入验证码",
			}
		}
	})
}
//登录页面结束========================================