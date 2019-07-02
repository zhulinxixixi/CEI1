package cn.javabs.cei.service.impl;

import cn.javabs.cei.dao.CategoryDao;
import cn.javabs.cei.dao.impl.CategoryDaoImpl;
import cn.javabs.cei.entity.Category;
import cn.javabs.cei.service.CategoryService;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public int delCategory(int id) {

        return categoryDao.delCategory(id);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryDao.getCategoryByName(categoryName);
    }
}
