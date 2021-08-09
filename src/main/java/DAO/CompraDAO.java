/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Objetos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import BD.Conexao;
/**
 *
 * @author user
 */
public class CompraDAO {
    public List<Compra> read() throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Compra> Compra = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT ");
            rs = stmt.executeQuery();

            while (rs.next()) {
                    Compra c = new Compra();
                
                c.setNrNotaFiscal(rs.getInt("NRO_NT_FISC"));
                c.setCodDrogaria(rs.getInt("COD_LAB"));
                c.setDataEntrega(rs.getString("DATA_ENTRE"));
                c.setDataCompra(rs.getString("DATA_COMPRA"));
                c.setTotalCompra(rs.getDouble("TOTAL_COMP"));
                Compra.add(c);
            }
                } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return Compra;
    
}
     
     public void create(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_compra ( COD_LAB, DATA_ENTRE, DATA_COMPRA, TOTAL_COMP) VALUES (?, ?, ?)");
            stmt.setInt(1, c.getCodDrogaria());
            stmt.setString(2, c.getDataEntrega());
            stmt.setString(3, c.getDataCompra());
            stmt.setDouble(4, c.getTotalCompra());
            stmt.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
     
     public void update(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_compra SET COD_LAB = ?, DATA_ENTRE = ?, DATA_COMPRA = ? TOTAL_COMP = ? WHERE COD_LAB = ?");
             stmt.setInt(1, c.getCodDrogaria());
            stmt.setString(2, c.getDataEntrega());
            stmt.setString(3, c.getDataCompra());
            stmt.setDouble(4, c.getTotalCompra());
            stmt.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
     
    public void delete(Compra c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbl_compra WHERE COD_LAB = ?");
            stmt.setInt(1, c.getCodDrogaria());
            stmt.execute();
                   
            
            
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    } 
}
