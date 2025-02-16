package app.list;

import app.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    public List<Product> getList() {
        List<Product> product = new ArrayList<>();
        product.add(new Product("Egg", 100, 0.2));
        product.add(new Product("Kiwi", 50, 12.5));
        product.add(new Product("Pineapple", 35, 20));
        return product;
    }
}
