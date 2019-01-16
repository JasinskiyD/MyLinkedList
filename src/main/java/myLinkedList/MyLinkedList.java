package myLinkedList;


import java.util.Arrays;


public class MyLinkedList {
    private Node head;
    private int size;

    public void add(String value){
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
       String[] result = new String[size];
        int index = 0;
        Node temp = head;

        while (temp != null){
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }





}
