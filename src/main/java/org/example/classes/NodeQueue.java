package org.example.classes;

public class NodeQueue {

    private DynamicQueue queue;
    private NodeQueue next;

    public NodeQueue(DynamicQueue value, NodeQueue next) {
        this.queue = value;
        this.next = next;
    }

    public DynamicQueue getQueue() {
        return this.queue; // arreglar
    }

    public void setQueue(DynamicQueue queue) {
        while (!queue.isEmpty()) {
            int aux = queue.getFirst();
            this.queue.add(aux);
            queue.remove();
        }
    }

    public NodeQueue getNext() {
        return next;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }
}
