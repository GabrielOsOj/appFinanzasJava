package com.gbcomp.proyjavaybdd.model.dto;

import java.sql.Date;

/**
 *
 * @author cuent
 */
public class DTOtransaction {

    private int IdTransaccion;
    private String Descripcion;
    private Double Total;
    private int Categoria;
    private String NombreCategoria;
    private Date Fecha;
    private int TipoGasto;
    private String NombreTipoGasto;

    public DTOtransaction(int IdTransaccion, String Descripcion, Double Total, int Categoria, Date Fecha, int TipoGasto) {
        this.IdTransaccion = IdTransaccion;
        this.Descripcion = Descripcion;
        this.Total = Total;
        this.Categoria = Categoria;
        this.Fecha = Fecha;
        this.TipoGasto = TipoGasto;
    }

    public DTOtransaction() {
    }

    public int getIdTransaccion() {
        return IdTransaccion;
    }

    public void setIdTransaccion(int IdTransaccion) {
        this.IdTransaccion = IdTransaccion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getTipoGasto() {
        return TipoGasto;
    }

    public void setTipoGasto(int TipoGasto) {
        this.TipoGasto = TipoGasto;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getNombreTipoGasto() {
        return NombreTipoGasto;
    }

    public void setNombreTipoGasto(String NombreTipoGasto) {
        this.NombreTipoGasto = NombreTipoGasto;
    }

    
    
    
}
