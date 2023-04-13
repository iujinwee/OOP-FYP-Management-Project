package Entity.DatabaseClass;

import Login.Account;

public class AccountDB extends Database {
    
    public AccountDB() {
        super("account_list.xlsx", new Account());
    }

    public Account findInstance(String id) {
        for(Object a : super.objectDB) {
            Account temp = (Account) a;
            String correctID = temp.getUserID().toLowerCase();
            if(correctID.compareTo(id.toLowerCase())==0){
                return temp;
            }
        }
        return null;
    }

    public void showDB() {
        for(Object a : super.objectDB) {
            Account temp = (Account) a;
            System.out.println(temp.getUserID() + ", " + temp.getPassword() + ", " + temp.getType());
        }
    }
    
    public void changePassword(Account account, String newPassword) {
        Account temp = this.findInstance(account.getUserID());
        if(temp.changePassword(newPassword)) {
            super.exportDB();
        }
    }
    
    
}
