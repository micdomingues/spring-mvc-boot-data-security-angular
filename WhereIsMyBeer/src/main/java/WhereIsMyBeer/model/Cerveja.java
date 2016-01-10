package WhereIsMyBeer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "CERVEJA")
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @NotNull
    @Column(name = "ORIGEM", length = 50, nullable = false)
    private String origem;

    @NotNull
    @Column(name = "DESCRICAO", length = 50, nullable = false)
    private String descricao;

    @Column(name = "ML")
    private int ml;

    @Column(name = "TEOR_ALCOLICO", precision = 4, scale = 2)
    private float teorAcolico;

    @Column(name = "TEMPERATURA_IDEAL")
    private float temperaturaIdeal;

    @Column(name = "ESTILO", length = 50)
    private String estilo;

    @Column(name = "SABOR", length = 50)
    private String sabor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public float getTeorAcolico() {
        return teorAcolico;
    }

    public void setTeorAcolico(float teorAcolico) {
        this.teorAcolico = teorAcolico;
    }

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Cerveja{" +
                "nome='" + nome + '\'' +
                ", origem='" + origem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ml=" + ml +
                ", teorAcolico=" + teorAcolico +
                ", temperaturaIdeal=" + temperaturaIdeal +
                ", estilo='" + estilo + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
