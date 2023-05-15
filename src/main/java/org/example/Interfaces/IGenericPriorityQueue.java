package org.example.Interfaces;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IGenericPriorityQueue<T> {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor, respecto a su prioridad.
     *
     * @param a        valor a acolar.
     * @param priority prioridad del valor a agregar.
     */
    void add(T a, int priority);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    T getFirst();

    /**
     * @return Devuelve la prioridad del primero.
     */
    int getPriority();

}
