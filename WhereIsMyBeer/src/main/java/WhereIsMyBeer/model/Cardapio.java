package WhereIsMyBeer.model;

import WhereIsMyBeer.model.FixedDomains.Cidade;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "CARDAPIOS")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false, length = 800)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
