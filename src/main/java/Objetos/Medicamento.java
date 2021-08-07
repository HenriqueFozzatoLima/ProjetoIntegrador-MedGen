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
public class Medicamento {
    
    private int codMed; 
    private String descricaoMed; 
    private int qtdeMed; 
    private int codLab; 

    /**
     * @return the codMed
     */
    public int getCodMed() {
        return codMed;
    }

    /**
     * @param codMed the codMed to set
     */
    public void setCodMed(int codMed) {
        this.codMed = codMed;
    }

    /**
     * @return the descricaoMed
     */
    public String getDescricaoMed() {
        return descricaoMed;
    }

    /**
     * @param descricaoMed the descricaoMed to set
     */
    public void setDescricaoMed(String descricaoMed) {
        this.descricaoMed = descricaoMed;
    }

    /**
     * @return the qtdeMed
     */
    public int getQtdeMed() {
        return qtdeMed;
    }

    /**
     * @param qtdeMed the qtdeMed to set
     */
    public void setQtdeMed(int qtdeMed) {
        this.qtdeMed = qtdeMed;
    }

    /**
     * @return the codLab
     */
    public int getCodLab() {
        return codLab;
    }

    /**
     * @param codLab the codLab to set
     */
    public void setCodLab(int codLab) {
        this.codLab = codLab;
    }
    
    
}
