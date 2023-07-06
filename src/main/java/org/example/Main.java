package org.example;

import org.example.Ejercicio4.Stack;
import org.example.classes.*;
import org.example.genericClasses.GenericNode;
import org.example.genericClasses.GenericQueue;
import org.example.genericClasses.GenericStack;
import org.example.genericClasses.Set;

import java.util.Queue;

import static org.example.classes.StackAlgorithms.*;

public class Main {
    public static void main(String[] args) {
//        QueueOfStacks queue = new QueueOfStacks();
//        DynamicStack stack = new DynamicStack();
//        stack.add(1);
//        stack.add(2);
//        stack.add(3);
//        DynamicStack stack1 = new DynamicStack();
//        stack1.add(4);
//        stack1.add(5);
//        stack1.add(6);
//        DynamicStack stack2 = new DynamicStack();
//        stack2.add(7);
//        stack2.add(8);
//        stack2.add(9);
//        queue.add(stack);
//        queue.add(stack1);
//        queue.add(stack2);
//        queue.print();
//        QueueOfStacks queue1 = new QueueOfStacks();
//        DynamicStack stack3 = new DynamicStack();
//        stack3.add(1);
//        stack3.add(2);
//        stack3.add(3);
//        DynamicStack stack4 = new DynamicStack();
//        stack4.add(4);
//        stack4.add(5);
//        stack4.add(6);
//        DynamicStack stack5 = new DynamicStack();
//        stack5.add(7);
//        stack5.add(8);
//        stack5.add(9);
//        queue1.add(stack3);
//        queue1.add(stack4);
//        queue1.add(stack5);
//        queue1.print();
//        QueueOfStacks result = sum(queue, queue1);
//        result.print();
//        QueueOfQueue queueQ = new QueueOfQueue();
//        DynamicQueue queue = new DynamicQueue();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        DynamicQueue queue1 = new DynamicQueue();
//        queue1.add(4);
//        queue1.add(5);
//        queue1.add(6);
//        DynamicQueue queue2 = new DynamicQueue();
//        queue2.add(7);
//        queue2.add(8);
//        queue2.add(9);
//        queueQ.add(queue);
//        queueQ.add(queue1);
//        queueQ.add(queue2);
//        queueQ.concatenate();
//        while (!queueQ.isEmpty()) {
//            System.out.print("[");
//            while (!queueQ.getFirst().isEmpty()) {
//                System.out.print(queueQ.getFirst().getFirst());
//                queueQ.getFirst().remove();
//            }
//            System.out.println("]");
//            queueQ.remove();
//        }
        DynamicStack stack = new DynamicStack();
        stack.add(3);
        stack.add(2);
        stack.add(4);
        stack.add(1);
        stack.add(1);
        stack.add(2);

        stack = tidy(stack);
        print(stack);
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
//            auxStack0.invest();
//            auxStack1.invest();
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