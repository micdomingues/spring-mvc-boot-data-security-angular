package WhereIsMyBeer.model;

import WhereIsMyBeer.model.FixedDomains.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by micdomingues on 21/12/2015.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @NotNull
    @Column(name = "NOME", length = 60, nullable = false)
    private String nome;

    @NotNull
    @Column(name = "USERNAME", length = 60, nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", length = 500, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "ID_ROLE", nullable = false)
    private Role role;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_bar_favorito",
            joinColumns= @JoinColumn(name="ID_USER"), inverseJoinColumns=@JoinColumn(name="ID_ESTABELECIMENTO"))
    private Set<Estabelecimento> baresFavoritos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Estabelecimento> getBaresFavoritos() {
        return baresFavoritos;
    }

    public void setBaresFavoritos(Set<Estabelecimento> baresFavoritos) {
        this.baresFavoritos = baresFavoritos;
    }
}
