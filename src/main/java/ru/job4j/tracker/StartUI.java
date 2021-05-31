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


    private void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
        }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new EditAction(),
                new ShowAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new EditAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
