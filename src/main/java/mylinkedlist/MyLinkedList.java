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
    private boolean isIndexInRange(int index) {
        return 0 <= index && index < size;
    }

    // add new element in the end of list, if element is not acceptable return - false, if element added return - true
    public boolean add(T element) {
        Node<T> newLastNode = new Node<>(element);

        // if list is empty
        if (isEmpty()) {
            // update first element in list with new parameter
            this.head = newLastNode;
            // if list is not empty
        } else {
            Node<T> currentLastNode = getNode(size - 1);
            //update last element in list with new parameter
            currentLastNode.setNext(newLastNode);
            newLastNode.setPrev(currentLastNode);
        }
        size++;
        return true;
    }

    private Node<T> getNode(int index) {
        if (!isIndexInRange(index))
            throw new IndexOutOfBoundsException(String.valueOf(index));

        int currentIndex = 0;
        Node<T> tempNode = head;

        while (currentIndex != index) {
            ++currentIndex;
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    public void set(int index, T element) {
        Node<T> temp = getNode(index);

        temp.setValue(element);
    }

    public void remove(int index) {

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

        for (int count = 0; count < size(); count++) {
            if (element.equals(tempNode.getValue())) {
                result.add(count);
            }
            tempNode = tempNode.getNext();
        }

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

    public ListIterator<T> listIterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements ListIterator<T> {
        Node<T> currentNode;
        Node<T> prevNode;
        int currentIndex = 0;
        int previousIndex = -1;

        MyIterator(Node<T> head) {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = currentNode.getValue();
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
            return value;
        }

        @Override
        public boolean hasPrevious() {
            return  prevNode != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            T value = prevNode.getValue();
            currentNode = prevNode;
            prevNode = prevNode.getPrev();
            previousIndex--;
            return value;
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return previousIndex;
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