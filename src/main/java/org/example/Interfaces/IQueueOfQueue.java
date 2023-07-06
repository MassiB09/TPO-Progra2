package org.example.Interfaces;

import org.example.classes.DynamicQueue;
import org.example.classes.QueueOfQueue;

public interface IQueueOfQueue {
    void add(DynamicQueue queue);

    void remove();

    boolean isEmpty();

    DynamicQueue getFirst();

    void concatenate();

    DynamicQueue flat();

    void reverseWithDepth();
}
