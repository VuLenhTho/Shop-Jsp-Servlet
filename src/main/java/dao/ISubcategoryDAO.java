package dao;

import model.SubcategoryModel;

import java.util.List;

public interface ISubcategoryDAO extends IGenericDAO<SubcategoryModel> {
    void insertSub(SubcategoryModel subcategoryModel);

    void updateSub(Integer id , SubcategoryModel subcategoryModel);

    void deleteSub(Integer id);

    SubcategoryModel findByID(Integer id);

    List<SubcategoryModel> findAllSub();
}
