

package com.mycompany.eliminaralrato;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodoEscolar implements Serializable {
    
    public PeriodoEscolar(){
         this.programas = new ArrayList<>();
    }
    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PeriodoEscolar{");
        sb.append("idPeriodoEscolar=").append(idPeriodoEscolar);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaTermino=").append(fechaTermino);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idPeriodoEscolar;
        return hash;
    }

    public List<ProgramaAcademico> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaAcademico> programas) {
        this.programas = programas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PeriodoEscolar that = (PeriodoEscolar) obj;
        return idPeriodoEscolar == that.idPeriodoEscolar ;
    }
    
     public void addPrograma(ProgramaAcademico programa) {
        programa.setNombre(nombre); // Relación bidireccional
        this.programas.add(programa);
    }
    
      private int idPeriodoEscolar; 
      private String nombre;
      private Date fechaInicio;
      private Date fechaTermino;
      private List<ProgramaAcademico> programas;
      private boolean status;

    
      
      public void periodo(){
          PeriodoEscolar pe = new PeriodoEscolar();
          pe.setIdPeriodoEscolar(1);
          pe.setNombre("2025-2");
          
          ProgramaAcademico pa = new ProgramaAcademico();
//          pa.setIdProgramaAcademico(1);
          pa.setNombre("ISC");
          pe.addPrograma(pa);
          pa.setDescripcion("aaaaa");
          pa.setPlan("ISC-2020");
          System.out.println("Periodo: " + pe.getIdPeriodoEscolar());
          System.out.println("Nombre: " + pe.getNombre());
          System.out.println("Programas disponibles: " + pe.getProgramas());
          
          ProgramaAcademicoDTO conexion = new ProgramaAcademicoDTO();
          
          
      } 
}

