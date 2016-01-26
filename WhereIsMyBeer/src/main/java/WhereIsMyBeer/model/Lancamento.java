package WhereIsMyBeer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "LANCAMENTO")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @Column(name = "DATA", nullable = false)
    private Date data;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(name = "ID_RANKING_BAR")
    private RankingBar rankingBar;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RankingBar getRankingBar() {
        return rankingBar;
    }

    public void setRankingBar(RankingBar rankingBar) {
        this.rankingBar = rankingBar;
    }
}
