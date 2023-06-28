package org.example.classes;

import java.util.Objects;

public class NodeDuplicates {

    private int value;
    private int times;
    private NodeDuplicates next;

    public NodeDuplicates(int value, NodeDuplicates next) {
        this.value = value;
        this.next = next;
        this.times = 1;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeDuplicates getNext() {
        return next;
    }

    public void setNext(NodeDuplicates next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeDuplicates node = (NodeDuplicates) o;
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }
    public void increaseTimes(){
        this.times++;
    }

    public void decreseTimes(){
        this.times--;
    }

}
