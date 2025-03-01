package com.mycompany.eliminaralrato;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Interfaz {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Programas Académicos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 650);

        // Crear un panel para organizar los campos de texto
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridBagLayout()); // Usamos GridBagLayout para un mejor control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre los componentes

        // Campos de texto
        JLabel lblClave = new JLabel("Clave:");
        JTextField txtClave = new JTextField(20);
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblDescripcion = new JLabel("Descripción:");
        JTextField txtDescripcion = new JTextField(20);
        JLabel lblFecha = new JLabel("Fecha:");

        // Campo para mostrar la fecha seleccionada
        JTextField txtFecha = new JTextField(20);
        txtFecha.setEnabled(false); // Este campo solo se usará para mostrar la fecha seleccionada.

        // Crear un botón para elegir la fecha
        JButton btnElegirFecha = new JButton("Elegir Fecha");

        // Crear el calendario (JCalendar)
        JCalendar calendario = new JCalendar();
        calendario.setPreferredSize(new Dimension(250, 250)); // Ajustar el tamaño
        calendario.setTodayButtonVisible(true); // Muestra el botón de "Hoy"

        // Crear un JDialog para mostrar el calendario cuando el botón "Elegir Fecha" sea presionado
        JDialog dialogoCalendario = new JDialog(ventana, "Seleccionar Fecha", true);
        dialogoCalendario.setSize(350, 350);
        dialogoCalendario.setLayout(new BorderLayout());
        dialogoCalendario.add(calendario, BorderLayout.CENTER);

        // Botón para seleccionar la fecha en el calendario
        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Al seleccionar una fecha, actualizar el campo de texto con la fecha elegida
                Date fechaSeleccionada = calendario.getDate();
                txtFecha.setText(fechaSeleccionada.toString());
                dialogoCalendario.dispose(); // Cerrar el JDialog del calendario
            }
        });

        dialogoCalendario.add(btnSeleccionar, BorderLayout.SOUTH); // Agregar el botón "Seleccionar" debajo del calendario

        // Cuando el botón "Elegir Fecha" es presionado, mostrar el JDialog con el calendario
        btnElegirFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogoCalendario.setLocationRelativeTo(ventana); // Centrar el JDialog respecto a la ventana principal
                dialogoCalendario.setVisible(true); // Mostrar el JDialog con el calendario
            }
        });

        // Añadir los campos y el botón al panel usando GridBagLayout
        gbc.gridx = 0; gbc.gridy = 0;
        panelCampos.add(lblClave, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panelCampos.add(txtClave, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelCampos.add(lblNombre, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panelCampos.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelCampos.add(lblDescripcion, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panelCampos.add(txtDescripcion, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panelCampos.add(lblFecha, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panelCampos.add(txtFecha, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        panelCampos.add(btnElegirFecha, gbc); 

        // Crear el panel lateral para los botones (Botones en la parte lateral)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Layout vertical para los botones
        panelBotones.setBorder(BorderFactory.createEmptyBorder(3, 5, 20, 10)); // Agregar borde para espaciado

        JButton btnNuevo = new JButton("+ Nuevo");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnActualizar = new JButton("Editar");
        JButton btnCancelar = new JButton("X Cancelar");

        panelBotones.add(btnNuevo);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnCancelar);
        
        
        btnGuardar.setEnabled(false);
        btnElegirFecha.setEnabled(false);
        btnCancelar.setEnabled(false);
        // Crear la tabla para mostrar los datos
        String[] columnas = {"Clave", "Nombre", "Descripción", "Fecha"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        // Organizar los componentes en la ventana
        ventana.setLayout(new BorderLayout(20, 20)); 
        ventana.add(panelCampos, BorderLayout.CENTER); 
        ventana.add(panelBotones, BorderLayout.EAST); 
        ventana.add(scroll, BorderLayout.SOUTH); 

        // Acciones de los botones
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Habilitar los campos y el calendario cuando se presiona "Nuevo"
                txtClave.setEnabled(true);
                txtNombre.setEnabled(true);
                txtDescripcion.setEnabled(true);
                calendario.setEnabled(true);  // Habilitar el calendario

                // Limpiar los campos de texto
                txtClave.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                calendario.setDate(new java.util.Date());  // Establece la fecha actual

                // Deshabilitar botones según la acción
                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnBuscar.setEnabled(false);
                btnActualizar.setEnabled(false);
                btnNuevo.setEnabled(false);
                btnElegirFecha.setEnabled(true);
                btnCancelar.setEnabled(true);
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String clave = txtClave.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String fecha = calendario.getDate().toString();  // Obtiene la fecha seleccionada en el calendario

                // Verificar si alguno de los campos está vacío
                if (clave.isEmpty() || nombre.isEmpty() || descripcion.isEmpty() || fecha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Formulario incompleto", JOptionPane.INFORMATION_MESSAGE);
                    return;  // Detener la ejecución si hay campos vacíos
                }

                // Si todos los campos están completos, agregar la fila a la tabla
                modeloTabla.addRow(new Object[]{clave, nombre, descripcion, fecha});

                // Lógica para habilitar y deshabilitar botones
                btnGuardar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnBuscar.setEnabled(true);
                btnActualizar.setEnabled(true);
            }
        });


        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabla.getSelectedRow();
                if (row >= 0) {
                    modeloTabla.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(ventana, "Seleccione una fila para eliminar.");
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto excepto la fecha
                txtClave.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                
                // Dejar la fecha seleccionada (no la borramos)
                // txtFecha.setText(""); // No limpiar el campo de fecha

                // Deshabilitar los campos y el calendario
                txtClave.setEnabled(false);
                txtNombre.setEnabled(false);
                txtDescripcion.setEnabled(false);
                
                // Activar botones cuando se cancele la operación
                btnEliminar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnActualizar.setEnabled(true);
                btnNuevo.setEnabled(true);
                btnCancelar.setEnabled(false);
                btnElegirFecha.setEnabled(false);
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabla.getSelectedRow();
                if (row >= 0) {
                    txtClave.setText((String) modeloTabla.getValueAt(row, 0));
                    txtNombre.setText((String) modeloTabla.getValueAt(row, 1));
                    txtDescripcion.setText((String) modeloTabla.getValueAt(row, 2));
                    calendario.setDate((java.util.Date) modeloTabla.getValueAt(row, 3));  // Actualiza la fecha
                } else {
                    JOptionPane.showMessageDialog(ventana, "Seleccione una fila para actualizar.");
                }
            }
        });

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
