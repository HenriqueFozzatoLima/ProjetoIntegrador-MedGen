/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexao;
import Objetos.Fornecedor;
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
public class FornecedorDAO {

    public List<Fornecedor> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedor = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setCodForncedor(rs.getInt("Cod_Lab"));
                f.setNomeFornecedor(rs.getString("Nome_Lab"));
                f.setRazaoSocial(rs.getString("Raz_Social"));
                f.setEmail(rs.getString("Email_Lab"));
                f.setCnpj(rs.getString("Cnpj"));
                f.setCidade(rs.getString("Cidade"));
                f.setEstado(rs.getString("Estado"));
                f.setCep(rs.getString("Cep"));
                f.setInscricaoEstadual(rs.getString("Inscri_Esta"));
                fornecedor.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return fornecedor;
    }

    public void create(Fornecedor f) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_produto (NOME_LAB, RAZ_SOCIAL, EMAIL_LAB, CNPJ, CIDADE, ESTADO, CEP, INSCRI_ESTA ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, f.getNomeFornecedor());
            stmt.setString(2, f.getRazaoSocial());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getCnpj());
            stmt.setString(5, f.getCidade());
            stmt.setString(6, f.getEstado());
            stmt.setString(7, f.getCep());
            stmt.setString(8, f.getInscricaoEstadual());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void update(Fornecedor f) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_produto SET NOME_LAB = ?, RAZ_SOCIAL = ?, EMAIL_LAB = ?, CNPJ = ?, CIDADE = ?, ESTADO = ?, CEP = ?, INSCRI_ESTA = ? WHERE COD_LAB = ?");
            stmt.setString(1, f.getNomeFornecedor());
            stmt.setString(2, f.getRazaoSocial());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getCnpj());
            stmt.setString(5, f.getCidade());
            stmt.setString(6, f.getEstado());
            stmt.setString(7, f.getCep());
            stmt.setString(8, f.getInscricaoEstadual());
            stmt.setInt(9, f.getCodForncedor());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void delete(Fornecedor f) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbl_produto WHERE COD_LAB = ?");
            stmt.setInt(1, f.getCodForncedor());
            stmt.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover. " + "\n" + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

}
