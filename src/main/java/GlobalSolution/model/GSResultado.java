package GlobalSolution.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class GSResultado {
    private int id_resultado;
    private int usuario_id;
    private int pontuacao;
    private Timestamp dataJogo;
}