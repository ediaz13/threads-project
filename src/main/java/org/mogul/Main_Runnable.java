package org.mogul;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main_Runnable {
    public static void main(String[] args) {

        // Así se USA Thread.State
        Thread t = new Thread(() -> {
            System.out.println("Corriendo!");
        });

        System.out.println(t.getState()); // → NEW
        t.start();
        System.out.println(t.getState()); // → RUNNABLE

        Thread.State state = t.getState(); // obtenés el estado actual

        switch (state) {
            case NEW        -> System.out.println("Todavía no arrancó");
            case RUNNABLE   -> System.out.println("Corriendo o listo para correr");
            case BLOCKED    -> System.out.println("Esperando un lock");
            case WAITING    -> System.out.println("Esperando otro thread");
            case TERMINATED -> System.out.println("Terminó");
        }
    }
}