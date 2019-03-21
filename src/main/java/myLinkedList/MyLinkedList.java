package mylinkedlist;

import org.apache.commons.text.TextStringBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static java.io.File.separator;
import static java.util.Objects.isNull;


public class MyLinkedList<T> implements Iterable<T>  {
    private Node<T> head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty()  {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    // checks the parameter that method accepts (parameter is the number of the element in the list), returns true if range acceptable and false if not
    private void verifyIndexInRange(Integer index) {
        if (isNull(index) || 0 >= index && index > size)
            throw new IndexOutOfBoundsException();
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
            this.head = new Node<>(element);
            // if list is not empty
        } else {
            //update last element in list with new parameter
            getNode(size - 1).setNext(new Node<>(element))
                    .getNext()
                    .setPrev(getNode(size - 1));
        }
        size++;
        return true;
    }

    private Node<T> getNode(Integer index) {
        verifyIndexInRange(index);

        int currentIndex = 0;
        Node<T> temp = head;

        while (currentIndex != index) {
            ++currentIndex;
            temp = temp.getNext();
        }
        return temp;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        return getNode(index).getValue();
    }

    public void set(int index, T element) {
        verifyIndexInRange(index);
        getNode(index).setValue(element).setNext(getNode(index + 1));
        if (getNode(index) != head) getNode(index).setPrev(getNode(index - 1));
    }

    public void remove(int index) {
        verifyIndexInRange(index);

        Node<T> temp = head;
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        } else {
            getNode(index).setNext(temp.getNext().getNext());
        }
        size--;
    }

    @Override
    public String toString() {
        TextStringBuilder string = new TextStringBuilder();
        Node<T> temp = head;

        while (temp != null) {
            string.appendSeparator(separator).append(temp.getValue());
            temp = temp.getNext();
        }

        return string.toString();
    }

    private List<Integer> indexList(T element) {
        List<Integer> result = new ArrayList<>();

        Node<T> temp = head;

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
        List<Integer> result = indexList(element);
        if (result.size() == 1) {
            return result.get(0);
        } else {
            return result.get(size - 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements Iterator<T> {
        Node<T> currentNode;

        MyIterator(Node<T> head) {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode.getNext() != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return currentNode.getNext().getValue();

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}