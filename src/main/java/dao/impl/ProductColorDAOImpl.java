package dao.impl;

import dao.IProductColorDAO;
import mapper.ProductColorMapper;
import model.ProductColorModel;

import java.util.List;

public class ProductColorDAOImpl extends AbstractDAO<ProductColorModel> implements IProductColorDAO {
    @Override
    public void insertProductColor(ProductColorModel productColorModel) {
        String sql ="INSERT INTO product_color(productID, colorID,amount) VALUE(?,?,?)";
        insertUpdateDelete(sql,productColorModel.getProductID(),productColorModel.getColorID(),productColorModel.getAmount());
    }

    @Override
    public void updateProductColor(Integer id, ProductColorModel productColorModel) {

    }

    @Override
    public void deleteProductColor(Integer id) {

    }

    @Override
    public List<ProductColorModel> findByProductID(Long id) {
        String sql = "SELECT * FROM product_color WHERE productID = ?";
        return findByProperties(sql, new ProductColorMapper(),id);
    }

    @Override
    public List<ProductColorModel> findAllProductColor() {
        String sql = "SELECT * FROM product_color";
        return findByProperties(sql, new ProductColorMapper());
    }
}
