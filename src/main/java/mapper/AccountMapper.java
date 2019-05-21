package mapper;

import model.AccountModel;
import utils.MapUtil;

import java.sql.ResultSet;

public class AccountMapper implements RowMapper<AccountModel> {
    @Override
    public AccountModel map(ResultSet rs) {
        return MapUtil.mapRow(new AccountModel(),rs);
    }
}
