package com.mycompany.eliminaralrato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramaAcademicoDTO {
    ProgramaAcademico programa;
    private static final String url = "jdbc:mysql://localhost:3306/7cm1";
    private static final String usuario = "root";
    private static final String contraseña = "root";
    public ProgramaAcademicoDTO() {
        
    }

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(url, usuario, contraseña);
    }    
}
