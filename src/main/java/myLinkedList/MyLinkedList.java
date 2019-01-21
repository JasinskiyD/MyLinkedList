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

    private Node getLastNode() {
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }

    private boolean indexInRange(int index) {
        return 0 <= index && index < size;
    }

    public boolean add(String element) {
        if (element == null) {
            return false;
        }
        if (head == null) {
            this.head = new Node(element);
        } else {
            getLastNode().setNext(new Node(element));
        }
        size++;
        return true;
    }

    public String get(int index) {
        if (indexInRange(index)) {
            int currentIndex = 0;
            Node temp = head;

            while (temp != null) {
                if (currentIndex == index) {
                    return temp.getValue();
                }
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return null;
    }

    public void set(int index, String element) {
        if (indexInRange(index)) {
            int currentIndex = 0;
            Node temp = head;
            Node currentValue;

            if (index == 0) {
                temp.setValue(element);
                return;
            }

            while (temp != null) {
                if ((currentIndex + 1) == index) {
                    currentValue = new Node(element);
                    currentValue.setNext(temp.getNext().getNext());
                    temp.setNext(currentValue);
                    return;
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        }
    }

    public void remove(int index) {
        if (indexInRange(index)) {
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
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            string.append(temp.getValue().concat(" "));
            temp = temp.getNext();
        }

        return string.toString();
    }


}
