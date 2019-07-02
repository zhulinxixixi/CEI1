<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改分类</title>


</head>
<body>

<div class="data_list backMain">
    <div class="dataHeader navi">
        ${navCode}
    </div>
    <div class="data_content">
        <form action="${pageContext.request.contextPath}/categoryServlet?op=editCategory&id=${category.categoryId}" method="post">
            <table>

                <tr>
                    <td>栏目名称:</td>
                    <td><input type="text" style="width: 700px; height: 35px; "
                               id="categoryName" name="categoryName" value="${category.categoryName}"></td>
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

        var text= document.getElementById("categoryName");
        var Obtn = document.getElementsByTagName("button")


        Obtn[0].onclick=function(){
            if(text.value==""||text.value==null){
                alert("名称不能为空！")
            }

        }

    }

</script>
