package org.example.Ejercicio4;

import java.util.Random;

public class Set implements ISet{
    private Node first;
    private int count;

    @Override
    public ISet add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            this.count++;
            return this;
        }

        if (this.first.getValue() == a) {
            return this;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return this;
            }
        }
        candidate.setNext(new Node(a, null));
        this.count++;

        return this;
    }

    @Override
    public ISet addAll(ISet set){
        ISet aux = new Set();

        while (!this.isEmpty()){
            int n = this.choose();
            aux.add(n);
            set.add(n);
            this.remove(n);
        }

        while (!aux.isEmpty()){
            int n = aux.choose();
            this.add(n);
            aux.remove(n);
        }
        return this;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node backup = this.first;
        Node candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        if (count != set.count) {
            return false;
        }

        Node aux = this.first;
        while (aux != null) {
            if (!exists(aux.getValue(), set.first)) {
                return false;
            }
            aux = aux.getNext();
        }

        return true;
    }

    private boolean exists(int value, Node node) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return exists(value, node.getNext());
    }
}
