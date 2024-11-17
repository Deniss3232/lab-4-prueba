// MainWindow.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

// MainWindow crea una interfaz gráfica para controlar las clases de vehículos
public class MainWindow extends JFrame {

    private JComboBox<String> vehicleSelector; // Selector de tipo de vehículo
    private JTextArea outputArea; // Área de salida para mostrar resultados
    private JPanel controlPanel; // Panel de controles específicos para cada vehículo

    // Instancias de las clases de vehículos
    private ClaseA claseA;
    private ClaseB claseB;
    private ClaseC claseC;

    // Constructor para configurar la interfaz gráfica
    public MainWindow() {
        setTitle("Sistema de Climatización y Mantenimiento de Vehículos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicialización de las instancias de vehículos
        claseA = new ClaseA();
        claseB = new ClaseB();
        claseC = new ClaseC();

        // Configuración del selector de vehículos
        vehicleSelector = new JComboBox<>(new String[]{"Clase A", "Clase B", "Clase C"});
        vehicleSelector.addActionListener(new VehicleSelectorListener());

        // Área de salida para mostrar resultados
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setRows(10);

        // Panel de controles
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        // Configuración del layout de la ventana
        setLayout(new BorderLayout());
        add(vehicleSelector, BorderLayout.NORTH); // Selector en la parte superior
        add(new JScrollPane(outputArea), BorderLayout.CENTER); // Área de salida en el centro
        add(controlPanel, BorderLayout.SOUTH); // Panel de control en la parte inferior

        // Inicializa controles para el vehículo por defecto (Clase A)
        updateControlPanel("Clase A");
    }

    // Actualiza el panel de control según el tipo de vehículo seleccionado
    private void updateControlPanel(String vehicleType) {
        controlPanel.removeAll(); // Limpia el panel de controles

        // Añade controles específicos para el tipo de vehículo seleccionado
        if (vehicleType.equals("Clase A")) {
            addControlsForClaseA();
        } else if (vehicleType.equals("Clase B")) {
            addControlsForClaseB();
        } else if (vehicleType.equals("Clase C")) {
            addControlsForClaseC();
        }

        controlPanel.revalidate(); // Actualiza el panel de controles
        controlPanel.repaint(); // Refresca la interfaz gráfica
    }

    // Añade los controles específicos para Clase A, incluyendo las nuevas funcionalidades de ventilación
    private void addControlsForClaseA() {
        JButton encenderButton = new JButton("Encender Climatización");
        encenderButton.addActionListener(e -> outputArea.append(claseA.encender() + "\n"));

        JButton apagarButton = new JButton("Apagar Climatización");
        apagarButton.addActionListener(e -> outputArea.append(claseA.apagar() + "\n"));

        JButton activarIonizadorButton = new JButton("Activar Ionizador");
        activarIonizadorButton.addActionListener(e -> outputArea.append(claseA.activarIonizador() + "\n"));

        JButton registrarMantenimientoButton = new JButton("Registrar Mantenimiento");
        registrarMantenimientoButton.addActionListener(e -> outputArea.append(claseA.registrarMantenimiento("Cambio de filtro") + "\n"));

        JButton mostrarHistorialButton = new JButton("Mostrar Historial de Mantenimiento");
        mostrarHistorialButton.addActionListener(e -> outputArea.append(claseA.mostrarHistorialMantenimiento() + "\n"));

        JButton programarMantenimientoButton = new JButton("Programar Mantenimiento");
        programarMantenimientoButton.addActionListener(e -> {
            Date fecha = new Date(System.currentTimeMillis() + 86400000); // +1 día desde hoy
            outputArea.append(claseA.programarMantenimiento(fecha) + "\n");
        });

        // Botón para ajustar el nivel de ventilación
        JButton ajustarNivelVentilacionButton = new JButton("Ajustar Nivel de Ventilación (1-5)");
        ajustarNivelVentilacionButton.addActionListener(e -> {
            String nivel = JOptionPane.showInputDialog("Ingrese nivel de ventilación (1-5):");
            if (nivel != null) {
                int nivelInt = Integer.parseInt(nivel);
                outputArea.append(claseA.ajustarNivelVentilacion(nivelInt) + "\n");
            }
        });

        // Botón para ajustar la dirección de ventilación
        JButton ajustarDireccionVentilacionButton = new JButton("Ajustar Dirección de Ventilación");
        ajustarDireccionVentilacionButton.addActionListener(e -> {
            String[] opciones = {"parabrisas", "frontal", "pies", "parabrisas-frontal", "frontal-pies", "parabrisas-pies"};
            String direccion = (String) JOptionPane.showInputDialog(
                    null, 
                    "Seleccione la dirección del flujo de aire:", 
                    "Dirección de Ventilación", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]
            );
            if (direccion != null) {
                outputArea.append(claseA.ajustarDireccionVentilacion(direccion) + "\n");
            }
        });

        // Botón para activar o desactivar la ventilación automática
        JButton activarVentilacionAutomaticaButton = new JButton("Activar Ventilación Automática");
        activarVentilacionAutomaticaButton.addActionListener(e -> outputArea.append(claseA.activarVentilacionAutomatica(true) + "\n"));

        JButton desactivarVentilacionAutomaticaButton = new JButton("Desactivar Ventilación Automática");
        desactivarVentilacionAutomaticaButton.addActionListener(e -> outputArea.append(claseA.activarVentilacionAutomatica(false) + "\n"));

        // Botón para activar o desactivar la circulación interna
        JButton activarCirculacionInternaButton = new JButton("Activar Circulación Interna");
        activarCirculacionInternaButton.addActionListener(e -> outputArea.append(claseA.activarCirculacionInterna(true) + "\n"));

        JButton desactivarCirculacionInternaButton = new JButton("Desactivar Circulación Interna");
        desactivarCirculacionInternaButton.addActionListener(e -> outputArea.append(claseA.activarCirculacionInterna(false) + "\n"));

        // Añade todos los botones al panel de control
        controlPanel.add(encenderButton);
        controlPanel.add(apagarButton);
        controlPanel.add(activarIonizadorButton);
        controlPanel.add(registrarMantenimientoButton);
        controlPanel.add(mostrarHistorialButton);
        controlPanel.add(programarMantenimientoButton);
        controlPanel.add(ajustarNivelVentilacionButton);
        controlPanel.add(ajustarDireccionVentilacionButton);
        controlPanel.add(activarVentilacionAutomaticaButton);
        controlPanel.add(desactivarVentilacionAutomaticaButton);
        controlPanel.add(activarCirculacionInternaButton);
        controlPanel.add(desactivarCirculacionInternaButton);
    }

    // Añade los controles específicos para Clase B, incluyendo las nuevas funcionalidades de ventilación
    private void addControlsForClaseB() {
        JButton encenderButton = new JButton("Encender Climatización");
        encenderButton.addActionListener(e -> outputArea.append(claseB.encender() + "\n"));

        JButton apagarButton = new JButton("Apagar Climatización");
        apagarButton.addActionListener(e -> outputArea.append(claseB.apagar() + "\n"));

        JButton registrarMantenimientoButton = new JButton("Registrar Mantenimiento");
        registrarMantenimientoButton.addActionListener(e -> outputArea.append(claseB.registrarMantenimiento("Cambio de filtro") + "\n"));

        JButton mostrarHistorialButton = new JButton("Mostrar Historial de Mantenimiento");
        mostrarHistorialButton.addActionListener(e -> outputArea.append(claseB.mostrarHistorialMantenimiento() + "\n"));

        JButton programarMantenimientoButton = new JButton("Programar Mantenimiento");
        programarMantenimientoButton.addActionListener(e -> {
            Date fecha = new Date(System.currentTimeMillis() + 00000000); // +1 día desde hoy
            outputArea.append(claseB.programarMantenimiento(fecha) + "\n");
        });

        // Botón para ajustar el nivel de ventilación
        JButton ajustarNivelVentilacionButton = new JButton("Ajustar Nivel de Ventilación (1-3)");
        ajustarNivelVentilacionButton.addActionListener(e -> {
            String nivel = JOptionPane.showInputDialog("Ingrese nivel de ventilación (1-3):");
            if (nivel != null) {
                int nivelInt = Integer.parseInt(nivel);
                outputArea.append(claseB.ajustarNivelVentilacion(nivelInt) + "\n");
            }
        });

        // Botón para ajustar la dirección de ventilación
        JButton ajustarDireccionVentilacionButton = new JButton("Ajustar Dirección de Ventilación");
        ajustarDireccionVentilacionButton.addActionListener(e -> {
            String[] opciones = {"parabrisas", "frontal", "pies"};
            String direccion = (String) JOptionPane.showInputDialog(
                    null, 
                    "Seleccione la dirección del flujo de aire:", 
                    "Dirección de Ventilación", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]
            );
            if (direccion != null) {
                outputArea.append(claseB.ajustarDireccionVentilacion(direccion) + "\n");
            }
        });

        // Botón para activar o desactivar el modo Eco de ventilación
        JButton activarModoEcoButton = new JButton("Activar Modo Eco");
        activarModoEcoButton.addActionListener(e -> outputArea.append(claseB.activarModoEco(true) + "\n"));

        JButton desactivarModoEcoButton = new JButton("Desactivar Modo Eco");
        desactivarModoEcoButton.addActionListener(e -> outputArea.append(claseB.activarModoEco(false) + "\n"));

        // Añade los botones al panel de control
        controlPanel.add(encenderButton);
        controlPanel.add(apagarButton);
        controlPanel.add(registrarMantenimientoButton);
        controlPanel.add(mostrarHistorialButton);
        controlPanel.add(programarMantenimientoButton);
        controlPanel.add(ajustarNivelVentilacionButton);
        controlPanel.add(ajustarDireccionVentilacionButton);
        controlPanel.add(activarModoEcoButton);
        controlPanel.add(desactivarModoEcoButton);
    }

    // Añade los controles específicos para Clase C
    private void addControlsForClaseC() {
        JButton encenderButton = new JButton("Encender Climatización");
        encenderButton.addActionListener(e -> outputArea.append(claseC.encender() + "\n"));

        JButton apagarButton = new JButton("Apagar Climatización");
        apagarButton.addActionListener(e -> outputArea.append(claseC.apagar() + "\n"));

        JButton registrarMantenimientoButton = new JButton("Registrar Mantenimiento");
        registrarMantenimientoButton.addActionListener(e -> outputArea.append(claseC.registrarMantenimiento("Revisión del sistema") + "\n"));

        JButton mostrarHistorialButton = new JButton("Mostrar Historial de Mantenimiento");
        mostrarHistorialButton.addActionListener(e -> outputArea.append(claseC.mostrarHistorialMantenimiento() + "\n"));

        JButton programarMantenimientoButton = new JButton("Programar Mantenimiento");
        programarMantenimientoButton.addActionListener(e -> {
            Date fecha = new Date(System.currentTimeMillis() + 00000000); // +1 día desde hoy
            outputArea.append(claseC.programarMantenimiento(fecha) + "\n");
        });

        // Añade los botones al panel de control
        controlPanel.add(encenderButton);
        controlPanel.add(apagarButton);
        controlPanel.add(registrarMantenimientoButton);
        controlPanel.add(mostrarHistorialButton);
        controlPanel.add(programarMantenimientoButton);
    }

    // Clase interna para manejar la selección de tipo de vehículo
    private class VehicleSelectorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedVehicle = (String) vehicleSelector.getSelectedItem();
            updateControlPanel(selectedVehicle); // Cambia los controles según el vehículo seleccionado
        }
    }

    // Método main para iniciar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
