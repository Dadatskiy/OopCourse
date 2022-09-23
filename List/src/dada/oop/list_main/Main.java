package dada.oop.list_main;

import dada.oop.list.ListItem;
import dada.oop.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        int listSize = 0;

        ListItem<Integer> fourth = new ListItem<>(-10);
        ListItem<Integer> third = new ListItem<>(42, fourth);
        ListItem<Integer> second = new ListItem<>(12, third);
        ListItem<Integer> first = new ListItem<Integer>(23, second);

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(first);
        System.out.println(list.getFirstData());
        System.out.println(list.getCount());
        System.out.println(list);

    }
}
