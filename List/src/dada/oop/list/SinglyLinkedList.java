package dada.oop.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            count++;
        }

    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        ListItem<T> p = head;

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < count - 1; i++) {
            stringBuilder.append(p.getData());
            stringBuilder.append(", ");
            p = p.getNext();
        }

        stringBuilder.append(p.getData());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public T getFirstData() {
        return head.getData();
    }

    public T getData(int index) {
        ListItem<T> p = head;

        for (int i = 0; i < index; p = p.getNext()) {
            i++;
        }

        return p.getData();
    }

    public T setData(int index, T data) {
        ListItem<T> p = head;

        for (int i = 0; i < index; p = p.getNext()) {
            i++;
        }

        T originalData = p.getData();

        p.setData(data);

        return originalData;
    }

    public T deleteItemByIndex(int index) {
        ListItem<T> p = head;

        for (int i = 0; i < index - 1; p = p.getNext()) {
            i++;
        }

        T originalData = p.getNext().getData();

        p.setNext(p.getNext().getNext());
        count--;

        return originalData;
    }

    public void addFirst(ListItem<T> listItem) {
        count++;
        ListItem<T> originalHead = head;
        head = new ListItem<>(listItem.getData(), listItem.getNext());
        head.setNext(originalHead);
    }

    public void add(ListItem<T> listItem, int index) {
        if (index == 0) {
            addFirst(listItem);
            return;
        }

        ListItem<T> p = head;

        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }

        count++;
        ListItem<T> newListItem = new ListItem<>(listItem.getData(), listItem.getNext());
        newListItem.setNext(p.getNext());
        p.setNext(newListItem);
    }

    public boolean deleteItemByData(T data) {
        ListItem<T> p = head;

        for (int i = 0; i < count - 1; i++) {
            if (p.getNext().getData() == data) {
                if (i == count - 1) {
                    p.setNext(p.getNext().getNext());
                }
                p.getNext().setNext(p.getNext().getNext().getNext());
                count--;

                return true;
            }

            System.out.println(getData(i));
            p = p.getNext();
        }

        return false;
    }

    public T deleteFirstItem() {
        T firstData = head.getData();
        head = head.getNext();
        count--;
        return firstData;
    }

    public void revert() {
        ListItem<T> previous = null;
        ListItem<T> p = head.getNext();
        head.setNext(null);

        while (p != null) {
            ListItem<T> next = p.getNext();
            p.setNext(head);
            head = p;
            p = next;
        }
    }

    /*public SinglyLinkedList<T> copy() {

        SinglyLinkedList listCopy = new SinglyLinkedList();
    }*/
}