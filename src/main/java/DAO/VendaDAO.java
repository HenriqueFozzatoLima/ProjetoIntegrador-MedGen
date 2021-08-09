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
import Objetos.Venda;
/**
 *
 * @author user
 */
public class VendaDAO {
    
      public List<Venda> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> venda = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda v = new Venda();
                
                v.setNrNotaFiscal(rs.getInt("NRO_NT_FISC_VEN"));
                v.setTotalVenda(rs.getDouble("Total_ven"));
                v.setDataVenda(rs.getString("Data_ven"));
                v.setDataEntrega(rs.getString("Data_Entre"));
                v.setCodDrogaria(rs.getInt("Cod_Drog"));
                venda.add(v);
//                iv.setNrNotaFiscal(rs.getInt("Nro_nt_fisc_ven"));
//                iv.setCodProduto(rs.getInt("Cod_prod"));
//                iv.setValUnitario(rs.getDouble("Val_Unit"));
//                iv.setValTotal(rs.getDouble("Preco_total"));
//                iv.setQtdeItens(rs.getInt("Qtde_Itens"));
//               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return venda;
    }
 
      public void create(Venda v) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_venda (TOTAL_VEN, DATA_VEN, DATA_ENTRE, COD_DROG) VALUES (?, ?, ?, ?, ?)");
            
            stmt.setDouble(1, v.getTotalVenda());
            stmt.setString(2, v.getDataVenda());
            stmt.setString(3, v.getDataEntrega());
            stmt.setInt(4, v.getCodDrogaria());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
      
      public void update(Venda v) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_venda SET TOTAL_VEN = ?, DATA_VEN = ?, DATA_ENTRE = ?, COD_DROG WHERE NR_NT_FISC_VEN = ?");
            stmt.setDouble(1, v.getTotalVenda());
            stmt.setString(2, v.getDataVenda());
            stmt.setString(3, v.getDataEntrega());
            stmt.setInt(4, v.getCodDrogaria());
            stmt.setInt(5, v.getNrNotaFiscal());

            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
     
       public void delete(Venda v) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbl_venda WHERE NR_NT_FISC_VEN = ?");
            stmt.setInt(1, v.getNrNotaFiscal());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
      
      
}
