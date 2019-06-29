package dao;

import model.ProductColorModel;
import model.ProductModel;
import paging.PageAble;
import paging.PageRequest;

import java.util.List;

public interface IProductDAO extends IGenericDAO<ProductModel> {
    void insertProduct(ProductModel productModel);

    void updateProduct(Long id, ProductModel productModel);

    void deleteProduct(Long id);
    
    ProductModel findByID(Long id);

    List<ProductModel> findAllProduct(PageAble pageAble);

    long countAllProduct();


}
