package org.example.classes;

import org.example.Interfaces.IQueueOfStacks;

public class QueueOfStacks implements IQueueOfStacks {

    private NodeStack first;
    private int count;

    public QueueOfStacks() {
        this.first = null;
        this.count = 0;
    }
    @Override
    public void add(DynamicStack a) {
        NodeStack node = new NodeStack(a, null);
        if(this.first == null) {
            this.first = node;
            this.count++;
            return;
        }
        NodeStack candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
        this.count++;
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
        this.count--;
    }
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
    @Override
    public DynamicStack getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return this.first.getStack();
    }

//    public void print() {
//        QueueOfStacks auxQueue = this.copy();
//        while (!auxQueue.isEmpty()) {
//            DynamicStack aux = auxQueue.getFirst();
//            while (!aux.isEmpty()) {
//                System.out.print(aux.getTop());
//                aux.remove();
//            }
//            System.out.println();
//            auxQueue.remove();
//        }
//    }

    public void print1() {
        QueueOfStacks auxQueue = this.copy();
        int count = this.length() * this.length();
        for (int i = 0; i < count; i++) {
            DynamicStack stack = auxQueue.getFirst();
            auxQueue.remove();
            System.out.printf("%2d ", stack.getTop());
            stack.remove();
            auxQueue.add(stack);
            if ((i+1) % this.length() == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public QueueOfStacks copy() {
        QueueOfStacks result = new QueueOfStacks();
        for (int i = 0; i < this.length(); i++) {
            DynamicStack stack = this.getFirst().copy();
            DynamicStack stack1 = this.getFirst().copy();
            this.remove();
            result.add(stack1);
            this.add(stack);
        }
        return result;
    }

    public int length() {
        return count;
    }
}
