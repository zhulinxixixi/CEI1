package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.NavDao;
import cn.javabs.cei.entity.Nav;
import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class NavDaoImpl implements NavDao {

    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public int addNav(Nav nav) {

        try {
            System.out.println(nav.getNavName());
            System.out.println(nav.getCatId());
            System.out.println(nav);

            return qr.update("insert into navs(navName,category_id) values(?,?);",nav.getNavName(),nav.getCatId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delNav(int id) {
        try {
            return qr.update("delete from navs where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateNav(Nav nav) {
        System.out.println(nav);

        try {

            return qr.update("update navs set navname=?,category_id=? where id=?"
                    ,nav.getNavName(),nav.getCatId(),nav.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Nav> getAllNav() {
        List<Nav> navs=null;
        try {
             navs = (List<Nav>) qr.query("select * from navs col,category  where col.category_id=category.categoryid",new BeanListHandler<Nav>(Nav.class));
            return navs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Nav getNavById(int id) {

        try {
            Nav nav = qr.query("select * from navs col,category cat where col.category_id=cat.categoryId and col.id=?",new BeanHandler<Nav>(Nav.class),id);
            return nav;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Nav getNavByName(String name) {
        try {
            Nav nav = qr.query("select * from navs col,category cat where col.category_id=cat.id and col.navName=?",new BeanHandler<Nav>(Nav.class),name);
            return nav;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
