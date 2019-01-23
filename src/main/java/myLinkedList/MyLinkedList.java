package myLinkedList;

public class MyLinkedList {
    private Node head;
    private int size;

    // return size of the list
    public int size() {
        return size;
    }

    // check if list is empty and returns status (true if empty and false if not)
    public boolean isEmpty() {
        return size == 0;
    }

    // returns last list element
    private Node getLastNode() {
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }

    // removes all of the elements from list
    public void clear() {
        head = null;
        size = 0;
    }

    // checks the parameter that method accepts (parameter is the number of the element in the list), returns true if range acceptable and false if not
    private boolean indexInRange(int index) {
        return 0 <= index && index < size;
    }

    // add new element in the end of list, if element is not acceptable return - false, if element added return - true
    public boolean add(String element) {
        if (element == null) {  // if element is invalid
            return false;   // method return false
        }
        if (head == null) {  // if first element in list is null
            this.head = new Node(element); // update first element in list with new parameter
        } else {    // if first element in list is valid value
            getLastNode().setNext(new Node(element)); // update last element in list with new parameter
        }
        size++; // update size of the list
        return true;
    }


    public String get(int index) {
        if (indexInRange(index)) {
            int currentIndex = 0;
            Node temp = head;

            while (temp != null) {
                if (currentIndex == index) {
                    return temp.getValue();
                }
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return null;
    }

    public void set(int index, String element) {
        if (indexInRange(index)) {
            int currentIndex = 0;
            Node temp = head;
            Node currentValue;

            if (index == 0) {
                temp.setValue(element);
                return;
            }

            while (temp != null) {
                if ((currentIndex + 1) == index) {
                    currentValue = new Node(element);
                    currentValue.setNext(temp.getNext().getNext());
                    temp.setNext(currentValue);
                    return;
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        }
    }


    public void remove(int index) {
        if (indexInRange(index)) {
            if (isEmpty()) {
                throw new IllegalStateException("Cannot remove() from and empty list.");
            }
            int currentIndex = 0;
            Node temp = head;

            if (index == 0) {
                head = head.getNext();
                size--;
                return;
            }

            while (temp != null) {
                if ((currentIndex + 1) == index) {
                    temp.setNext(temp.getNext().getNext());
                    size--;
                    return;
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        }
    }

    // returns all elements of list in String format
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            string.append(temp.getValue().concat(" "));
            temp = temp.getNext();
        }

        return string.toString();
    }


}
