package Database;

import Login.Account;

public class AccountDB extends Database {
    
    public AccountDB() {
        super("account_list.xlsx", new Account());
    }

    @Override
    public Account findInstance(String id) {
        for(Object a : super.objectDB) {
            Account currentAccount = (Account) a;
            if(currentAccount.getUserID().compareTo(id)==0){
                return currentAccount;
            }
        }
        return new Account();
    }

    public void changePassword(Account account, String newPassword) {
        Account temp = this.findInstance(account.getUserID());
        temp.changePassword(newPassword);
    }
}
