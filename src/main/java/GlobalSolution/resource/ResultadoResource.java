package GlobalSolution.resource;

import GlobalSolution.bo.GSResultadoBO;
import GlobalSolution.model.GSResultado;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/resultados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResultadoResource {

    private final GSResultadoBO resultadoBO = new GSResultadoBO();

    @GET
    public List<GSResultado> listarResultados() throws SQLException {
        return resultadoBO.listarResultados();
    }

    @POST
    public String inserirResultado(GSResultado resultado) throws SQLException {
        resultadoBO.inserirResultado(resultado);
        return "Resultado inserido com sucesso!";
    }

    @PUT
    @Path("/{id}")
    public String atualizarResultado(@PathParam("id") int id, GSResultado resultado) throws SQLException {
        resultadoBO.atualizarResultado(id, resultado);
        return "Resultado atualizado com sucesso!";
    }

    @DELETE
    @Path("/{id}")
    public String deletarResultado(@PathParam("id") int id) throws SQLException {
        resultadoBO.deletarResultado(id);
        return "Resultado deletado com sucesso!";
    }
    @GET
    @Path("/{usuario_id}/total")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getTotalPontos(@PathParam("usuario_id") int usuarioId) {
        try {
            int total = resultadoBO.somarPontos(usuarioId);
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("usuario_id", usuarioId);
            resposta.put("total_pontos", total);
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException("Erro ao buscar ranking: " + e.getMessage(), 500);
        }
    }
}

