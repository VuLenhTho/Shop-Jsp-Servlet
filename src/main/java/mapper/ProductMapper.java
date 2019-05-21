package mapper;

import model.ProductModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class ProductMapper implements RowMapper<ProductModel> {
    @Override
    public ProductModel map(ResultSet rs) {
        return MapUtil.mapRow(new ProductModel(),rs);
    }
}
