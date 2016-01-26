package WhereIsMyBeer.model.FixedDomains;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by micdomingues on 21/01/2016.
 */
@Entity
@Table(name = "FD_CIDADES")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
