package co.edu.uniquindio;

public class ListaSimpleEnlazadaCircular<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tam;

    public ListaSimpleEnlazadaCircular() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null) {
            primero = newNodo;
            ultimo = newNodo;
            ultimo.setProximo(primero);
        } else {
            newNodo.setProximo(primero);
            primero = newNodo;
            ultimo.setProximo(primero);
        }
        tam++;
    }

    public void agregarUltimo(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);
        if (primero == null) {
            primero = newNodo;
            ultimo = newNodo;
            ultimo.setProximo(primero);
        } else {
            ultimo.setProximo(newNodo);
            ultimo = newNodo;
            ultimo.setProximo(primero);
        }
        tam++;
    }

    public void mostrar() {
        if (primero == null) {
            System.out.println("[]");
            return;
        }

        Nodo<T> actual = primero;
        String mensaje = "[";

        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        } while (actual != primero);

        mensaje += "]";
        System.out.println(mensaje);
    }

    public int getTam() {
        return tam;
    }

    public boolean estaVacia() {
        return primero == null;
    }
}
