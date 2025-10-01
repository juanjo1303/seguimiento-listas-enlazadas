package co.edu.uniquindio;

public class BiCola<T> extends Cola<T> {

    public BiCola() {
        super();
    }

    public void encolarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setProximo(primero);
            primero = nuevo;
        }
        tam++;
    }

    public T desencolarFinal() {
        if (primero == null) {
            return null;
        }

        if (primero == ultimo) {
            T dato = primero.getDato();
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
}
