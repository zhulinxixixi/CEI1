<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加栏目</title>
</head>
<body>


<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <form action="${pageContext.request.contextPath}/columnServlet?op=addColumn" method="post">
            <table>
                <tr>
                    <td>栏目名称:</td>
                    <td><input type="text" style="width: 700px; height: 35px; "
                               id="columnName" name="columnName"></td>
                </tr>
                <tr>
                    <td>栏目分类:</td>

                    <td>
                        <select style="width: 700px; height: 35px;" name="catid">
                            <c:forEach items="${categories}" var="l">
                                <option value="${l.categoryId}">${l.categoryName}</option>
                            </c:forEach>
                        </select>
                    </td>

                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="添加栏目"></td>
                </tr>
            </table>

        </form>
    </div>
</div>

</body>
</html>
