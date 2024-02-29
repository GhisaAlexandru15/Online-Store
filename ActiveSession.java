import java.util.Map;

public class ActiveSession {
    private float totalPrice;
    private final String username;
    private final Map<Product, Integer> shoppingCart;

    public ActiveSession(String username, Map<Product, Integer> shoppingCart) {
        this.username = username;
        this.shoppingCart = shoppingCart;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public int addToCart(Product product, int quantity) {
        if (quantity > product.quantity)
            System.out.println("Only " + product.quantity + " products available");
        else {
            shoppingCart.put(product, quantity);
            totalPrice = totalPrice + product.price * quantity;
            product.quantity = product.quantity - quantity;
        }
        return product.quantity;
    }

    public int removeFromCart(Product product) {
        if (shoppingCart.containsKey(product)) {
            totalPrice = totalPrice - product.price * shoppingCart.get(product);
            product.quantity = product.quantity + shoppingCart.get(product);
            shoppingCart.remove(product);
        }
        return product.quantity;
    }

    public String getShoppingCartList() {
        StringBuilder shoppingCartList=new StringBuilder();
        for (Map.Entry<Product, Integer> product : shoppingCart.entrySet()) {
            shoppingCartList.append(product.getKey()).append(" x").append(product.getValue()).append('\n');
        }
        return shoppingCartList.toString();
    }

    public void removeShoppingCart() {
        shoppingCart.clear();
        totalPrice = 0;
    }

    @Override
    public String toString() {
        return "ActiveSession{\n" +
                "totalPrice=" + totalPrice +
                ", username='" + username + '\'' +
                ", shoppingCart=\n" + getShoppingCartList() +
                '}';
    }
}
