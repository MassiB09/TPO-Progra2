package org.example.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueOfStacksTest {
    DynamicStack stack1;
    DynamicStack stack2;
    QueueOfStacks queue;
    @BeforeEach
    public void init() {
         stack1 = new DynamicStack();
         stack2 = new DynamicStack();
         queue = new QueueOfStacks();
    }

    @Test
    public void add() {
        assertTrue(queue.isEmpty());

        queue.add(stack1);
        assertFalse(queue.isEmpty());

        queue.add(stack2);
        assertEquals(stack1, queue.getFirst());

        queue.remove();
        assertEquals(stack2, queue.getFirst());
    }

    @Test
    public void remove() {
        assertTrue(queue.isEmpty());

        queue.add(stack1);
        queue.add(stack2);
        assertFalse(queue.isEmpty());

        queue.remove();
        assertEquals(stack2, queue.getFirst());

        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());

        queue.add(stack1);
        assertFalse(queue.isEmpty());

        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void getFirst() {
        assertTrue(queue.isEmpty());

        queue.add(stack1);
        assertEquals(stack1, queue.getFirst());

        queue.add(stack2);
        assertEquals(stack1, queue.getFirst());
    }

    @Test
    public void copy() {
        assertTrue(queue.isEmpty());
        stack1.add(1);
        stack2.add(2);
        queue.add(stack1);
        queue.add(stack2);
        QueueOfStacks copy = queue.copy();
        copy.remove();
        assertEquals(stack2.getTop(), copy.getFirst().getTop());
        assertEquals(stack1.getTop(), queue.getFirst().getTop());

        copy.remove();
        assertTrue(copy.isEmpty());
        assertFalse(queue.isEmpty());
    }
}
