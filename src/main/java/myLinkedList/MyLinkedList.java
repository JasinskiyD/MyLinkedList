package mylinkedlist;

import org.apache.commons.text.TextStringBuilder;

import java.util.ArrayList;

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
    private boolean isIndexInRange(int index) {
        return 0 <= index && index < size;
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

    public String get(int index) {
        if (!isIndexInRange(index) || isEmpty()) {
            return null;
        }
        return getNode(index).getValue();
    }

    public void set(int index, String element) {
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
            string.append(temp.getValue()).appendSeparator(separator);
            temp = temp.getNext();
        }

        return string.toString();
    }

    private ArrayList indexList(String element){
        ArrayList<Integer> result = new ArrayList<>();

        int count = 0;

        Node temp = head;

        //if list is empty add -1 to array list
        if (isEmpty()){
            result.add(-1);
            return result;
        }

        //check every list element
        for (int i = 0; i < size(); i++) {
            //if element match element in list - add index of element to array list
            if (element.equals(temp.getValue())) {
                result.add(count);
            }
            //switch to next element in list
            count++;
            temp = temp.getNext();
        }
        return result;
    }

    public int indexOf(String element) {
      return (int) indexList(element).get(0);
    }

    public int lastIndexOf (String element) {
        return (int) indexList(element).get(size-1);
    }
}