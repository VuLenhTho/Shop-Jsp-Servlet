package dao.impl;

import dao.ISexDAO;
import mapper.SexMapper;
import model.SexModel;

import java.util.List;

public class SexDAOImpl extends AbstractDAO<SexModel> implements ISexDAO {
    @Override
    public void insertSex(SexModel sexModel) {
        String sql = "INSERT INTO sex(sexName) VALUE (?)";
        insertUpdateDelete(sql,sexModel.getSexName());
    }

    @Override
    public void updateSex(Integer id, SexModel sexModel) {
        String sql = "UPDATE sex SET sexName =? WHERE id =?";
        insertUpdateDelete(sql,sexModel.getSexName(),id);
    }

    @Override
    public void deleteSex(Integer id) {
        String sql = "DELETE FROM sex WHERE id =?";
        insertUpdateDelete(sql,id);
    }

    @Override
    public SexModel findByID(Integer id) {
        String sql = "SELECT * FROM sex WHERE id =?";
        List<SexModel> sexModel = findByProperties(sql,new SexMapper(),id);
        return sexModel.isEmpty()?null:sexModel.get(0);
    }

    @Override
    public List<SexModel> findAllSex() {
        String sql = "SELECT * FROM sex WHERE id =?";
        List<SexModel> sexModels = findByProperties(sql,new SexMapper());
        return sexModels.isEmpty()?null:sexModels;
    }
}
