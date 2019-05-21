package service;

import model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    void insertCategory(CategoryModel categoryModel);

    void updateCategory(CategoryModel categoryModel);

    void deleteCategory(Integer id);

    CategoryModel findByID(Integer id);

    List<CategoryModel> findAllCategory();
}
