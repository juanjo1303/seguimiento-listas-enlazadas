package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaSimpleEnlazadaCircular<T extends Comparable<T>> {
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

    public void ordenarAscendentemente() {
        if (primero == null) return;

        List<T> elementos = new ArrayList<>();
        Nodo<T> actual = primero;
        do {
            elementos.add(actual.getDato());
            actual = actual.getProximo();
        } while (actual != primero);

        Collections.sort(elementos);

        actual = primero;
        for (T dato : elementos) {
            actual.setDato(dato);
            actual = actual.getProximo();
        }
    }

    public void insertarOrdenado(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            ultimo.setProximo(primero);
        } else if (dato.compareTo(primero.getDato()) < 0) {
            nuevo.setProximo(primero);
            primero = nuevo;
            ultimo.setProximo(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != primero &&
                    dato.compareTo(actual.getProximo().getDato()) >= 0) {
                actual = actual.getProximo();
            }
            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
            if (actual == ultimo) {
                ultimo = nuevo;
            }
        }
        tam++;
    }

    public int getTam() {
        return tam;
    }

    public boolean estaVacia() {
        return primero == null;
    }
}
