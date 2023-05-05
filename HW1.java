// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.*;

public class HW1 {
    private class Contact {
        private Set<String> phoneNumbers;

        public Contact() {
            this.phoneNumbers = new HashSet<>();
        }

        public void addPhoneNumber(String phoneNumber) {
            this.phoneNumbers.add(phoneNumber);
        }

        public Set<String> getPhoneNumbers() {
            return this.phoneNumbers;
        }
    }

    private Map<String, Contact> contacts;
    private Scanner scanner;

    public HW1() {
        this.contacts = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Введите имя нового контакта: ");
        String name = scanner.nextLine();
        Contact contact = contacts.get(name);
        if (contact == null) {
            contact = new Contact();
            contacts.put(name, contact);
        }
        addPhoneNumber(contact);
    }

    public void addPhoneNumber(Contact contact) {
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        contact.addPhoneNumber(phoneNumber);
        System.out.println("Номер добавлен.");
    }

    public void addPhoneNumberToContact() {
        System.out.print("Введите имя контакта: ");
        String name = scanner.nextLine();
        Contact contact = contacts.get(name);
        if (contact == null) {
            System.out.println("Контакт не найден.");
            return;
        }
        addPhoneNumber(contact);
    }

    public void searchContacts() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        if (!contacts.containsKey(name)) {
            System.out.println("Контакт не найден.");
            return;
        }
        System.out.println(name + ": " + contacts.get(name).getPhoneNumbers());
    }

    public void printPhoneBook() {
        for (String name : contacts.keySet()) {
            System.out.println(name + ": " + contacts.get(name).getPhoneNumbers());
        }
    }

    public static void main(String[] args) {
        HW1 phoneBook = new HW1();
        int choice = -1;
        while (choice != 0) {
            System.out.println("\nВыберите действие:\n"
                    + "1 - Создать контакт\n"
                    + "2 - Добавить номер в существующий контакт\n"
                    + "3 - Поиск контактов (по имени)\n"
                    + "4 - Вывод телефонной книги\n"
                    + "0 - Выход");
            System.out.print("Ваш выбор: ");
            choice = phoneBook.scanner.nextInt();
            phoneBook.scanner.nextLine();
            switch (choice) {
                case 1:
                    phoneBook.addContact();
                    break;
                case 2:
                    phoneBook.addPhoneNumberToContact();
                    break;
                case 3:
                    phoneBook.searchContacts();
                    break;
                case 4:
                    phoneBook.printPhoneBook();
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }
}
