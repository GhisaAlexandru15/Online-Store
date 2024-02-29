import java.util.List;
import java.util.Scanner;

public interface ShoppingCartInterface {

    default void shoppingCart(OnlineStore store, String username) {
        Scanner console = new Scanner(System.in);
        int option, id, quantity;
        List<Product> products = store.getProducts();
        do {
            System.out.println("0. Continue shopping");
            System.out.println("1. Add to cart");
            System.out.println("2. Remove from cart");
            System.out.println("3. Display shopping cart");
            System.out.println("4. Checkout");
            if (console.hasNextInt())
                option = console.nextInt();
            else option = -1;
            console.nextLine();
            switch (option) {
                case 0:

                    break;
                case 1:
                    System.out.println("Products list:");
                    for (Product value : products) System.out.println(value);
                    System.out.println("Product id: ");
                    if (console.hasNextInt())
                        id = console.nextInt();
                    else {
                        id = -1;
                        console.nextLine();
                    }
                    if (!products.contains(new Product(id, "", 0, 0)))
                        System.out.println("Invalid Id");
                    else {
                        System.out.println("Quantity: ");
                        quantity = console.nextInt();
                        if (quantity <= 0)
                            System.out.println("Quantity must be positive");
                        else {
                            for (Product product : products)
                                if (product.equals(new Product(id, "", 0, 0)))
                                    store.addToCart(username, product, quantity);
                            System.out.println(quantity + " products added");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Shopping cart:");
                    System.out.println(store.getShoppingCartList(username));
                    System.out.println("Product id: ");
                    if (console.hasNextInt())
                        id = console.nextInt();
                    else {
                        id = -1;
                        console.nextLine();
                    }
                    if (!products.contains(new Product(id, "", 0, 0)))
                        System.out.println("Invalid Id");
                    else
                        for (Product product : products)
                            if (product.equals(new Product(id, "", 0, 0)))
                                store.removeFromCart(username, product);


                    break;
                case 3:
                    System.out.println("Shopping cart:");
                    System.out.println(store.getShoppingCartList(username));
                    System.out.println("Total price: " + store.getTotalPrice(username));
                    break;
                case 4:
                    System.out.println("Order received");
                    System.out.println(store.getSessionDetails(username));
                    store.removeShoppingCart(username);
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }

        } while (option != 0 && option != 4);
    }
}
