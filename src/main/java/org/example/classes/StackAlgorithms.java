package org.example.classes;


import org.example.Interfaces.IStack;

public class StackAlgorithms {

    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static DynamicStack copy(DynamicStack stack) {
        DynamicStack copy = new DynamicStack();
        DynamicStack aux = new DynamicStack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }
        return copy;
    }

    public static void revert(IStack stack) {
        IStack aux = new DynamicStack();
        IStack aux2 = new DynamicStack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }
        while (!aux2.isEmpty()) {
            stack.add(aux2.getTop());
            aux2.remove();
        }
    }

    public static DynamicStack tidy(DynamicStack stack){ //Ejercicio5
        Set set = new Set();
        DynamicStack aux = copy(stack);
        while(!aux.isEmpty()){
            set.add(aux.getTop());
            aux.remove();
        }
        while(!set.isEmpty()){
            int a = set.choose();
            addOrdered(aux, a);
            set.remove(a);
        }
        return aux;
    }

    private static void addOrdered (DynamicStack stack, int a){
        if(stack.isEmpty()){
            stack.add(a);
            return;
        }
        if(stack.getTop() > a){
            int aux = stack.getTop();
            stack.remove();
            addOrdered(stack, a);
            stack.add(aux);
        } else {
            stack.add(a);
        }
    }
}
