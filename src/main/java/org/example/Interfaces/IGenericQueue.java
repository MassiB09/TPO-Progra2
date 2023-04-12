package org.example.Interfaces;

public interface IGenericQueue<T> {
    void add(T a);
    void remove();
    boolean isEmpty();
    T getFirst();
}
