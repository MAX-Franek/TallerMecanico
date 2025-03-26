package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.time.LocalDate;

public class Revision extends Trabajo {

    private static final float FACTOR_HORA = 35F;

    public Revision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio){
        super(cliente, vehiculo, fechaInicio);
    }
    public Revision(Revision revision){super(revision);}

    @Override
    public float getPrecioEspecifico(){return (estaCerrada()) ? FACTOR_HORA * getHoras() : 0;}

    @Override
    public String toString() {
        String cadena;
        if (!estaCerrada()){
            cadena = String.format("%s - %s: (%s - ), 0 horas, 0,00 € en material", getCliente(), getVehiculo(), getFechaInicio().format(FORMATO_FECHA));
        }else {
            cadena =  String.format("%s - %s: (%s - %s), 0 horas, 0,00 € en material, 10,00 € total", getCliente(), getVehiculo(), getFechaInicio().format(FORMATO_FECHA), getFechaFin().format(FORMATO_FECHA));
        }
        return cadena;
    }

}