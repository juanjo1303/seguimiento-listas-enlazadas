package co.edu.uniquindio.doblementeenlazada;

class Nodo {
    int data;
    Nodo prev;
    Nodo next;

    Nodo(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
