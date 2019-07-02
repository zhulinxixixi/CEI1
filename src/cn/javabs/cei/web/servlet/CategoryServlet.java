package cn.javabs.cei.web.servlet;

import cn.javabs.cei.entity.Category;
import cn.javabs.cei.service.CategoryService;
import cn.javabs.cei.service.impl.CategoryServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        String op = request.getParameter("op");
        if ("addCategory".equals(op)){
            addCategory(request,response);
        }else if ("gotoAdd".equals(op)){
            gotoAdd(request,response);
        }else if ("findAllCategory".equals(op)){
            findAllCategory(request,response);
        }else if ("gotoEdit".equals(op)){
            gotoEdit(request,response);
        } else if("editCategory".equals(op)){
            editCategory(request,response);
        }else if("delCategory".equals(op)){
            delCategory(request,response);
        }else {
            System.out.println("参数错误");
        }


    }

    private void delCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        categoryService.delCategory(categoryId);
        findAllCategory(request,response);
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String name = request.getParameter("categoryName");

        Category category = new Category();
        int categoryId = Integer.parseInt(id);
        category.setCategoryId(categoryId);
        category.setCategoryName(name);
        if(name==null||name==""){
            gotoEdit(request,response);
        }else {

            categoryService.updateCategory(category);
            findAllCategory(request,response);
        }

    }

    private void gotoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findCategoryById(categoryId);

        request.setAttribute("category",category);
        request.getRequestDispatcher("/backgroud/navigator/editCategory.jsp").forward(request,response);

    }
    private void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.findAllCategory();

        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/backgroud/navigator/categoryList.jsp").forward(request,response);

    }
    private void gotoAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/backgroud/navigator/addCategory.jsp").forward(request,response);
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {

        Category category = new Category();

        String c = request.getParameter("categoryName");
        System.out.println(c);

        category.setCategoryName(c);

        System.out.println(category);

        categoryService.addCategory(category);

        try {
            BeanUtils.populate(category,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int rows = categoryService.addCategory(category);
        if(rows>0){
            request.setAttribute("msg","添加分类成功");
            try {
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("msgs","添加分类失败");
            try {
                request.getRequestDispatcher("/default.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }






    }

