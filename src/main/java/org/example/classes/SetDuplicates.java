package org.example.classes;

import org.example.Interfaces.ISetDuplicates;
import java.util.Random;

public class SetDuplicates implements ISetDuplicates {

    private NodeDuplicates first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new NodeDuplicates(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            this.first.increaseTimes();
            return;
        }

        NodeDuplicates candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                candidate.increaseTimes();
                return;
            }
        }
        candidate.setNext(new NodeDuplicates(a, null));
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                if(this.first.getTimes() == 1){
                    this.first = null;
                    this.count--;
                } else {
                    this.first.decreseTimes();
                }
            }
            return;
        }

        if (this.first.getValue() == a) {
            if(this.first.getTimes() == 1) {
                this.first = this.first.getNext();
                this.count--;
            } else {
                this.first.decreseTimes();
            }
            return;
        }

        NodeDuplicates backup = this.first;
        NodeDuplicates candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                if(candidate.getTimes() == 1) {
                    backup.setNext(candidate.getNext());
                    this.count--;
                    return;
                } else {
                    candidate.decreseTimes();
                    return;
                }
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
    public int chooseTimes(int value) {
        if (!contains(value)) {
            System.out.println("El elemento seleccionado no pertenece al conjunto");
            return -1;
        } else{
            return getNode(value, this.first).getTimes();
        }
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        NodeDuplicates candidate = this.first;
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
        if (count != this.count) {
            return false;
        }

        NodeDuplicates aux = this.first;
        while (aux != null) {
            if (!exists(aux.getValue(), this.first)) {
                return false;
            }
            aux = aux.getNext();
        }

        return true;
    }

    private boolean exists(int value, NodeDuplicates node) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return exists(value, node.getNext());
    }

    private NodeDuplicates getNode(int value, NodeDuplicates node) {
        if (value == node.getValue()) {
            return node;
        }
        return getNode(value, node.getNext());
    }

    public boolean contains(int value) {
        return exists(value, first);
    }
    public int getCount() {
        return count;
    }
}
