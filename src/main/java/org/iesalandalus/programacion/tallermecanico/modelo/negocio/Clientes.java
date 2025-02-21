package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clientes {
    private List<Cliente> coleccionClientes;

    public Clientes(){
        coleccionClientes = new ArrayList<>();
    }

    public List<Cliente> get() {
        return new ArrayList<>(coleccionClientes);
    }
    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(cliente, "No se puede insertar un cliente nulo.");
        if (coleccionClientes.contains(cliente)){
            throw new TallerMecanicoExcepcion("Ya existe un cliente con ese DNI.");
        }
        coleccionClientes.add(cliente);
    }
    public boolean modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(cliente,"No se puede modificar un cliente nulo.");
        Cliente clienteExistente = buscar(cliente);
        if (clienteExistente == null){
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        }
        if(nombre != null && !nombre.trim().isEmpty()){
            clienteExistente.setNombre(nombre);
        }
        if (telefono != null && !telefono.trim().isEmpty()){
            clienteExistente.setTelefono(telefono);
        }
        return true;

    }
    public Cliente buscar(Cliente cliente){
        Objects.requireNonNull(cliente,"No se puede buscar un cliente nulo.");
        int indice = coleccionClientes.indexOf(cliente);
        return (indice != -1) ? coleccionClientes.get(indice) : null;
    }
    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(cliente, "No se puede borrar un cliente nulo.");
        Cliente clienteExistente = buscar(cliente);
        if (clienteExistente == null){
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        }
        coleccionClientes.remove(clienteExistente);
    }

}
