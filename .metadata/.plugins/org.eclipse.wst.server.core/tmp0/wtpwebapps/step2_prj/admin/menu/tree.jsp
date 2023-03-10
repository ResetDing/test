<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<meta charset="utf-8">
<jsp:include page="/admin/header.jsp" />
<link href="js/plugins/jquery-ztree/3.5/css/metro/zTreeStyle.css" rel="stylesheet"/>
<style>
body{height:auto;font-family: "Microsoft YaHei";}
button{font-family: "SimSun","Helvetica Neue",Helvetica,Arial;}
</style>
<body class="hold-transition box box-main">
	<input id="treeId"   name="treeId"    type="hidden"/>
	<input id="treeName" name="treeName"  type="hidden" />
	<div class="wrapper"><div class="treeShowHideButton" onclick="search();">
		<label id="btnShow" title="显示搜索" style="display:none;">︾</label>
		<label id="btnHide" title="隐藏搜索">︽</label>
	</div>
	<div class="treeSearchInput" id="search">
		<label for="keyword">关键字：</label><input type="text" class="empty" id="keyword" maxlength="50">
		<button class="btn" id="btn" onclick="searchNode()"> 搜索 </button>
	</div>
	<div class="treeExpandCollapse">
		<a href="javascript:" id="btnExpand">展开</a> /
		<a href="javascript:" id="btnCollapse">折叠</a>
	</div>
	<div id="tree" class="ztree treeselect"></div>
	</div>
	<div class="layui-layer-btn">
		<a class="layui-layer-btn0"onclick="loadObj()"><i class="fa fa-check"></i> 确定</a>
		<a class="layui-layer-btn1" onclick="$.modal.close()"><i class="fa fa-close"></i> 关闭</a>
	</div>
	<jsp:include page="/admin/footer.jsp" />
	<script src="js/plugins/jquery-ztree/3.5/js/jquery.ztree.all-3.5.js"></script>
	<script >
		// 树结构初始化加载
		var setting = {view:{selectedMulti:false},data:{key:{title:"title"},simpleData:{enable:true}},
			callback:{onClick:function(event, treeId, treeNode){
				var treeId = treeNode.id;
				var treeName = treeNode.name;
				$("#treeId").val(treeId);
				$("#treeName").val(treeName);
			}}
		}, tree, loadTree = function(){
			$.getJSON(ctx + "/MenuServlet?method=zTree", function(data) {
				var treeName = $("#treeName").val();
			    tree = $.fn.zTree.init($("#tree"), setting, data);
			    // 展开第一级节点
			    var nodes = tree.getNodesByParam("level", 0);
			    for (var i = 0; i < nodes.length; i++) {
			        tree.expandNode(nodes[i], false, false, false);
			        selectCheckNode(treeName,nodes[i]);
			    }
			}, null, null, "正在加载，请稍后...");
		};

		$(function() {
		    loadTree();
		});

		function selectCheckNode(treeName, node) {
			if(treeName == node.name){
				tree.selectNode(node, true);
			}
		}

		$('#btnExpand').click(function() {
			tree.expandAll(true);
		});
		$('#btnCollapse').click(function() {
			tree.expandAll(false);
		});

		function loadObj(){
			var treeId = $("#treeId").val();
			var treeName = $("#treeName").val();
			parent.$("#treeId").val(treeId);
			parent.$("#treeName").val(treeName);
			var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
			parent.layer.close(index);
		}

		var lastValue = "", nodeList = [], key = $("#keyword");
		key.bind("focus", focusKey).bind("blur", blurKey).bind("change cut input propertychange", searchNode);
		key.bind("keydown", function (e){if(e.which == 13){searchNode();}});

		function focusKey(e) {
			if (key.hasClass("empty")) {
				key.removeClass("empty");
			}
		}

		function blurKey(e) {
			if (key.get(0).value === "") {
				key.addClass("empty");
			}
			searchNode(e);
		}

		function searchNode() {
			var value = $.trim(key.get(0).value);
			var keyType = "name";
			if (lastValue === value) {
				return;
			}
			lastValue = value;
			var nodes = tree.getNodes();
			if (value == "") {
				showAllNode(nodes);
				return;
			}
			hideAllNode(nodes);
			nodeList = tree.getNodesByParamFuzzy(keyType, value);
			updateNodes(nodeList);
		}

		function hideAllNode(nodes){
			var tree = $.fn.zTree.getZTreeObj("tree");
			nodes = tree.transformToArray(nodes);
			for(var i=nodes.length-1; i>=0; i--) {
				tree.hideNode(nodes[i]);
			}
		}

		function showAllNode(nodes){
			nodes = tree.transformToArray(nodes);
			for(var i=nodes.length-1; i>=0; i--) {
				if(nodes[i].getParentNode()!=null){
					tree.expandNode(nodes[i],false,false,false,false);
				}else{
					tree.expandNode(nodes[i],true,true,false,false);
				}
				tree.showNode(nodes[i]);
				showAllNode(nodes[i].children);
			}
		}

		function updateNodes(nodeList) {
			tree.showNodes(nodeList);
			for(var i=0, l=nodeList.length; i<l; i++) {
				var treeNode = nodeList[i];
				showChildren(treeNode);
				showParent(treeNode)
			}
		}

		function showChildren(treeNode){
			if (treeNode.isParent){
				for(var idx in treeNode.children){
					var node = treeNode.children[idx];
					tree.showNode(node);
					showChildren(node);
				}
			}
		}
		function showParent(treeNode){
			var parentNode;
			while((parentNode = treeNode.getParentNode()) != null){
				tree.showNode(parentNode);
				tree.expandNode(parentNode, true, false, false);
				treeNode = parentNode;
			}
		}

		function search($this) {
			$('#search').slideToggle(200);
			$('#btnShow').toggle();
			$('#btnHide').toggle();
			$('#keyword').focus();
		}
	</script>
</body>
</html>
