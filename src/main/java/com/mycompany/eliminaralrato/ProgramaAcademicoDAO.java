package com.mycompany.eliminaralrato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaAcademicoDAO {
    private static final String SQL_INSERT = "call insertar(?,?, ?, ?,?)";
    private static final String SQL_SELECT = "call consultar()";
    private static final String SQL_DELETE = "call elimina(?,?)";
    private static final String SQL_SELECT_BY_CLAVE = "call selectbyID(?,?)";
    private static final String SQL_UPDATE = "call editar(?, ?, ?, ?, ?)";
    
     public void create(ProgramaAcademico programa) {
        try (Connection conn = ProgramaAcademicoDTO.getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setLong(1, programa.getClave());
            stmt.setString(2, programa.getNombre());
            stmt.setString(3, programa.getDescripcion());
            stmt.setDate(4, (Date) programa.getFechaCreacion());  
            stmt.setInt(5, programa.getStatus());


            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("¡Inserción exitosa!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     public List<ProgramaAcademico> Select() {
        List<ProgramaAcademico> listaProgramas = new ArrayList<>();
        
        try (Connection conn = ProgramaAcademicoDTO.getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                java.sql.Date fechaSQL = rs.getDate("fechaCreacion");
                java.util.Date fechaUtil = new java.util.Date(fechaSQL.getTime());

                ProgramaAcademico programa = new ProgramaAcademico(
                    rs.getLong("clave"),           
                    rs.getString("nombre"),        
                    rs.getString("descripcion"),   
                    fechaUtil,                     
                    rs.getInt("status")            
                );
                listaProgramas.add(programa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProgramas;  
    }
     
     
     public void Delete(Long clave) {
        try (Connection conn = ProgramaAcademicoDTO.getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            int status = 0;
            stmt.setLong(2, clave);  // Usamos la clave para eliminar el registro
            stmt.setInt(1, status);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("¡Eliminado con éxito!");
            } else {
                System.out.println("No se encontró el programa con la clave: " + clave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
      public List<ProgramaAcademico> SelectByClave(Long clave) {
        List<ProgramaAcademico> listaProgramas = new ArrayList<>();

        try (Connection conn = ProgramaAcademicoDTO.getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_CLAVE)) {
             int status = 1 ;
            stmt.setLong(1, clave);  
            stmt.setInt(2, status);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    java.sql.Date fechaSQL = rs.getDate("fechaCreacion");
                    java.util.Date fechaUtil = new java.util.Date(fechaSQL.getTime());

                    ProgramaAcademico programa = new ProgramaAcademico(
                        rs.getLong("clave"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        fechaUtil,
                        rs.getInt("status")
                    );
                    listaProgramas.add(programa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProgramas;
    }
      
    public void Update(ProgramaAcademico programa) {
    try (Connection conn = ProgramaAcademicoDTO.getConexion();
         PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

        stmt.setLong(1, programa.getClave());
        stmt.setString(2, programa.getNombre());
        stmt.setString(3, programa.getDescripcion());
        stmt.setDate(4, new java.sql.Date(programa.getFechaCreacion().getTime())); 
        stmt.setInt(5, programa.getStatus());

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("¡Actualización exitosa!");
        } else {
            System.out.println("No se encontró el programa con la clave: " + programa.getClave());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
