package mapper;

import model.CategoryModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel map(ResultSet rs) {
        return MapUtil.mapRow(new CategoryModel(),rs);
    }
}
