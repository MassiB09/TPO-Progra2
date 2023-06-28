package org.example.classes;

import org.example.Interfaces.ISet;
import java.util.Random;

public class SuperSet implements ISet {

    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            return;
        }

        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return;
            }
        }
        candidate.setNext(new Node(a, null));
        this.count++;
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
        SuperSet set = (SuperSet) o;
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

    public boolean contains(int value) {
        return exists(value, first);
    }


    public boolean subset(ISet a) {
        ISet aux = new Set();
        boolean subset = true;
        while (!a.isEmpty()) {
            int element = a.choose();
            if (!in(this, element)) {
                subset = false;
                break;
            }
            aux.add(element);
            a.remove(element);
            this.remove(element);
        }
        if (this.isEmpty()) {
            subset = false;
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            this.add(element);
            aux.remove(element);
        }
        return subset;
    }

    public static boolean in(ISet a, int element) {
        ISet aux = new Set();
        boolean exists = false;
        while (!a.isEmpty()) {
            int value = a.choose();
            if (element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }
        while (!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }

    public Set Complemento(Set a) {
        Set result = new Set();
        SuperSet b = this;

        while (!b.isEmpty()) {
            int aux = b.choose();
            if (!a.contains(aux)) {
                result.add(aux);
            }
            b.remove(aux);
        }

        return result;
    }

}
