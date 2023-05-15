package org.example.genericClasses;

public class PriorityGenericNode<T> {

    private T value;
    private int priority;
    private PriorityGenericNode<T> next;

    public PriorityGenericNode(T value, int priority, PriorityGenericNode<T> next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityGenericNode<T> getNext() {
        return next;
    }

    public void setNext(PriorityGenericNode<T> next) {
        this.next = next;
    }
}
