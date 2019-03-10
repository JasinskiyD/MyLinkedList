package mylinkedlist;


class Node<T> {
    private T value;
    private Node next;

    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    Node setValue(T value) {
        this.value = value;
        return this;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

}
