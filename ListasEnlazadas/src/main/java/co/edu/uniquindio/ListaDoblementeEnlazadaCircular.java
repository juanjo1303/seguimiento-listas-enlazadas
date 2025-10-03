package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDoblementeEnlazadaCircular<T extends Comparable<T>> {
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int tam;

    public ListaDoblementeEnlazadaCircular() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void agregarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) { // lista vacía
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            primero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            primero = nuevo;
        }
        tam++;
    }

    public void agregarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }
        tam++;
    }

    public void mostrarAdelante() {
        if (primero == null) {
            System.out.println("[]");
            return;
        }
        NodoDoble<T> actual = primero;
        String mensaje = "[";
        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getSiguiente();
        } while (actual != primero);
        mensaje += "]";
        System.out.println(mensaje);
    }

    public void mostrarAtras() {
        if (ultimo == null) {
            System.out.println("[]");
            return;
        }
        NodoDoble<T> actual = ultimo;
        String mensaje = "[";
        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getAnterior();
        } while (actual != ultimo);
        mensaje += "]";
        System.out.println(mensaje);
    }

    public void ordenarAscendentemente() {
        if (primero == null) return;

        List<T> elementos = new ArrayList<>();
        NodoDoble<T> actual = primero;
        do {
            elementos.add(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != primero);

        Collections.sort(elementos);

        actual = primero;
        for (T dato : elementos) {
            actual.setDato(dato);
            actual = actual.getSiguiente();
        }
    }

    public void insertarOrdenado(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else if (dato.compareTo(primero.getDato()) < 0) {
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            primero = nuevo;
        } else {
            NodoDoble<T> actual = primero;
            while (actual.getSiguiente() != primero &&
                    dato.compareTo(actual.getSiguiente().getDato()) >= 0) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            nuevo.setAnterior(actual);
            actual.getSiguiente().setAnterior(nuevo);
            actual.setSiguiente(nuevo);
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
        return tam == 0;
    }
}

