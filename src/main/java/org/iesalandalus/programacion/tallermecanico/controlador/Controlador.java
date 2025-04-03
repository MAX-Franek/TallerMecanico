package org.iesalandalus.programacion.tallermecanico.controlador;

import org.iesalandalus.programacion.tallermecanico.modelo.cascada.ModeloCascada;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.vista.Vista;

import java.time.LocalDate;
import java.util.List;

public class Controlador {
    private final ModeloCascada modeloCascada;
    private final Vista vista;

    public Controlador(ModeloCascada modeloCascada, Vista vista) {
        if (modeloCascada == null || vista == null) {
            throw new NullPointerException("El modelo y la vista no pueden ser nulos.");
        }
        this.modeloCascada = modeloCascada;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void comenzar() {
        modeloCascada.comenzar();
        vista.comenzar();
    }

    public void terminar() {
        vista.terminar();
        modeloCascada.terminar();
    }

    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {
        modeloCascada.insertar(cliente);
    }

    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        modeloCascada.insertar(vehiculo);
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        modeloCascada.insertar(revision);
    }

    public Cliente buscar(Cliente cliente) {
        return modeloCascada.buscar(cliente);
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        return modeloCascada.buscar(vehiculo);
    }

    public Revision buscar(Revision revision) {
        return modeloCascada.buscar(revision);
    }

    public boolean modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {
        return modeloCascada.modificar(cliente, nombre, telefono);
    }

    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        return modeloCascada.anadirHoras(revision, horas);
    }

    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        return modeloCascada.anadirPrecioMaterial(revision, precioMaterial);
    }

    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        return modeloCascada.cerrar(revision, fechaFin);
    }

    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
        modeloCascada.borrar(cliente);
    }

    public void borrar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        modeloCascada.borrar(vehiculo);
    }

    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
        modeloCascada.borrar(revision);
    }

    public List<Cliente> getClientes() {
        return modeloCascada.getClientes();
    }

    public List<Vehiculo> getVehiculos() {
        return modeloCascada.getVehiculos();
    }

    public List<Revision> getRevisiones() {
        return modeloCascada.getRevisiones();
    }

    public List<Revision> getRevisiones(Cliente cliente) {
        return modeloCascada.getRevisiones(cliente);
    }

    public List<Revision> getRevisiones(Vehiculo vehiculo) {
        return modeloCascada.getRevisiones(vehiculo);
    }
}
