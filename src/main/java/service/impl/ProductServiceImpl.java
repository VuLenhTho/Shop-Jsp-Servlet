package service.impl;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import model.AccountModel;
import model.ProductModel;
import paging.PageAble;
import service.IProductService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductDAO productDAO;

    public ProductServiceImpl() {
        productDAO = new ProductDAOImpl();
    }

    @Override
    public void insertProduct(HttpServletRequest request, ProductModel productModel) {
        Date date = new Date();
        AccountModel accountModel = (AccountModel) SessionUtil.getValue(request,"USER");
        productModel.setCreatedDate(new Timestamp(date.getTime()));
        productModel.setCreatedBy(accountModel.getUserName());
        productModel.setStatus("TRADING");
        productDAO.insertProduct(productModel);
    }

    @Override
    public void updateProduct(HttpServletRequest request, ProductModel productModel) {
        Date date = new Date();
        AccountModel accountModel = (AccountModel) SessionUtil.getValue(request,"USER");
        productModel.setModifiedDate(new Timestamp(date.getTime()));
        productModel.setModifiedBy(accountModel.getUserName());
        productDAO.updateProduct(productModel.getId(),productModel);
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }

    @Override
    public ProductModel findByID(Long id) {
        return productDAO.findByID(id);
    }

    @Override
    public List<ProductModel> findAllProduct(PageAble pageAble) {
        return productDAO.findAllProduct(pageAble);
    }

    @Override
    public long countAllProduct() {
        return productDAO.countAllProduct();
    }


}
