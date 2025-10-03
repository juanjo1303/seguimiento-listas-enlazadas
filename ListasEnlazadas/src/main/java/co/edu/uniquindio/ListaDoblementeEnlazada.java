package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDoblementeEnlazada<T extends Comparable<T>> {
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int tam;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void agregarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        tam++;
    }

    public void agregarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (ultimo == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tam++;
    }

    public T eliminarInicio() {
        if (primero == null) return null;
        T dato = primero.getDato();
        if (primero == ultimo) {
            primero = ultimo = null;
        } else {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
        }
        tam--;
        return dato;
    }

    public T eliminarFinal() {
        if (ultimo == null) return null;
        T dato = ultimo.getDato();
        if (primero == ultimo) {
            primero = ultimo = null;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }
        tam--;
        return dato;
    }

    public void mostrarAdelante() {
        NodoDoble<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public void mostrarAtras() {
        NodoDoble<T> actual = ultimo;
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getAnterior();
        }
        System.out.println("null");
    }

    public void ordenarAscendentemente() {
        if (primero == null) return;

        List<T> elementos = new ArrayList<>();
        NodoDoble<T> actual = primero;
        while (actual != null) {
            elementos.add(actual.getDato());
            actual = actual.getSiguiente();
        }

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
        } else if (dato.compareTo(primero.getDato()) < 0) {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        } else {
            NodoDoble<T> actual = primero;
            while (actual.getSiguiente() != null &&
                    dato.compareTo(actual.getSiguiente().getDato()) >= 0) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            if (actual.getSiguiente() != null) {
                actual.getSiguiente().setAnterior(nuevo);
            } else {
                ultimo = nuevo;
            }
            nuevo.setAnterior(actual);
            actual.setSiguiente(nuevo);
        }
        tam++;
    }

}

