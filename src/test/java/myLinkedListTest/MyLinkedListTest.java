
package myLinkedListTest;

import mylinkedlist.MyLinkedList;
import org.junit.Test;


import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private static final String WORD = "word";
    private static final String WORD_2 = "word_2";
    private static final Integer NUM = 1;
    private static final Integer NUM_2 = 2;

    @Test
    public void testDefaultConstructor() {
        MyLinkedList<Object> list = new MyLinkedList<>();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddElement() {
        MyLinkedList<Object> list = new MyLinkedList<>();

        assertTrue(list.add(WORD));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void testReadElement() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(NUM);

        assertEquals(WORD, list.get(0));
        assertEquals(NUM, list.get(1));
    }

    @Test
    public void testUpdateElement() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(NUM);
        list.add(WORD);
        list.set(0, WORD_2);
        list.set(1, NUM_2);

        assertEquals(2, list.size());
        assertEquals(NUM_2, list.get(1));
        assertEquals(WORD_2, list.get(0));
    }

    @Test
    public void testDeleteFirstElement() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(WORD_2);

        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(WORD_2, list.get(0));
    }

    @Test
    public void testDeleteInnerElement() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(WORD_2);
        list.add(NUM);

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(NUM, list.get(1));
    }

    @Test
    public void testDeleteLastElement() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(WORD_2);
        list.add(NUM);
        list.add(NUM_2);

        list.remove(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testClearList() {
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(NUM);
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetIndexOfElement(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(WORD_2);
        list.add(NUM);
        list.add(NUM_2);

        assertEquals(0, list.indexOf(WORD));
        assertEquals(2, list.indexOf(NUM));
    }

    @Test
    public void testGetLastIndexOfElement(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(NUM);

        assertEquals(1, list.lastIndexOf(NUM));
    }

    @Test
    public void testIndexOfElementIfElementIsAbsent(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(NUM);

        assertEquals(-1, list.indexOf(WORD_2));
        assertEquals(-1, list.lastIndexOf(NUM_2));
    }

    @Test
    public void testToStringSeparator(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(NUM);

        String result = list.toString();
        assertTrue(result.endsWith("1"));
    }

    @Test
    public void testHasNext(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(NUM);

        assertTrue(list.iterator().hasNext());
    }

    @Test
    public void testHasPrev(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);

        assertFalse(list.listIterator().hasPrevious());
    }

    @Test
    public void testNextElement(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(WORD_2);
        list.add(NUM);

        Iterator<Object> iterator = list.iterator();

        assertEquals(WORD, iterator.next());
        assertEquals(WORD_2, iterator.next());
        assertEquals(NUM, iterator.next());
    }

    @Test
    public void testPrevElement(){
        MyLinkedList<Object> list = new MyLinkedList<>();
        list.add(WORD);
        list.add(WORD_2);
        list.add(NUM);

        ListIterator<Object> iterator = list.listIterator();
        iterator.next();
        iterator.next();

        assertEquals(WORD_2, iterator.previous());

    }
}

