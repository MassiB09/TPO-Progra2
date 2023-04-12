package org.example;

import org.example.classes.DynamicQueue;
import org.example.genericClasses.GenericNode;
import org.example.classes.QueueOfStacks;
import org.example.classes.DynamicStack;
import org.example.genericClasses.GenericQueue;
import org.example.genericClasses.GenericStack;

public class Main {
    public static void main(String[] args) {
//        GenericNode<String> generic = new GenericNode<>("Hola", null);
//        System.out.println(generic.getValue());
        DynamicStack stack0 = new DynamicStack();
        stack0.add(4);
        stack0.add(3);
        stack0.add(2);
        stack0.add(1);
        DynamicStack stack1 = new DynamicStack();
        stack1.add(8);
        stack1.add(7);
        stack1.add(6);
        stack1.add(5);
        DynamicStack stack2 = new DynamicStack();
        stack2.add(12);
        stack2.add(11);
        stack2.add(10);
        stack2.add(9);
        DynamicStack stack3 = new DynamicStack();
        stack3.add(16);
        stack3.add(15);
        stack3.add(14);
        stack3.add(13);
        //System.out.println(stack.getTop());
        QueueOfStacks queue = new QueueOfStacks();
        queue.add(stack0);
        queue.add(stack1);
        queue.add(stack2);
        queue.add(stack3);
//        queue.print1();
//        QueueOfStacks copy = queue.copy();
//        copy.print1();
//        sum(queue, copy).print1(); //
//        System.out.println(getTraza(queue));
//        System.out.println(getTraza(queue));
        //getTransposed(queue);
        //queue.print1();
        GenericStack stack = new GenericStack();
        stack.push(1);
        stack.push("hola");
        stack.push(2);
        stack.push("chau");
        stack.push(queue);
        inverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.pop();
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

    public static void inverse(GenericStack stack) {
        GenericQueue aux = new GenericQueue();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.pop();
        }
        while (!aux.isEmpty()) {
            stack.push(aux.getFirst());
            aux.remove();
        }
    }
}