package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item(1, "Заявка номер 1"));
        tracker.add(new Item(2, "Заявка номер 2"));
        System.out.println(tracker.findById( 2 ));
    }
}
