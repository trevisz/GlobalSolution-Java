package GlobalSolution.dao;

import GlobalSolution.model.GSPergunta;
import GlobalSolution.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GSPerguntaDAO {

    public void inserir(GSPergunta pergunta) throws SQLException {
        String sql = "INSERT INTO GS_PERGUNTAS (enunciado, alternativa_a, alternativa_b, alternativa_c, alternativa_d, correta) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pergunta.getEnunciado());
            stmt.setString(2, pergunta.getAlternativaA());
            stmt.setString(3, pergunta.getAlternativaB());
            stmt.setString(4, pergunta.getAlternativaC());
            stmt.setString(5, pergunta.getAlternativaD());
            stmt.setString(6, pergunta.getCorreta());
            stmt.executeUpdate();
        }
    }

    public List<GSPergunta> listar() throws SQLException {
        List<GSPergunta> perguntas = new ArrayList<>();
        String sql = "SELECT * FROM GS_PERGUNTAS";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GSPergunta p = new GSPergunta();
                p.setId_pergunta(rs.getInt("id_pergunta"));
                p.setEnunciado(rs.getString("enunciado"));
                p.setAlternativaA(rs.getString("alternativa_a"));
                p.setAlternativaB(rs.getString("alternativa_b"));
                p.setAlternativaC(rs.getString("alternativa_c"));
                p.setAlternativaD(rs.getString("alternativa_d"));
                p.setCorreta(rs.getString("correta"));
                perguntas.add(p);
            }
        }
        return perguntas;
    }

    public void atualizar(int id, GSPergunta pergunta) throws SQLException {
        String sql = "UPDATE GS_PERGUNTAS SET enunciado=?, alternativa_a=?, alternativa_b=?, alternativa_c=?, alternativa_d=?, correta=? WHERE id_pergunta=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pergunta.getEnunciado());
            stmt.setString(2, pergunta.getAlternativaA());
            stmt.setString(3, pergunta.getAlternativaB());
            stmt.setString(4, pergunta.getAlternativaC());
            stmt.setString(5, pergunta.getAlternativaD());
            stmt.setString(6, pergunta.getCorreta());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM GS_PERGUNTAS WHERE id_pergunta=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<GSPergunta> listarPorCategoria(String nome) throws SQLException {
        List<GSPergunta> lista = new ArrayList<>();
        String sql = "SELECT * FROM GS_PERGUNTAS WHERE categoria = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GSPergunta p = new GSPergunta();
                p.setId_pergunta(rs.getInt("id_pergunta"));
                p.setEnunciado(rs.getString("enunciado"));
                p.setAlternativaA(rs.getString("alternativa_a"));
                p.setAlternativaB(rs.getString("alternativa_b"));
                p.setAlternativaC(rs.getString("alternativa_c"));
                p.setAlternativaD(rs.getString("alternativa_d"));
                p.setCorreta(rs.getString("correta"));
                p.setCategoria(rs.getString("categoria"));
                lista.add(p);
            }
        }
        return lista;
    }
}

