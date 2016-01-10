package WhereIsMyBeer.model;

import javax.persistence.*;

/**
 * Created by micdomingues on 23/12/2015.
 */
@Entity
@Table(name = "ESTABELECIMENTO")
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;

    @Column(name = "CIDADE", length = 80, nullable = false)
    private String cidade;

    @Column(name = "BAIRRO", length = 80, nullable = false)
    private String bairro;

    @Column(name = "ENDERECO", length = 80, nullable = false)
    private String endereco;

    @Column(name = "TELEFONE", length = 80, nullable = false)
    private String telefone;

    @Column(name = "DESCRICAO", length = 80, nullable = false)
    private String descricao;

    //FOTO

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
