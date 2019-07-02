<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>首页</title>
</head>
<body>

<%--<jsp:forward page="/addCategory.jsp"></jsp:forward>&ndash;%&gt;--%>
<%--<a href="${pageContext.request.contextPath}/backgroud/mainTemp.jsp">mainTemp.jsp</a>--%>
<%--<a href="${pageContext.request.contextPath}/backgroud/default.jsp">default.jsp</a>--%>

<a href="${pageContext.request.contextPath}/columnServlet?op=gotoAdd"method="">添加栏目</a>

<a href="${pageContext.request.contextPath}/columnServlet?op=findAllColumn"method="">查询所有栏目</a>

<a href="${pageContext.request.contextPath}/categoryServlet?op=gotoAdd">添加分类</a>
<a href="${pageContext.request.contextPath}/categoryServlet?op=findAllCategory"method="">查询所有分类</a>


</html>
