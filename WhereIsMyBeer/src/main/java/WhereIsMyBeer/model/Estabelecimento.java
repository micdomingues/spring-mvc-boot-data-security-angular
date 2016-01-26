package WhereIsMyBeer.model;

import WhereIsMyBeer.model.FixedDomains.Cidade;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "ESTABELECIMENTOS")
public class Estabelecimento  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    private Cidade cidade;

    @Column(name = "BAIRRO", length = 80, nullable = false)
    private String bairro;

    @Column(name = "CNPJ", length = 80, nullable = false)
    private String cnpj;

    @Column(name = "ENDERECO", length = 80, nullable = false)
    private String endereco;

    @Column(name = "TELEFONE", length = 80, nullable = false)
    private String telefone;

    @Column(name = "DESCRICAO", length = 80, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_CARDAPIO")
    private Cardapio cardapio;

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evento> eventos;

    @ManyToOne
    @JoinColumn(name = "ID_RANKING_BAR")
    private RankingBar rankingBar;

    @Max(5)
    @Min(0)
    @Column(name = "AVALIACAO")
    private int avaliacao;

    @ManyToOne
    @JoinColumn(name = "ID_DONO_BAR")
    private User donobar;

    @ManyToOne
    @JoinColumn(name = "ID_FAVORITADO")

    public RankingBar getRankingBar() {
        return rankingBar;
    }

    public void setRankingBar(RankingBar rankingBar) {
        this.rankingBar = rankingBar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public User getDonobar() {
        return donobar;
    }

    public void setDonobar(User donobar) {
        this.donobar = donobar;
    }
}
