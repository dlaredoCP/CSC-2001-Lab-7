import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test
    void size(){
        LinkedList<String> ex = new LinkedList<>(null, null);
        assertEquals(0, ex.size());
        ex.add("hello");
        assertEquals(1,ex.size());
        ex.add("world");
        assertEquals(2, ex.size());
    }

    @Test
    void n(){
        LinkedList<String> ex = new LinkedList<>("hello", null);
        ex.add("world");
        assertEquals(2, ex.size());
    }
}