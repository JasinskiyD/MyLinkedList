
package myLinkedListTest;

import mylinkedlist.MyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private static final String WORD = "word";
    private static final String WORD_2 = "word_2";

    @Test
    public void testDefaultConstructor(){
        MyLinkedList list = new MyLinkedList();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddElement(){
        MyLinkedList list = new MyLinkedList();

        assertTrue(list.add(WORD));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void testReadElement(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(WORD_2);

        assertEquals(WORD, list.get(0));
        assertEquals(WORD_2, list.get(1));
    }

    @Test
    public void testUpdateElement(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add("test");
        list.add("some");
        list.set(0, WORD_2);

        assertEquals(3, list.size());
        assertEquals(WORD_2, list.get(0));
    }

    @Test
    public void testDeleteElement(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearList(){
        MyLinkedList list = new MyLinkedList();
        list.add(WORD);
        list.add(WORD_2);
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertNull(list.get(0));
    }
}

