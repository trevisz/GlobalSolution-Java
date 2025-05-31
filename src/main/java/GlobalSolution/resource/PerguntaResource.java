package GlobalSolution.resource;

import GlobalSolution.bo.GSPerguntaBO;
import GlobalSolution.model.GSPergunta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/perguntas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerguntaResource {

    private final GSPerguntaBO perguntaBO = new GSPerguntaBO();

    @GET
    public List<GSPergunta> listarPerguntas() throws SQLException {
        return perguntaBO.listarPerguntas();
    }

    @POST
    public String inserirPergunta(GSPergunta pergunta) throws SQLException {
        perguntaBO.inserirPergunta(pergunta);
        return "Pergunta inserida com sucesso!";
    }

    @PUT
    @Path("/{id}")
    public String atualizarPergunta(@PathParam("id") int id, GSPergunta pergunta) throws SQLException {
        perguntaBO.atualizarPergunta(id, pergunta);
        return "Pergunta atualizada com sucesso!";
    }

    @DELETE
    @Path("/{id}")
    public String deletarPergunta(@PathParam("id") int id) throws SQLException {
        perguntaBO.deletarPergunta(id);
        return "Pergunta deletada com sucesso!";
    }
    @GET
    @Path("/categoria/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GSPergunta> listarPorCategoria(@PathParam("nome") String nome) {
        try {
            return perguntaBO.listarPorCategoria(nome);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Erro ao buscar perguntas por categoria: " + e.getMessage(), 500);
        }
    }

}

