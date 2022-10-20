package dada.oop.list_main;

import dada.oop.list.ListItem;
import dada.oop.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        int listSize = 0;

        ListItem<Integer> sixth = new ListItem<>(60);
        ListItem<Integer> fifth = new ListItem<>(50, sixth);
        ListItem<Integer> fourth = new ListItem<>(40, fifth);
        ListItem<Integer> third = new ListItem<>(30, fourth);
        ListItem<Integer> second = new ListItem<>(20, third);
        ListItem<Integer> first = new ListItem<>(10, second);

        ListItem<Integer> sixthCopy = new ListItem<>(third);

        sixthCopy.setData(555);

        System.out.println(third);




        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(first);
        System.out.println(list);
        list.revert();
        //System.out.println(list.getFirstData());
        //System.out.println(list.deleteFirstItem());
        //list.add(fourth,0);
        System.out.println(list);
    }
}
