package com.mycompany.eliminaralrato;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

class ProgramaAcademico implements Serializable{
    private Long clave;
    
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private int status;
    private PeriodoEscolar periodoEscolar;
    
    public ProgramaAcademico() {}
    
     public ProgramaAcademico(Long clave,String nombre, String descripcion, Date fechaCreacion, int status) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.clave = clave;
    }
    
    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }

    
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgramaAcademico{");

        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');

        sb.append('}');
        return sb.toString();
    }

    // hashCode y equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (79 * hash + this.clave);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProgramaAcademico that = (ProgramaAcademico) obj;
        return clave == that.clave ;
    }
}
