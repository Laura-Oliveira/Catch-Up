package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="imovel")
@Access(AccessType.FIELD)
@NamedQueries(
        {
            @NamedQuery(
                name = Imovel.TIPOIMOVEL_CIDADE,
                query = "SELECT c FROM Imovel c WHERE c.tipoImovel LIKE ?1 AND "
                		+ "c.cidadeImovel LIKE ?2"       
            ),
            @NamedQuery(
                name = Imovel.ALL_IMOVEL,
                query = "SELECT c FROM Imovel c"
            ),
            @NamedQuery(
        		name = Imovel.TIPO_IMOVEL,
        		query = "SELECT C FROM Imovel c WHERE c.tipoImovel LIKE ?1"),
            
            @NamedQuery(
            		name = Imovel.CIDADES,
            		query = "SELECT C FROM Imovel c WHERE c.cidadeImovel LIKE ?1"),
            
            @NamedQuery(
                    name = Imovel.IMOVEL_POR_NOME,
                    query = "SELECT c FROM Imovel c WHERE c.name LIKE ?1"),
    
            @NamedQuery(
                    name = Imovel.IMOVEL_POR_FAVORITO,
                    query = "SELECT i FROM Imovel i JOIN i.userImovel ui JOIN ui.user u "
                    		+ "WHERE u.id = ?1"),
            
            @NamedQuery(
                    name = Imovel.IMOVEL_FROM_USER,
                    query = "SELECT c FROM Imovel c WHERE c.user.id = ?1"       
                ),
        }
)
public class Imovel implements Serializable 
{
    public static final String TIPOIMOVEL_CIDADE = "TipoImovelECidade";
    public static final String ALL_IMOVEL = "AllImvel";
    public static final String TIPO_IMOVEL = "TipoImovel";
    public static final String CIDADES = "Cidades";
    public static final String IMOVEL_POR_NOME = "ImovelPorNome";
    public static final String IMOVEL_POR_FAVORITO = "ImovelPorFavorito";
    public static final String IMOVEL_FROM_USER = "ImovelDoUsuario";
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size (min = 5, max=200)
    @Column(name= "TXT_NAME", nullable = false, length = 200)
    private String name;
    
    @NotNull
    @Size (min = 5)
    @Column(name= "TXT_INFO", nullable = false)
    private String info;
    
    @Column(name="PHONE", nullable = false)
    private String phone;
    
    @NotNull
    @Size (min = 5)
    @Column(name= "TXT_ENDERECO", nullable = false)
    private String endereco;
    
    @NotNull
    @Size (min = 2)
    @Column(name= "TXT_TIPOIMOVEL", nullable = false)
    private String tipoImovel; 

	@NotNull
    @Size (min = 1)
    @Column(name= "TXT_QUANT_COMODOS", nullable = false)
    private String quantComodos; 
    
    @NotNull
    @Size (min = 2)
    @Column(name= "TXT_CIDADE", nullable = false)
    private String cidadeImovel;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="ID_USER", referencedColumnName = "ID", nullable = false)
    private User user;
    
    @OneToMany(mappedBy = "imovel")
    @JoinColumn(name = "IMOVEL_ID", nullable = false)
    private List<UserImovel> userImovel;
        
    public List<UserImovel> getUserImovel() {
		return userImovel;
	}

	public void setUserImovel(List<UserImovel> userImovel) {
		this.userImovel = userImovel;
	}

	public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
		return endereco;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	 public String getTipoImovel() {
			return tipoImovel;
		}

		public void setTipoImovel(String tipoImovel) {
			this.tipoImovel = tipoImovel;
		}


		public String getQuantComodos() {
			return quantComodos;
		}
		
		public void setQuantComodos(String quantComodos) {
			this.quantComodos = quantComodos;
		}

		public String getCidadeImovel() {
			return cidadeImovel;
		}

		public void setCidadeImovel(String cidadeImovel) {
			this.cidadeImovel = cidadeImovel;
		}	
}