/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.AbstractTableModel;
import DAO.MedicamentoDAO;
import Objetos.Medicamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MedicamentoTableModel extends AbstractTableModel{
    private List<Medicamento> dados = new ArrayList<>();
    private String[] colunas = {"DescMed", "CodForn","QtdeProd"};

    @Override
    public String getColumnName(int Column) {
        return colunas[Column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getDescricaoMed();
            case 1:
                return dados.get(linha).getCodLab();
            case 2:
                return dados.get(linha).getQtdeMed();
        }
        return null;

    }
    
    @Override
    public void setValueAt(Object valor,int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setDescricaoMed((String) valor);
                break;
            case 1:
                dados.get(linha).setCodMed(Integer.parseInt((String) valor));
                break;          
            case 2:
                dados.get(linha).setQtdeMed(Integer.parseInt((String) valor));
                  
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Medicamento m){
        this.dados.add(m);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
   public Medicamento pegaDadosLinha (int linha){
       return dados.get(linha);
   }
   
   private void lerDados(){
       MedicamentoDAO mdao = new MedicamentoDAO();
       
       for(Medicamento m : mdao.read()){
           
           this.addLinha(m);
       }
       this.fireTableDataChanged();
   }
   public void recarregaTabela(){
       this.dados.clear();
       lerDados();
       this.fireTableDataChanged();
   }
    
}
