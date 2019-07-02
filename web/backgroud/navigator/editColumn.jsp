<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改栏目</title>
</head>
<body>

<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <form action="${pageContext.request.contextPath}/columnServlet?op=editColumn&id=${column.id}" method="post">
            <table>
                <tr>
                    <td>栏目名称:</td>
                    <td><input type="text" style="width: 700px; height: 35px; "
                               id="columnName" name="columnName" value="${column.columnName}"></td>
                </tr>
                <tr>
                    <td>导航名称</td>

                    <td>

                        <select style="width: 700px; height: 35px;"  name="catId"   >

                            <option value="${column.catId}">${column.categoryName}</option>
                            <c:forEach items="${categories}" var="l">
                                <option value="${l.categoryId}">${l.categoryName}</option>
                            </c:forEach>

                        </select>
                    </td>

                </tr>

                <tr>
                    <td><button>修改</button></td>
                </tr>
            </table>

        </form>
    </div>
</div>


</body>
</html>
<script type="text/javascript">
    window.onload=function(){

        var text= document.getElementById("columnName");
        var Obtn = document.getElementsByTagName("button")


        Obtn[0].onclick=function(){

            if(text.value==""||text.value==null){
                alert("名称不能为空！")
            }

        }

    }

</script>