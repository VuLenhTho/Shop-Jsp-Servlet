package service.impl;

import dao.IDiscountDAO;
import dao.impl.DiscountDAOImpl;
import model.AccountModel;
import model.DiscountModel;
import service.IDiscountService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class DiscountServiceImpl implements IDiscountService {
    private IDiscountDAO discountDAO;

    public DiscountServiceImpl() {
        discountDAO = new DiscountDAOImpl();
    }

    @Override
    public void insertDiscount(HttpServletRequest request, DiscountModel discountModel) {
        Date date = new Date();
        AccountModel accountModel = (AccountModel) SessionUtil.getValue(request,"USER");
        discountModel.setCreatedBy(accountModel.getUserName());
        discountModel.setCreatedDate(new Timestamp(date.getTime()));
        discountDAO.insertDiscount(discountModel);
    }

    @Override
    public void updateDiscount(HttpServletRequest request, DiscountModel discountModel) {
        Date date = new Date();
        AccountModel accountModel = (AccountModel) SessionUtil.getValue(request,"USER");
        discountModel.setModifiedBy(accountModel.getUserName());
        discountModel.setModifiedDate(new Timestamp(date.getTime()));
        discountDAO.updateDiscount(discountModel.getId(),discountModel);
    }

    @Override
    public void deleteDiscount(Long id) {
        discountDAO.deleteDiscount(id);
    }

    @Override
    public DiscountModel findByID(Long id) {
        return discountDAO.findByID(id);
    }

    @Override
    public List<DiscountModel> findAllDiscount() {
        return discountDAO.findAllDiscount();
    }
}
