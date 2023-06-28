package org.example;

import org.example.classes.*;
import org.example.genericClasses.GenericNode;
import org.example.genericClasses.GenericQueue;
import org.example.genericClasses.GenericStack;
import org.example.genericClasses.Set;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TwoWayQueue queue = new TwoWayQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        while(!queue.isEmpty()) {
            System.out.println(queue.getFirst());
            queue.remove();
        }
    }

    public static int getTraza(QueueOfStacks queue) {
        QueueOfStacks matrix = queue.copy();
        int traza = 0;
        int length = matrix.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                matrix.getFirst().remove();
            }
            traza += matrix.getFirst().getTop();
            matrix.remove();
        }
        return traza;
    }

    public static void invertirCola(QueueOfStacks queue) {
        if (queue.isEmpty()) {
            return;
        }
        DynamicStack elemento = queue.getFirst();
        queue.remove();
        invertirCola(queue);
        queue.add(elemento);
    }

    public static void getTransposed(QueueOfStacks matrix) {
        //QueueOfStacks matrix = queue.copy();
        DynamicQueue auxQueue = new DynamicQueue();
        int length = matrix.length();
        invertirCola(matrix);
        for (int i = 0; i < length; i++) {
            DynamicStack aux = matrix.getFirst();
            while (!aux.isEmpty()) {
                auxQueue.add(aux.getTop());
                aux.remove();
            }
            matrix.remove();
        }
        for (int i = 0; i < length; i++) {
            DynamicStack stack = new DynamicStack();
            stack.add(auxQueue.getFirst());
            auxQueue.remove();
            matrix.add(stack);
        }
        while (!auxQueue.isEmpty()) {
            DynamicStack stack = matrix.getFirst();
            matrix.remove();
            stack.add(auxQueue.getFirst());
            auxQueue.remove();
            matrix.add(stack);
        }
    }

    public static QueueOfStacks sum(QueueOfStacks queue0, QueueOfStacks queue1) {
        QueueOfStacks result = new QueueOfStacks();
        while(!queue0.isEmpty()) {
            DynamicStack resultStack = new DynamicStack();
            DynamicStack auxStack0 = queue0.getFirst();
            DynamicStack auxStack1 = queue1.getFirst();
            auxStack0.invest();
            auxStack1.invest();
            queue0.remove();
            queue1.remove();
            while (!auxStack0.isEmpty()) {
                int aux = auxStack1.getTop() + auxStack0.getTop();
                auxStack0.remove();
                auxStack1.remove();
                resultStack.add(aux);
            }
            result.add(resultStack);
        }
        return result;
    }

    public static <T> void inverse(GenericStack<T> stack) {
        GenericQueue<T> aux = new GenericQueue<T>();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.pop();
        }
        while (!aux.isEmpty()) {
            stack.push(aux.getFirst());
            aux.remove();
        }
    }

    public static <T> Set<T> copy(Set<T> set) {
        GenericQueue<T> queue = new GenericQueue<T>();
        Set<T> copy = new Set<T>();
        while (!set.isEmpty()) {
            T aux = set.choose();
            queue.add(aux);
            set.remove(aux);
        }
        while (!queue.isEmpty()) {
            T aux = queue.getFirst();
            set.add(aux);
            copy.add(aux);
            queue.remove();
        }
        return copy;
    }
}