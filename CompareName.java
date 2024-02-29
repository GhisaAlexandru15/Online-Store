import java.util.Comparator;

public class CompareName implements Comparator<Product> {
    @Override
    public int compare(Product product, Product product2) {
        return product.name.compareTo(product2.name);
    }

    @Override
    public Comparator<Product> reversed() {
        return Comparator.super.reversed();
    }
}
