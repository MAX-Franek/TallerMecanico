package org.iesalandalus.programacion.tallermecanico.vista.ventanas.controladores;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.iesalandalus.programacion.tallermecanico.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.tallermecanico.vista.ventanas.utilidades.Controladores;

public class VentanaPrincipal extends Controlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> co_dni;

    @FXML
    private TableColumn<?, ?> co_nombre;

    @FXML
    private TableColumn<?, ?> co_telefono;

    @FXML
    private TableView<?> tabla_cliente;

    @FXML
    void insertarCliente(ActionEvent event) {
        LeerCliente leerCliente = (LeerCliente) Controladores.get("/vistas/leerCliente.fxml", "Leer Cliente", null);
        leerCliente.getEscenario().showAndWait();
        leerCliente.centrar();
    }
    @FXML
    void insertarVehiculo(ActionEvent event) {
        LeerVehiculo leerVehiculo = (LeerVehiculo) Controladores.get("/vistas/leerVehiculo.fxml","Leer Vehiculo", null);
        leerVehiculo.getEscenario().showAndWait();
        leerVehiculo.centrar();
    }
    @FXML
    void leerRevision(ActionEvent event) {
        LeerRevision leerRevision = (LeerRevision) Controladores.get("/vistas/leerRevision.fxml", "Leer Revision", null);
        leerRevision.getEscenario().showAndWait();
        leerRevision.centrar();
    }

    @FXML
    void initialize() {
        assert co_dni != null : "fx:id=\"co_dni\" was not injected: check your FXML file 'VentanaPrincipal.fxml'.";
        assert co_nombre != null : "fx:id=\"co_nombre\" was not injected: check your FXML file 'VentanaPrincipal.fxml'.";
        assert co_telefono != null : "fx:id=\"co_telefono\" was not injected: check your FXML file 'VentanaPrincipal.fxml'.";
        assert tabla_cliente != null : "fx:id=\"tabla_cliente\" was not injected: check your FXML file 'VentanaPrincipal.fxml'.";

    }
}