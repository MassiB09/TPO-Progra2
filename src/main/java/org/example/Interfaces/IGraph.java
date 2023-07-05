package org.example.Interfaces;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IGraph {

    /**
     * Precondicion: El nodo no existe.
     * @param node, valor del nodo a agregar.
     */
    void addNode(int node);

    /**
     * Precondicion: El nodo existe.
     * @param node, valor que representa el nodo a borrar.
     */
    void removeNode(int node);

    /**
     * @return conjunto con todos los nodos presentes.
     */
    ISet nodes();

    /**
     * Precondicion: No existe la arista pero existen los nodos.
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     * @param weight, peso de la arista.
     */
    void addEdge(int from, int to, int weight);

    /**
     * Precondicion: Existe la arista
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     */
    void removeEdge(int from, int to);

    /**
     * Precondicion: Existen los nodos
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     * @return <code>true</code> si la arista existe, <code>false</code> en otro caso.
     */
    boolean edgeExists(int from, int to);

    /**
     * Precondicion: Existe la arista
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     * @return peso de la arista.
     */
    int weight(int from, int to);

    void changeWeightRandom(int from, int to);
    void normalizeWeights();
    boolean isSymetric();
    boolean esFuertementeConexo();

}