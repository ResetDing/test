<%@page import="net.wanho.po.User"%>
<%@page import="net.wanho.constant.Constants"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="net.wanho.constant.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	服务器启动时间:
	<%=DateFormat.getDateTimeInstance().format(Constants.START_DATE)%>,
	累计共接待过<%=Constants.TOTAL_HISTORY_COUNT%>
	访客
	<br /> 同时在线人数最多为<%=Constants.MAX_ONLINE_COUNT%>
	人
	<br /> 发生在
	<%=DateFormat.getDateTimeInstance().format(Constants.MAX_ONLINE_COUNT_DATE)%>.
	<br /> 目前在线总数：<%=Constants.SESSION_MAP.size()%>,登录用户：
	<%=Constants.CURRENT_LOGIN_COUNT%>.
	<br />
	<table border=1>
		<tr>
			<th>jsessionid</th>
			<th>account</th>
			<th>creationTime</th>
			<th>lastAccessedTime</th>
			<th>new</th>
			<th>activeTimes</th>
			<th>ip</th>
		</tr>
		<%
			for (String id : Constants.SESSION_MAP.keySet()) {
				HttpSession sess = Constants.SESSION_MAP.get(id);
				User user = (User) sess.getAttribute(Constants.CURRENTUSER);
		%>
		<tr <%=session == sess ? "bgcolor=#DDDDDD" : ""%>>
			<td><%=id%></td>
			<td><%=user == null ? " " : user.getLoginName()%></td>
			<td><%=DateFormat.getDateTimeInstance().format(sess.getCreationTime())%></td>
			<td><%=DateFormat.getDateTimeInstance().format(sess.getLastAccessedTime())%></td>
			<td><%=sess.isNew()%></td>
			<td><%=sess.getAttribute("activeTimes")%></td>
			<td><%=sess.getAttribute("ip")%></td>

		</tr>
		<%
			}
		%>

	</table>

</body>
</html>