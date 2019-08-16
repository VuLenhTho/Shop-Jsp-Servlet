package service.impl;

import dao.IProductColorDAO;
import dao.impl.ProductColorDAOImpl;
import model.ProductColorModel;
import service.IProductColorService;

import java.util.List;

public class ProductColorServiceImpl implements IProductColorService {
    private IProductColorDAO productColorDAO;

    public ProductColorServiceImpl() {
        productColorDAO = new ProductColorDAOImpl();
    }

    @Override
    public void insertProductColor(ProductColorModel productColorModel) {

    }

    @Override
    public void updateProductColor(Integer id, ProductColorModel productColorModel) {

    }

    @Override
    public void deleteProductColor(Integer id) {

    }

    @Override
    public List<ProductColorModel> findByProductID(Long id) {
        return productColorDAO.findByProductID(id);
    }

    @Override
    public List<ProductColorModel> findAllProductColor() {
        return productColorDAO.findAllProductColor();
    }
}
