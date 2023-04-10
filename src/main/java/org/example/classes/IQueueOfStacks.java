package org.example.classes;

import java.util.Stack;

public interface IQueueOfStacks {
    void add(DynamicStack stack);
    void remove();
    boolean isEmpty();
    DynamicStack getFirst();
}
