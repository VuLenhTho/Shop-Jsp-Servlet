package service;

import model.SubcategoryModel;

import java.util.List;

public interface ISubcategoryService {
    void insertSub(SubcategoryModel subcategoryModel);

    void updateSub(SubcategoryModel subcategoryModel);

    void deleteSub(Integer id);

    SubcategoryModel findByID(Integer id);

    List<SubcategoryModel> findAllSub();
}
