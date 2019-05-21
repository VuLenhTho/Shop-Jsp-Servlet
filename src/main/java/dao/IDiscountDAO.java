package dao;

import model.DiscountModel;

import java.util.List;

public interface IDiscountDAO extends IGenericDAO<DiscountModel> {
    void insertDiscount(DiscountModel discountModel);

    void updateDiscount(Long id, DiscountModel discountModel);

    void deleteDiscount(Long id);

    DiscountModel findByID(Long id);

    List<DiscountModel> findAllDiscount();
}
