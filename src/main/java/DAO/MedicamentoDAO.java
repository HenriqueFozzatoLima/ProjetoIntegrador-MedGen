/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexao;
import Objetos.Medicamento;
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
public class MedicamentoDAO {
    
    public List<Medicamento> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> medicamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_medicamento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Medicamento med = new Medicamento();
                med.setCodMed(rs.getInt("Cod_Med"));
                med.setDescricaoMed(rs.getString("Desc_Med"));
                med.setQtdeMed(rs.getInt("Qtde_Med"));
                med.setCodLab(rs.getInt("Cod_Lab"));
                medicamentos.add(med);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return medicamentos;
    }

    public void create(Medicamento med) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_medicamento (DESC_MED, QTDE_MED, COD_LAB) VALUES (?, ?, ?)");
            stmt.setString(1, med.getDescricaoMed());
            stmt.setDouble(2, med.getQtdeMed());
            stmt.setDouble(3, med.getCodLab());
            stmt.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

      public void update(Medicamento med) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_medicamento SET DESC_MED = ?, QTDE_MED = ?, COD_LAB = ? WHERE COD_MED = ?");
            stmt.setString(1, med.getDescricaoMed());
            stmt.setDouble(2, med.getQtdeMed());
            stmt.setDouble(3, med.getCodLab());
            stmt.setInt(4, med.getCodMed());

            stmt.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
      public void delete(Medicamento med) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbl_medicamento WHERE COD_MED = ?");
            stmt.setInt(1, med.getCodMed());
            stmt.execute();
                   
            
            
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
    
}
