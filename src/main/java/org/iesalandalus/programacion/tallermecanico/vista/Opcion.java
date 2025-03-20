package org.iesalandalus.programacion.tallermecanico.vista;

import java.util.HashMap;
import java.util.Map;


public enum Opcion {
    INSERTAR_CLIENTE(11, "Insertar cliente."),
    BUSCAR_CLIENTE(12, "Buscar un cliente."),
    BORRAR_CLIENTE(13, "Borrar un cliente."),
    LISTAR_CLIENTES(14, "Lista los clientes."),
    MODIFICAR_CLIENTE(15, "Modifica un cliente."),
    INSERTAR_VEHICULO(21, "Inserta un vehículo."),
    BUSCAR_VEHICULO(22, "Busca un vehículo."),
    BORRAR_VEHICULO(23,"Borra un vehículo."),
    LISTAR_VEHICULOS(24, "Lista los vehículos."),
    INSERTAR_REVISION(31, "Inserta una revisión."),
    BUSCAR_REVISION(32, "Busca una revisión."),
    BORRAR_REVISION(33, "Borra una revisión."),
    LISTAR_REVISIONES(34, "Lista las revisiones."),
    LISTAR_REVISIONES_CLIENTE(35, "Lista las revisiones de un cliente."),
    LISTAR_REVISIONES_VEHICULO(36, "Lista las revisiones de un vehículo."),
    ANADIR_HORAS_REVISION(37,"Añade las horas de revisión."),
    ANADIR_PRECIO_MATERIAL_REVISION(38, "Añade el precio del material de revisión."),
    CERRAR_REVISION(39, "Cierra la revisión."),
    SALIR(0, "Salir.");

    private final int numeroOpcion;
    private final String texto;
    private static final Map<Integer, Opcion> opciones = new HashMap<>();

    static {
        for (Opcion opcion : values()){
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }
    Opcion (int numeroOpcion, String texto){
        this.numeroOpcion = numeroOpcion;
        this.texto = texto;
    }

    public static boolean esValida(int numeroOpcion){return opciones.containsKey(numeroOpcion);}

    public static Opcion get (int numeroOpcion){
        if (!esValida(numeroOpcion)) {
            throw new IllegalArgumentException("El número de la opción no es correcto.");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {return String.format("[numeroOpcion=%s, texto=%s]", numeroOpcion, texto);}
}
