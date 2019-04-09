package mylinkedlist;

class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;


    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    Node<T> setValue(T value) {
        this.value = value;
        return this;
    }

    Node<T> getNext() {
        return next;
    }

    Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

     Node<T> getPrev() {
        return prev;
    }

     void setPrev(Node<T> prev) {
        this.prev = prev;
    }

}
