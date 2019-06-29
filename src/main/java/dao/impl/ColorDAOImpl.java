package dao.impl;

import dao.IColorDAO;
import mapper.ColorMapper;
import model.ColorModel;

import java.util.List;

public class ColorDAOImpl extends AbstractDAO<ColorModel> implements IColorDAO {
    @Override
    public void insertColor(ColorModel colorModel) {
        String sql = "INSERT INTO color(colorName) VALUE (?)";
        insertUpdateDelete(sql,colorModel.getColorName());
    }

    @Override
    public void updateColor(Integer id, ColorModel colorModel) {
        String sql = "UPDATE color SET colorName =? WHERE id =?";
        insertUpdateDelete(sql,colorModel.getColorName(),id);
    }

    @Override
    public void deleteColor(Integer id) {
        String sql = "DELETE FROM color WHERE id =?";
        insertUpdateDelete(sql,id);
    }

    @Override
    public ColorModel findByID(Integer id) {
        String sql = "SELECT * FROM color WHERE id= ? ";
        List<ColorModel> colorModel = findByProperties(sql,new ColorMapper(),id);
        return colorModel.isEmpty()? null : colorModel.get(0);
    }

    @Override
    public List<ColorModel> findAllColor() {
        String sql = "SELECT * FROM color ";
        List<ColorModel> colorModels = findByProperties(sql,new ColorMapper());
        return colorModels.isEmpty()? null : colorModels;
    }

    @Override
    public List<ColorModel> findByProductID(Long id) {
        String sql = "SELECT id,colorName FROM product_color,color WHERE productID = ? AND colorID = color.id";
        List<ColorModel> colorModels = findByProperties(sql,new ColorMapper(),id);
        return colorModels.isEmpty()? null : colorModels;
    }


}
