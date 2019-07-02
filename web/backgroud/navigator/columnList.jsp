<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二级导航</title>
    <script src="/js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>


<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <table class="table table-hover table-bordered">
            <tr>
                <th>一级导航序号</th>
                <th>导航类别</th>
                <th>二级导航序号</th>
                <th>二级导航名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${columns}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.columnName}</td>
                    <td>${c.catId}</td>
                    <td>${c.categoryName}</td>
                    <td>
                        <a class="btn btn-mini btn-info" href="${pageContext.request.contextPath}/columnServlet?op=gotoEdit&id=${c.id}">修改</a>
                            <%--<button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='/columnServlet?op=editColumn&id=${c.id}'">修改</button>&nbsp;&nbsp;--%>
                        <button class="btn btn-mini btn-danger" type="button" onclick="newsDelete(${c.id})">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    function newsDelete(id){
        if(confirm("确认定要删除这个栏目吗？")==true){

            window.location.href="${pageContext.request.contextPath}/columnServlet?op=delColumn&id="+id;
            alert("删除成功!");



        }
    }
</script>
