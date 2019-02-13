package mylinkedlist;

import static java.io.File.separator;

public class MyLinkedList {
    private Node head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    // checks the parameter that method accepts (parameter is the number of the element in the list), returns true if range acceptable and false if not
    private boolean indexInRange(int index) {
        return index >= 0 && index < size;
    }

    // add new element in the end of list, if element is not acceptable return - false, if element added return - true
    public boolean add(String element) {
        // if element is invalid return false
        if (element == null) {
            return false;
        }
        // if list is empty
        if (isEmpty()) {
            // update first element in list with new parameter
            this.head = new Node(element);
            // if list is not empty
        } else {
            //update last element in list with new parameter
            getNode(size - 1).setNext(new Node(element)); //
        }
        size++;
        return true;
    }

    private Node getNode(int index) {
        if (!indexInRange(index)) {
            return null;
        }
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                break;
            } else {
                currentIndex++;
                temp = temp.getNext();
            }
        }
        return temp;
    }

    public String get(int index) {
        if (!indexInRange(index) || isEmpty()) {
            return null;
        }
        return getNode(index).getValue();
    }

    public void set(int index, String element) {
        Node newNode = getNode(index);
        Node nextNode = getNode(index + 1);
        newNode.setValue(element);
        newNode.setNext(nextNode);
    }

    public void remove(int index) {
        if (!indexInRange(index)) {
            return;
        }
        Node temp = head;
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        getNode(index).setNext(temp.getNext().getNext());
        size--;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            string.append(temp.getValue()).append(separator);
            temp = temp.getNext();
        }

        return string.toString();
    }


}
