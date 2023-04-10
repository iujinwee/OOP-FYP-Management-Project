package Login;

import java.util.ArrayList;


public class AccountDB {

	public AccountDB() {
		// studentAccList = FileReader.readExcelFile("student_list.xlsx", new Account());
		// supervisorAccList = FileReader.readExcelFile("faculty_list.xlsx", new Account());
		// fypcoordAccList = FileReader.readExcelFile("FYP coordinator.xlsx", new Account());
	}

	/**
	 * Update 
	 * @param account 
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(Account account, String newPassword) {
		return false;
		// iterate through studentAccList
			// if temp matches account, then temp.changePassword(newPassword) and return true
		// iterate through supervisorAccList 
	}
	
	/**
	 * Find the corresponding Account object from AccountDB given an input User ID.
	 * @param userID 
	 * @return 
	 */
	public Account findAcc(String UserID) {
		return null;
		
	}
}