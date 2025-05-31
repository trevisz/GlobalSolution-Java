package GlobalSolution.bo;

import GlobalSolution.dao.GSResultadoDAO;
import GlobalSolution.model.GSResultado;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

public class GSResultadoBO {

    private final GSResultadoDAO resultadoDAO = new GSResultadoDAO();

    public List<GSResultado> listarResultados() throws SQLException {
        return resultadoDAO.listar();
    }

    public void inserirResultado(GSResultado resultado) throws SQLException {
        if (resultado.getPontuacao() < 0) {
            throw new WebApplicationException("Pontuação não pode ser negativa.", Response.Status.BAD_REQUEST);
        }
        resultadoDAO.inserir(resultado);
    }

    public void atualizarResultado(int id, GSResultado resultado) throws SQLException {
        resultadoDAO.atualizar(id, resultado);
    }

    public void deletarResultado(int id) throws SQLException {
        resultadoDAO.deletar(id);
    }
    public int somarPontos(int usuarioId) throws SQLException {
        return resultadoDAO.somarPontos(usuarioId);
    }

}
