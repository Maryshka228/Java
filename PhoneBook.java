package Project;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, Integer> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addPhoneNumber(String name, int phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneBook.get(name) + 1);
        } else {
            phoneBook.put(name, 1);
        }
    }

    public void displayPhoneBook() {
        phoneBook.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumber("Вася Пупкин", 123456789);
        phoneBook.addPhoneNumber("Иван Петрович", 987654321);
        phoneBook.addPhoneNumber("Вася Пупкин", 987654321);
        phoneBook.addPhoneNumber("Петя Смирнов", 123456789);
        phoneBook.addPhoneNumber("Иван Петрович", 111222333);

        phoneBook.displayPhoneBook();
    }
}
