package GlobalSolution.bo;

import GlobalSolution.dao.GSUsuarioDAO;
import GlobalSolution.model.GSUsuario;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

public class GSUsuarioBO {

    private final GSUsuarioDAO usuarioDAO = new GSUsuarioDAO();

    public List<GSUsuario> listarUsuarios() throws SQLException {
        return usuarioDAO.listar();
    }

    public void inserirUsuario(GSUsuario usuario) throws SQLException {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new WebApplicationException("Nome não pode ser vazio.", Response.Status.BAD_REQUEST);
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new WebApplicationException("Email não pode ser vazio.", Response.Status.BAD_REQUEST);
        }
        usuarioDAO.inserir(usuario);
    }

    public GSUsuario loginOuRegistrar(GSUsuario usuario) throws SQLException {
        GSUsuario existente = usuarioDAO.buscarPorEmail(usuario.getEmail());
        if (existente != null) {
            return existente; // Usuário já cadastrado (login)
        } else {
            usuarioDAO.inserir(usuario);
            return usuarioDAO.buscarPorEmail(usuario.getEmail()); // Retorna o novo usuário
        }
    }

    public GSUsuario buscarPorEmail(String email) throws SQLException {
        return usuarioDAO.buscarPorEmail(email);
    }

    public void deletarUsuario(int id) throws SQLException {
        usuarioDAO.deletar(id);
    }
}