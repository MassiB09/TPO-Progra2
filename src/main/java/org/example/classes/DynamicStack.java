package org.example.classes;

public class DynamicStack implements IStack {

    private Node first;

    @Override
    public void add(int a) {
        this.first = new Node(a, this.first);
    }

    @Override
    public void remove() {
        if(this.first == null) {
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
        if(this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return -1;
        }
        return this.first.getValue();
    }

    public DynamicStack copy() {
        DynamicStack auxStack = new DynamicStack();
        DynamicStack result = new DynamicStack();
        while (!this.isEmpty()) {
            int aux = this.getTop();
            auxStack.add(aux);
            this.remove();
        }
        while (!auxStack.isEmpty()) {
            int aux = auxStack.getTop();
            result.add(aux);
            this.add(aux);
            auxStack.remove();
        }
        return result;
    }
}
