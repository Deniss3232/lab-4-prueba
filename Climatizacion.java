// Climatizacion.java

// Interfaz para el sistema de climatización general
interface Climatizacion {
    String encender();               // Método para encender el sistema de climatización
    String apagar();                 // Método para apagar el sistema de climatización
    String ajustarTemperatura(int cambio); // Método para ajustar la temperatura
}

// Interfaz para funcionalidades de ventilación
interface Ventilacion {
    String ajustarNivelVentilacion(int nivel);  // Método para ajustar el nivel de ventilación
    String direccionarFlujoAire(String direccion); // Método para direccionar el flujo de aire
}

// Interfaz para funcionalidades del ionizador (solo en Clase A)
interface Ionizador {
    String activarIonizador();        // Método para activar el ionizador
    String modoPurificacionProfunda(); // Método para activar el modo de purificación profunda
}

// Interfaz para funcionalidades de calefacción
interface Calefaccion {
    String ajustarCalefaccionAsientos(int nivel); // Método para ajustar la calefacción de los asientos
}
