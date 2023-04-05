package Users.UserDetails;
public abstract class User implements UserInterface {

	private String userID;
	private String name;
	private String email;
	UserType type;

	/**
	 * 
	 * @param userID
	 */

	public User(){

	};
	
	public User(String userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
	}

	public String getUserID() {
		return this.userID;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setUserID(String id) {
		this.userID = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserType(UserType inputType){
		this.type = inputType;
	}

	@Override
	public void showMenu() {
		System.out.println("=======================================");
        System.out.println("   Welcome to FYP Management System!   ");
        System.out.println("=======================================");
        System.out.printf("You are currently signed in as a %s.\n", type);
   	}

	abstract public void viewUserMenu();
	// abstract public userType getUserType();
}