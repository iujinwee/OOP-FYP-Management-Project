package Login;

import java.util.ArrayList;
import FileManager.FileReader;


public class AccountDB {

	private ArrayList<Object> studentAccList;
	private ArrayList<Object> supervisorAccList;
	private ArrayList<Object> fypcoordAccList;

	public AccountDB() {
		studentAccList = FileReader.readExcelFile("student_list.xlsx", new Account());
		supervisorAccList = FileReader.readExcelFile("faculty_list.xlsx", new Account());
		fypcoordAccList = FileReader.readExcelFile("FYP coordinator.xlsx", new Account());
	}

	public boolean changePassword(Account account, String newPassword) {
		
	}

}