/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.AbstractTableModel;
import DAO.DrogariaDAO;
import Objetos.Drogaria;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class DrogariaTableModel extends AbstractTableModel{
 
    private List<Drogaria> dados = new ArrayList<>();
    private String[] colunas = {"Nome","RazaoSocial","Email", "Cnpj", "Cidade", "Estado", "Cep"};
    

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
                return dados.get(linha).getNomeDrogaria();
            case 1:
                return dados.get(linha).getRazaoSocial();
            case 2:
                return dados.get(linha).getEmail();
            case 3:
                return dados.get(linha).getCnpj();
            case 4:
                return dados.get(linha).getCidade();
            case 5:
                return dados.get(linha).getEstado();
            case 6:
                return dados.get(linha).getCep();
        
        }
        return null;

    }
    
    @Override
    public void setValueAt(Object valor,int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setNomeDrogaria((String) valor);
                break;
            case 1:
                dados.get(linha).setRazaoSocial(((String) valor));
                break;
            case 2:
                dados.get(linha).setEmail(((String) valor));
                break;
            case 3:
                dados.get(linha).setCnpj(((String) valor));
            case 4:
                dados.get(linha).setCidade(((String) valor));
            case 5:
                dados.get(linha).setEstado(((String) valor));
            case 6:
                dados.get(linha).setCep(((String) valor));   
                  
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Drogaria d){
        this.dados.add(d);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
   public Drogaria pegaDadosLinha (int linha){
       return dados.get(linha);
   }
   
   private void lerDados(){
       DrogariaDAO ddao = new DrogariaDAO();
       
       for(Drogaria d : ddao.read()){
           
           this.addLinha(d);
       }
       this.fireTableDataChanged();
   }
   public void recarregaTabela(){
       this.dados.clear();
       lerDados();
       this.fireTableDataChanged();
   }
}
