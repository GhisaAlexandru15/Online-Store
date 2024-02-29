import java.util.Set;

public class LoginSystem {
    private final Set<User> users;
    private final Set<String> usernames;
    private final OnlineStore store;

    public LoginSystem(Set<User> users, Set<String> usernames, OnlineStore store) {
        this.users = users;
        this.usernames = usernames;
        this.store = store;
    }

    public boolean checkUsername(String username) {
        return usernames.contains(username);
    }

    public boolean register(String username, String password) {
        User user = new User(username, password);
        if (!checkUsername(username)) {
            users.add(user);
            usernames.add(username);
            return true;
        } else return false;
    }

    public boolean login(String username, String password) {
        User user = new User(username, password);
        if (users.contains(user)) {
            store.addSession(username);
            return true;
        } else return false;
    }

    public boolean logout(String username) {
        store.removeSession(username);
        return true;
    }
}
