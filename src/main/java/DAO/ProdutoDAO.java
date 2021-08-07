/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexao;
import Objetos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ProdutoDAO {

  

    public List<Produto> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setCodProd(rs.getInt("Cod_Prod"));
                p.setDescProd(rs.getString("Desc_Prod"));
                p.setValCusto(rs.getDouble("Val_Custo"));
                p.setValVenda(rs.getDouble("Val_Venda"));
                p.setQtdeProd(rs.getInt("Qtde_Prod"));
                produtos.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    public void create(Produto p) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_produto (DESC_PROD, VAL_CUSTO, VAL_VENDA, QTDE_PROD) VALUES (?, ?, ?, ?)");
            stmt.setString(1, p.getDescProd());
            stmt.setDouble(2, p.getValCusto());
            stmt.setDouble(3, p.getValVenda());
            stmt.setInt(4, p.getQtdeProd());

            stmt.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

      public void update(Produto p) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_produto SET DESC_PROD = ?, VAL_CUSTO = ?, VAL_VENDA = ?, QTDE_PROD = ? WHERE COD_PROD = ?");
            stmt.setString(1, p.getDescProd());
            stmt.setDouble(2, p.getValCusto());
            stmt.setDouble(3, p.getValCusto());
            stmt.setInt(4, p.getQtdeProd());
            stmt.setInt(5, p.getCodProd());

            stmt.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
      public void delete(Produto p) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbl_produto WHERE COD_PROD = ?");
            stmt.setInt(1, p.getCodProd());
            stmt.execute();
                   
            
            
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
    
    
}
