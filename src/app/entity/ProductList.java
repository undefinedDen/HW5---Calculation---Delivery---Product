package app.entity;

import java.util.List;

public class ProductList {
    public void getFruit(List<Product> diaryProduct) {
        diaryProduct.add(new Product("Egg", 100, 0.2));
        diaryProduct.add(new Product("Kiwi", 50, 12.5));
        diaryProduct.add(new Product("Pineapple", 35, 20));
    }
}
