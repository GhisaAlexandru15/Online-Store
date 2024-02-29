import java.util.*;

public class UserInterface implements OnlineStoreInterface {
    private final LoginSystem loginSystem;
    private final OnlineStore store;

    public UserInterface(LoginSystem loginSystem, OnlineStore store) {
        this.loginSystem = loginSystem;
        this.store = store;
    }

    public void loadInterface() {
        String username;
        String password;

        Scanner console = new Scanner(System.in);
        int option;
        do {
            System.out.println("0. Exit");
            System.out.println("1. Login");
            System.out.println("2. Register");
            if (console.hasNextInt())
                option = console.nextInt();
            else
                option = -1;
            console.nextLine();
            switch (option) {
                case 0:

                    break;
                case 1:
                    System.out.println("Username: ");
                    username = console.nextLine();
                    System.out.println("Password: ");
                    password = console.nextLine();
                    if (loginSystem.login(username, password)) {
                        onlineStore(store, username);
                        if (loginSystem.logout(username))
                            System.out.println("Logged off");
                    } else if (loginSystem.checkUsername(username))
                        System.out.println("Wrong password");
                    else System.out.println("Account doesn't exist");
                    break;
                case 2:
                    System.out.println("Username: ");
                    username = console.nextLine();
                    System.out.println("Password: ");
                    password = console.nextLine();
                    if (loginSystem.register(username, password))
                        System.out.println("Account created");
                    else System.out.println("Username already used");
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        } while (option != 0);
    }
}
