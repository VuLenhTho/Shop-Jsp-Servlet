package service;

import model.ProductModel;
import paging.PageAble;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IProductService {
    void insertProduct(HttpServletRequest request, ProductModel productModel);

    void updateProduct(HttpServletRequest request, ProductModel productModel);

    void deleteProduct(Long id);

    ProductModel findByID(Long id);

    List<ProductModel> findAllProduct(PageAble pageAble);

    long countAllProduct();
}
