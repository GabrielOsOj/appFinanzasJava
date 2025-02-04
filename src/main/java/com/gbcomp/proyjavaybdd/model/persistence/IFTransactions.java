package com.gbcomp.proyjavaybdd.model.persistence;

import com.gbcomp.proyjavaybdd.model.dto.DTOtransaction;
import java.sql.ResultSet;

/**
 *
 * @author cuent
 */
public interface IFTransactions {
    
    /*Seleccion de transacciones*/
    public void agregarTRS(DTOtransaction transaction);
    public void eliminarTRS(int id);
    public void editarTRS(DTOtransaction transaction);
    
    /*Selecciones unitarias*/
    public ResultSet seleccionarTRS(int id);
    
    
    /*Seleccion de categorias*/
    public ResultSet seleccionarTodoTRS();
    public ResultSet seleccionarTodoCat();   
    public ResultSet seleccionarTodoTiposOps();    
    
    /* Utilidades y filtros */
    public Double obtIngresos();
    public Double obtGastos();
    
  
}
