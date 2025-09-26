package co.edu.uniquindio;

public class MainList {
    public static void main(String[] args) {
        ListaSimpleEnlazada lista = new ListaSimpleEnlazada(); // sin <>

        lista.agregarPrimero(10);
        lista.agregarPrimero("Hola");
        lista.agregarPrimero(3.14);

        lista.mostrar();

        for (Object elemento : lista) {
            System.out.println("Elemento: " + elemento);
        }
    }
}

