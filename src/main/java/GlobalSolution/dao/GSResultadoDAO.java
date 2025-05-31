package GlobalSolution.dao;

import GlobalSolution.model.GSResultado;
import GlobalSolution.util.Conexao;

import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GSResultadoDAO {

    public void inserir(GSResultado resultado) throws SQLException {
        String sql = "INSERT INTO GS_RESULTADOS (usuario_id, pontuacao, data_jogo) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, resultado.getUsuario_id());
            stmt.setInt(2, resultado.getPontuacao());
            stmt.setTimestamp(3, resultado.getDataJogo());
            stmt.executeUpdate();
        }
    }

    public List<GSResultado> listar() throws SQLException {
        List<GSResultado> resultados = new ArrayList<>();
        String sql = "SELECT * FROM GS_RESULTADOS";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GSResultado r = new GSResultado();
                r.setId_resultado(rs.getInt("id_resultado"));
                r.setUsuario_id(rs.getInt("usuario_id"));
                r.setPontuacao(rs.getInt("pontuacao"));
                r.setDataJogo(rs.getTimestamp("data_jogo"));
                resultados.add(r);
            }
        }
        return resultados;
    }

    public void atualizar(int id, GSResultado resultado) throws SQLException {
        String sql = "UPDATE GS_RESULTADOS SET usuario_id=?, pontuacao=?, data_jogo=? WHERE id_resultado=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, resultado.getUsuario_id());
            stmt.setInt(2, resultado.getPontuacao());
            stmt.setTimestamp(3, resultado.getDataJogo());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM GS_RESULTADOS WHERE id_resultado=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    public int somarPontos(int usuarioId) throws SQLException {
        String sql = "SELECT COALESCE(SUM(pontuacao), 0) AS total FROM GS_RESULTADOS WHERE usuario_id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        }
        return 0;
    }


}

