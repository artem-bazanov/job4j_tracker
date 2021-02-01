package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker){
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void editItem(Input input, Tracker tracker){
        System.out.println("=== Edit item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item replaced");
        } else {
            System.out.println("Item not found");
        }
    }
    public static void showItem(Input input, Tracker tracker){
        System.out.println("=== Show all items ====");
        Item[] arr = tracker.findAll();
        for (Item item : arr) {
            System.out.println(item);
        }
    }

    public static void deleteItem(Input input, Tracker tracker){
        System.out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Item not found");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker){
        System.out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item arr = tracker.findById(id);
        if (arr != null) {
            System.out.println(arr);
        } else {
            System.out.println("Item not found");
        }
    }

    public static void findByNameItem(Input input, Tracker tracker){
        System.out.println("=== Find item by Name ====");
        String name = input.askStr("Enter name: ");
        Item[] arr = tracker.findByName(name);
        if (arr.length == 0) {
            System.out.println("Item`s name not found");
        } else {
            for (Item item : arr) {
                System.out.println(item);
            }
        }
    }


    private void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run){
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);

                } else if (select == 1) {
                StartUI.showItem(input, tracker);

                } else if (select == 2) {
                StartUI.editItem(input, tracker);

                } else if (select == 3) {
                StartUI.deleteItem(input, tracker);

                } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);

                } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);

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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }


}
