package org.example.Interfaces;

import org.example.classes.DynamicStack;

import java.util.Stack;

public interface IQueueOfStacks {
    void add(DynamicStack stack);
    void remove();
    boolean isEmpty();
    DynamicStack getFirst();
}
