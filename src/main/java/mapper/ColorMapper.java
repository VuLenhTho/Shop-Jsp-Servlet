package mapper;

import model.ColorModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class ColorMapper implements RowMapper<ColorModel> {

    @Override
    public ColorModel map(ResultSet rs) {
        return MapUtil.mapRow(new ColorModel(),rs);
    }
}
