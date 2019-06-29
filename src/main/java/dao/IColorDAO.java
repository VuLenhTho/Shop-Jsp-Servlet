package dao;

import model.ColorModel;

import java.util.List;

public interface IColorDAO extends IGenericDAO<ColorModel> {
    void insertColor(ColorModel colorModel);

    void updateColor(Integer id, ColorModel colorModel);

    void deleteColor(Integer id);

    ColorModel findByID(Integer id);

    List<ColorModel> findAllColor();

    List<ColorModel> findByProductID(Long id);
}
