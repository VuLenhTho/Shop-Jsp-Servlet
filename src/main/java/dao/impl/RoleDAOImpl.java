package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.RoleModel;

import java.util.List;

public class RoleDAOImpl extends AbstractDAO<RoleModel> implements IRoleDAO {
    @Override
    public void insertRole(RoleModel roleModel) {
        String sql = "INSERT INTO role(roleName) VALUE(?)";
        insertUpdateDelete(sql, roleModel.getRoleName());
    }

    @Override
    public void updateRole(Integer id, RoleModel roleModel) {
        String sql = "UPDATE role SET roleName= ? WHERE id =?";
        insertUpdateDelete(sql, roleModel.getRoleName(), id);
    }

    @Override
    public void deleteRole(Integer id) {
        String sql = "DELETE FROM role WHERE id =?";
        insertUpdateDelete(sql, id);
    }

    @Override
    public RoleModel findByID(Integer id) {
        String sql = "SELECT * FROM role WHERE id =? ";
        List<RoleModel> roleModel = findByProperties(sql, new RoleMapper(), id);
        return roleModel.isEmpty() ? null : roleModel.get(0);
    }

    @Override
    public List<RoleModel> findAllRole() {
        String sql = "SELECT * FROM role";
        List<RoleModel> roleModels = findByProperties(sql, new RoleMapper());
        return roleModels.isEmpty() ? null : roleModels;
    }
}
