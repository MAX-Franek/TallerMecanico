package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;

public class Mecanico extends Trabajo {
    private static final float FACTOR_HORA = 30F;
    private static final float FACTOR_PRECIO_MATERIAL = 1.5F;
    private float precioMaterial;

    public Mecanico(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        super(cliente, vehiculo, fechaInicio);
        precioMaterial = 0;
    }

    public Mecanico(Mecanico mecanico) {
        super(mecanico);
        precioMaterial = mecanico.precioMaterial;
    }

    public float getPrecioMaterial() {
        return precioMaterial;
    }

    public void anadirPrecioMaterial(float precioMaterial) throws TallerMecanicoExcepcion {
        if (precioMaterial <= 0) {
            throw new IllegalArgumentException("El precio del material a añadir debe ser mayor que cero.");
        }
        if (estaCerrado()) {
            throw new TallerMecanicoExcepcion("No se puede añadir precio del material, ya que el trabajo mecánico está cerrado.");
        }
        this.precioMaterial += precioMaterial;
    }

    @Override
    public float getPrecioEspecifico(){
        return (estaCerrado()) ? FACTOR_HORA * getHoras() + FACTOR_PRECIO_MATERIAL * getPrecioMaterial() : 0;
    }

    @Override
    public String toString() {
        String cadena;
        if (!estaCerrado()){
            cadena = String.format("Mecánico -> %s - %s (%s - ): 0 horas, 0,00 € en material", getCliente(), getVehiculo(), getFechaInicio().format(FORMATO_FECHA));
        }else {
            cadena =  String.format("Mecánico -> %s - %s (%s - %s): 0 horas, 0,00 € en material, 10,00 € total", getCliente(), getVehiculo(), getFechaInicio().format(FORMATO_FECHA), getFechaFin().format(FORMATO_FECHA));
        }
        return cadena;
    }

}