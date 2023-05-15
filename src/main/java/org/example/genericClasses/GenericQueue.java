package org.example.genericClasses;

import org.example.Interfaces.IGenericQueue;

public class GenericQueue<T> implements IGenericQueue<T> {
    private GenericNode<T> first;
    @Override
    public void add(T a) {
        GenericNode<T> node = new GenericNode<T>(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        GenericNode<T> candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return this.first.getValue();
    }
}
