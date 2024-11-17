// ClaseB.java

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// ClaseB representa un vehículo de gama media con funcionalidades de ventilación moderadas
public class ClaseB implements Climatizacion, Ventilacion, Calefaccion {

    private List<String> historialMantenimiento; // Historial de mantenimiento
    private Date proximoMantenimiento; // Próximo mantenimiento programado

    private int nivelVentilacion; // Nivel de ventilación de 1 a 3
    private String direccionVentilacion; // Dirección del flujo de aire (parabrisas, frontal, pies)
    private boolean modoEcoActivo; // Indica si el modo Eco de ventilación está activo

    // Constructor que inicializa las variables de la clase
    public ClaseB() {
        historialMantenimiento = new ArrayList<>();
        proximoMantenimiento = null;
        nivelVentilacion = 1; // Nivel de ventilación inicial
        direccionVentilacion = "frontal"; // Dirección de ventilación predeterminada
        modoEcoActivo = false; // El modo Eco está desactivado por defecto
    }

    // Métodos de Climatización básica

    @Override
    public String encender() {
        return "Sistema de climatización encendido.";
    }

    @Override
    public String apagar() {
        return "Sistema de climatización apagado.";
    }

    @Override
    public String ajustarTemperatura(int cambio) {
        return "Temperatura ajustada en " + cambio + " grados.";
    }

    // Funcionalidades adicionales de ventilación

    // Ajusta el nivel de ventilación de 1 a 3
    public String ajustarNivelVentilacion(int nivel) {
        if (nivel < 1 || nivel > 3) {
            return "Nivel de ventilación inválido. Seleccione un nivel entre 1 y 3.";
        }
        nivelVentilacion = nivel;
        return "Nivel de ventilación ajustado a " + nivel;
    }

    // Ajusta la dirección del flujo de aire
    public String ajustarDireccionVentilacion(String direccion) {
        if (direccion.equals("parabrisas") || direccion.equals("frontal") || direccion.equals("pies")) {
            direccionVentilacion = direccion;
            return "Dirección de ventilación ajustada a: " + direccion;
        }
        return "Dirección de ventilación inválida. Use 'parabrisas', 'frontal' o 'pies'.";
    }

    // Activa o desactiva el modo Eco de ventilación para ahorro de energía
    public String activarModoEco(boolean activar) {
        modoEcoActivo = activar;
        if (activar) {
            return "Modo Eco de ventilación activado. Intensidad de ventilación reducida para ahorro de energía.";
        }
        return "Modo Eco de ventilación desactivado.";
    }

    // Funciones de mantenimiento

    public String generarAvisoMantenimiento() {
        return "Aviso: Se recomienda realizar mantenimiento al sistema de climatización.";
    }

    public String registrarMantenimiento(String descripcion) {
        String registro = new Date() + " - " + descripcion;
        historialMantenimiento.add(registro);
        return "Registro de mantenimiento añadido: " + registro;
    }

    public String mostrarHistorialMantenimiento() {
        StringBuilder historial = new StringBuilder("Historial de Mantenimiento:\n");
        for (String registro : historialMantenimiento) {
            historial.append(registro).append("\n");
        }
        return historial.toString();
    }

    public String programarMantenimiento(Date fecha) {
        proximoMantenimiento = fecha;
        return "Próximo mantenimiento programado para: " + fecha;
    }

    public String mostrarProximoMantenimiento() {
        return (proximoMantenimiento != null) ? 
               "Próximo mantenimiento programado para: " + proximoMantenimiento : 
               "No hay mantenimiento programado.";
    }

    // Funciones de calefacción

    @Override
    public String ajustarCalefaccionAsientos(int nivel) {
        return "Calefacción de asientos ajustada a nivel " + nivel;
    }

    // Métodos de ventilación básica

    @Override
    public String direccionarFlujoAire(String direccion) {
        return ajustarDireccionVentilacion(direccion);
    }
}
