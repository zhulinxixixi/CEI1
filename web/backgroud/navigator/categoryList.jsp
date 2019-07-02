<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一级导航</title>
</head>
<body>
<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <table class="table table-hover table-bordered">
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${categories}" var="c">
                <tr>
                    <td>${c.categoryId}</td>
                    <td>${c.categoryName}</td>
                    <td>
                        <a class="btn btn-mini btn-info" href="${pageContext.request.contextPath}/categoryServlet?op=gotoEdit&id=${c.categoryId}">修改</a>
                        <button class="btn btn-mini btn-danger" type="button" onclick="categoryDelete(${c.categoryId})">删除</button>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    function categoryDelete(id){
        if(confirm("确定要删除这个分类吗？")==true){

            window.location.href="${pageContext.request.contextPath}/categoryServlet?op=delCategory&categoryId="+id;
            alert("删除成功!");



        }
    }
</script>