package cn.javabs.cei.dao;

import cn.javabs.cei.entity.Category;

import java.util.List;

public interface CategoryDao {
    int addCategory(Category category);

    int delCategory(int id);

    int updateCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryById(int id);

    Category getCategoryByName(String categoryName);

}
