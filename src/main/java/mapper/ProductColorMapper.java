package mapper;

import model.ProductColorModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class ProductColorMapper implements RowMapper<ProductColorModel>{

    @Override
    public ProductColorModel map(ResultSet rs) {
        return MapUtil.mapRow(new ProductColorModel(), rs);
    }
}
