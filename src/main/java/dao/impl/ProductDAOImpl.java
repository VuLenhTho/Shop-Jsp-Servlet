package dao.impl;

import dao.IProductDAO;
import mapper.ProductMapper;
import model.ProductModel;

import java.util.List;

public class ProductDAOImpl extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public void insertProduct(ProductModel productModel) {
        String sql = "INSERT INTO product(productName, importPrice, price, amount, " +
                "createdBy, createdDate, thumbnail, sexID, " +
                "status, subcategoryID, discountID,trends,hotSelling, colorID, sizeID,thumbnailList)" +
                "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,)";
        insertUpdateDelete(sql,
                productModel.getProductName(), productModel.getImportPrice(),
                productModel.getPrice(),productModel.getAmount(),
                productModel.getCreatedBy(),productModel.getCreatedDate(),
                productModel.getThumbnail(),productModel.getSexID(),
                productModel.getStatus(),productModel.getSubcategoryID(),
                productModel.getDiscountID(),productModel.getTrends(),
                productModel.getHotSelling(),productModel.getColorID(),
                productModel.getSizeID(),productModel.getThumbnailList());
    }

    @Override
    public void updateProduct(Long id, ProductModel productModel) {
        String sql = "UPDATE product SET productName =?, importPrice =?, price=?, amount=?, " +
                "modifiedBy=?, modifiedDate=?, thumbnail=?, sexID=?, " +
                "status=?, subcategoryID=?, discountID=?,trends=?,hotSelling=?, colorID=?, " +
                "sizeID=?,thumbnailList=? WHERE id=?";
        insertUpdateDelete(sql,
                productModel.getProductName(), productModel.getImportPrice(),
                productModel.getPrice(),productModel.getAmount(),
                productModel.getModifiedBy(),productModel.getModifiedDate(),
                productModel.getThumbnail(),productModel.getSexID(),
                productModel.getStatus(),productModel.getSubcategoryID(),
                productModel.getDiscountID(),productModel.getTrends(),
                productModel.getHotSelling(),productModel.getColorID(),
                productModel.getSizeID(),productModel.getThumbnailList(),id);
    }

    @Override
    public void deleteProduct(Long id) {
        String sql = "DELETE FROM product WHERE id =?";
        insertUpdateDelete(sql,id);
    }

    @Override
    public ProductModel findByID(Long id) {
        String sql = "SELECT * FROM product WHERE id =?";
        List<ProductModel> productModel = findByProperties(sql,new ProductMapper(),id);
        return productModel.isEmpty()? null : productModel.get(0);
    }

    @Override
    public List<ProductModel> findAllProduct() {
        String sql = "SELECT * FROM product";
        List<ProductModel> productModels = findByProperties(sql,new ProductMapper());
        return productModels.isEmpty()? null : productModels;
    }
}
