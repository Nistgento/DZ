package lesson2_3;

import java.time.LocalDate;

public class Product {
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
    }
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
    public static void main(String[] args) {
        Product product = new Product(
                "SmatPhome Redmi X Note Pro",
                LocalDate.of(2025, 5, 30),
                "Xiaomi",
                "China",
                30000,
                false
        );
        product.printProductInfo();
    }
}

