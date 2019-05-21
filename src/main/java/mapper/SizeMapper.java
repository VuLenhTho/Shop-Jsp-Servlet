package mapper;

import model.SizeModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class SizeMapper implements RowMapper<SizeModel> {
    @Override
    public SizeModel map(ResultSet rs) {
        return MapUtil.mapRow(new SizeModel(),rs);
    }
}
