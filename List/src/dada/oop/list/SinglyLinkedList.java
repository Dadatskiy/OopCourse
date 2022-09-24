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
        int i;
        ListItem<T> p = head;

        StringBuilder stringBuilder = new StringBuilder("[");

        for (i = 0; i < count - 1; i++) {
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
        int i;
        ListItem<T> p;

        for (p = head, i = 0; i < index; p = p.getNext()) {
            i++;
        }

        return p.getData();
    }

    public T setData(int index, T data) {
        int i;
        ListItem<T> p;

        for (p = head, i = 0; i < index; p = p.getNext()) {
            i++;
        }

        T originalData = p.getData();

        p.setData(data);

        return originalData;
    }

    public T deleteElement(int index) {
        int i;
        ListItem<T> p;

        for (p = head, i = 0; i < index - 1; p = p.getNext()) {
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


}
