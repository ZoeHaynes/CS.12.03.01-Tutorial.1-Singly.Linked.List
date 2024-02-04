import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest<T> {

    private SinglyLinkedList sll1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        
        sll1 = new SinglyLinkedList(1);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

        sll1 = null;

    }

    @org.junit.jupiter.api.Test
    void size() {

        assertEquals(1, sll1.size());
        sll1.addLast(2);
        assertEquals(2, sll1.size());
        sll1.removeFirst();
        assertEquals(1, sll1.size());
        sll1.removeFirst();
        assertEquals(0, sll1.size());

    }

    @org.junit.jupiter.api.Test
    void isEmpty() {

        assertEquals(false, sll1.isEmpty());
        sll1.removeLast();
        assertEquals(true, sll1.isEmpty());
        sll1.addLast(5);
        assertEquals(false, sll1.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void peekFirst() {

        T data = (T) sll1.peekFirst();
        assertEquals(1, data);
        sll1.addFirst(0);
        T data2 = (T) sll1.peekFirst();
        assertEquals(0, data2);

    }

    @org.junit.jupiter.api.Test
    void peekLast() {

        T data = (T) sll1.peekLast();
        assertEquals(1, data);
        sll1.addFirst(0);
        T data2 = (T) sll1.peekLast();
        assertEquals(1, data2);
        sll1.addLast(2);
        T data3 = (T) sll1.peekLast();
        assertEquals(2, data3);

    }

    @org.junit.jupiter.api.Test
    void addFirst() {

        sll1.addFirst(21);
        assertEquals(21, sll1.peekFirst());
        sll1.addFirst(11);
        assertEquals(11, sll1.peekFirst());

    }

    @org.junit.jupiter.api.Test
    void addLast() {

        sll1.addLast(21);
        assertEquals(21, sll1.peekLast());
        sll1.addLast(11);
        assertEquals(11, sll1.peekLast());

    }

    @org.junit.jupiter.api.Test
    void insert() {

        sll1.insert(14, 0);
        assertEquals(14, sll1.peekFirst());

        sll1.insert(13,0);
        assertEquals(13, sll1.peekFirst());

        sll1.insert(11, 3);

        assertEquals(11, sll1.peekLast());

        sll1.insert(12, 2);

        assertEquals(13, sll1.valueAt(0));
        assertEquals(14, sll1.valueAt(1));
        assertEquals(12, sll1.valueAt(2));
        assertEquals(1, sll1.valueAt(3));
        assertEquals(11, sll1.valueAt(4));


        assertThrows(IllegalArgumentException.class, ()->{ sll1.insert(7,6);});


    }

    @org.junit.jupiter.api.Test
    void removeFirst() {

        sll1.removeFirst();
        assertThrows(RuntimeException.class, () -> {sll1.peekFirst();});

        sll1.addFirst(0);
        sll1.addFirst(0);
        sll1.addLast(7);
        sll1.addFirst(8);

        sll1.removeFirst();

        assertEquals(0, sll1.peekFirst());
        sll1.removeFirst();

        assertEquals(0, sll1.peekFirst());

        sll1.removeFirst();

        assertEquals(7, sll1.peekFirst());

    }

    @org.junit.jupiter.api.Test
    void removeLast() {

        sll1.removeLast();
        assertThrows(RuntimeException.class, () -> {sll1.peekFirst();});

        sll1.addFirst(0);
        sll1.addFirst(0);
        sll1.addLast(7);
        sll1.addFirst(8);


        sll1.removeLast();


        assertEquals(8, sll1.peekFirst());
        assertEquals(0, sll1.peekLast());

        sll1.removeLast();

        assertEquals(8, sll1.peekFirst());
        assertEquals(0, sll1.peekLast());

    }

    @org.junit.jupiter.api.Test
    void removeAt() {

        sll1.removeAt(0);
        assertThrows(RuntimeException.class, () -> {sll1.peekFirst();});

        sll1.addFirst(1);
        sll1.addLast(2);
        sll1.addLast(3);
        sll1.addLast(4);

        sll1.removeAt(3);
        assertEquals(3, sll1.peekLast());


        sll1.removeAt(1);
        assertEquals(1, sll1.peekFirst());
        assertEquals(3, sll1.peekLast());
        assertEquals(2, sll1.size());

        assertThrows(IllegalArgumentException.class, () -> {sll1.removeAt(-1);});
        assertThrows(IllegalArgumentException.class, () -> {sll1.removeAt(2);});

    }

    @org.junit.jupiter.api.Test
    void contains() {

        assertTrue(sll1.contains(1));
        assertFalse(sll1.contains(0));

        sll1.addFirst(16);
        assertTrue(sll1.contains(16));
        assertTrue(sll1.contains(1));

        sll1.removeLast();
        assertFalse(sll1.contains(1));

    }

    @org.junit.jupiter.api.Test
    void valueAt() {

        assertEquals(1, sll1.valueAt(0));
        assertThrows(IllegalArgumentException.class, () -> {sll1.valueAt(1);});

        sll1.addLast(2);
        assertEquals(2, sll1.valueAt(1));

        sll1.addFirst(0);
        assertEquals(0, sll1.valueAt(0));

    }

    @org.junit.jupiter.api.Test
    void reverse() {

        sll1.addLast(2);
        sll1.addLast(3);
        sll1.addLast(4);
        sll1.addLast(5);
        sll1.addLast(6);
        sll1.addLast(7);
        sll1.addLast(8);
        sll1.addLast(9);
        sll1.addLast(10);

        String forward = "1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null";
        String backward = "10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null";

        assertEquals(forward, sll1.toString());
        sll1.reverse();
        assertEquals(backward, sll1.toString());

    }

    @org.junit.jupiter.api.Test
    void testToString() {

        String expected = "1 -> null";
        assertEquals(expected, sll1.toString());
        sll1.removeFirst();

        sll1.addFirst(0);
        sll1.addFirst(0);
        sll1.addLast(7);

        expected = "0 -> 0 -> 7 -> null";
        assertEquals(expected, sll1.toString());

    }

}