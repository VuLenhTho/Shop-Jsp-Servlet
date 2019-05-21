package dao.impl;

import dao.IDiscountDAO;
import mapper.DiscountMapper;
import model.DiscountModel;

import java.util.List;

public class DiscountDAOImpl extends AbstractDAO<DiscountModel> implements IDiscountDAO {
    @Override
    public void insertDiscount(DiscountModel discountModel) {
        String sql = "INSERT INTO discount(discountName, percent, startDate," +
                " endDate,createdBy,createdDate) " +
                "VALUE (?,?,?,?,?,?)";
        insertUpdateDelete(sql,discountModel.getDiscountName(),discountModel.getPercent(),
                discountModel.getStartDate(),discountModel.getEndDate(),
                discountModel.getCreatedBy(),discountModel.getCreatedDate());
    }

    @Override
    public void updateDiscount(Long id, DiscountModel discountModel) {
        String sql = "UPDATE discount SET discountName=?,  percent=?, startDate=?," +
                " endDate=?,modifiedBy=?,modifiedDate=? WHERE id=? ";
        insertUpdateDelete(sql,discountModel.getDiscountName(),discountModel.getPercent(),
                discountModel.getStartDate(),discountModel.getEndDate(),
                discountModel.getModifiedBy(),discountModel.getModifiedDate(),id);
    }

    @Override
    public void deleteDiscount(Long id) {
        String sql = "DELETE FROM discount WHERE id =?";
        insertUpdateDelete(sql,id);
    }

    @Override
    public DiscountModel findByID(Long id) {
        String sql = "SELECT * FROM discount WHERE id= ?";
        List<DiscountModel> discountModel = findByProperties(sql,new DiscountMapper(),id);
        return discountModel.isEmpty() ? null : discountModel.get(0);
    }

    @Override
    public List<DiscountModel> findAllDiscount() {
        String sql = "SELECT * FROM discount";
        List<DiscountModel> discountModel = findByProperties(sql,new DiscountMapper());
        return discountModel.isEmpty() ? null : discountModel;
    }
}
