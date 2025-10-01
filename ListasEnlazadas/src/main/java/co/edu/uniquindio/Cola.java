package co.edu.uniquindio;

public class Cola<T> {
    protected Nodo<T> primero;
    protected Nodo<T> ultimo;
    protected int tam;

    public Cola() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void encolar(T dato) {
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

    public T desencolar() {
        if (primero == null) return null;
        T dato = primero.getDato();
        primero = primero.getProximo();
        if (primero == null) {
            ultimo = null;
        }
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
