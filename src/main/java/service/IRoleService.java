package service;

import model.RoleModel;

import java.util.List;

public interface IRoleService {
    void insertRole(RoleModel roleModel);

    void updateRole(RoleModel roleModel);

    void deleteRole(Integer id);

    RoleModel findByID(Integer id);

    List<RoleModel> findAllRole();
}
