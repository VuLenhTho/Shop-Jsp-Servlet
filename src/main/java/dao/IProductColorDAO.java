package dao;

import model.ProductColorModel;

import java.util.List;

public interface IProductColorDAO {
    void insertProductColor(ProductColorModel productColorModel);

    void updateProductColor(Integer id, ProductColorModel productColorModel);

    void deleteProductColor(Integer id);

    List<ProductColorModel> findByProductID(Long id);

    List<ProductColorModel> findAllProductColor();
}
