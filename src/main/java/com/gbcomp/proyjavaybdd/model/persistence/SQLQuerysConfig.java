package com.gbcomp.proyjavaybdd.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author cuent
 */
public abstract class SQLQuerysConfig {

    private Connection conn;
    protected PreparedStatement PSagregarTRS;
    protected PreparedStatement PSeliminarTRS;
    protected PreparedStatement PSeditarTRS;

    protected PreparedStatement PSseleccionarIngresos;
    protected PreparedStatement PSseleccionarGastos;

    protected PreparedStatement PSseleccionar_todosTRS;
    protected PreparedStatement PSseleccionar_todosCAT;
    protected PreparedStatement PSseleccionar_todosTipoOps;

    private HashMap<String, String> SQLquerys;

    public SQLQuerysConfig(Connection connection) {

        this.loadHashMap();
        this.conn = connection;

        try {
            this.loadQuerys();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadHashMap() {
        this.SQLquerys = new HashMap<>();
        this.SQLquerys.put("INSERT_TRANSACTIONS", "INSERT INTO Transacciones VALUES (null,?,?,?,?,?);");

        this.SQLquerys.put("SELECT_ALL_TRANSACTIONS", "SELECT * FROM Transacciones ORDER BY fecha;");
        this.SQLquerys.put("SELECT_ALL_CATEGORIES", "SELECT * FROM Categorias;");
        this.SQLquerys.put("SELECT_ALL_TIPO_GASTO", "SELECT * FROM TipoGasto");
        this.SQLquerys.put("DELETE_TRANSACTION", "DELETE FROM Transacciones WHERE IdTransaccion=?");

        this.SQLquerys.put("SELECT_INGRESOS", "SELECT SUM(T.Total) FROM Transacciones AS t LEFT JOIN TipoGasto AS tg ON t.TipoGasto=tg.IdGasto WHERE tg.gasto = 'ingreso'");

        this.SQLquerys.put("SELECT_GASTOS", "SELECT SUM(T.Total) FROM Transacciones AS t LEFT JOIN TipoGasto AS tg ON t.TipoGasto=tg.IdGasto WHERE tg.gasto = 'gasto'");

    }

    ;

    private void loadQuerys() throws SQLException {

        this.PSagregarTRS = this.conn.
                prepareStatement(SQLquerys.get("INSERT_TRANSACTIONS"));

        this.PSseleccionar_todosTRS = this.conn
                .prepareStatement(SQLquerys.get("SELECT_ALL_TRANSACTIONS"));

        this.PSseleccionar_todosCAT = this.conn
                .prepareStatement(SQLquerys.get("SELECT_ALL_CATEGORIES"));

        this.PSseleccionar_todosTipoOps = this.conn
                .prepareStatement(SQLquerys.get("SELECT_ALL_TIPO_GASTO"));

        this.PSeliminarTRS = this.conn
                .prepareStatement(SQLquerys.get("DELETE_TRANSACTION"));

        this.PSseleccionarIngresos = this.conn
                .prepareStatement(SQLquerys.get("SELECT_INGRESOS"));

        this.PSseleccionarGastos = this.conn.prepareStatement(SQLquerys.get("SELECT_GASTOS"));

    }

}
