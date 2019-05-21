package service;

import model.SexModel;

import java.util.List;

public interface ISexService {
    void insertSex(SexModel sexModel);

    void updateSex(SexModel sexModel);

    void deleteSex(Integer id);

    SexModel findByID(Integer id);

    List<SexModel> findAllSex();
}
