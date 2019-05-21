package service.impl;

import dao.IAccountDAO;
import dao.impl.AccountDAOImpl;
import model.AccountModel;
import model.request.AccountRequest;
import service.IAccountService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
    }

    @Override
    public void insertAccount(AccountModel accountModel) {
        Date date = new Date();
        accountModel.setCreatedDate(new Timestamp(date.getTime()));
        accountDAO.insertAccount(accountModel);
    }

    @Override
    public void updateAccount(AccountModel accountModel) {
        accountDAO.updateAccount(accountModel.getId(),accountModel);
    }

    @Override
    public void deleteAccount(Long id) {
        accountDAO.deleteAccount(id);
    }

    @Override
    public List<AccountModel> findAllAccount() {
        return accountDAO.findAllAccount();
    }

    @Override
    public AccountModel findByUserNameAndPassword(AccountRequest accountRequest) {
        return accountDAO.findByUserNameAndPassword(accountRequest.getUserName(),accountRequest.getPassword());
    }

    @Override
    public AccountModel findByID(Long id) {
        return accountDAO.findByID(id);
    }
}
