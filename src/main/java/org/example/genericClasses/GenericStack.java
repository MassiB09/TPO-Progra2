package org.example.genericClasses;

import org.example.Interfaces.IGenericStack;

public class GenericStack<T> implements IGenericStack {
    private GenericNode<T> top;


    public void push(Object a) { //No entiendo por que no se usa T
        this.top = new GenericNode<T>((T) a, this.top); //No entiendo este warning xd
    }

    public void pop() {
        if(this.top == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.top = this.top.getNext();
    }


    public boolean isEmpty() {
        return this.top == null;
    }


    public T getTop() {
        if(this.top == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return null;
        }
        return this.top.getValue();
    }

    public GenericStack<T> copy() {
        GenericStack<T> auxStack = new GenericStack<T>();
        GenericStack<T> result = new GenericStack<T>();
        while (!this.isEmpty()) {
            T aux = this.getTop();
            auxStack.push(aux);
            this.pop();
        }
        while (!auxStack.isEmpty()) {
            T aux = auxStack.getTop();
            result.push(aux);
            this.push(aux);
            auxStack.pop();
        }
        return result;
    }
}
