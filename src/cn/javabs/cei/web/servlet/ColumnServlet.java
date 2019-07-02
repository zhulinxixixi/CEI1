package cn.javabs.cei.web.servlet;

import cn.javabs.cei.entity.Category;
import cn.javabs.cei.entity.Column;
import cn.javabs.cei.service.CategoryService;
import cn.javabs.cei.service.ColumnService;
import cn.javabs.cei.service.impl.CategoryServiceImpl;
import cn.javabs.cei.service.impl.ColumnServiceImpl;
import cn.javabs.cei.util.NavUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/columnServlet")
public class ColumnServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();
    ColumnService columnService = new ColumnServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        String op = request.getParameter("op");

        if (op.equals("addColumn")){
            System.out.println("3");
            addColumn(request,response);
        }else if (op.equals("gotoShow")){
            System.out.println("1");
            gotoShow(request,response);
        }else if(op.equals("findAllColumn")){
            findAllColumn(request,response);
        }else if(op.equals("gotoAdd")){
            gotoAdd(request,response);
        }else if("editColumn".equals(op)){

            editColumn(request,response);
        } else if("gotoEdit".equals(op)){

            gotoEdit(request,response);
        }else if("delColumn".equals(op)){
            delColumn(request,response);
        } else {
            System.out.println("参数异常！");
        }
    }
//删除
    private void delColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        columnService.delColumn(id);
        findAllColumn(request,response);

    }

    private void gotoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        int id = Integer.parseInt(request.getParameter("id"));
        Column column = columnService.findColumnById(id);
        request.setAttribute("column",column);


        List<Category> categories = categoryService.findAllCategory();
        request.setAttribute("categories",categories);



        request.getRequestDispatcher("/backgroud/navigator/editColumn.jsp").forward(request,response);
    }

    private void editColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String colName = request.getParameter("columnName");
        if(colName==null||colName==""){
            gotoEdit(request,response);
        }else {
            int id = Integer.parseInt(request.getParameter("id"));
            int catId = Integer.parseInt(request.getParameter("catId"));
            Column column = new Column();
            column.setId(id);
            column.setColumnName(colName);
            column.setCatId(catId);
            columnService.updateColumn(column);
            findAllColumn(request,response);
        }
    }

    private void gotoAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Category> categories = categoryService.findAllCategory();
        request.setAttribute("categories",categories);

        request.getRequestDispatcher("/backgroud/navigator/addColumn.jsp").forward(request,response);
    }

    private void findAllColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Column> columns = columnService.findAllColumn();
        request.setAttribute("columns",columns);
        System.out.println("columns="+columns);
        request.getRequestDispatcher("/backgroud/navigator/columnList.jsp").forward(request,response);
    }

    private void addColumn(HttpServletRequest request, HttpServletResponse response) {


        Column column = new Column();

        String columnName = request.getParameter("columnName");

        String id = request.getParameter("catid");

        int catid = Integer.parseInt(id);
        column.setColumnName(columnName);
        column.setCatId(catid);
        columnService.addColumn(column);
        try {
            BeanUtils.populate(column,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int rows = columnService.addColumn(column);
            if(rows>0){
                request.setAttribute("msg","添加栏目成功");
                try {
                    request.getRequestDispatcher("/success.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("msgs","添加栏目失败");
                try {
                    request.getRequestDispatcher("/default.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    }

    private void gotoShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.findAllCategory();

        request.setAttribute("categories",categories);

        System.out.println(categories);


        request.getRequestDispatcher("/background/navigator/addColumn.jsp").forward(request,response);

    }



}
