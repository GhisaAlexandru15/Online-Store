import java.util.Scanner;

public interface OnlineStoreInterface extends ShoppingCartInterface, ProductsInterface {
    default void onlineStore(OnlineStore store, String username) {
        Scanner console = new Scanner(System.in);
        int option;
        do {
            System.out.println("0. Logout");
            System.out.println("1. Display products");
            System.out.println("2. Shopping cart");
            if (console.hasNextInt())
                option = console.nextInt();
            else option = -1;
            console.nextLine();
            switch (option) {
                case 0:
                    break;
                case 1:
                    displayProducts(store);
                    break;
                case 2:
                    shoppingCart(store, username);
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        } while (option != 0);
    }
}
