package org.example.classes;

import org.example.Interfaces.IQueueOfQueue;

public class QueueOfQueue implements IQueueOfQueue {
    private NodeQueue first;

    @Override
    public void add(DynamicQueue queue) {
        NodeQueue node = new NodeQueue(queue, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        NodeQueue candidate = this.first;
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
    public DynamicQueue getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return this.first.getQueue();
    }

    @Override
    public void concatenate(QueueOfQueue queue) { //Probar
        QueueOfQueue auxQ = new QueueOfQueue();
        while (!queue.isEmpty()) {
            DynamicQueue aux = queue.getFirst();
            auxQ.add(aux);
            queue.remove();
        }
        while (!auxQ.isEmpty()) {
            DynamicQueue aux = auxQ.getFirst();
            queue.add(aux);
            this.add(aux);
        }
    }
}
