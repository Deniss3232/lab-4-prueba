// ClaseA.java

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// ClaseA representa un vehículo de gama alta con funcionalidades avanzadas de climatización
public class ClaseA implements Climatizacion, Ventilacion, Ionizador, Calefaccion {

    private boolean ionizadorActivo; // Indica si el ionizador está activo
    private String intensidadIonizador; // Nivel de intensidad del ionizador
    private boolean purificacionProfundaActiva; // Indica si el modo de purificación profunda está activo
    private String calidadAire; // Calidad actual del aire en el interior del vehículo
    private boolean autoLimpiezaActiva; // Indica si la auto-limpieza del ionizador está activa
    private boolean bajoConsumoActivo; // Indica si el modo de bajo consumo está activo
    private boolean avisoMantenimientoActivo; // Indica si hay un aviso de mantenimiento activo
    private List<String> historialMantenimiento; // Historial de mantenimiento
    private Date proximoMantenimiento; // Próximo mantenimiento programado

    private int nivelVentilacion; // Nivel de ventilación de 1 a 5
    private String direccionVentilacion; // Dirección del flujo de aire (parabrisas, frontal, pies o combinaciones)
    private boolean ventilacionAutomaticaActiva; // Indica si la ventilación automática está activa
    private boolean circulacionInternaActiva; // Indica si la recirculación de aire interno está activa

    // Constructor de ClaseA: inicializa todas las variables de instancia
    public ClaseA() {
        ionizadorActivo = false;
        intensidadIonizador = "bajo";
        purificacionProfundaActiva = false;
        calidadAire = "Buena";
        autoLimpiezaActiva = false;
        bajoConsumoActivo = false;
        avisoMantenimientoActivo = false;
        historialMantenimiento = new ArrayList<>();
        proximoMantenimiento = null;
        nivelVentilacion = 1; // Nivel de ventilación inicial
        direccionVentilacion = "frontal"; // Dirección de ventilación predeterminada
        ventilacionAutomaticaActiva = false;
        circulacionInternaActiva = false;
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

    // Implementación de funcionalidades adicionales de ventilación

    // Ajusta el nivel de ventilación de 1 a 5
    public String ajustarNivelVentilacion(int nivel) {
        if (nivel < 1 || nivel > 5) {
            return "Nivel de ventilación inválido. Seleccione un nivel entre 1 y 5.";
        }
        nivelVentilacion = nivel;
        return "Nivel de ventilación ajustado a " + nivel;
    }

    // Ajusta la dirección del flujo de aire
    public String ajustarDireccionVentilacion(String direccion) {
        if (direccion.equals("parabrisas") || direccion.equals("frontal") || direccion.equals("pies") ||
            direccion.equals("parabrisas-frontal") || direccion.equals("frontal-pies") || direccion.equals("parabrisas-pies")) {
            direccionVentilacion = direccion;
            return "Dirección de ventilación ajustada a: " + direccion;
        }
        return "Dirección de ventilación inválida. Use 'parabrisas', 'frontal', 'pies' o combinaciones.";
    }

    // Activa o desactiva la ventilación automática según temperatura y calidad del aire
    public String activarVentilacionAutomatica(boolean activar) {
        ventilacionAutomaticaActiva = activar;
        if (activar) {
            return "Ventilación automática activada. Ajustando según temperatura y calidad del aire.";
        }
        return "Ventilación automática desactivada.";
    }

    // Activa la recirculación de aire interno
    public String activarCirculacionInterna(boolean activar) {
        circulacionInternaActiva = activar;
        if (activar) {
            return "Modo de circulación interna activado. Evitando entrada de aire exterior.";
        }
        return "Modo de circulación interna desactivado. Permitida la entrada de aire exterior.";
    }

    // Métodos adicionales de Ionizador

    @Override
    public String activarIonizador() {
        ionizadorActivo = true;
        return "Ionizador activado.";
    }

    @Override
    public String modoPurificacionProfunda() {
        purificacionProfundaActiva = true;
        ionizadorActivo = true;
        intensidadIonizador = "alto";
        return "Modo de purificación profunda activado. Duración aproximada: 10 minutos.";
    }

    // Muestra la calidad actual del aire
    public String mostrarCalidadAire() {
        String mensaje = "Calidad del aire interior: " + calidadAire;
        if (calidadAire.equals("Pobre")) {
            mensaje += " Notificación: Calidad del aire baja. Se recomienda activar el ionizador.";
        }
        return mensaje;
    }

    // Actualiza la calidad del aire para simulaciones
    public String actualizarCalidadAire(String nuevaCalidad) {
        if (nuevaCalidad.equals("Excelente") || nuevaCalidad.equals("Buena") || nuevaCalidad.equals("Regular") || nuevaCalidad.equals("Pobre")) {
            calidadAire = nuevaCalidad;
            return "Calidad del aire actualizada a: " + nuevaCalidad;
        }
        return "Calidad de aire inválida. Use 'Excelente', 'Buena', 'Regular' o 'Pobre'.";
    }

    // Activa la auto-limpieza del ionizador
    public String activarAutoLimpieza() {
        autoLimpiezaActiva = true;
        return "Auto-limpieza del ionizador activada y completada.";
    }

    // Muestra una alerta de mantenimiento para el sistema de ionización
    public String mostrarAlertaMantenimiento() {
        return "Alerta: Se recomienda limpiar o reemplazar componentes del sistema de ionización.";
    }

    // Activa el modo de bajo consumo para el ionizador
    public String activarModoBajoConsumo() {
        bajoConsumoActivo = true;
        if (ionizadorActivo) {
            intensidadIonizador = "bajo";
            return "Modo de bajo consumo activado. Intensidad del ionizador ajustada a 'bajo'.";
        }
        return "Modo de bajo consumo activado.";
    }

    public String desactivarModoBajoConsumo() {
        bajoConsumoActivo = false;
        return "Modo de bajo consumo desactivado.";
    }

    // Funciones de mantenimiento

    public String generarAvisoMantenimiento() {
        avisoMantenimientoActivo = true;
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
