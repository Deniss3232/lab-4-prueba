import java.util.Date;
import java.util.Scanner;

public class InterfazClaseB {
    public static void main(String[] args) {
        ClaseB vehiculo = new ClaseB(); // Crea una instancia de ClaseB
        Scanner scanner = new Scanner(System.in); // Inicializa un objeto Scanner para la entrada del usuario
        int opcion; // Variable para almacenar la opción seleccionada por el usuario

        do {
            // Lectura de la opción ingresada por el usuario
            opcion = scanner.nextInt(); // Lee la opción ingresada
            scanner.nextLine(); // Consume la nueva línea después de la entrada

            switch (opcion) {
                case 1: // Encender sistema
                    vehiculo.encender(); // Llama al método encender()
                    break;

                case 2: // Apagar sistema
                    vehiculo.apagar(); // Llama al método apagar()
                    break;

                case 3: // Ajustar temperatura
                    int temperatura = scanner.nextInt(); // Lee la temperatura
                    scanner.nextLine();
                    vehiculo.ajustarTemperatura(temperatura); // Ajusta la temperatura
                    break;

                case 4: // Ajustar nivel de ventilación
                    int nivelVentilacion = scanner.nextInt(); // Lee el nivel de ventilación
                    scanner.nextLine();
                    vehiculo.ajustarNivelVentilacion(nivelVentilacion); // Ajusta el nivel de ventilación
                    break;

                case 5: // Ajustar dirección de ventilación
                    String direccion = scanner.nextLine(); // Lee la dirección de ventilación
                    vehiculo.ajustarDireccionVentilacion(direccion); // Ajusta la dirección
                    break;

                case 6: // Activar/Desactivar modo Eco
                    boolean activarModoEco = scanner.nextBoolean(); // Lee si activa o no el modo Eco
                    scanner.nextLine();
                    vehiculo.activarModoEco(activarModoEco); // Activa o desactiva el modo Eco
                    break;

                case 7: // Registrar mantenimiento
                    String descripcion = scanner.nextLine(); // Lee la descripción del mantenimiento
                    vehiculo.registrarMantenimiento(descripcion); // Registra el mantenimiento
                    break;

                case 8: // Mostrar historial de mantenimiento
                    vehiculo.mostrarHistorialMantenimiento(); // Muestra el historial
                    break;

                case 9: // Programar próximo mantenimiento
                    String fechaInput = scanner.nextLine(); // Lee la fecha como texto
                    try {
                        Date fecha = new Date(fechaInput); // Convierte el texto en fecha
                        vehiculo.programarMantenimiento(fecha); // Programa el mantenimiento
                    } catch (Exception e) {
                        // Manejo de errores en la fecha
                    }
                    break;

                case 10: // Mostrar próximo mantenimiento
                    vehiculo.mostrarProximoMantenimiento(); // Muestra el próximo mantenimiento
                    break;

                case 0: // Salir
                    break;

                default: // Opciones inválidas
                    // No realiza ninguna acción
                    break;
            }
        } while (opcion != 0); // Repite mientras la opción no sea salir

        scanner.close(); // Cierra el scanner al finalizar
    }
}
