package org.example.classes;

import java.util.Objects;

public class TwoWayNode {

    private int value;
    private TwoWayNode next;
    private TwoWayNode previous;

    public TwoWayNode(int value, TwoWayNode next, TwoWayNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TwoWayNode getNext() {
        return next;
    }

    public void setNext(TwoWayNode next) {
        this.next = next;
    }

    public TwoWayNode getPrevious() {
        return previous;
    }

    public void setPrevious(TwoWayNode previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoWayNode node = (TwoWayNode) o;
        return getValue() == node.getValue() &&
                Objects.equals(getNext(), node.getNext()) &&
                Objects.equals(getPrevious(), node.getPrevious());
    }
}
