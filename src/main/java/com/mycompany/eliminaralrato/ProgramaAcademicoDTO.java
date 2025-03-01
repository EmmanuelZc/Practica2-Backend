package com.mycompany.eliminaralrato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramaAcademicoDTO {
    ProgramaAcademico programa;
    
    public ProgramaAcademicoDTO(){
        String url = "jdbc:mysql://localhost:3306/7cm1";
        String usuario = "root";
        String contraseña = "root";
        
        Conexion(url,usuario,contraseña);
    }
    
    private void Conexion(String url, String usuario, String contraseña){
        
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            // Crear una declaración
            Statement stmt = conn.createStatement();
            System.out.println("Conexion establecida");
            // Ejecutar una consulta
            String consulta = "SELECT * FROM periodoescolar";  
            ResultSet rs = stmt.executeQuery(consulta);
            
            // Procesar el resultado
            while (rs.next()) {
                System.out.println("Columna1: " + rs.getString(1) + " | Columna2: " + rs.getString(2));
            }
            
            // Cerrar ResultSet y Statement (opcional ya que el try-with-resources lo hace automáticamente)
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
