package Step3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    Tree testTree = new Tree();

    @Test
    void find() {
        Tree test = new Tree();
        test.insert("Dog");
        assertTrue(test.find("Dog"));
        assertFalse(test.find("Cat"));
    }
}