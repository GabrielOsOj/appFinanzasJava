package com.gbcomp.proyjavaybdd.model.impl;

import com.gbcomp.proyjavaybdd.model.persistence.IFbddConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cuent
 */
public class sqliteConnector implements IFbddConnector {

    private Connection con;
    private String workingPath = System.getProperty("user.dir");
    private String bddUrl = "jdbc:sqlite:"+workingPath+"\\src\\resources\\dbAppFinanzas.db";

    @Override
    public void connect() {
        
        try {
            this.con = DriverManager.getConnection(bddUrl);
            System.out.println("Conectado!");
        } catch (SQLException e) {
            System.err.println("Cannot connect to sqlite database");
            System.exit(1);
        }
    }

    @Override
    public void disconect() {

        try {
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Cannot disconect sqlite database!");
        }

    }

    @Override
    public Connection getConnection() {

        return this.con;

    }

}
