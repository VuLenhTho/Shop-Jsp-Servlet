package service;

import model.SizeModel;

import java.util.List;

public interface ISizeService {
    void insertSize(SizeModel sizeModel);

    void updateSize(SizeModel sizeModel);

    void deleteSize(Integer id);

    SizeModel findByID(Integer id);

    List<SizeModel> findAllSize();
}
