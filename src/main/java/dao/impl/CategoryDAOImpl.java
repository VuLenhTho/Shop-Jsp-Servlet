package dao.impl;

import dao.ICategoryDAO;
import mapper.CategoryMapper;
import model.CategoryModel;

import java.util.List;

public class CategoryDAOImpl extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public void insertCategory(CategoryModel categoryModel) {
        String sql = "INSERT INTO category(categoryName) VALUE(?)";
        insertUpdateDelete(sql,categoryModel.getCategoryName());
    }

    @Override
    public void updateCategory(Integer id, CategoryModel categoryModel) {
        String sql = "UPDATE category SET categoryName =? WHERE id = ? ";
        insertUpdateDelete(sql,categoryModel.getCategoryName(),id);
    }

    @Override
    public void deleteCategory(Integer id) {
        String sql = "DELETE FROM category WHERE id =?";
        insertUpdateDelete(sql , id);
    }

    @Override
    public CategoryModel findByID(Integer id) {
        String sql = "SELECT * FROM category WHERE id =?";
        List<CategoryModel> categoryModel = findByProperties(sql,new CategoryMapper(),id);
        return categoryModel.isEmpty()? null : categoryModel.get(0);
    }

    @Override
    public List<CategoryModel> findAllCategory() {
        String sql = "SELECT * FROM category";
        List<CategoryModel> categoryModels = findByProperties(sql,new CategoryMapper());
        return categoryModels.isEmpty()? null : categoryModels;
    }
}
