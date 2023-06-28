package org.example.Interfaces;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ISetDuplicates {

    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param a valor a agregar.
     */
    void add(int a);

    /**
     * Postcondicion: Reduce la cantidad de veces que está presente un elemento en el conjunto, sí es 0 lo borra. Sí no existe no hace nada
     *
     * @param a valor a quitar.
     */
    void remove(int a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el un elemento del conjunto.
     */
    int choose();

    /**
     * @return Devuelve un elemento del conjunto y la cantidad de veces que se ingreso.
     */

    int chooseTimes(int value);

}