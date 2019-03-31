package mylinkedlist;

import org.apache.commons.text.TextStringBuilder;

import java.util.*;

import static java.io.File.separator;


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
    private boolean isIndexInRange(Integer index) {
        return 0 <= index && index < size;
    }

    // add new element in the end of list, if element is not acceptable return - false, if element added return - true
    public boolean add(T element) {
        Node<T> currentLastNode = getNode(size - 1);
        Node<T> newLastNode = new Node<>(element);

        // if element is invalid return false
        if (element == null) {
            return false;
        }
        // if list is empty
        if (isEmpty()) {
            // update first element in list with new parameter
            this.head = new Node<>(element);
            size++;
            return true;
            // if list is not empty
        }
        //update last element in list with new parameter
        currentLastNode.setNext(newLastNode);
        newLastNode.setPrev(currentLastNode);
        size++;
        return true;
    }

    private Node<T> getNode(int index) {
        if (!isIndexInRange(index))
            return null;

        int currentIndex = 0;
        Node<T> tempNode = head;

        while (currentIndex != index) {
            ++currentIndex;
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        return getNode(index).getValue();
    }

    public void set(int index, T element) {
        Node<T> temp = getNode(index);

        if (!isIndexInRange(index))
            return;

        temp.setValue(element)
                .setNext(temp.getNext())
                .setPrev(temp.getPrev());
    }

    public void remove(int index) {
        if (!isIndexInRange(index))
            return;

        Node<T> nodeToRemove = getNode(index);
        Node<T> nodeBeforeNodeToRemove =  nodeToRemove.getPrev();
        Node<T> nodeAfterNodeToRemove =  nodeToRemove.getNext();

        if (index == 0) {
            head = nodeAfterNodeToRemove;
            head.setPrev(null);
        } else if (index == size-1){
            nodeBeforeNodeToRemove.setNext(null);
        } else {
            nodeBeforeNodeToRemove.setNext(nodeAfterNodeToRemove);
            nodeAfterNodeToRemove.setPrev(nodeBeforeNodeToRemove);
        }
        size--;
    }

    @Override
    public String toString() {
        TextStringBuilder string = new TextStringBuilder();
        Node<T> tempNode = head;

        while (tempNode != null) {
            string.appendSeparator(separator).append(tempNode.getValue());
            tempNode = tempNode.getNext();
        }

        return string.toString();
    }

    private List<Integer> indexList(T element) {
        List<Integer> result = new ArrayList<>();

        Node<T> tempNode = head;

        //check every list element
        for (int count = 0; count < size(); count++) {
            //if element match element in list - add index of element to array list
            if (element.equals(tempNode.getValue())) {
                result.add(count);
            }
            //switch to next element in list
            tempNode = tempNode.getNext();
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

    private class MyIterator implements ListIterator<T> {
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
        public boolean hasPrevious() {
                return currentNode.getPrev() != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return currentNode.getPrev().getValue();
        }

        @Override
        public int nextIndex() {
            return indexOf(currentNode.getValue()) + 1;
        }

        @Override
        public int previousIndex() {
            return indexOf(currentNode.getValue()) - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }

    }
}