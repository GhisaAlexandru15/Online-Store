import java.util.Comparator;

public class ComparePrice implements Comparator<Product> {
    @Override
    public int compare(Product product, Product product2) {
        return Float.compare(product.price, product2.price);
    }

    @Override
    public Comparator<Product> reversed() {
        return Comparator.super.reversed();
    }
}
