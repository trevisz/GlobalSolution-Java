package GlobalSolution.dao;

import GlobalSolution.model.GSUsuario;
import GlobalSolution.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GSUsuarioDAO {

    public void inserir(GSUsuario usuario) throws SQLException {
        String sql = "INSERT INTO GS_USUARIOS (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<GSUsuario> listar() throws SQLException {
        List<GSUsuario> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, nome, email FROM GS_USUARIOS";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println(">>> Conexão estabelecida e SELECT executado.");

            while (rs.next()) {
                GSUsuario u = new GSUsuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                usuarios.add(u);
            }

            System.out.println(">>> Usuários encontrados: " + usuarios.size());

        }
        return usuarios;
    }

    public GSUsuario buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM GS_USUARIOS WHERE email = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                GSUsuario user = new GSUsuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        }
        return null;
    }
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM GS_USUARIOS WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
