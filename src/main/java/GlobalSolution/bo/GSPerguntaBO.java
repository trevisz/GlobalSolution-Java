package GlobalSolution.bo;

import GlobalSolution.dao.GSPerguntaDAO;
import GlobalSolution.model.GSPergunta;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

public class GSPerguntaBO {

    private final GSPerguntaDAO perguntaDAO = new GSPerguntaDAO();

    public List<GSPergunta> listarPerguntas() throws SQLException {
        return perguntaDAO.listar();
    }

    public void inserirPergunta(GSPergunta pergunta) throws SQLException {
        if (pergunta.getEnunciado() == null || pergunta.getEnunciado().isEmpty()) {
            throw new WebApplicationException("Enunciado não pode ser vazio.", Response.Status.BAD_REQUEST);
        }
        perguntaDAO.inserir(pergunta);
    }

    public void atualizarPergunta(int id, GSPergunta pergunta) throws SQLException {
        perguntaDAO.atualizar(id, pergunta);
    }

    public void deletarPergunta(int id) throws SQLException {
        perguntaDAO.deletar(id);
    }

    public List<GSPergunta> listarPorCategoria(String nome) throws SQLException {
        return perguntaDAO.listarPorCategoria(nome);
    }
}
