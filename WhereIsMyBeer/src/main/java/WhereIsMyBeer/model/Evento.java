package WhereIsMyBeer.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "EVENTOS")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false, length = 800)
    private String descricao;

    @Column(name = "DATA", nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "ID_ESTABELECIMENTO")
    private Estabelecimento estabelecimento;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
