package com.gbcomp.proyjavaybdd.model.persistence;

import java.sql.Connection;

/**
 *
 * @author cuent
 */
public interface IFbddConnector {
    
    public void connect();
    public void disconect();
    public Connection getConnection();
    
}
