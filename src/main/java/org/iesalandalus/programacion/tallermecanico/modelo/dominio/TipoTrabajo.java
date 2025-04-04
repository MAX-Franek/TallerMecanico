package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

public enum TipoTrabajo {
    MECANICO("Mecánico"),
    REVISION("Revisión");

    private String nombre;

    private TipoTrabajo(String nombre){
        this.nombre = nombre;
    }

    static TipoTrabajo get(Trabajo trabajo) {
        if (trabajo == null){
            throw new IllegalArgumentException("El trabajo no puede ser nulo");
        }

        if (trabajo instanceof Mecanico) {
            return MECANICO;
        } else if (trabajo instanceof Revision) {
            return REVISION;
        }else {
            throw new IllegalArgumentException("El tipo de trabajo es desconocido");
        }

    }
}
