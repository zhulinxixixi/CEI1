package cn.javabs.cei.web.servlet;

import cn.javabs.cei.entity.Category;
import cn.javabs.cei.entity.Nav;
import cn.javabs.cei.service.CategoryService;
import cn.javabs.cei.service.NavService;
import cn.javabs.cei.service.impl.CategoryServiceImpl;
import cn.javabs.cei.service.impl.NavServiceImpl;
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

@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {

    CategoryService categoryService = new CategoryServiceImpl();
    NavService navService = new NavServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        String op = request.getParameter("op");

        if (op.equals("addNav")){
            System.out.println("3");
            addNav(request,response);
        }else if (op.equals("gotoShow")){
            System.out.println("1");
            gotoShow(request,response);
        }else if(op.equals("findAllNav")){
            findAllNav(request,response);
        }else if(op.equals("gotoAdd")){
            gotoAdd(request,response);
        }else if("editNav".equals(op)){

            editNav(request,response);
        } else if("gotoEdit".equals(op)){

            gotoEdit(request,response);
        }else if("delNav".equals(op)){
            delNav(request,response);
        } else {
            System.out.println("参数异常！");
        }
    }
    //删除
    private void delNav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        navService.delNav(id);
        findAllNav(request,response);

    }
//编辑
    private void gotoEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        int id = Integer.parseInt(request.getParameter("id"));
        Nav nav = navService.findNavById(id);
        request.setAttribute("nav",nav);//setAttribute作用是保存数据


        List<Category> categories = categoryService.findAllCategory();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/backgroud/navigator/editNav.jsp").forward(request,response);
    }

    private void gotoAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Category> categories = categoryService.findAllCategory();
        request.setAttribute("categories",categories);

        request.getRequestDispatcher("/backgroud/navigator/addNav.jsp").forward(request,response);
    }

    private void editNav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String colName = request.getParameter("navName");
        if(colName==null||colName==""){
            gotoEdit(request,response);
        }else {
            int id = Integer.parseInt(request.getParameter("id"));
            int catId = Integer.parseInt(request.getParameter("catId"));
            Nav nav = new Nav();
            nav.setId(id);
            nav.setNavName(colName);
            nav.setCatId(catId);
            navService.updateNav(nav);
            findAllNav(request,response);
        }
    }

    private void findAllNav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Nav> navs = navService.findAllNav();
        request.setAttribute("navs",navs);
        System.out.println("navs="+navs);
        request.getRequestDispatcher("/backgroud/navigator/navList.jsp").forward(request,response);
    }

    private void addNav(HttpServletRequest request, HttpServletResponse response) {


        Nav nav = new Nav();

        String navName = request.getParameter("navName");

        String id = request.getParameter("catid");

        int catid = Integer.parseInt(id);
        nav.setNavName(navName);
        nav.setCatId(catid);
//        navService.addNav(nav);
        try {
            BeanUtils.populate(nav,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int rows = navService.addNav(nav);
            if(rows!=0){
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


        request.getRequestDispatcher("/background/navigator/addNav.jsp").forward(request,response);

    }



}
