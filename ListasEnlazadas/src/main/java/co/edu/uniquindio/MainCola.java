package co.edu.uniquindio;

public class MainCola {
    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();

        cola.encolar("A");
        cola.encolar("B");

        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("Desencolado: " + cola.desencolar());
    }
}


