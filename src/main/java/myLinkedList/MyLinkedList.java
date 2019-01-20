package myLinkedList;


public class MyLinkedList {
    private Node head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(String value) {
        if (value == null) {
            throw new NullPointerException("The first argument for add() is null.");
        }
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
        return true;
    }

    public String get(int index) {
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void set(int index, String value) {
        int currentIndex = 0;
        Node temp = head;
        Node currentValue;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            temp.setValue(value);
            return;
        }

        while (temp != null) {
            if ((currentIndex + 1) == index) {
                currentValue = new Node(value);
                currentValue.setNext(temp.getNext().getNext());
                temp.setNext(currentValue);
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from and empty list.");
        }
        int currentIndex = 0;
        Node temp = head;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        while (temp != null) {
            if ((currentIndex + 1) == index) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            s.append(temp.getValue() + " ");
            temp = temp.getNext();
        }

        return s.toString();
    }


}
