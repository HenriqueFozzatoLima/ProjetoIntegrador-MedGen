/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import BD.Conexao;
import Objetos.ItensVenda;


/**
 *
 * @author user
 */
public class ItensVendaDAO {
    
      public List<ItensVenda> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItensVenda> itensvenda = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM itens_venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ItensVenda iv = new ItensVenda();
                
                iv.setNrNotaFiscal(rs.getInt("Nro_nt_fisc_ven"));
                iv.setCodProduto(rs.getInt("Cod_prod"));
                iv.setValUnitario(rs.getDouble("Val_Unit"));
                iv.setValTotal(rs.getDouble("Preco_total"));
                iv.setQtdeItens(rs.getInt("Qtde_Itens"));
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return itensvenda;
    }
    
       public void create(ItensVenda iv) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO itens_venda (COD_PROD, VAL_UNIT, PRECO_TOTAL, QTDE_ITENS) VALUES (?, ?, ?, ?)");
            
            
            stmt.setInt(1, iv.getCodProduto());
            stmt.setDouble(2, iv.getValUnitario());
            stmt.setDouble(3, iv.getValTotal());
            stmt.setInt(4, iv.getQtdeItens());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
       
       
          public void update(ItensVenda iv) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE itens_venda SET COD_PROD = ?, VAL_UNIT = ?, PRECO_TOTAL = ?, QTDE_ITENS WHERE NR_NT_FISC_VEN = ?");
            stmt.setDouble(1, iv.getCodProduto());
            stmt.setDouble(2, iv.getValUnitario());
            stmt.setDouble(3, iv.getValTotal());
            stmt.setInt(4, iv.getQtdeItens());
            stmt.setInt(5, iv.getNrNotaFiscal());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
      
          
           public void delete(ItensVenda iv) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM itens_venda WHERE NR_NT_FISC_VEN = ?");
            stmt.setInt(1, iv.getNrNotaFiscal());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
      
}
