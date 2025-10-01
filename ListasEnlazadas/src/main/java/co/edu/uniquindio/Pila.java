package co.edu.uniquindio;

public class Pila<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tam;

    public Pila() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void empilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setProximo(nuevo);
            ultimo = nuevo;
        }
        tam++;
    }

    public T desempilar() {
        if (ultimo == null) {
            return null;
        }

        if (primero == ultimo) { // solo un elemento
            T dato = ultimo.getDato();
            primero = null;
            ultimo = null;
            tam = 0;
            return dato;
        }

        Nodo<T> actual = primero;
        while (actual.getProximo() != ultimo) {
            actual = actual.getProximo();
        }

        T dato = ultimo.getDato();
        ultimo = actual;
        ultimo.setProximo(null);
        tam--;
        return dato;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public int getTam() {
        return tam;
    }
}

