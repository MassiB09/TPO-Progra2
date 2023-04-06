package org.example.classes;

public class NodeStack {

    private DynamicStack stack;
    private NodeStack next;

    public NodeStack(DynamicStack value, NodeStack next) {
        this.stack = value;
        this.next = next;
    }

    public DynamicStack getStack() {
        return this.stack; // arreglar
    }

    public void setStack(DynamicStack stack) {
        while (!stack.isEmpty()) {
            int aux = stack.getTop();
            this.stack.add(aux);
            stack.remove();
        }
    }

    public NodeStack getNext() {
        return next;
    }

    public void setNext(NodeStack next) {
        this.next = next;
    }
}
