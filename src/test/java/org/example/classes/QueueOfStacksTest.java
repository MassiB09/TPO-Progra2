package org.example.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueOfStacksTest {
    @Test
    public void add() {
        DynamicStack stack1 = new DynamicStack();
        stack1.add(1);
        stack1.add(2);
        DynamicStack stack2 = new DynamicStack();
        stack1.add(3);
        stack1.add(4);
        QueueOfStacks queue = new QueueOfStacks();
        assertTrue(queue.isEmpty());

        queue.add(stack1);
        assertFalse(queue.isEmpty());

        queue.add(stack2);
        assertEquals(stack1, queue.getFirst());

        queue.remove();
        assertEquals(stack2, queue.getFirst());
    }
}
