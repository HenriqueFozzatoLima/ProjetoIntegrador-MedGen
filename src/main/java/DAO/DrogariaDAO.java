/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexao;
import Objetos.Drogaria;
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
public class DrogariaDAO {
    
       public List<Drogaria> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Drogaria> drogaria = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_drogaria");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Drogaria drog = new Drogaria();
                drog.setCodDrogaria(rs.getInt("Cod_Drog"));
                drog.setNomeDrogaria(rs.getString("Nome_Drog"));
                drog.setRazaoSocial(rs.getString("Raz_Social"));
                drog.setEmail(rs.getString("Email_Drog"));
                drog.setCnpj(rs.getString("Cnpj"));
                drog.setCidade(rs.getString("Cidade"));
                drog.setEstado(rs.getString("Estado"));
                drog.setCep(rs.getString("Cep"));
                
                drogaria.add(drog);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return drogaria;
    }
       
          public void create(Drogaria drog) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_drogaria (NOME_DROG, RAZ_SOCIAL, EMAIL_DROG, CNPJ, CIDADE, ESTADO, CEP ) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, drog.getNomeDrogaria());
            stmt.setString(2, drog.getRazaoSocial());
            stmt.setString(3, drog.getEmail());
            stmt.setString(4, drog.getCnpj());
            stmt.setString(5, drog.getCidade());
            stmt.setString(6, drog.getEstado());
            stmt.setString(7, drog.getCep());
            
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
        

    public void update(Drogaria drog) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_drogaria SET NOME_DROG = ?, RAZ_SOCIAL = ?, EMAIL_DROG = ?, CNPJ = ?, CIDADE = ?, ESTADO = ?, CEP = ? WHERE COD_DROG = ?");
            stmt.setString(1, drog.getNomeDrogaria());
            stmt.setString(2, drog.getRazaoSocial());
            stmt.setString(3, drog.getEmail());
            stmt.setString(4, drog.getCnpj());
            stmt.setString(5, drog.getCidade());
            stmt.setString(6, drog.getEstado());
            stmt.setString(7, drog.getCep());
            stmt.setInt(8, drog.getCodDrogaria());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
     public void delete(Drogaria drog) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbl_drogaria WHERE COD_DROG = ?");
            stmt.setInt(1, drog.getCodDrogaria());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    } 
    
}
