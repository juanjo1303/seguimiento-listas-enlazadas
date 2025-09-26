package co.edu.uniquindio.doblementeenlazada;

class ListaDoble {
    Nodo head;
    Nodo tail;

    //Agregar al incio
    public void agregarAlInicio(int data) {
        Nodo nuevo = new Nodo(data);
        if (head == null) { // lista vacía
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo; // actualizar inicio
        }
        size++;
    }


    // Agregar al final
    public void agregarAlFinal(int data) {
        Nodo nuevo = new Nodo(data);
        if (head == null) { // lista vacía
            head = nuevo;
            tail = nuevo;
        } else {
            tail.next = nuevo;
            nuevo.prev = tail;
            tail = nuevo; // actualizar final
        }
        size++;
    }

    //Agregar posición específica
    public void agregarEnPosicion(int data, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            agregarAlInicio(data);
            return;
        }

        if (posicion == size) {
            agregarAlFinal(data);
            return;
        }

        Nodo nuevo = new Nodo(data);
        Nodo actual = head;

        // avanzar hasta la posición
        for (int i = 0; i < posicion; i++) {
            actual = actual.next;
        }

        // insertar entre actual.prev y actual
        Nodo previo = actual.prev;
        previo.next = nuevo;
        nuevo.prev = previo;

        nuevo.next = actual;
        actual.prev = nuevo;

        size++;
    }
}
