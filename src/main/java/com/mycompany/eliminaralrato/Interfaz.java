package com.mycompany.eliminaralrato;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Interfaz {
    private DefaultTableModel modeloTabla;  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz().crearVentana();  
            }
        });
    }

    private void crearVentana() {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Programas Académicos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 650);

        // Crear un panel para organizar los campos de texto
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        
       
        
        // Campos de texto
        JLabel lblClave = new JLabel("Clave:");
        JTextField txtClave = new JTextField(20);
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblDescripcion = new JLabel("Descripción:");
        JTextField txtDescripcion = new JTextField(20);
        JLabel lblFecha = new JLabel("Fecha:");

        JTextField txtFecha = new JTextField(20);
        txtFecha.setEnabled(false);

        JButton btnElegirFecha = new JButton("Elegir Fecha");
        JCalendar calendario = new JCalendar();
        calendario.setPreferredSize(new Dimension(250, 250));
        calendario.setTodayButtonVisible(true);

        JDialog dialogoCalendario = new JDialog(ventana, "Seleccionar Fecha", true);
        dialogoCalendario.setSize(350, 350);
        dialogoCalendario.setLayout(new BorderLayout());
        dialogoCalendario.add(calendario, BorderLayout.CENTER);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(e -> {
            Date fechaSeleccionada = calendario.getDate();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            txtFecha.setText(formatoFecha.format(fechaSeleccionada));
            dialogoCalendario.dispose();
        });

        dialogoCalendario.add(btnSeleccionar, BorderLayout.SOUTH);
        btnElegirFecha.addActionListener(e -> {

            dialogoCalendario.setLocationRelativeTo(ventana);
            dialogoCalendario.setVisible(true);
        });

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

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(3, 5, 20, 10));

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
        txtClave.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDescripcion.setEnabled(false);
        calendario.setEnabled(false);
        
        
        
        
        String[] columnas = {"Clave", "Nombre", "Descripción", "Fecha"};
        modeloTabla = new DefaultTableModel(columnas, 0);  
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        cargarTabla();
        ventana.setLayout(new BorderLayout(20, 20)); 
        ventana.add(panelCampos, BorderLayout.CENTER); 
        ventana.add(panelBotones, BorderLayout.EAST); 
        ventana.add(scroll, BorderLayout.SOUTH); 

        btnNuevo.addActionListener(e -> {
            txtClave.setEnabled(true);
            txtNombre.setEnabled(true);
            txtDescripcion.setEnabled(true);
            calendario.setEnabled(true);

            txtClave.setText("");
            txtNombre.setText("");
            txtDescripcion.setText("");
            calendario.setDate(new Date());

            btnEliminar.setEnabled(false);
            btnGuardar.setEnabled(true);
            btnBuscar.setEnabled(false);
            btnActualizar.setEnabled(false);
            btnNuevo.setEnabled(false);
            btnElegirFecha.setEnabled(true);
            btnCancelar.setEnabled(true);
        });

        btnGuardar.addActionListener(e -> {
            try {
                Long clave = Long.parseLong(txtClave.getText().trim());
                String nombre = txtNombre.getText().trim();
                String descripcion = txtDescripcion.getText().trim();
                java.sql.Date fechaSQL = java.sql.Date.valueOf(txtFecha.getText());

                int status = 1;

                ProgramaAcademico programa = new ProgramaAcademico(clave, nombre, descripcion, fechaSQL, status);
                ProgramaAcademicoDAO dao = new ProgramaAcademicoDAO();
                dao.create(programa);

                cargarTabla();  

                JOptionPane.showMessageDialog(null, "Registro guardado correctamente");

                btnGuardar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnBuscar.setEnabled(true);
                btnActualizar.setEnabled(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Clave debe ser un número válido", "Error de formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String clavetx = JOptionPane.showInputDialog("Ingrese la clave:");
                Long clave = Long.parseLong(clavetx);
                ProgramaAcademico programa = new ProgramaAcademico();
                ProgramaAcademicoDAO dao = new ProgramaAcademicoDAO();
                List<ProgramaAcademico> programaSeleccionado =  dao.SelectByClave(clave);
                
                System.out.println(programaSeleccionado);
                
                
            }
            
        });  
        
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabla.getSelectedRow();
                if (row >= 0) {

                    Long clave = (Long) modeloTabla.getValueAt(row, 0);
                    int confirm = JOptionPane.showConfirmDialog(null, 
                        "¿Está seguro de que desea eliminar este programa?", 
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        ProgramaAcademicoDAO dao = new ProgramaAcademicoDAO();
                        dao.Delete(clave);
                        cargarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
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
        ventana.setVisible(true);

    }
    
        
    private void cargarTabla() {
        ProgramaAcademicoDAO dao = new ProgramaAcademicoDAO();
        List<ProgramaAcademico> listaProgramas = dao.Select();

        modeloTabla.setRowCount(0);

        for (ProgramaAcademico programa : listaProgramas) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = formatoFecha.format(programa.getFechaCreacion());

            modeloTabla.addRow(new Object[]{
                programa.getClave(),
                programa.getNombre(),
                programa.getDescripcion(),
                fechaFormateada
            });
        }

        if (listaProgramas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay programas académicos activos.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
