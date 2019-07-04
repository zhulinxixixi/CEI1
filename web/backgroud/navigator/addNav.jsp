<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加栏目</title>

</head>
<body>
<h5 align="center" style="font-size: 24px;">
    添加栏目
</h5>
<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <form action="${pageContext.request.contextPath}/navServlet?op=addNav" method="post">
            <table align="center" >
                <tr>
                    <td style="color: brown ">栏目名称:</td>
                    <td><input type="text" style="width: 700px; height: 35px; color: brown" id="navName" name="navName"></td>
                </tr>
                <tr>
                    <td style="color:brown">栏目分类:</td>
                    <td>
                        <select style="width: 700px; height: 35px; color: brown" name="catid">
                            <c:forEach items="${categories}" var="l">
                                <option value="${l.categoryId}">${l.categoryName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td colspan="2"  ><input type="submit" value="添加栏目"></td>
                </tr>
            </table>

        </form>
    </div>
</div>

</body>
</html>
