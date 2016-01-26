package WhereIsMyBeer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "RANKING_BAR")
public class RankingBar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PONTUACAO", nullable = false)
    private BigInteger pontuacao;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rankingBar")
    private List<Lancamento> lancamentos;

    public BigInteger getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(BigInteger pontuacao) {
        this.pontuacao = pontuacao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
