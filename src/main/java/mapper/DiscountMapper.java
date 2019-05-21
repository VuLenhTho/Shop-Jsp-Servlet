package mapper;

import model.DiscountModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class DiscountMapper implements RowMapper<DiscountModel> {
    @Override
    public DiscountModel map(ResultSet rs) {
        return MapUtil.mapRow(new DiscountModel(),rs);
    }
}
