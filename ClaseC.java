// ClaseC.java

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// ClaseC representa un vehículo de gama básica con funcionalidades limitadas
public class ClaseC implements Climatizacion, Ventilacion {

    private List<String> historialMantenimiento; // Historial de mantenimiento
    private Date proximoMantenimiento; // Próximo mantenimiento programado

    // Constructor que inicializa el historial y el próximo mantenimiento
    public ClaseC() {
        historialMantenimiento = new ArrayList<>();
        proximoMantenimiento = null;
    }

    // Implementación de encender() de Climatizacion
    @Override
    public String encender() {
        return "Sistema de climatización encendido.";
    }

    // Implementación de apagar() de Climatizacion
    @Override
    public String apagar() {
        return "Sistema de climatización apagado.";
    }

    // Implementación de ajustarTemperatura() de Climatizacion
    @Override
    public String ajustarTemperatura(int cambio) {
        return "Temperatura ajustada en " + cambio + " grados.";
    }

    // Genera un aviso de mantenimiento para el sistema de climatización
    public String generarAvisoMantenimiento() {
        return "Aviso: Se recomienda realizar mantenimiento al sistema de climatización.";
    }

    // Registra una entrada de mantenimiento en el historial con fecha y descripción
    public String registrarMantenimiento(String descripcion) {
        String registro = new Date() + " - " + descripcion;
        historialMantenimiento.add(registro);
        return "Registro de mantenimiento añadido: " + registro;
    }

    // Muestra el historial completo de mantenimientos
    public String mostrarHistorialMantenimiento() {
        StringBuilder historial = new StringBuilder("Historial de Mantenimiento:\n");
        for (String registro : historialMantenimiento) { // Recorre cada entrada en el historial
            historial.append(registro).append("\n");
        }
        return historial.toString();
    }

    // Programa la fecha para el próximo mantenimiento
    public String programarMantenimiento(Date fecha) {
        proximoMantenimiento = fecha;
        return "Próximo mantenimiento programado para: " + fecha;
    }

    // Muestra la fecha del próximo mantenimiento programado
    public String mostrarProximoMantenimiento() {
        return (proximoMantenimiento != null) ? 
               "Próximo mantenimiento programado para: " + proximoMantenimiento : 
               "No hay mantenimiento programado.";
    }

    // Implementación de ajustarNivelVentilacion() de Ventilacion
    @Override
    public String ajustarNivelVentilacion(int nivel) {
        return "Nivel de ventilación ajustado a " + nivel;
    }

    // Implementación de direccionarFlujoAire() de Ventilacion
    @Override
    public String direccionarFlujoAire(String direccion) {
        return "Flujo de aire direccionado a " + direccion;
    }
}
