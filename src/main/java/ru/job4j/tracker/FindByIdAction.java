package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker){
        System.out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item arr = tracker.findById(id);
        if (arr != null) {
            System.out.println(arr);
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
