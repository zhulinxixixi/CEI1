<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类</title>
</head>
<body>

<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <form action="${pageContext.request.contextPath}/categoryServlet?op=addCategory" method="post">
            <table>
                <tr>
                    <td>分类名称:</td>
                    <td><input type="text" style="width: 700px; height: 35px; "
                               id="categoryName" name="categoryName"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="添加分类"></td>
                </tr>
            </table>

        </form>
    </div>
</div>


</body>
</html>
