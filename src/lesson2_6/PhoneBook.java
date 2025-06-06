package lesson2_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Smit", "+7 (123) 456-78-90");
        phoneBook.add("Pirs", "+7 (987) 654-32-10");
        phoneBook.add("Smit", "+7 (555) 123-45-67");

        System.out.println("Smit: " + phoneBook.get("Smit"));
        System.out.println("Pirs: " + phoneBook.get("Pirs"));
        System.out.println("Nom: " + phoneBook.get("Nom"));
    }
}