package service;

import model.AccountModel;
import model.request.AccountRequest;

import java.util.List;

public interface IAccountService {
    void insertAccount(AccountModel accountModel);

    void updateAccount(AccountModel accountModel);

    void deleteAccount(Long id);

    List<AccountModel> findAllAccount();

    AccountModel findByUserNameAndPassword(AccountRequest accountRequest);

    AccountModel findByID(Long id);
}
