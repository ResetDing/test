/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.59
 * Generated at: 2022-03-03 05:59:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/Lenovo/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/step2_prj/WEB-INF/lib/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
    _jspx_dependants.put("/WEB-INF/lib/standard-1.1.2.jar", Long.valueOf(1625809360000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<title>后台首页</title>\n");
      out.write("<base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\">\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("    <meta http-equiv=\"refresh\" content=\"0;ie.html\"/>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("<link rel=\"shortcut icon\" href=\"favicon.ico\">\n");
      out.write("<link href=\"css/plugins/bootstrap/bootstrap.min.css?v=3.3.6\" rel=\"stylesheet\">\n");
      out.write("<link href=\"css/plugins/font-awesome/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\n");
      out.write("<link href=\"css/plugins/animate/animate.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"css/style.css?v=4.1.0\" rel=\"stylesheet\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"fixed-sidebar full-height-layout gray-bg\" style=\"overflow: hidden\">\n");
      out.write("\t<input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"userId\">\n");
      out.write("\t<div id=\"wrapper\">\n");
      out.write("\t\t<!--左侧导航开始-->\n");
      out.write("\t\t<nav class=\"navbar-default navbar-static-side\" role=\"navigation\">\n");
      out.write("\t\t\t<div class=\"nav-close\">\n");
      out.write("\t\t\t\t<i class=\"fa fa-times-circle\"></i>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"sidebar-collapse\">\n");
      out.write("\t\t\t\t<ul class=\"nav\" id=\"side-menu\">\n");
      out.write("\t\t\t\t\t<li class=\"nav-header\">\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown profile-element\">\n");
      out.write("\t\t\t\t\t\t\t<span>\n");
      out.write("\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle \" src=\"img/3.jpg\" height=\"64px\" width=\"64px\" />\n");
      out.write("\t\t\t\t\t\t\t</span> \n");
      out.write("\t\t\t\t\t\t\t<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\"> \n");
      out.write("\t\t\t\t\t\t\t<span class=\"clear\"> \n");
      out.write("\t\t\t\t\t\t\t<span class=\"block m-t-xs\">\n");
      out.write("\t\t\t\t\t\t\t\t<strong class=\"font-bold\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</strong></span> \n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"text-muted text-xs block\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.remark}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<b class=\"caret\"></b></span>\n");
      out.write("\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu animated fadeInRight m-t-xs\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"form_avatar.html\">修改头像</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"profile.html\">个人资料</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"contacts.html\">联系我们</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"J_menuItem\" href=\"mailbox.html\">信箱</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"login.html\">安全退出</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"logo-element\">WAN</div>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"admin/Ïßault.jsp\" class=\"J_menuItem\"> <i class=\"fa fa-home\"></i> <span class=\"nav-label \">后台首页</span>\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<script type=\"text/x-jquery-tmpl\" id=\"menuTmpl\">\n");
      out.write("                    <li class=\"secMenu\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${url}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"J_menuItem\">\n");
      out.write("                            <i class=\"fa ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${icon}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></i>\n");
      out.write("                            <span class=\"nav-label\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${menuName}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </span>\n");
      out.write("\n");
      out.write("                            {{if  children.length>0 }}\n");
      out.write("\n");
      out.write("                             <span class=\"fa arrow\"></span>\n");
      out.write("                            {{/if}}\n");
      out.write("\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                        <ul class=\"nav nav-second-level\">\n");
      out.write("                             {{each children}}\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"J_menuItem\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${url}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                 <i class=\"fa  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${icon}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></i>\n");
      out.write("                                 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'${menuName}'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                            </li>\n");
      out.write("                            {{/each}}\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </script>\n");
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</nav>\n");
      out.write("\t\t<!--左侧导航结束-->\n");
      out.write("\t\t<!--右侧部分开始-->\n");
      out.write("\t\t<div id=\"page-wrapper\" class=\"gray-bg dashbard-1\">\n");
      out.write("\t\t\t<div class=\"row border-bottom\">\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("\t\t\t\t\t<div class=\"navbar-header \">\n");
      out.write("\t\t\t\t\t\t<a class=\"navbar-minimalize minimalize-styl-2 btn btn-primary \" href=\"#\"> <i class=\"fa fa-bars\"></i>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- 一级菜单 -->\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-top-links navbar-left \" id=\"topMenu\">\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("\t\t\t\t\t\t<li class=\"hidden-xs\"><a href=\"javascript:;\" class=\"clearCache\"> <i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i> <sapn>清除缓存</sapn>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"hidden-xs\"><a href=\"javascript:;\" class=\"lockcms\"> <i class=\"fa fa-lock\" aria-hidden=\"true\"></i> <sapn>锁屏</sapn>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown hidden-xs\"><a class=\"right-sidebar-toggle\" aria-expanded=\"false\"> <i class=\"fa fa-tasks\"></i> 主题\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row content-tabs\">\n");
      out.write("\t\t\t\t<button class=\"roll-nav roll-left J_tabLeft\">\n");
      out.write("\t\t\t\t\t<i class=\"fa fa-backward\"></i>\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t\t<nav class=\"page-tabs J_menuTabs\">\n");
      out.write("\t\t\t\t\t<div class=\"page-tabs-content\">\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"active J_menuTab\" data-id=\"admin/default.jsp\">后台首页</a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t\t<button class=\"roll-nav roll-right J_tabRight\">\n");
      out.write("\t\t\t\t\t<i class=\"fa fa-forward\"></i>\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t\t<div class=\"btn-group roll-nav roll-right\">\n");
      out.write("\t\t\t\t\t<button class=\"dropdown J_tabClose\" data-toggle=\"dropdown\">\n");
      out.write("\t\t\t\t\t\t页面操作<span class=\"caret\"></span>\n");
      out.write("\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t<ul role=\"menu\" class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("\t\t\t\t\t\t<li class=\"J_tabShowActive\"><a>刷新当前</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"J_tabCloseOther\"><a>关闭其他</a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"J_tabCloseAll\"><a>关闭全部</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row J_mainContent\" id=\"content-main\">\n");
      out.write("\t\t\t\t<iframe class=\"J_iframe\" name=\"iframe0\" width=\"100%\" height=\"100%\" src=\"admin/default.jsp?v=4.0\" frameborder=\"0\" data-id=\"admin/default.jsp\" seamless></iframe>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"footer\">\n");
      out.write("\t\t\t\t<div class=\"pull-right\">\n");
      out.write("\t\t\t\t\t&copy; 2018-2020 <a href=\"http://www.zi-han.net/\" target=\"_blank\">wanho</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--右侧部分结束-->\n");
      out.write("\t\t<!--右侧边栏开始-->\n");
      out.write("\t\t<div id=\"right-sidebar\">\n");
      out.write("\t\t\t<div class=\"sidebar-container\">\n");
      out.write("\t\t\t\t<ul class=\"nav nav-tabs navs-3\">\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a data-toggle=\"tab\" href=\"#tab-1\"> <i class=\"fa fa-gear\"></i> 主题\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<div class=\"tab-content\">\n");
      out.write("\t\t\t\t\t<div id=\"tab-1\" class=\"tab-pane active\">\n");
      out.write("\t\t\t\t\t\t<div class=\"sidebar-title\">\n");
      out.write("\t\t\t\t\t\t\t<h3>\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"fa fa-comments-o\"></i> 主题设置\n");
      out.write("\t\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t\t<small><i class=\"fa fa-tim\"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"skin-setttings\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"title\">主题设置</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"setings-item\">\n");
      out.write("\t\t\t\t\t\t\t\t<span>收起左侧菜单</span>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"switch\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"onoffswitch\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"collapsemenu\" class=\"onoffswitch-checkbox\" id=\"collapsemenu\"> <label class=\"onoffswitch-label\" for=\"collapsemenu\"> <span class=\"onoffswitch-inner\"></span> <span class=\"onoffswitch-switch\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"setings-item\">\n");
      out.write("\t\t\t\t\t\t\t\t<span>固定顶部</span>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"switch\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"onoffswitch\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"fixednavbar\" class=\"onoffswitch-checkbox\" id=\"fixednavbar\"> <label class=\"onoffswitch-label\" for=\"fixednavbar\"> <span class=\"onoffswitch-inner\"></span> <span class=\"onoffswitch-switch\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"setings-item\">\n");
      out.write("\t\t\t\t\t\t\t\t<span> 固定宽度 </span>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"switch\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"onoffswitch\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"boxedlayout\" class=\"onoffswitch-checkbox\" id=\"boxedlayout\"> <label class=\"onoffswitch-label\" for=\"boxedlayout\"> <span class=\"onoffswitch-inner\"></span> <span class=\"onoffswitch-switch\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"title\">皮肤选择</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"setings-item default-skin nb\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"skin-name \"> <a href=\"#\" class=\"s-skin-0\"> 默认皮肤 </a>\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"setings-item blue-skin nb\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"skin-name \"> <a href=\"#\" class=\"s-skin-1\"> 蓝色主题 </a>\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"setings-item yellow-skin nb\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"skin-name \"> <a href=\"#\" class=\"s-skin-3\"> 黄色/紫色主题 </a>\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--右侧边栏结束-->\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- 全局js -->\n");
      out.write("\t<script src=\"js/plugins/jquery/jquery.min.js?v=2.1.4\"></script>\n");
      out.write("\t<script src=\"js/plugins/bootstrap/bootstrap.min.js?v=3.3.6\"></script>\n");
      out.write("\t<script src=\"js/plugins/metisMenu/jquery.metisMenu.js\"></script>\n");
      out.write("\t<script src=\"js/plugins/slimscroll/jquery.slimscroll.min.js\"></script>\n");
      out.write("\t<script src=\"js/plugins/layer/layer.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- 自定义js -->\n");
      out.write("\t<script src=\"js/hplus.js?v=4.1.0\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/contabs.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- 第三方插件 -->\n");
      out.write("\t<script src=\"js/plugins/pace/pace.min.js\"></script>\n");
      out.write("\t<script src=\"js/plugins/hullabaloo/hullabaloo.js\"></script>\n");
      out.write("\t<script src=\"js/plugins/jquery-tmpl/jquery.tmpl.js\"></script>\n");
      out.write("\n");
      out.write("\t<!--自定义js-->\n");
      out.write("\t<script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
