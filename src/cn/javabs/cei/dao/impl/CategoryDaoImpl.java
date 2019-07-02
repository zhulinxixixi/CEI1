package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.CategoryDao;
import cn.javabs.cei.entity.Category;
import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int addCategory(Category category) {
        try {


            return qr.update("insert into category(categoryName) values(?);",category.getCategoryName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delCategory(int id) {

        try {
            return qr.update("delete from category where categoryId = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateCategory(Category category) {
        try {
            return qr.update("update category set categoryName=? where categoryId=?",category.getCategoryName(),category.getCategoryId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = null;
        try {
            categories = qr.query("select * from category",new BeanListHandler<Category>(Category.class));
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category getCategoryById(int id) {
        try {
            Category category = qr.query("select * from category where categoryId=?",new BeanHandler<Category>(Category.class),id);
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        try {
            Category category = qr.query("select * from category where category=?",new BeanHandler<Category>(Category.class));
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
