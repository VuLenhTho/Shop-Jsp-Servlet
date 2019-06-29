package service;

import model.AccountModel;
import model.request.AccountRequest;
import paging.PageAble;

import java.util.List;

public interface IAccountService {
    void insertAccount(AccountModel accountModel);

    void updateAccount(AccountModel accountModel);

    void deleteAccount(Long id);

    List<AccountModel> findAllAccount(PageAble pageAble);

    AccountModel findByUserNameAndPassword(AccountRequest accountRequest);

    AccountModel findByID(Long id);

    long countAllAccount();
}
