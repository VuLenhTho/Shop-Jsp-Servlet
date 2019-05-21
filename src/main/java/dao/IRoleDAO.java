package dao;

import model.RoleModel;

import java.util.List;

public interface IRoleDAO extends IGenericDAO<RoleModel> {
    void insertRole(RoleModel roleModel);

    void updateRole(Integer id, RoleModel roleModel);

    void deleteRole(Integer id);

    RoleModel findByID(Integer id);

    List<RoleModel> findAllRole();

}
