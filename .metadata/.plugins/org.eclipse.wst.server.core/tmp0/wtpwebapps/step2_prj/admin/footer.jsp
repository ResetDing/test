<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<base href="${pageContext.request.contextPath }/">
<script src="js/plugins/jquery/jquery.min.js"></script>
<script src="js/plugins/bootstrap/bootstrap.min.js"></script>



<!-- bootstrap-table 表格插件 -->

<script src="js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table-export.js"></script>
<script src="js/plugins/bootstrap-table/tableExport.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table-editable.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-editable.js"></script>
<script src="js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>
<script src="js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="js/plugins/bootstrap-table/extensions/toolbar/bootstrap-table-toolbar.min.js"></script>
<!-- jquery-export 表格导出插件 -->
<!-- <script src="js/plugins/bootstrap-table/extensions/export/bootstrap-table-export.js"></script> -->
<script src="js/plugins/bootstrap-table/extensions/export/tableExport.js"></script>

<!-- jquery-validate 表单验证插件 -->
<script src="js/plugins/validate/jquery.validate.min.js"></script>
<script src="js/plugins/validate/messages_zh.min.js"></script>
<script src="js/plugins/validate/jquery.validate.extend.js"></script>
<!-- jquery-validate 表单树插件 -->
<script src="js/plugins/jqTreeGrid/jquery.treegrid.min.js"></script>
<script src="js/plugins/jqTreeGrid/jquery.treegrid.extension.js"></script>

<!-- 遮罩层 -->
<script src="js/plugins/blockUI/jquery.blockUI.js"></script>
<script src="js/plugins/layer/layer.min.js"></script>

<!--  <script src="js/plugins/ruoyi/js/common.js"></script>-->
<script src="js/plugins/ruoyi/js/ry-ui.min.js"></script>
<script src="js/common.js"></script>

<input id="pageContext" type="hidden" value="${pageContext.request.contextPath}" />
<script>
var ctx = $("#pageContext").val()+"/";
</script>