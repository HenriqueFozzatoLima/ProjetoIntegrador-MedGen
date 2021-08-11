/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.VendaDAO;
import Objetos.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class VendaTableModel extends AbstractTableModel{
    
    private List<Venda> dados = new ArrayList<>();
    private String[] colunas = {"codDrogaria", "DataCompra","dataEntrega", "totalCompra",};

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
                return dados.get(linha).getCodDrogaria();
            case 1:
                return dados.get(linha).getDataVenda();
            case 2:
                return dados.get(linha).getDataEntrega();
            case 3:
                return dados.get(linha).getTotalVenda();    
        }
        return null;

    }
    
    @Override
    public void setValueAt(Object valor,int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setCodDrogaria(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setDataVenda(((String) valor));
                break;          
            case 2:
                dados.get(linha).setDataEntrega(((String) valor));
            case 3:
                dados.get(linha).setTotalVenda(Double.parseDouble((String) valor));    
                  
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    
     public void addLinha(Venda v){
        this.dados.add(v);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
   public Venda pegaDadosLinha (int linha){
       return dados.get(linha);
   }
   
   private void lerDados(){
         VendaDAO vdao = new VendaDAO();
       
       for(Venda v : vdao.read()){
           
           this.addLinha(v);
       }
       this.fireTableDataChanged();
   }
   public void recarregaTabela(){
       this.dados.clear();
       lerDados();
       this.fireTableDataChanged();
   }
    
}
