package dao;

import model.ProductModel;

import java.util.List;

public interface IProductDAO extends IGenericDAO<ProductModel> {
    void insertProduct(ProductModel productModel);

    void updateProduct(Long id, ProductModel productModel);

    void deleteProduct(Long id);
    
    ProductModel findByID(Long id);

    List<ProductModel> findAllProduct();
}
