package dao;

import model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
    void insertCategory(CategoryModel categoryModel);

    void updateCategory(Integer id, CategoryModel categoryModel);

    void deleteCategory(Integer id);

    CategoryModel findByID(Integer id);

    List<CategoryModel> findAllCategory();
}
