package mylinkedlist;


class Node {
    private String value;
    private Node next;

    Node(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    Node setValue(String value) {
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
