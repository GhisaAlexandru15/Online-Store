import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineStore {
    private final List<Product> products;
    private final Map<String, ActiveSession> sessions;

    public OnlineStore(List<Product> products, Map<String, ActiveSession> sessions) {
        this.products = products;
        this.sessions = sessions;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsSorted(Comparator<Product> sortCriteria) {
        products.sort(sortCriteria);
        return products;
    }

    public void addSession(String username) {
        Map<Product, Integer> shoppingCart = new HashMap<>();
        ActiveSession session = new ActiveSession(username, shoppingCart);
        sessions.put(username, session);
    }

    public void removeSession(String username) {
        sessions.remove(username);
    }


    public String getShoppingCartList(String username) {
        return sessions.get(username).getShoppingCartList();
    }

    public float getTotalPrice(String username) {
        return sessions.get(username).getTotalPrice();
    }

    public void addToCart(String username, Product product, int quantity) {
        product.quantity = sessions.get(username).addToCart(product, quantity);
    }

    public void removeFromCart(String username, Product product) {
        product.quantity = sessions.get(username).removeFromCart(product);
    }

    public void removeShoppingCart(String username) {
        sessions.get(username).removeShoppingCart();
    }

    public String getSessionDetails(String username) {
        return sessions.get(username).toString();
    }
}
