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
public class ItensVenda {
    
    private int nrNotaFiscal;
    private int codProduto;
    private int qtdeItens;
    private double valTotal;
    private double valUnitario;

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
     * @return the codProduto
     */
    public int getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    /**
     * @return the qtdeItens
     */
    public int getQtdeItens() {
        return qtdeItens;
    }

    /**
     * @param qtdeItens the qtdeItens to set
     */
    public void setQtdeItens(int qtdeItens) {
        this.qtdeItens = qtdeItens;
    }

    /**
     * @return the valTotal
     */
    public double getValTotal() {
        return valTotal;
    }

    /**
     * @param valTotal the valTotal to set
     */
    public void setValTotal(double valTotal) {
        this.valTotal = valTotal;
    }

    /**
     * @return the valUnitario
     */
    public double getValUnitario() {
        return valUnitario;
    }

    /**
     * @param valUnitario the valUnitario to set
     */
    public void setValUnitario(double valUnitario) {
        this.valUnitario = valUnitario;
    }
    
    
}
