package com.gbcomp.proyjavaybdd.model.impl;

import com.gbcomp.proyjavaybdd.model.dto.DTOtransaction;
import com.gbcomp.proyjavaybdd.model.persistence.SQLQuerysConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gbcomp.proyjavaybdd.model.persistence.IFTransactions;

public class sqliteTransactions extends SQLQuerysConfig implements IFTransactions {

    public sqliteTransactions(Connection conn) {
        super(conn);
    }

    @Override
    public void agregarTRS(DTOtransaction tr) {

        try {

            this.PSagregarTRS
                    .setString(1,
                            tr.getDescripcion());
            this.PSagregarTRS
                    .setDouble(2, tr.getTotal());
            this.PSagregarTRS
                    .setInt(3,
                            tr.getCategoria());

            this.PSagregarTRS
                    .setDate(4,
                            tr.getFecha());

            this.PSagregarTRS
                    .setInt(5,
                            tr.getTipoGasto());

            this.PSagregarTRS.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Failed in SQLiteTransactions"
                    + " PSagregar");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarTRS(int id) {

        try {

            this.PSeliminarTRS.setInt(1, id);
            this.PSeliminarTRS.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Cannot delete register with id= " + id);

        }
    }

    @Override
    public void editarTRS(DTOtransaction transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet seleccionarTRS(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet seleccionarTodoTRS() {

        try {
            return this.PSseleccionar_todosTRS.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed to load data from database!");
        }
        return null;
    }

    @Override
    public ResultSet seleccionarTodoCat() {

        try {
            return this.PSseleccionar_todosCAT.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet seleccionarTodoTiposOps() {
        try {
            return this.PSseleccionar_todosTipoOps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Utilidades */
    @Override
    public Double obtIngresos() {

        try {

            return this.PSseleccionarIngresos.executeQuery().getDouble(1);

        } catch (SQLException e) {

        }

        return null;
    }

    @Override
    public Double obtGastos() {

        try {

            return this.PSseleccionarGastos.executeQuery().getDouble(1);

        } catch (SQLException e) {

        }

        return null;
    }

}
