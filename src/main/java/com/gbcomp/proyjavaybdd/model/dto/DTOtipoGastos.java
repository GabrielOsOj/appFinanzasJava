package com.gbcomp.proyjavaybdd.model.dto;

/**
 *
 * @author cuent
 */
public class DTOtipoGastos {

    private int idTipoGasto;
    private String Gasto;

    public DTOtipoGastos() {
    }

    public DTOtipoGastos(int idTipoGasto, String Gasto) {
        this.idTipoGasto = idTipoGasto;
        this.Gasto = Gasto;
    }

    public int getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(int idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public String getGasto() {
        return Gasto;
    }

    public void setGasto(String Gasto) {
        this.Gasto = Gasto;
    }

}
