package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                    name = User.USER_POR_EMAIL,
                    query = "SELECT u FROM User u WHERE u.email LIKE ?1"
            )
            ,
            @NamedQuery(
                    name = User.USER_POR_ID,
                    query = "SELECT u FROM User u WHERE u.id LIKE ?1"
            )
            ,
            @NamedQuery(
                    name = User.USER_POR_LETRA,
                    query ="SELECT u FROM User u WHERE u.name LIKE ?1 ORDER BY u.id"
            )
            ,            
            @NamedQuery(
                    name = User.USER_POR_NOME,
                    query = "SELECT u FROM User u WHERE u.name LIKE ?1 ORDER BY u.id"
            )
            ,            
            @NamedQuery(
                    name = User.ALL_USERS,
                    query = "SELECT u FROM User u"
            )
            ,            
            @NamedQuery(
                    name = User.USER_POR_CPF,
                    query = "SELECT u FROM User u WHERE u.cpf LIKE ?1"
            )
        }
)

@SqlResultSetMapping(
        name = "User.QuantidadeUsers",
        entities = {
            @EntityResult(entityClass = User.class)},
        columns = {
            @ColumnResult(name = "id", type = Long.class)
            ,
                    @ColumnResult(name = "cpf", type = String.class)
            ,
                    @ColumnResult(name = "name", type = String.class)
            ,
                    @ColumnResult(name = "email", type = String.class)
        }
)
public class User implements Serializable {

    public static final String USER_POR_NOME = "UserPorNome";
    public static final String USER_POR_EMAIL = "UserPorEmail";
    public static final String USER_POR_LETRA = "UserPorLetra";
    public static final String USER_POR_ID = "UserPorId";
    public static final String ALL_USERS = "AllUsers";
    public static final String USER_POR_CPF = "UserPorCpf";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "TXT_CPF", nullable = false, length = 14, unique = true)
    private String cpf;



    @Column(name = "TXT_NAME", nullable = false, length = 255)
    private String name;


    @Column(name = "TXT_EMAIL", nullable = false, length = 70)
    private String email;


    @Column(name = "TXT_PASSWORD", nullable = false, length = 20)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

}