import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void countNodes(){
        BST<String> animals = new BST<>("dog", null, null);
        assertEquals(1,BST.countNodes(animals));
    }

    @Test
    void mirror(){
        BST<String> animals = new BST<>("dog",
                new BST<>("cat",
                        new BST<>("bee", null, null),
                        new BST<>("chimp", null, null)),
                new BST<>("elephant",null, null));
        animals = BST.mirror(animals);
        assertEquals("elephant", animals.getLeft().getValue());
    }

    @Test
    void preorder(){
        BST<String> animals = new BST<>("dog",
                new BST<>("cat",
                        new BST<>("bee", null, null),
                        new BST<>("chimp", null, null)),
                new BST<>("elephant",null, null));
        LinkedList<String> newAnimals = BST.preorder(animals);
        assertEquals("cat", newAnimals.getRest().getFirst());
    }

    @Test
    void findPath(){
        BST<String> animals = new BST<>("dog",
                new BST<>("cat",
                        new BST<>("bee", null, null),
                        new BST<>("chimp", null, null)),
                new BST<>("elephant",null, null));
        assertEquals("left", BST.findPath(animals, "chimp").getFirst());
    }

    @Test
    void contains(){
        BST<String> animals = new BST<>("dog",
                new BST<>("cat",
                        new BST<>("bee", null, null),
                        new BST<>("chimp", null, null)),
                new BST<>("elephant",null, null));
        assertEquals(true, animals.contains(animals, "chimp"));
    }

}