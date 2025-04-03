package org.iesalandalus.programacion.tallermecanico.vista.eventos;

import java.util.HashMap;
import java.util.Map;

public enum Evento {
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
    INSERTAR_MECANICO(32, "Insertar un mecanico."),
    BUSCAR_TRABAJO(33, "Busca una revisión."),
    BORRAR_TRABAJO(34, "Borra una revisión."),
    LISTAR_TRABAJOS(35, "Lista las revisiones."),
    LISTAR_TRABAJOS_CLIENTE(36, "Lista las revisiones de un cliente."),
    LISTAR_TRABAJOS_VEHICULO(37, "Lista las revisiones de un vehículo."),
    ANADIR_HORAS_TRABAJO(38,"Añadir horas a un trabajo."),
    ANADIR_PRECIO_MATERIAL_TRABAJO(39, "Añade el precio del material a un trabajo."),
    CERRAR_TRABAJO(40, "Cerrar trabajo."),
    SALIR(0, "Salir.");

    private final int codigo;
    private final String texto;
    private static final Map<Integer, Evento> eventos = new HashMap<>();

    static {
        for (Evento evento : values()){
            eventos.put(evento.codigo, evento);
        }
    }
    private Evento(int codigo, String texto){
        this.codigo = codigo;
        this.texto = texto;
    }
    public int getCodigo(){return codigo;}

    public static boolean esValido(int codigo){return eventos.containsKey(codigo);}

    public static Evento get (int codigo){
        if (!esValido(codigo)) {
            throw new IllegalArgumentException("El código no es correcto");
        }
        return eventos.get(codigo);
    }

    @Override
    public String toString() {return texto;}
}
