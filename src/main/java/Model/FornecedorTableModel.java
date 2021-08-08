/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.FornecedorDAO;
import Objetos.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kaiop
 */
public class FornecedorTableModel extends AbstractTableModel {
    
    private List<Fornecedor> dados = new ArrayList<>();
    private String[] colunas = {"Nome","RazaoSocial","Email", "Cnpj", "Cidade", "Estado", "Cep", "InscriçaoEstadual"};
    

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
                return dados.get(linha).getNomeFornecedor();
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
            case 7:
                return dados.get(linha).getInscricaoEstadual();
        }
        return null;

    }
    
    @Override
    public void setValueAt(Object valor,int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setNomeFornecedor((String) valor);
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
            case 7:
                dados.get(linha).setInscricaoEstadual(((String) valor));    
                  
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Fornecedor f){
        this.dados.add(f);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
   public Fornecedor pegaDadosLinha (int linha){
       return dados.get(linha);
   }
   
   private void lerDados(){
       FornecedorDAO fdao = new FornecedorDAO();
       
       for(Fornecedor f : fdao.read()){
           
           this.addLinha(f);
       }
       this.fireTableDataChanged();
   }
   public void recarregaTabela(){
       this.dados.clear();
       lerDados();
       this.fireTableDataChanged();
   }
   
    
    
}
