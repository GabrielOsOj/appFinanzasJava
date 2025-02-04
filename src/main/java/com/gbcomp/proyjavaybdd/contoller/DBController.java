package com.gbcomp.proyjavaybdd.contoller;

import com.gbcomp.proyjavaybdd.model.dto.DTOcategorias;
import com.gbcomp.proyjavaybdd.model.dto.DTOtipoGastos;
import com.gbcomp.proyjavaybdd.model.impl.sqliteConnector;
import com.gbcomp.proyjavaybdd.model.impl.sqliteTransactions;
import com.gbcomp.proyjavaybdd.model.persistence.IFbddConnector;
import com.gbcomp.proyjavaybdd.model.dto.DTOtransaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.gbcomp.proyjavaybdd.model.persistence.IFTransactions;
import java.sql.Date;
import java.time.LocalDate;

/**
 * @author cuent
 */
public class DBController {

    IFbddConnector SQLConnector;
    IFTransactions SQLOps;

    public DBController() {

        this.SQLConnector = new sqliteConnector();
        this.SQLConnector.connect();
        this.SQLOps = new sqliteTransactions(SQLConnector.getConnection());

    }

    /* Funciones de carga*/
 /* Funciones de la vista*/
    public void eliminar(int id) {

        this.SQLOps.eliminarTRS(id);
    }

    public void agregar(String Descripcion, String total, String categoria, LocalDate fecha, String tipoGasto) {

        DTOtransaction tr = new DTOtransaction();
        tr.setIdTransaccion(0);
        tr.setCategoria(this.getCategoria(categoria).getIdCategoria());
        tr.setDescripcion(Descripcion);
        tr.setFecha(this.getSQLdate(fecha));
        tr.setTipoGasto(this.getTipoGasto(tipoGasto.toLowerCase()).getIdTipoGasto());
        tr.setTotal(this.getTotalInDouble(total));

        this.SQLOps.agregarTRS(tr);
    }

    public Double obtIngresos() {

        return this.SQLOps.obtIngresos();

    }

    public Double obtGastos() {

        return this.SQLOps.obtGastos();

    }

    /* Utilidades */
    private DTOcategorias getCategoria(String categoria) {

        for (DTOcategorias cat : this.seleccionarCategorias()) {

            if (cat.getCategoria().equals(categoria)) {
                return cat;
            }
        }

        return null;
    }

    private DTOcategorias getCategoria(int Idcategoria) {

        for (DTOcategorias cat : this.seleccionarCategorias()) {

            if (cat.getIdCategoria() == Idcategoria) {
                return cat;
            }
        }

        return null;
    }

    private DTOtipoGastos getTipoGasto(String gasto) {

        for (DTOtipoGastos tipoGasto : this.seleccionarTiposOps()) {

            if (tipoGasto.getGasto().equals(gasto)) {

                return tipoGasto;

            }

        }
        return null;
    }

    private DTOtipoGastos getTipoGasto(int Idgasto) {

        for (DTOtipoGastos tipoGasto : this.seleccionarTiposOps()) {

            if (tipoGasto.getIdTipoGasto() == Idgasto) {

                return tipoGasto;

            }

        }
        return null;
    }

    private Date getSQLdate(LocalDate date) {

        return Date.valueOf(date);

    }

    private Double getTotalInDouble(String total) {

        return Double.parseDouble(total);
    }

    private ArrayList<DTOtransaction>
            ArrayDTOtransaccionBuilder(ResultSet rs) {

        ArrayList<DTOtransaction> data = new ArrayList<>();

        try {

            while (rs.next()) {

                DTOtransaction result = new DTOtransaction();

                result.setIdTransaccion(rs.getInt(1));
                result.setDescripcion(rs.getString(2));
                result.setCategoria(rs.getInt(4));
                result.setFecha(rs.getDate(5));
                result.setTipoGasto(rs.getInt(6));

                result.setNombreCategoria(this.getCategoria(result.getCategoria()).getCategoria());
                result.setNombreTipoGasto(this.getTipoGasto(result.getTipoGasto()).getGasto());

                if (result.getNombreTipoGasto().equals("gasto")) {
                    result.setTotal((rs.getDouble(3)) * -1);

                } else {
                    
                    result.setTotal((rs.getDouble(3)));

                }

                data.add(result);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return data;
    }

    /*Selecciones de datos*/
    public ArrayList<DTOtransaction> seleccionarTodo() {

        ResultSet rs = this.SQLOps.seleccionarTodoTRS();
        return this.ArrayDTOtransaccionBuilder(rs);

    }

    public ArrayList<DTOtransaction> seleccionarGastos() {

        ArrayList<DTOtransaction> gastos = new ArrayList();

        for (DTOtransaction t : this.seleccionarTodo()) {

            if (t.getNombreTipoGasto().equals("gasto")) {
                t.setTotal(t.getTotal()*-1);
                gastos.add(t);
            }

        }

        return gastos;
    }

    public ArrayList<DTOcategorias> seleccionarCategorias() {

        ResultSet resp = this.SQLOps.seleccionarTodoCat();
        ArrayList<DTOcategorias> data = new ArrayList();
        try {
            while (resp.next()) {

                DTOcategorias c = new DTOcategorias();
                c.setIdCategoria(resp.getInt(1));
                c.setCategoria(resp.getString(2));
                data.add(c);
            }
            return data;

        } catch (SQLException e) {
            return null;
        }

    }

    public ArrayList<DTOtipoGastos> seleccionarTiposOps() {

        ResultSet resp = this.SQLOps.seleccionarTodoTiposOps();
        ArrayList<DTOtipoGastos> data = new ArrayList();

        try {
            while (resp.next()) {
                DTOtipoGastos tg = new DTOtipoGastos();
                tg.setIdTipoGasto(resp.getInt(1));
                tg.setGasto(resp.getString(2));
                data.add(tg);
            }
            return data;
        } catch (SQLException e) {
            return null;
        }

    }

}
