<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<h3 align="center" style="font-size: 24px;">
    导航后台页面
</h3>
<form>
    <table border="1" align="center" bordercolor="blue" style="width: 200px; height: 300px;">
        <tr>
            <td align="center"style="font-size: 20px; background-color: paleturquoise; ">
                <a href="${pageContext.request.contextPath}/navServlet?op=gotoAdd"method="">添加栏目</a>
            </td>
        </tr>
        <tr>
            <td align="center"style="font-size: 20px; background-color: pink;" >
                <a href="${pageContext.request.contextPath}/navServlet?op=findAllNav"method="">查询所有栏目</a>

            </td>
        </tr>
        <tr>
            <td align="center"style="font-size: 20px; background-color: paleturquoise;" >
                <a href="${pageContext.request.contextPath}/categoryServlet?op=gotoAdd">添加分类</a>
            </td>
        </tr>
        <tr>
            <td align="center"style="font-size: 20px; background-color: pink;" >
                <a href="${pageContext.request.contextPath}/categoryServlet?op=findAllCategory"method="">查询所有分类</a>
            </td>
        </tr>
    </table>

</form>

</body>

</html>
