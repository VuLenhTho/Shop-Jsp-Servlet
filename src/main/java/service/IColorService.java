package service;

import model.ColorModel;

import java.util.List;

public interface IColorService {
    void insertColor(ColorModel colorModel);

    void updateColor(ColorModel colorModel);

    void deleteColor(Integer id);

    ColorModel findByID(Integer id);

    List<ColorModel> findAllColor();
}
