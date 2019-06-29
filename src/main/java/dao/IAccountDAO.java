package dao;

import model.AccountModel;
import paging.PageAble;

import java.util.List;

public interface IAccountDAO extends IGenericDAO<AccountModel>{
    void insertAccount(AccountModel accountModel);

    void updateAccount(Long id, AccountModel accountModel);

    void deleteAccount(Long id);

    List<AccountModel> findAllAccount(PageAble pageAble);

    AccountModel findByUserNameAndPassword(String userName, String password);

    AccountModel findByID(Long id);

    long countAllAccount();
}
