package org.example.genericClasses;
public class GenericNode<T> {
    private T value;
    private GenericNode<T> next;

    public GenericNode(T value, GenericNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }
}
