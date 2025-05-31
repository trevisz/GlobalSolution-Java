package GlobalSolution.model;

import lombok.Data;


@Data
public class GSPergunta {
    private int id_pergunta;
    private String enunciado;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String correta;
    private String categoria;
}
