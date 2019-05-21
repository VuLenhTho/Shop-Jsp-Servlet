package mapper;

import model.RoleModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class RoleMapper  implements RowMapper<RoleModel> {
    @Override
    public RoleModel map(ResultSet rs) {
        return MapUtil.mapRow(new RoleModel(),rs);
    }
}
