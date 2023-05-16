package org.example.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    BinaryTree tree;

    @BeforeEach
    public void init() {
        tree = new BinaryTree();
    }

    @Test
    public void create() {
        assertTrue(tree.isEmpty());
        assertNull(tree.getLeft());
        assertNull(tree.getRight());
        tree.create(1);
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.getValue());
        assertNull(tree.getLeft());
        assertNull(tree.getRight());
    }
    @Test
    public void getValue() {
        assertTrue(tree.isEmpty());
        tree.create(0);
        assertEquals(0, tree.getValue());
        tree.addLeft(1);
        tree.addRight(2);
        assertEquals(1,tree.getLeft().getValue());
        assertEquals(2,tree.getRight().getValue());
    }

    @Test
    public void isEmpty() {
        assertTrue(tree.isEmpty());

        tree.create(0);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void addLeft() {
        assertTrue(tree.isEmpty());

        tree.create(0);
        assertFalse(tree.isEmpty());

        tree.addLeft(1);
        assertEquals(1,tree.getLeft().getValue());

        tree.getLeft().addLeft(2);
        assertEquals(2, tree.getLeft().getLeft().getValue());
    }

    @Test
    public void addRight() {
        assertTrue(tree.isEmpty());

        tree.create(0);
        assertFalse(tree.isEmpty());

        tree.addRight(1);
        assertEquals(1,tree.getRight().getValue());

        tree.getRight().addRight(2);
        assertEquals(2, tree.getRight().getRight().getValue());
    }

    @Test
    public void removeLeft() {
        assertTrue(tree.isEmpty());

        tree.create(0);
        assertFalse(tree.isEmpty());


    }
}
