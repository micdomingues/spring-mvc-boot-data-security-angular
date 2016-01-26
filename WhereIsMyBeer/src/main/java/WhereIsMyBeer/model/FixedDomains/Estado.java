package WhereIsMyBeer.model.FixedDomains;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by micdomingues on 21/01/2016.
 */
@Entity
@Table(name = "FD_ESTADOS")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @NotNull
    @Column(name = "SIGLA", nullable = false, length = 2)
    private String sigla;


    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
