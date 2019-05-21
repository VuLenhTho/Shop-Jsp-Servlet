package dao.impl;

import dao.ISubcategoryDAO;
import mapper.SubcategoryMapper;
import model.SubcategoryModel;

import java.util.List;

public class SubCategoryDAOImpl extends AbstractDAO<SubcategoryModel> implements ISubcategoryDAO {
    @Override
    public void insertSub(SubcategoryModel subcategoryModel) {
        String sql ="INSERT INTO subcategory(categoryID, subcategoryName) VALUE (?,?)";
        insertUpdateDelete(sql,subcategoryModel.getCategoryID()
                ,subcategoryModel.getSubcategoryName());
    }

    @Override
    public void updateSub(Integer id, SubcategoryModel subcategoryModel) {
        String sql ="UPDATE subcategory SET categoryID =?, subcategoryName=? WHERE id =?";
        insertUpdateDelete(sql,subcategoryModel.getCategoryID()
                ,subcategoryModel.getSubcategoryName(),id);
    }

    @Override
    public void deleteSub(Integer id) {
        String sql ="DELETE FROM subcategory WHERE id =?";
        insertUpdateDelete(sql,id);
    }

    @Override
    public SubcategoryModel findByID(Integer id) {
        String sql ="SELECT * FROM subcategory WHERE id =?";
        List<SubcategoryModel> subcategoryModel = findByProperties(sql,new SubcategoryMapper(),id);
        return subcategoryModel.isEmpty()?null:subcategoryModel.get(0);
    }

    @Override
    public List<SubcategoryModel> findAllSub() {
        String sql ="SELECT * FROM subcategory";
        List<SubcategoryModel> subcategoryModels = findByProperties(sql,new SubcategoryMapper());
        return subcategoryModels.isEmpty()?null:subcategoryModels;
    }

}
