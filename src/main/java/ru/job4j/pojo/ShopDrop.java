package ru.job4j.pojo;

import static ru.job4j.pojo.Product.Print;
import static ru.job4j.pojo.Shop.indexOfNull;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        if (index != -1) {
            for (int i = index; i < products.length - 1; i++) {
                products[i] = products[i + 1];
            }
            products[products.length-1] = null;
            return products;
        } else return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[1] = null;
        System.out.println("List1:");
        Print(products);
        products = leftShift(products, indexOfNull(products));
        System.out.println("List2:");
        Print(products);
    }
}


