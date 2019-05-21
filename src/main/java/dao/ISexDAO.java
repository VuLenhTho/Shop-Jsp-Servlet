package dao;

import model.SexModel;

import java.util.List;

public interface ISexDAO extends IGenericDAO<SexModel> {
    void insertSex(SexModel sexModel);

    void updateSex(Integer id, SexModel sexModel);

    void deleteSex(Integer id);

    SexModel findByID(Integer id);

    List<SexModel> findAllSex();
}
