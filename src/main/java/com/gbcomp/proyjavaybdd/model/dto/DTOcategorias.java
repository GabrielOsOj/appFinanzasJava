package com.gbcomp.proyjavaybdd.model.dto;

/**
 *
 * @author cuent
 */
public class DTOcategorias {

    private int IdCategoria;
    private String Categoria;

    public DTOcategorias() {
    }

    public DTOcategorias(int IdCategoria, String Categoria) {
        this.IdCategoria = IdCategoria;
        this.Categoria = Categoria;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String toString() {
        return Categoria;
    }

}
