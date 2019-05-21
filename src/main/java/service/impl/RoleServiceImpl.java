package service.impl;

import dao.IRoleDAO;
import dao.impl.RoleDAOImpl;
import model.RoleModel;
import service.IRoleService;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    private IRoleDAO roleDAO;

    public RoleServiceImpl() {
        roleDAO = new RoleDAOImpl();
    }

    @Override
    public void insertRole(RoleModel roleModel) {
        roleDAO.insertRole(roleModel);
    }

    @Override
    public void updateRole(RoleModel roleModel) {
        roleDAO.updateRole(roleModel.getId(),roleModel);
    }

    @Override
    public void deleteRole(Integer id) {
        roleDAO.deleteRole(id);
    }

    @Override
    public RoleModel findByID(Integer id) {
        return roleDAO.findByID(id);
    }

    @Override
    public List<RoleModel> findAllRole() {
        return roleDAO.findAllRole();
    }
}
