package Entity.DatabaseClass;

import Entity.AccountClass.Account;

public class AccountDB extends Database {
    
    /** 
     * Account Database Constructor.
     */
    public AccountDB() {
        super("account_list.xlsx", new Account());
    }

    /**
     * Method to find instance of Account object in AccountDB, matched by the User ID, not case sensitive.
     * @param id Input User ID to be found
     * @return Account object
     */
    public Account findInstance(String id) {
        for(Object a : super.objectDB) {
            Account temp = (Account) a;
            String correctID = temp.getUserID().toLowerCase();
            if(correctID.compareTo(id.toLowerCase())==0){
                return temp;
            }
        }
        return new Account();
    }
    
    // only for debugging and trialing purposes
    public void viewDB() {
        for(Object a : super.objectDB) {
            Account temp = (Account) a;
            System.out.println(temp.getUserID() + ", " + temp.getPassword() + ", " + temp.getType());
        }
    }
    
}
