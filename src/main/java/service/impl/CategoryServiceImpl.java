package service.impl;

import dao.ICategoryDAO;
import dao.impl.CategoryDAOImpl;
import model.CategoryModel;
import service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl  implements ICategoryService {
    private ICategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public void insertCategory(CategoryModel categoryModel) {
        categoryDAO.insertCategory(categoryModel);
    }

    @Override
    public void updateCategory(CategoryModel categoryModel) {
        categoryDAO.updateCategory(categoryModel.getId(),categoryModel);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    public CategoryModel findByID(Integer id) {
        return categoryDAO.findByID(id);
    }

    @Override
    public List<CategoryModel> findAllCategory() {
        return categoryDAO.findAllCategory();
    }
}
