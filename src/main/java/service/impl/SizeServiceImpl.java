package service.impl;

import dao.ISizeDAO;
import dao.impl.SizeDAOImpl;
import model.SizeModel;
import service.ISizeService;

import java.util.List;

public class SizeServiceImpl implements ISizeService {
    private ISizeDAO sizeDAO;

    public SizeServiceImpl() {
        sizeDAO = new SizeDAOImpl();
    }

    @Override
    public void insertSize(SizeModel sizeModel) {
        sizeDAO.insertSize(sizeModel);
    }

    @Override
    public void updateSize(SizeModel sizeModel) {
        sizeDAO.updateSize(sizeModel.getId(),sizeModel);
    }

    @Override
    public void deleteSize(Integer id) {
        sizeDAO.deleteSize(id);
    }

    @Override
    public SizeModel findByID(Integer id) {
        return sizeDAO.findByID(id);
    }

    @Override
    public List<SizeModel> findAllSize() {
        return sizeDAO.findAllSize();
    }
}
