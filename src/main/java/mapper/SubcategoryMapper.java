package mapper;

import model.SubcategoryModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class SubcategoryMapper implements RowMapper<SubcategoryModel> {
    @Override
    public SubcategoryModel map(ResultSet rs) {
        return MapUtil.mapRow(new SubcategoryModel(),rs);
    }
}
