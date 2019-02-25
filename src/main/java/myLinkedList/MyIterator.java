package mylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator<Node> {

    private Node list;

    public MyIterator(Node newList) {
        this.list = newList;
    }


    @Override
    public boolean hasNext() {
        return list.getNext() != null;
    }

    @Override
    public Node next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return list.getNext();
        }
    }

    @Override
    public void remove(){
      //will be implemented after Double linked list implementation
    }

}

