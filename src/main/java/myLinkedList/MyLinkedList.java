package mylinkedlist;

import org.apache.commons.text.TextStringBuilder;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static java.io.File.separator;

public class MyLinkedList<T> implements Iterable<T> {
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
    private boolean isIndexInRange(int index) {
        return 0 <= index && index < size;
    }

    // add new element in the end of list, if element is not acceptable return - false, if element added return - true
    public boolean add(T element) {
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
        if (!isIndexInRange(index)) {
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

    public T get(int index) {
        if (!isIndexInRange(index) || isEmpty()) {
            return null;
        }
        return (T) getNode(index).getValue();
    }

    public void set(int index, T element) {
        getNode(index).setValue(element).setNext(getNode(index + 1));
    }

    public void remove(int index) {
        if (!isIndexInRange(index)) {
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
        TextStringBuilder string = new TextStringBuilder();
        Node temp = head;

        while (temp != null) {
            string.appendSeparator(separator).append(temp.getValue());
            temp = temp.getNext();
        }

        return string.toString();
    }

    private ArrayList<Integer> indexList(T element) {
        ArrayList<Integer> result = new ArrayList<>();

        Node temp = head;

        //check every list element
        for (int count = 0; count < size(); count++) {
            //if element match element in list - add index of element to array list
            if (element.equals(temp.getValue())) {
                result.add(count);
            }
            //switch to next element in list
            temp = temp.getNext();
        }

        //if list is empty add -1 to array list
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    public int indexOf(T element) {
        return indexList(element).get(0);
    }

    public int lastIndexOf(T element) {
        ArrayList<Integer> result = indexList(element);
        if (result.size() == 1) {
            return result.get(0);
        } else {
            return result.get(size - 1);
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator(head);
    }

    public class Iterator implements java.util.Iterator {
        Node currentNode;

        Iterator(Node head) {
            currentNode = head;
        }

        public boolean hasNext() {
            return currentNode.getNext() != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return (T) currentNode.getNext().getValue();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}