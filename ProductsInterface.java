import java.util.List;
import java.util.Scanner;

public interface ProductsInterface {

    default void displayProducts(OnlineStore store) {
        Scanner console = new Scanner(System.in);
        int option;
        List<Product> products = null;
        System.out.println("1. Default");
        System.out.println("2. Sort by name");
        System.out.println("3. Sort by name reverse");
        System.out.println("4. Sort by price");
        System.out.println("5. Sort by price reverse");
        if (console.hasNextInt())
            option = console.nextInt();
        else option = -1;
        console.nextLine();
        switch (option) {
            case 1:
                products = store.getProducts();
                break;
            case 2:
                products = store.getProductsSorted(new CompareName());
                break;
            case 3:
                products = store.getProductsSorted(new CompareName().reversed());
                break;
            case 4:
                products = store.getProductsSorted(new ComparePrice());
                break;
            case 5:
                products = store.getProductsSorted(new ComparePrice().reversed());
                break;
            default:
                System.out.println("Not an option");
                break;
        }
        if (option >= 1 && option <= 5) {
            System.out.println("Products list:");
            for (Product product : products) System.out.println(product);
        }
    }
}
