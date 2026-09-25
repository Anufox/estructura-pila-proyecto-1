package sis.unifranz.pila.estructura;

import sis.unifranz.pila.model.Estudiante;

public class Pila {

    private Estudiante[] elementos;
    private int tope;

    private static final int CAPACIDAD = 100;

    public Pila() {
        elementos = new Estudiante[CAPACIDAD];
        tope = -1;
    }
    public void agregar(Estudiante estudiante) {

        if (tope == CAPACIDAD - 1) {
            throw new RuntimeException("La pila está llena");
        }

        tope++;
        elementos[tope] = estudiante;
    }
    public Estudiante quitar() {

        if (tope == -1) {
            throw new RuntimeException("La pila está vacía");
        }

        Estudiante estudiante = elementos[tope];

        elementos[tope] = null;
        tope--;

        return estudiante;
    }
    public Estudiante[] mostrar() {

        Estudiante[] resultado = new Estudiante[tope + 1];

        for (int i = 0; i <= tope; i++) {
            resultado[i] = elementos[i];
        }

        return resultado;
    }
    public int tamanyo() {
        return tope + 1;
    }
}