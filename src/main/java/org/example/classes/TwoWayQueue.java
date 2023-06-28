package org.example.classes;

public class TwoWayQueue {

    private TwoWayNode first;
    private TwoWayNode last;


    public TwoWayQueue() {
        this.first = null;
        this.last = null;
    }

    public void add(int a) {
        TwoWayNode newNode = new TwoWayNode(a);
        if (this.first == null) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            newNode.setPrevious(last);
            last.setNext(newNode);
            first.setPrevious(newNode);
            last = newNode;
        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("No se puede desacolar una cola vacía");
            return;
        }

        if (first == last) {
            first = null;
            last = null;
        } else {
            TwoWayNode newFirst = first.getNext();
            newFirst.setPrevious(last);
            last.setNext(newFirst);
            first = newFirst;
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }


    public int getFirst() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero de una cola vacía");
            return -1;
        }
        return this.first.getValue();
    }
}