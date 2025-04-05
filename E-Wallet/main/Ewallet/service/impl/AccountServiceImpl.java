package Ewallet.service.impl;

import Ewallet.model.Account;
import Ewallet.model.WalletSystem;
import Ewallet.service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private WalletSystem walletSystem = new WalletSystem();
    private List<Account> accounts = walletSystem.getAccounts();
    @Override
    public boolean createAccount(Account account) {

        for(int i=0;i<accounts.size();i++){ // 0    0<5   0 1 2 3 4
            if (isAccountExist(account.getUserName())){
                return false;
            }
        }

        walletSystem.getAccounts().add(account);
        return true;
    }

    @Override
    public boolean findAccount(Account account) {
        for(int i=0;i<accounts.size();i++){ // 0    0<5   0 1 2 3 4
            if (accounts.get(i).getUserName().equals(account.getUserName())
                    && accounts.get(i).getPassword().equals(account.getPassword())){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deposit(Account account, double money) {
        /* TODO
         * check if account exist on ewallet if account not exist return false
         * add  money to account if success return true
         * */
         if (account == null || money <= 0) {
                return false;
         }

        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName())) { // match based on unique ID
                account.setBalance(acc.getBalance() + money);
                return true;
            }
        }
         return false;
    }

    @Override
    public boolean withdraw(Account account, double money) {
        /*  TODO
         * check if account exist on ewallet if account not exist return false
         * check if money (greater than) of account balance return false
         * cut  money from account if success return true
         * */

        if (account == null || money <= 0) {
            return false;
        }
        for (Account acc : accounts) {
            if (isAccountExist(acc.getUserName()) && acc.getUserName().equals(account.getUserName())) {
                if(account.getBalance() >= money){
                    account.setBalance(account.getBalance() - money);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean transfer(Account account, String transferAccount, double money) {

        /*  TODO
         * check if account exist on ewallet if account not exist return false
         * check if transferAccount exist on ewallet if account not exist return false
         * check if money (greater than) of account balance return false
         * cut money from account if and add to transferAccount success return true
         * */
        if (!isAccountExist(account.getUserName())) {

            return false;
        }


        Account receiver = null;
        for (Account acc : accounts) {
            if (acc.getUserName().equals(transferAccount)) {
                receiver = acc;
                break;
            }
        }


        if (receiver == null) {
            return false;
        }


        if (account.getBalance() < money) {
            return false;
        }

        account.setBalance(account.getBalance() - money);
        receiver.setBalance(receiver.getBalance() + money);
        return true;

    }

    @Override
    public  Account showProfileDetails(Account account) {
        /* TODO
             check if account exist on ewallet if account not exist return false
             if exist return account  if not exist return null

         */
        if (account == null) {
            return null;
        }
        for (Account acc : accounts) {
            if (isAccountExist(acc.getUserName()) && acc.getUserName().equals(account.getUserName()))
            {
                System.out.println("Detils of acc " + account.getUserName());
                return account;
            }
        }
        return null;
    }

    // TODO pirvate function to check if account exist on ewallet

    private boolean isAccountExist(String accountUserName) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(accountUserName)) {
                return true;
            }
        }
        return false;
    }
}
