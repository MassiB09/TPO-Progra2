package org.example.classes;

import org.example.Interfaces.IQueue;

public class DynamicQueue implements IQueue {

    private Node first;

    @Override
    public void add(int a) {
        Node node = new Node(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        Node candidate = this.first;
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
    public int getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getValue();
    }

    public void invest() { //Arreglar ejercicio 1 en el main (creo que existe una funcion invertir cola en el main)
        if (this.isEmpty()) {
            return;
        }

        int value = this.getFirst();
        this.remove();
        this.invest();
        this.add(value);
    }
}
