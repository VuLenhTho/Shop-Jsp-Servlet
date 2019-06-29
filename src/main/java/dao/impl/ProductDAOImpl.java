package dao.impl;

import dao.IProductDAO;
import mapper.ColorMapper;
import mapper.ProductMapper;
import model.ColorModel;
import model.ProductColorModel;
import model.ProductModel;
import paging.PageAble;

import java.util.List;

public class ProductDAOImpl extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public void insertProduct(ProductModel productModel) {
        String sql = "INSERT INTO product(productName, importPrice, price, amount, " +
                "createdBy, createdDate, thumbnail, sexID, " +
                "subcategoryID, discountID,trends,hotSelling, " +
                "thumbnailList)" +
                "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        insertUpdateDelete(sql,
                productModel.getProductName(), productModel.getImportPrice(),
                productModel.getPrice(), productModel.getAmount(),
                productModel.getCreatedBy(), productModel.getCreatedDate(),
                productModel.getThumbnail(), productModel.getSexID(),
                productModel.getSubcategoryID(),
                productModel.getDiscountID(), productModel.getTrends(),
                productModel.getHotSelling(), productModel.getThumbnailList());
    }

    @Override
    public void updateProduct(Long id, ProductModel productModel) {
        String sql = "UPDATE product SET productName =?, importPrice =?, price=?, amount=?, " +
                "modifiedBy=?, modifiedDate=?, thumbnail=?, sexID=?, " +
                "status=?, subcategoryID=?, discountID=?,trends=?,hotSelling=?, " +
                "thumbnailList=? WHERE id=?";
        insertUpdateDelete(sql,
                productModel.getProductName(), productModel.getImportPrice(),
                productModel.getPrice(), productModel.getAmount(),
                productModel.getModifiedBy(), productModel.getModifiedDate(),
                productModel.getThumbnail(), productModel.getSexID(),
                productModel.getStatus(), productModel.getSubcategoryID(),
                productModel.getDiscountID(), productModel.getTrends(),
                productModel.getHotSelling(), productModel.getThumbnailList(), id);
    }

    @Override
    public void deleteProduct(Long id) {
        String sql = "DELETE FROM product WHERE id =?";
        insertUpdateDelete(sql, id);
    }

    @Override
    public ProductModel findByID(Long id) {
        String sql = "SELECT * FROM product WHERE id =?";
        List<ProductModel> productModel = findByProperties(sql, new ProductMapper(), id);
        return productModel.isEmpty() ? null : productModel.get(0);
    }

    @Override
    public List<ProductModel> findAllProduct(PageAble pageAble) {
        String sql = "SELECT * FROM product";
        if (pageAble.getPage() != 0 && pageAble.getLimit() != 0) {
            sql += " LIMIT " + pageAble.getLimit() + " OFFSET " + pageAble.getObset();
        }
        return findByProperties(sql, new ProductMapper());
    }

    @Override
    public long countAllProduct() {
        String sql = "SELECT COUNT(*) FROM product";
        return countAll(sql);
    }

}
