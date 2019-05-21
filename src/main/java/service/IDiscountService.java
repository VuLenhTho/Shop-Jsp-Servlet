package service;

import model.DiscountModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IDiscountService {
    void insertDiscount(HttpServletRequest request, DiscountModel discountModel);

    void updateDiscount(HttpServletRequest request, DiscountModel discountModel);

    void deleteDiscount(Long id);

    DiscountModel findByID(Long id);

    List<DiscountModel> findAllDiscount();
}
