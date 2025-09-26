package co.edu.uniquindio;

import java.util.Iterator;

public class ListaSimpleEnlazada<T> implements Iterable<T> {
    private Nodo<T> primero;
    private int tam;

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);
        if (primero == null) {
            primero = newNodo;
        } else {
            newNodo.setProximo(primero);
            primero = newNodo;
        }
        tam++;
    }

    public void mostrar() {
        Nodo<T> actual = primero;
        String mensaje = "[";
        while (actual != null) {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        }
        mensaje += "]";
        System.out.println(mensaje);
    }

    public void agregarUltimo(T dato) {
        Nodo<T> newNodo = new Nodo(dato);
        if (primero == null){
            primero = newNodo;
        } else {
            Nodo<T> ultimo = primero;
            while (ultimo.getProximo() != null){
                ultimo = ultimo.getProximo();
            }
            ultimo.setProximo(newNodo);
        }
        tam++;
    }

    public void agregarCualquierPosicion(int pos, T dato) {
        if (pos < 0 || pos > tam) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        Nodo<T> newNodo = new Nodo<>(dato);

        if (pos == 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
        } else {
            Nodo<T> actual = primero;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public int getTam() {
        return tam;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = primero;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T dato = actual.getDato();
                actual = actual.getProximo();
                return dato;
            }
        };
    }
}
