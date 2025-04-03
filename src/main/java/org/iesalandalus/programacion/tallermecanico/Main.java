package org.iesalandalus.programacion.tallermecanico;

import org.iesalandalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalandalus.programacion.tallermecanico.modelo.cascada.ModeloCascada;
import org.iesalandalus.programacion.tallermecanico.vista.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        ModeloCascada modeloCascada = new ModeloCascada();
        Controlador controlador = new Controlador(modeloCascada, vista);
        controlador.comenzar();
    }
}
