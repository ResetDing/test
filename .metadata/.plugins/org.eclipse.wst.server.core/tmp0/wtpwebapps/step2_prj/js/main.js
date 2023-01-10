
//清除缓存的开始============================================================

$(".clearCache").click(function() {
	window.sessionStorage.clear();
	window.localStorage.clear();
	var index = layer.msg('清除缓存中，请稍候', {
		icon : 16,
		time : false,
		shade : 0.8
	});
	setTimeout(function() {
		layer.close(index);
		layer.msg("缓存清除成功！");
	}, 1000);

	/*
	 * $.hulla = new hullabaloo(); setTimeout(function() {
	 * $.hulla.send("Hi！这里是懒人素材！", "success"); }, 1000);
	 */

});
// 清除缓存的结束============================================================

// 锁屏的开始===============================================

$(".lockcms").on("click", function() {
	window.localStorage.setItem("lockcms", true);
	lockPage();
})

// 锁屏
function lockPage() {
	layer
			.open({
				title : false,
				scrollbar : false,
				type : 1,
				area : [ '500px', '200px' ],
				content : '<form  class="form-horizontal"  >'
						+ '<div  id="lock-box" class="text-center">'
						+ '<div ><img src="img/3.jpg" class="userAvatar img-circle" height="64px" width="64px"/></div>'
						+ '<div class="alert alert-success col-sm-10 col-sm-offset-1" >当前用户</div>'
						+ '<div class="form-group">'
						+ '<div class="col-sm-6 col-sm-offset-1">'
						+ '<input type="password" class="form-control lock"   autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />'
						+ '</div>'
						+ '<button class="btn btn-primary col-sm-4" id="unlock">解锁</button>'
						+ '</div>' + '</div>' + '</form>',
				closeBtn : 0,
				shade : 0.9,
				success : function() {
					// 判断是否设置过头像，如果设置过则修改顶部、左侧和个人资料中的头像，否则使用默认头像
					/*
					 * if(window.sessionStorage.getItem('userFace') &&
					 * $(".userAvatar").length > 0){
					 * $(".userAvatar").attr("src",$(".userAvatar").attr("src").split("images/")[0] +
					 * "images/" +
					 * window.sessionStorage.getItem('userFace').split("images/")[1]); }
					 */
				}
			})
	$(".lock").focus();
}

// 判断是否显示锁屏
if (window.localStorage.getItem("lockcms") == "true") {
	lockPage();
}
// 解锁
$("body").on("click", "#unlock", function() {
	if ($(".lock").val() == '') {
		layer.msg("请输入解锁密码！");
		$(this).siblings(".lock").focus();
	} else {
		if ($(".lock").val() == "123456") {
			window.localStorage.setItem("lockcms", false);
			$(this).siblings(".lock").val('');
			layer.closeAll("page");
		} else {
			layer.msg("密码错误，请重新输入！");
			$(this).siblings(".lock").val('').focus();
		}
	}
});
$(document).on('keydown', function(event) {
	var event = event || window.event;
	if (event.keyCode == 13) {
		$("#unlock").click();
	}
});

// 锁屏的结束===============================================



//一级菜单开始=========================================

