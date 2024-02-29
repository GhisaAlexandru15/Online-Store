import java.util.*;

public class Exercise3 {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Set<User> users = new HashSet<>();
        Set<String> usernames = new HashSet<>();
        Map<String, ActiveSession> sessions = new HashMap<>();
        User admin = new User("admin", "admin");
        users.add(admin);
        usernames.add(admin.getUsername());
        Product product1 = new Product(2357, "apa", 5.76F, 100);
        Product product2 = new Product(3859, "suc", 55.54F, 10);
        Product product3 = new Product(165, "paine", 27.10F, 20);
        Product product4 = new Product(1237, "salam", 100.34F, 3);
        Product product5 = new Product(1358, "unt", 14.34F, 3);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        OnlineStore onlineStore = new OnlineStore(products, sessions);
        LoginSystem loginSystem = new LoginSystem(users, usernames, onlineStore);
        UserInterface userInterface = new UserInterface(loginSystem, onlineStore);

        userInterface.loadInterface();
    }
}
