package com.mycompany.eliminaralrato;

import java.io.Serializable;
import java.util.Objects;

class ProgramaAcademico implements Serializable{
    private Long idProgramaAcademico;
    private String nombre;
    private String descripcion;
    private String plan;
    private PeriodoEscolar periodoEscolar;
    private boolean status;
    public ProgramaAcademico() {}
    
    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getIdProgramaAcademico() {
        return idProgramaAcademico;
    }

    public void setIdProgramaAcademico(Long idProgramaAcademico) {
        this.idProgramaAcademico = idProgramaAcademico;
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

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgramaAcademico{");
        sb.append("idProgramaAcademico=").append(idProgramaAcademico);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", plan='").append(plan).append('\'');
        sb.append('}');
        return sb.toString();
    }

    // hashCode y equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (79 * hash + this.idProgramaAcademico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProgramaAcademico that = (ProgramaAcademico) obj;
        return idProgramaAcademico == that.idProgramaAcademico ;
    }
}
