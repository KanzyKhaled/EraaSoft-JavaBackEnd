package Ewallet.model;

import java.util.ArrayList;
import java.util.List;

public class WalletSystem {

    private final String walletName = "EraaSoft Wallet";

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    public String getWalletName() {
        return walletName;
    }
}