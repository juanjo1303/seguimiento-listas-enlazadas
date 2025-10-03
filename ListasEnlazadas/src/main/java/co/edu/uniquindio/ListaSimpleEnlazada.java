package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaSimpleEnlazada<T extends Comparable<T>> implements Iterable<T> {
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

    public void ordenarAscendentemente() {
        if (primero == null) return;

        List<T> elementos = new ArrayList<>();
        Nodo<T> actual = primero;
        while (actual != null) {
            elementos.add(actual.getDato());
            actual = actual.getProximo();
        }

        Collections.sort(elementos);

        actual = primero;
        for (T dato : elementos) {
            actual.setDato(dato);
            actual = actual.getProximo();
        }
    }

    public void insertarOrdenado(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null || dato.compareTo(primero.getDato()) < 0) {
            nuevo.setProximo(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null &&
                    dato.compareTo(actual.getProximo().getDato()) >= 0) {
                actual = actual.getProximo();
            }
            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
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
