package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    private void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run){
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);

                } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] arr = tracker.findAll();
                for (Item item : arr) {
                    System.out.println(item);
                }

                } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item replaced");
                } else {
                    System.out.println("Item not found");
                }

                } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item not found");
                }

                } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item arr = tracker.findById(id);
                if (arr != null) {
                    System.out.println(arr);
                } else {
                    System.out.println("Item not found");
                }

                } else if (select == 5) {
                System.out.println("=== Find item by Name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] arr = tracker.findByName(name);
                if (arr.length == 0) {
                    System.out.println("Item`s name not found");
                } else {
                    for (Item item : arr) {
                        System.out.println(item);
                    }
                }

                } else if (select == 6) {
                run = false;
                }
            }
        }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }


}
