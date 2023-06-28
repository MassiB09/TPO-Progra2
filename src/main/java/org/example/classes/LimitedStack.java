package org.example.classes;

import org.example.Interfaces.IStack;

public class LimitedStack implements IStack {

    private Node first;

    private int limit;

    private int size;

    public LimitedStack(int a){
        this.limit = a;
        this.size = 0;
    }

    @Override
    public void add(int a) {

        if(this.limit>this.size) {
            this.first = new Node(a, this.first);
            this.size++;
        } else{
            System.out.println("La pila llego a su limite el nÃºmero " + a + " no se pudo agregar");
        }

    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
