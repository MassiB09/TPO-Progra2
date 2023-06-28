package org.example.Ejercicio4;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ISet {

    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param a valor a agregar.
     */
    ISet add(int a);

    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param set valor a agregar.
     */
    ISet addAll(ISet set);

    /**
     * Postcondicion: Quita el elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param a valor a quitar.
     */
    void remove(int a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve él un elemento del conjunto.
     */
    int choose();

}
