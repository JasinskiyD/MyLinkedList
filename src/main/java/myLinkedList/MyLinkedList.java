package myLinkedList;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<T> {
    private Node head;
    private int size;

    public void add(T value){
        if(head == null){
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    @Override
    public String toString(){
        List result = new ArrayList();
        int index = 0;
        Node temp = head;

        while (temp != null){
            result.add(index, temp.getValue());
            index++;
            temp = temp.getNext();
        }
        return result.toString();
    }


}
