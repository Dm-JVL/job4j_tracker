package ru.job4j.pojo;

public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }


    public static void Print(Product[] products){
        for (int i = 0; i < products.length; i++) {
            Product temp = products[i];
            if (temp != null) {
                System.out.println("Index: " + i + " " + temp.toString());
            } else {
                System.out.println("Index: " + i + " null");
            }
        }
    }
}

