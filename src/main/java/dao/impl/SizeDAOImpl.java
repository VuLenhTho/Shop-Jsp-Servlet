package dao.impl;

import dao.ISizeDAO;
import mapper.SizeMapper;
import model.SizeModel;

import java.util.List;

public class SizeDAOImpl extends AbstractDAO<SizeModel> implements ISizeDAO {
    @Override
    public void insertSize(SizeModel sizeModel) {
        String sql ="INSERT INTO size(sizeName) VALUE(?)";
        insertUpdateDelete(sql,sizeModel.getSizeName());
    }

    @Override
    public void updateSize(Integer id, SizeModel sizeModel) {
        String sql ="UPDATE size SET sizeName=? WHERE id =?";
        insertUpdateDelete(sql,sizeModel.getSizeName(),id);
    }

    @Override
    public void deleteSize(Integer id) {
        String sql ="DELETE FROM size WHERE id =?";
        insertUpdateDelete(sql,id);
    }

    @Override
    public SizeModel findByID(Integer id) {
        String sql ="SELECT * FROM size WHERE id =?";
        List<SizeModel> sizeModel = findByProperties(sql,new SizeMapper(),id);
        return sizeModel.isEmpty()?null: sizeModel.get(0);
    }

    @Override
    public List<SizeModel> findAllSize() {
        String sql ="SELECT * FROM size ";
        List<SizeModel> sizeModels = findByProperties(sql,new SizeMapper());
        return sizeModels.isEmpty()?null: sizeModels;
    }
}
