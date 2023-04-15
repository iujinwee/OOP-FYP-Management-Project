import Controller.WelcomePage;
import Controller.Account.Login;

public class App {

	public static void main(String[] args) {
        // Welcome Page
        new WelcomePage(); 

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. Once 5 attempts up, terminate program)
        new Login();
    }
}