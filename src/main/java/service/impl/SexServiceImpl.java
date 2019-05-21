package service.impl;

import dao.ISexDAO;
import dao.ISizeDAO;
import dao.impl.SexDAOImpl;
import dao.impl.SizeDAOImpl;
import model.SexModel;
import service.ISexService;

import java.util.List;

public class SexServiceImpl implements ISexService {
    private ISexDAO sexDAO;

    public SexServiceImpl() {
        sexDAO = new SexDAOImpl();
    }

    @Override
    public void insertSex(SexModel sexModel) {
        sexDAO.insertSex(sexModel);
    }

    @Override
    public void updateSex(SexModel sexModel) {
        sexDAO.updateSex(sexModel.getId(),sexModel);
    }

    @Override
    public void deleteSex(Integer id) {
        sexDAO.deleteSex(id);
    }

    @Override
    public SexModel findByID(Integer id) {
        return sexDAO.findByID(id);
    }

    @Override
    public List<SexModel> findAllSex() {
        return sexDAO.findAllSex();
    }
}
