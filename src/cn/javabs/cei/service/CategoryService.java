package cn.javabs.cei.service;

import cn.javabs.cei.entity.Category;

import java.util.List;

public interface CategoryService {
    int delCategory(int categoryId);

    int updateCategory(Category category);

    Category findCategoryById(int categoryId);

    List<Category> findAllCategory();

    int addCategory(Category category);

    Category findCategoryByName(String categoryName);
}
