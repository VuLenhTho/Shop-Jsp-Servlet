package mapper;

import model.SexModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class SexMapper implements RowMapper<SexModel> {
    @Override
    public SexModel map(ResultSet rs) {
        return MapUtil.mapRow(new SexModel(),rs);
    }
}
