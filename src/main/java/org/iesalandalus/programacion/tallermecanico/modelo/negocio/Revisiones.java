package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {
    private List<Revision> coleccionRevisiones;

    public Revisiones(){
        coleccionRevisiones = new ArrayList<>();
    }
    public List<Revision> get(){
        return new ArrayList<>(coleccionRevisiones);
    }
    public List<Revision> get(Cliente cliente){
        return new ArrayList<>(coleccionRevisiones);
    }
    public List<Revision> get(Vehiculo vehiculo){
        return new ArrayList<>(coleccionRevisiones);
    }
    public void insertar ( Revision revision){
        Objects.requireNonNull(revision,"No se puede insertar una revisión nula.");

    }
    private void comprobarRevision (Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision){
        
    }
    public Revision anadirHoras(Revision revision, int horas){
        return revision;
    }
    private Revision getRevision (Revision revision){
        return revision;
    }
    public Revision anadirPrecioMaterial (Revision revision, float precioMaterial){
        return revision;
    }
    public Revision cerrar (Revision revision, LocalDate fechaFin){
        return revision;
    }
    public Revision buscar (Revision revision){
        Objects.requireNonNull(revision,"No se puede buscar una revisión nula.");
        int indice = coleccionRevisiones.indexOf(revision);
        return (indice == -1) ? null : coleccionRevisiones.get(indice);
    }
    public void borrar (Revision revision){
        Objects.requireNonNull(revision,"No se puede borrar una revisión nula.");
    }


}
