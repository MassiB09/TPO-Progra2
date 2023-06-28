package org.example.classes;

public class TwoWayQueue {

    private TwoWayNode first;
    private TwoWayNode last;


    public void add(int a) {
        TwoWayNode node = new TwoWayNode(a, null, null);
        if (this.first == null && this.isEmpty()) {
            this.first = node;
            this.last = node;
        } else {
            node.setPrevious(this.last);
            node.getPrevious().setNext(node);
            this.last = node;
        }
    }

    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desacolar una cola vacía");
            return;
        }
        this.first = this.first.getNext();
        //this.last = this.first.getNext();
        if (this.first != null) {
            this.first.setPrevious(null);
        } else {
            this.last = null; // La cola está vacía después de desacolar el único elemento
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