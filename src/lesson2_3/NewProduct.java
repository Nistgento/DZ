package lesson2_3;

import javax.annotation.processing.SupportedSourceVersion;
import java.time.LocalDate;

public class NewProduct {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Xaiomi",
                LocalDate.of(2025, 2, 1),
                "Xiaomi corp",
                "China",
                5555.99,
                true);

        productsArray[1] = new Product("IPhone",
                LocalDate.of(2024, 1, 5),
                "Apple",
                "USA",
                6666.99,
                true);

        productsArray[2] = new Product("Sumsung",
                LocalDate.of(2023, 5, 8),
                "Sumsung inc",
                "Korea",
                6669.99,
                false);
        productsArray[3] = new Product("POCO",
                LocalDate.of(2021, 3, 15),
                "Xiaomi",
                "China",
                3344.99,
                true);
        productsArray[4] = new Product("Honor",
                LocalDate.of(2020, 12, 20),
                "Honor",
                "Korea",
                2215.59,
                false);
        System.out.println("List of products:");
        System.out.println("                 ");
        for (Product product : productsArray) {
            product.printProductInfo();
        }
    }
}
class Product {
    private final String name;
    private final LocalDate productionDate;
    private final String manufacturer;
    private final String countryOfOrigin;
    private final double price;
    private boolean isReserved;

    public Product(String name, LocalDate productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printProductInfo() {
        System.out.println("Information:");
        System.out.println("Name: " + name);
        System.out.println("Production Date: " + productionDate);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Country Of Origin: " + countryOfOrigin);
        System.out.println("Price: " + price);
        System.out.println("Reserved: " + isReserved);
        System.out.println("                       ");
    }
    public String getName() {
        return name;
    }
    public LocalDate getProductionDate() {
        return productionDate;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    public double getPrice() {
        return price;
    }
    public boolean isReserved() {
        return isReserved;
    }
    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
}