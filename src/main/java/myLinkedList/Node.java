package myLinkedList;


class Node {
    private String value;
    private Node next;

    Node(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

}
