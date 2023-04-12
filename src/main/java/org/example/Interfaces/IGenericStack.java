package org.example.Interfaces;

public interface IGenericStack<T> {
    void push(T a);
    void pop();
    boolean isEmpty();
    T getTop();
}
