package service.impl;

import dao.IColorDAO;
import dao.impl.ColorDAOImpl;
import model.ColorModel;
import service.IColorService;

import java.util.List;

public class ColorServiceImpl implements IColorService {
    private IColorDAO colorDAO;

    public ColorServiceImpl() {
        colorDAO = new ColorDAOImpl();
    }

    @Override
    public void insertColor(ColorModel colorModel) {
        colorDAO.insertColor(colorModel);
    }

    @Override
    public void updateColor(ColorModel colorModel) {
        colorDAO.updateColor(colorModel.getId(),colorModel);
    }

    @Override
    public void deleteColor(Integer id) {
        colorDAO.deleteColor(id);
    }

    @Override
    public ColorModel findByID(Integer id) {
        return colorDAO.findByID(id);
    }

    @Override
    public List<ColorModel> findAllColor() {
        return colorDAO.findAllColor();
    }
}
