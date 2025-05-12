package org.iesalandalus.programacion.tallermecanico.modelo.negocio.ficheros;


import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.*;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.ITrabajos;


import javax.swing.text.Document;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class Trabajos implements ITrabajos {
    private final String FICHERO_TRABAJOS ="../../../../../../../../../ficheros/trabajos.xml";
    private final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final String RAIZ = "TalleMecanico";
    private final String TRABAJO = "trabajo";
    private final String CLIENTE = "cliente";
    private final String VEHICULO = "vehiculo";
    private final String FECHA_INICIO = "fechaInicio";
    private final String FECHA_FIN = "fechaFin";
    private final String HORAS = "horas";
    private final String PRECIO_MATERIAL = "Precio material";
    private final String TIPO = "tipo ";
    private final String REVISION = "revision";
    private final String MECANICO = "Mecanico";

    private final List<Trabajo> coleccionTrabajos;

    public Trabajos(){
        coleccionTrabajos = new ArrayList<>();
    }
    protected static Trabajos getInstancia() {
        return new Trabajos();
    }
    public void comenzar(){

    }
    private void procesarDocumentoXml(Document documentoXml){

    }

    @Override
    public List<Trabajo> get(){
        return new ArrayList<>(coleccionTrabajos);
    }


    @Override
    public List<Trabajo> get(Cliente cliente){
        List<Trabajo> trabajosClientes = new ArrayList<>();
        for(Trabajo Trabajo : coleccionTrabajos){
            if(Trabajo.getCliente().equals(cliente)){
                trabajosClientes.add(Trabajo);
            }
        }
        return trabajosClientes;
    }


    @Override
    public List<Trabajo> get(Vehiculo vehiculo){
        List<Trabajo> trabajosVehiculos = new ArrayList<>();
        for(Trabajo Trabajo : coleccionTrabajos){
            if(Trabajo.getVehiculo().equals(vehiculo)){
                trabajosVehiculos.add(Trabajo);
            }
        }
        return trabajosVehiculos;
    }


    @Override
    public void insertar(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo,"No se puede insertar un trabajo nulo.");
        comprobarTrabajo(trabajo.getCliente(), trabajo.getVehiculo(), trabajo.getFechaInicio());
        coleccionTrabajos.add(trabajo);
    }




    private void comprobarTrabajo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws TallerMecanicoExcepcion{
        for(Trabajo trabajo : coleccionTrabajos){
            if(!trabajo.estaCerrado()){
                if(trabajo.getCliente().equals(cliente)){
                    throw new TallerMecanicoExcepcion("El cliente tiene otro trabajo en curso.");
                } else if(trabajo.getVehiculo().equals(vehiculo)){
                    throw new TallerMecanicoExcepcion("El vehículo está actualmente en el taller.");
                }


            } else {
                if(trabajo.getCliente().equals(cliente) && !fechaRevision.isAfter(trabajo.getFechaFin())){
                    throw new TallerMecanicoExcepcion("El cliente tiene otro trabajo posterior.");
                } else if (trabajo.getVehiculo().equals(vehiculo) && !fechaRevision.isAfter(trabajo.getFechaFin())){
                    throw new TallerMecanicoExcepcion("El vehículo tiene otro trabajo posterior.");
                }
            }
        }
    }


    @Override
    public Trabajo anadirHoras(Trabajo trabajo, int horas) throws TallerMecanicoExcepcion{
        Objects.requireNonNull(trabajo, "No puedo añadir horas a un trabajo nulo.");
        Trabajo trabajoEncontrado = getTrabajoAbierto(trabajo.getVehiculo());
        trabajoEncontrado.anadirHoras(horas);
        return trabajoEncontrado;
    }




    private Trabajo getTrabajoAbierto(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(vehiculo, "No puedo operar sobre una revisión nula.");
        Trabajo trabajoEncontrado = null;
        Iterator<Trabajo> iteradorTrabajos = coleccionTrabajos.iterator();
        while (iteradorTrabajos.hasNext() && trabajoEncontrado == null){
            Trabajo trabajo = iteradorTrabajos.next();
            if(trabajo.getVehiculo().equals(vehiculo) && !trabajo.estaCerrado()){
                trabajoEncontrado = trabajo;
            }
        }
        if(trabajoEncontrado == null){
            throw new TallerMecanicoExcepcion("No existe ningún trabajo abierto para dicho vehículo.");
        }
        return trabajoEncontrado;
    }


    @Override
    public Trabajo anadirPrecioMaterial(Trabajo trabajo, float precioMaterial) throws TallerMecanicoExcepcion{
        Objects.requireNonNull(trabajo, "No puedo añadir precio del material a un trabajo nulo.");
        Trabajo trabajoEncontrado = getTrabajoAbierto(trabajo.getVehiculo());
        if(trabajoEncontrado instanceof Mecanico mecanico){
            mecanico.anadirPrecioMaterial(precioMaterial);
        } else {
            throw new TallerMecanicoExcepcion("No se puede añadir precio al material para este tipo de trabajos.");
        }
        return trabajoEncontrado;
    }


    @Override
    public Trabajo cerrar(Trabajo trabajo, LocalDate fechaFin) throws TallerMecanicoExcepcion{
        Objects.requireNonNull(trabajo, "No puedo cerrar un trabajo nulo.");
        Trabajo trabajoEncontrado = getTrabajoAbierto(trabajo.getVehiculo());
        trabajoEncontrado.cerrar(fechaFin);
        return trabajoEncontrado;
    }


    @Override
    public Trabajo buscar(Trabajo trabajo) {
        Objects.requireNonNull(trabajo, "No se puede buscar un trabajo nulo.");
        int indice = coleccionTrabajos.indexOf(trabajo);
        return (indice != -1) ? coleccionTrabajos.get(indice) : null;
    }




    @Override
    public void borrar(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No se puede borrar un trabajo nulo.");
        if (!coleccionTrabajos.contains(trabajo)) {
            throw new TallerMecanicoExcepcion("No existe ningún trabajo igual.");
        }
        coleccionTrabajos.remove(trabajo);
    }
}






