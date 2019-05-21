package service.impl;

import dao.ISubcategoryDAO;
import dao.impl.SubCategoryDAOImpl;
import model.SubcategoryModel;
import service.ISubcategoryService;

import java.util.List;

public class SubcategoryServiceImpl implements ISubcategoryService {
    private ISubcategoryDAO subcategoryDAO;

    public SubcategoryServiceImpl() {
        subcategoryDAO = new SubCategoryDAOImpl();
    }

    @Override
    public void insertSub(SubcategoryModel subcategoryModel) {
        subcategoryDAO.insertSub(subcategoryModel);
    }

    @Override
    public void updateSub(SubcategoryModel subcategoryModel) {
        subcategoryDAO.updateSub(subcategoryModel.getId(),subcategoryModel);
    }

    @Override
    public void deleteSub(Integer id) {
        subcategoryDAO.deleteSub(id);
    }

    @Override
    public SubcategoryModel findByID(Integer id) {
        return subcategoryDAO.findByID(id);
    }

    @Override
    public List<SubcategoryModel> findAllSub() {
        return subcategoryDAO.findAllSub();
    }
}
