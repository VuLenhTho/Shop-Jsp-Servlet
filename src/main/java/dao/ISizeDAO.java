package dao;

import model.SizeModel;

import java.util.List;

public interface ISizeDAO extends IGenericDAO<SizeModel> {
    void insertSize(SizeModel sizeModel);

    void updateSize(Integer id, SizeModel sizeModel);

    void deleteSize(Integer id);

    SizeModel findByID(Integer id);

    List<SizeModel> findAllSize();
}
