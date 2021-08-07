/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author kaiop
 */
public class Compra {
    
    private int nrNotaFiscal;
    private int codDrogaria;
    private String dataCompra;
    private String dataEntrega;
    private Double totalCompra;

    /**
     * @return the nrNotaFiscal
     */
    public int getNrNotaFiscal() {
        return nrNotaFiscal;
    }

    /**
     * @param nrNotaFiscal the nrNotaFiscal to set
     */
    public void setNrNotaFiscal(int nrNotaFiscal) {
        this.nrNotaFiscal = nrNotaFiscal;
    }

    /**
     * @return the codDrogaria
     */
    public int getCodDrogaria() {
        return codDrogaria;
    }

    /**
     * @param codDrogaria the codDrogaria to set
     */
    public void setCodDrogaria(int codDrogaria) {
        this.codDrogaria = codDrogaria;
    }

    /**
     * @return the dataCompra
     */
    public String getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the dataEntrega
     */
    public String getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the totalCompra
     */
    public Double getTotalCompra() {
        return totalCompra;
    }

    /**
     * @param totalCompra the totalCompra to set
     */
    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    
    
    
}
