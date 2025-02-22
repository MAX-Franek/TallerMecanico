package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.Objects;

public record Vehiculo(String marca, String modelo, String matricula) {
    private static final String ER_MARCA = "^(?!.*\\b[A-ZÁÉÍÓÚÑ]{2}-[A-ZÁÉÍÓÚÑ]{2}\\b)(?:[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*(?:[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)*|\\b[A-ZÁÉÍÓÚÑ]+\\b)(?:[\\s-](?:[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*(?:[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)*|\\b[A-ZÁÉÍÓÚÑ]+\\b))*$";
    private static final String ER_MATRICULA = "^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";

    public Vehiculo(String marca, String modelo, String matricula){

        this.marca = Objects.requireNonNull(marca, "La marca no puede ser nula.");
        this.modelo = Objects.requireNonNull(modelo, "El modelo no puede ser nulo.");
        this.matricula = Objects.requireNonNull(matricula,"La matrícula no puede ser nula.");
        validarMarca(marca);
        validarModelo(modelo);
        validarMatricula(matricula);
    }
    private void validarMarca(String marca){
        if (!marca.matches(ER_MARCA)){
            throw new IllegalArgumentException("La marca no tiene un formato válido.");
        }
    }
    private void validarModelo(String modelo){
        if (modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar en blanco.");
        }
    }
    private void validarMatricula(String matricula){
        if (!matricula.matches(ER_MATRICULA)){
            throw new IllegalArgumentException("La matrícula no tiene un formato válido.");
        }
    }
    public static Vehiculo get(String matricula){
        Objects.requireNonNull(matricula,"La matrícula no puede ser nula.");

        return new Vehiculo("Renault","Megane",matricula);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, matricula);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", marca, modelo, matricula);
    }
}
