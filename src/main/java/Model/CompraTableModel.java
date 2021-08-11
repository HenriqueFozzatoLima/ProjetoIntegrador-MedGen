/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.CompraDAO;
import Objetos.Compra;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class CompraTableModel extends AbstractTableModel{
    
    private List<Compra> dados = new ArrayList<>();
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
                return dados.get(linha).getDataCompra();
            case 2:
                return dados.get(linha).getDataEntrega();
            case 3:
                return dados.get(linha).getTotalCompra();    
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
                dados.get(linha).setDataCompra(((String) valor));
                break;          
            case 2:
                dados.get(linha).setDataEntrega(((String) valor));
            case 3:
                dados.get(linha).setTotalCompra(Double.parseDouble((String) valor));    
                  
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
  public void addLinha(Compra c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
   public Compra pegaDadosLinha (int linha){
       return dados.get(linha);
   }
   
   private void lerDados() throws SQLException{
         CompraDAO cdao = new CompraDAO();
       
       for(Compra c : cdao.read()){
           
           this.addLinha(c);
       }
       this.fireTableDataChanged();
   }
   public void recarregaTabela() throws SQLException{
       this.dados.clear();
       lerDados();
       this.fireTableDataChanged();
   }
    
}
