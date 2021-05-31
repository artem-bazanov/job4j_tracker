package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker){
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
        return true;
    }
}
