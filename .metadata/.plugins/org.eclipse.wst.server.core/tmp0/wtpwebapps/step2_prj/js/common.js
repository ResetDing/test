function getHeight() {
        return $(window).height() - $('h1').outerHeight(true);
    }
(function($) {
	
	
	
    $.extend({
        table: {
            _option: {},
            _params: {},
            init: function(options) {
                $.table._option = options;
                $.table._params = $.common.isEmpty(options.queryParams) ? $.table.queryParams: options.queryParams;
                _sortOrder = $.common.isEmpty(options.sortOrder) ? "asc": options.sortOrder;
                _sortName = $.common.isEmpty(options.sortName) ? "": options.sortName;
                
                
                $("#bootstrap-table").bootstrapTable({
                    url: options.url,//请求后台的URL（*）
                    contentType: "application/x-www-form-urlencoded",
                    method: "post",   //请求方式（*）
                    toolbar: "#toolbar",//工具按钮用哪个容器
                    striped: true,                      //是否显示行间隔色
                    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    sortable: true,                     //是否启用排序
                    sortOrder: "asc",                   //排序方式
                    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                    sortName: _sortName,
                    sortOrder: _sortOrder,
                    sortStable: true,
                    pagination: true,
                    pageNumber: 1,
                    pageSize: 10,                     //每页的记录行数（*）
                    pageList: [5, 10, 15, 20],        //可供选择的每页的行数（*）
                    search: $.common.visible(options.search), //search: true,                      //是否显示表格搜索
                    strictSearch: true,
                    iconSize: "outline",
                  
                    minimumCountColumns: 2,             //最少允许的列数
                    clickToSelect: true,                //是否启用点击选中行
                    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                    showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
                    cardView: false,                    //是否显示详细视图
                    detailView: false,                  //是否显示父子表
                    //height: getHeight(),                //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                    
                    showPaginationSwitch: true,////显示切换分页
                    showFooter: false,                    //显示底部，默认不显示,
                    showFullscreen: false,               //显示全屏
                    showHeader: true,                    //显示头部，默认显示
                    showRefresh: $.common.visible(options.showRefresh),
                    showColumns: $.common.visible(options.showColumns),
                    showToggle: $.common.visible(options.showToggle),
                    showExport: $.common.visible(options.showExport),
                    queryParams: $.table._params,
                    columns: options.columns
                })
                
                
            },
            queryParams: function(params) {
            	var search = {};
				$.each($("#condition-form").serializeArray(), function(i, field) {
					search[field.name] = field.value
				});
				search.pageSize = params.limit;
				search.pageNum = params.offset / params.limit + 1;
				search.searchValue = params.search;
				search.orderByColumn = params.sort;
				search.isAsc = params.order;
				return search;
            },
            search: function(form) {
               var params = $("#bootstrap-table").bootstrapTable("getOptions");
//                params.queryParams = function(params) {
//                    var search = {};
//                    $.each($("#" + form).serializeArray(),
//                    function(i, field) {
//                        search[field.name] = field.value
//                    });
//                    search.pageSize = params.limit;
//                    search.pageNum = params.offset / params.limit + 1;
//                    search.searchValue = params.search;
//                    search.orderByColumn = params.sort;
//                    search.isAsc = params.order;
//                    return search
//                };
                $("#bootstrap-table").bootstrapTable("refresh", params)
            },
            exportExcel: function(form) {
                $.post($.table._option.exportUrl, $("#" + form).serializeArray(),
                function(result) {
                    if (result.code == web_status.SUCCESS) {
                        window.location.href = ctx + "common/download?fileName=" + result.msg + "&delete=" + true
                    } else {
                        $.modal.alertError(result.msg)
                    }
                })
            },
            refresh: function() {
                $("#bootstrap-table").bootstrapTable("refresh", {
                    url: $.table._option.url,
                    silent: true
                })
            },
            selectColumns: function(column) {
                return $.map($("#bootstrap-table").bootstrapTable("getSelections"),
                function(row) {
                    return row[column]
                })
            },
            selectFirstColumns: function() {
                return $.map($("#bootstrap-table").bootstrapTable("getSelections"),
                function(row) {
                    return row[$.table._option.columns[1].field]
                })
            }
        },
        treeTable: {
            _option: {},
            init: function(options) {
                $.table._option = options;
                $("#bootstrap-table").bootstrapTreeTable({
                    code: options.id,
                    parentCode: options.parentId,
                    type: "get",
                    url: options.url,
                    ajaxParams: {},
                    expandColumn: "0",
                    striped: false,
                    bordered: true,
                    expandAll: $.common.visible(options.expandAll),
                    columns: options.columns
                })
            }
        },
        form: {
            selectCheckeds: function(name) {
                var checkeds = "";
                $('input:checkbox[name="' + name + '"]:checked').each(function(i) {
                    if (0 == i) {
                        checkeds = $(this).val()
                    } else {
                        checkeds += ("," + $(this).val())
                    }
                });
                return checkeds
            },
            selectSelects: function(name) {
                var selects = "";
                $("#" + name + " option:selected").each(function(i) {
                    if (0 == i) {
                        selects = $(this).val()
                    } else {
                        selects += ("," + $(this).val())
                    }
                });
                return selects
            }
        },
        modal: {
            icon: function(type) {
                var icon = "";
                if (type == modal_status.WARNING) {
                    icon = 0
                } else {
                    if (type == modal_status.SUCCESS) {
                        icon = 1
                    } else {
                        if (type == modal_status.FAIL) {
                            icon = 2
                        } else {
                            icon = 3
                        }
                    }
                }
                return icon
            },
            msg: function(content, type) {
                if (type != undefined) {
                    layer.msg(content, {
                        icon: $.modal.icon(type),
                        time: 1000,
                        shift: 5,
                        shade: 0.1
                    })
                } else {
                    layer.msg(content)
                }
            },
            msgError: function(content) {
                $.modal.msg(content, modal_status.FAIL)
            },
            msgSuccess: function(content) {
                $.modal.msg(content, modal_status.SUCCESS)
            },
            msgWarning: function(content) {
                $.modal.msg(content, modal_status.WARNING)
            },
            alert: function(content, type) {
                layer.alert(content, {
                    icon: $.modal.icon(type),
                    title: "系统提示",
                    btn: ["确认"],
                    btnclass: ["btn btn-primary"],
                })
            },
            msgReload: function(msg, type) {
                layer.msg(msg, {
                    icon: $.modal.icon(type),
                    time: 500,
                    shade: [0.1, "#8F8F8F"]
                },
                function() {
                    $.modal.reload()
                })
            },
            alertError: function(content) {
                $.modal.alert(content, modal_status.FAIL)
            },
            alertSuccess: function(content) {
                $.modal.alert(content, modal_status.SUCCESS)
            },
            alertWarning: function(content) {
                $.modal.alert(content, modal_status.WARNING)
            },
            close: function() {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index)
            },
            confirm: function(content, callBack) {
                layer.confirm(content, {
                    icon: 3,
                    title: "系统提示",
                    btn: ["确认", "取消"],
                    btnclass: ["btn btn-primary", "btn btn-danger"],
                },
                function(index) {
                    layer.close(index);
                    callBack(true)
                })
            },
            open: function(title, url, width, height) {
                if ($.common.isEmpty(title)) {
                    title = false
                }
                if ($.common.isEmpty(url)) {
                    url = "404.html"
                }
                if ($.common.isEmpty(width)) {
                    width = 800
                }
                if ($.common.isEmpty(height)) {
                    height = ($(window).height() - 50)
                }
                layer.open({
                    type: 2,
                    area: [width + "px", height + "px"],
                    fix: false,
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: url
                })
            },
            openFull: function(title, url, width, height) {
                if ($.common.isEmpty(title)) {
                    title = false
                }
                if ($.common.isEmpty(url)) {
                    url = "404.html"
                }
                if ($.common.isEmpty(width)) {
                    width = 800
                }
                if ($.common.isEmpty(height)) {
                    height = ($(window).height() - 50)
                }
                var index = layer.open({
                    type: 2,
                    area: [width + "px", height + "px"],
                    fix: false,
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: url
                });
                layer.full(index)
            },
            loading: function(message) {
                $.blockUI({
                    message: '<div class="loaderbox"><div class="loading-activity"></div> ' + message + "</div>"
                })
            },
            closeLoading: function() {
                setTimeout(function() {
                    $.unblockUI()
                },
                50)
            },
            reload: function() {
                parent.location.reload()
            }
        },
        operate: {
            submit: function(url, type, dataType, data) {
                $.modal.loading("正在处理中，请稍后...");
                var config = {
                    url: url,
                    type: type,
                    dataType: dataType,
                    data: data,
                    success: function(result) {
                        $.operate.ajaxSuccess(result)
                    }
                };
                $.ajax(config)
            },
            post: function(url, data) {
                $.operate.submit(url, "post", "json", data)
            },
            remove: function(id) {
                $.modal.confirm("确定删除该条" + $.table._option.modalName + "信息吗？",
                function() {
                    var url = $.common.isEmpty(id) ? $.table._option.removeUrl: $.table._option.removeUrl.replace("{id}", id);
                    var data = {
                        "ids": id
                    };
                    $.operate.submit(url, "post", "json", data)
                })
            },
            batRemove: function() {
                var rows = $.common.isEmpty($.table._option.id) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.id);
                if (rows.length == 0) {
                    $.modal.alertWarning("请至少选择一条记录");
                    return
                }
                $.modal.confirm("确认要删除选中的" + rows.length + "条数据吗?",
                function() {
                    var url = $.table._option.removeUrl;
                    var data = {
                        "ids": rows.join()
                    };
                    $.operate.submit(url, "post", "json", data)
                })
            },
            add: function(id) {
                var url = $.common.isEmpty(id) ? $.table._option.createUrl: $.table._option.createUrl.replace("{id}", id);
                $.modal.open("添加" + $.table._option.modalName, url)
                
            },
            edit: function(id) {
                var url = $.table._option.updateUrl+"&id="+id;
                $.modal.open("修改" + $.table._option.modalName, url)
                
            },
            addFull: function(id) {
                var url = $.common.isEmpty(id) ? $.table._option.createUrl: $.table._option.createUrl.replace("{id}", id);
                $.modal.openFull("添加" + $.table._option.modalName, url)
            },
            editFull: function(id) {
               
            	  var url = $.table._option.updateUrl+"&id="+id;
                $.modal.openFull("修改" + $.table._option.modalName, url)
               
            },
            save: function(url, data) {
                $.modal.loading("正在处理中，请稍后...");
                var config = {
                    url: url,
                    type: "post",
                    dataType: "json",
                    data: data,
                    success: function(result) {
                        $.operate.saveSuccess(result)
                    }
                };
                $.ajax(config)
            },
            ajaxSuccess: function(result) {
                if (result.success == true) {
                    $.modal.msgSuccess(result.msg);
                    $.table.refresh()
                } else {
                    $.modal.alertError(result.msg)
                }
                $.modal.closeLoading()
            },
            saveSuccess: function(result) {
                if (result.success ==true) {
                    $.modal.msgReload("保存成功,正在刷新数据请稍后……", modal_status.SUCCESS)
                } else {
                    $.modal.alertError(result.msg)
                }
                $.modal.closeLoading()
            }
        },
        common: {
            isEmpty: function(value) {
                if (value == null || this.trim(value) == "") {
                    return true
                }
                return false
            },
            visible: function(value) {
                if ($.common.isEmpty(value) || value == true) {
                    return true
                }
                return false
            },
            trim: function(value) {
                if (value == null) {
                    return ""
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "")
            },
            random: function(min, max) {
                return Math.floor((Math.random() * max) + min)
            }
        }
    })
})(jQuery);
web_status = {
    SUCCESS: 0,
    FAIL: 500
};
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};