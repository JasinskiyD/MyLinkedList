
package myLinkedListTest;

import mylinkedlist.MyLinkedList;
import org.junit.Test;


import static org.junit.Assert.*;

public class MyLinkedListTest {
    private static final String WORD = "word";
    private static final String WORD_2 = "word_2";
    private static final Integer NUM = 1;
    private static final Integer NUM_2 = 2;

    @Test
    public void testDefaultConstructor() {
        MyLinkedList list = new MyLinkedList();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddElement() {
        MyLinkedList list = new MyLinkedList();

        assertTrue(list.add(WORD));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void testReadElement() {
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);

        assertEquals(WORD, list.get(0));
        assertEquals(NUM, list.get(1));
    }

    @Test
    public void testUpdateElement() {
        MyLinkedList list = new MyLinkedList();
        list.add(NUM);
        list.add(WORD);
        list.set(0, WORD_2);
        list.set(1, NUM_2);

        assertEquals(2, list.size());
        assertEquals(NUM_2, list.get(1));
        assertEquals(WORD_2, list.get(0));
    }

    @Test
    public void testDeleteElement() {
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearList() {
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertNull(list.get(0));
        assertEquals(-1, list.indexOf(NUM));
        assertEquals(-1, list.lastIndexOf(WORD));
    }

    @Test
    public void testGetIndexOfElement(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(WORD_2);
        list.add(NUM);
        list.add(NUM_2);

        assertEquals(0, list.indexOf(WORD));
        assertEquals(2, list.indexOf(NUM));
    }

    @Test
    public void testGetLastIndexOfElement(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);

        assertEquals(1, list.lastIndexOf(NUM));
    }

    @Test
    public void testIndexOfElementIfElementIsAbsent(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);

        assertEquals(-1, list.indexOf(WORD_2));
        assertEquals(-1, list.lastIndexOf(NUM_2));
    }

    @Test
    public void testToStringSeparator(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);

        String result = list.toString();
        assertTrue(result.endsWith("1"));
    }

    @Test
    public void testHasNext(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);

        assertTrue(list.iterator().hasNext());
    }

    @Test
    public void testHasNextIfElementAbsent(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);

        assertFalse(list.iterator().hasNext());
    }

    @Test
    public void testNextElement(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(NUM);

        assertEquals(NUM, list.iterator().next());
    }
}

