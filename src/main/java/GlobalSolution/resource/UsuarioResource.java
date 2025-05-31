package GlobalSolution.resource;

import GlobalSolution.bo.GSUsuarioBO;
import GlobalSolution.model.GSUsuario;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private final GSUsuarioBO usuarioBO = new GSUsuarioBO();

    @GET
    public List<GSUsuario> listarUsuarios() throws SQLException {
        return usuarioBO.listarUsuarios();
    }

    @POST
    public String inserirUsuario(GSUsuario usuario) throws SQLException {
        usuarioBO.inserirUsuario(usuario);
        return "Usuário inserido com sucesso!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GSUsuario loginOuRegistrar(GSUsuario usuario) {
        try {
            return usuarioBO.loginOuRegistrar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Erro ao processar o login/registro: " + e.getMessage(), 500);
        }
    }

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public GSUsuario buscarPorEmail(@QueryParam("email") String email) {
        try {
            GSUsuario user = usuarioBO.buscarPorEmail(email);
            if (user == null) {
                throw new WebApplicationException("Usuário não encontrado", 404);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Erro ao buscar usuário: " + e.getMessage(), 500);
        }
    }

    @DELETE
    @Path("/{id}")
    public String deletarUsuario(@PathParam("id") int id) {
        try {
            usuarioBO.deletarUsuario(id);
            return "Usuário deletado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Erro ao deletar usuário: " + e.getMessage(), 500);
        }
    }


}
