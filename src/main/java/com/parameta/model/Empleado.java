/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameta.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristhian
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNumeroDocumento", query = "SELECT e FROM Empleado e WHERE e.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Empleado.findByApellidosEmpleado", query = "SELECT e FROM Empleado e WHERE e.apellidosEmpleado = :apellidosEmpleado")
    , @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado")
    , @NamedQuery(name = "Empleado.findByTipoDocumento", query = "SELECT e FROM Empleado e WHERE e.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Empleado.findByFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleado.findByFechaVinculacion", query = "SELECT e FROM Empleado e WHERE e.fechaVinculacion = :fechaVinculacion")
    , @NamedQuery(name = "Empleado.findByCargoEmpleado", query = "SELECT e FROM Empleado e WHERE e.cargoEmpleado = :cargoEmpleado")
    , @NamedQuery(name = "Empleado.findBySalarioEmpleado", query = "SELECT e FROM Empleado e WHERE e.salarioEmpleado = :salarioEmpleado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "apellidos_empleado")
    private String apellidosEmpleado;
    @Basic(optional = false)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Basic(optional = false)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "fecha_vinculacion")
    @Temporal(TemporalType.DATE)
    private Date fechaVinculacion;
    @Basic(optional = false)
    @Column(name = "cargo_empleado")
    private String cargoEmpleado;
    @Basic(optional = false)
    @Column(name = "salario_empleado")
    private int salarioEmpleado;

    public Empleado() {
    }

    public Empleado(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Empleado(String numeroDocumento, String apellidosEmpleado, String nombreEmpleado, String tipoDocumento, Date fechaNacimiento, Date fechaVinculacion, String cargoEmpleado, int salarioEmpleado) {
        this.numeroDocumento = numeroDocumento;
        this.apellidosEmpleado = apellidosEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.tipoDocumento = tipoDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaVinculacion = fechaVinculacion;
        this.cargoEmpleado = cargoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public int getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(int salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numeroDocumento=" + numeroDocumento + ", apellidosEmpleado=" + apellidosEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", tipoDocumento=" + tipoDocumento + ", fechaNacimiento=" + fechaNacimiento + ", fechaVinculacion=" + fechaVinculacion + ", cargoEmpleado=" + cargoEmpleado + ", salarioEmpleado=" + salarioEmpleado + '}';
    }


}
