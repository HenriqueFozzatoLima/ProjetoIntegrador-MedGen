/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.sql.Date;



/**
 *
 * @author kaiop
 */
public class Venda {
    
    private int nrNotaFiscal;
    private int codDrogaria;
    private String dataVenda;
    private String dataEntrega;
    private Double totalVenda;

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
     * @return the dataVenda
     */
    public String getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
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
     * @return the totalVenda
     */
    public Double getTotalVenda() {
        return totalVenda;
    }

    /**
     * @param totalVenda the totalVenda to set
     */
    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }
    
  
}
