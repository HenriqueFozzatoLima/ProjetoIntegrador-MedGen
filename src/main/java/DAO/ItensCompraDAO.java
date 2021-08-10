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
import Objetos.ItensCompra;

/**
 *
 * @author user
 */
public class ItensCompraDAO {
    public List<ItensCompra> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItensCompra> itenscompra = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_itens_compra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ItensCompra ic = new ItensCompra();
                
                ic.setNrNotaFiscalCompra(rs.getInt("Nro_nt_fisc"));
                ic.setCodProduto(rs.getInt("Cod_prod"));
                ic.setValUnitario(rs.getDouble("Val_Unit"));
                ic.setValTotal(rs.getDouble("Preco_total"));
                ic.setQtdeItens(rs.getInt("Qtde_Itens"));
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return itenscompra;
    }
    
    public void create(ItensCompra ic) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_itens_compra (COD_PROD, VAL_UNIT, PRECO_TOTAL, QTDE_ITENS) VALUES (?, ?, ?, ?)");
            
            
            stmt.setInt(1, ic.getCodProduto());
            stmt.setDouble(2, ic.getValUnitario());
            stmt.setDouble(3, ic.getValTotal());
            stmt.setInt(4, ic.getQtdeItens());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(ItensCompra ic) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_itens_compra SET COD_PROD = ?, VAL_UNIT = ?, PRECO_TOTAL = ?, QTDE_ITENS WHERE NR_NT_FISC = ?");
            stmt.setDouble(1, ic.getCodProduto());
            stmt.setDouble(2, ic.getValUnitario());
            stmt.setDouble(3, ic.getValTotal());
            stmt.setInt(4, ic.getQtdeItens());
            stmt.setInt(5, ic.getNrNotaFiscalCompra());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
      public void delete(ItensCompra ic) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbl_itens_compra WHERE NR_NT_FISC = ?");
            stmt.setInt(1, ic.getNrNotaFiscalCompra());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
    
}
