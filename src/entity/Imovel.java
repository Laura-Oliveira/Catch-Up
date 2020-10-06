package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
                name = Imovel.IMOVEL_POR_NOME,
                query = "SELECT c FROM Imovel c WHERE c.name LIKE ?1"
                    
            ),
            @NamedQuery(
                name = Imovel.ALL_IMOVEL,
                query = "SELECT c FROM Imovel c"
            ),
            @NamedQuery(
        		name = Imovel.IMOVEL_APARTAMENTO,
        		query = "SELECT C FROM Imovel c WHERE c.tipoImovel LIKE 'apartamento'"),
           
        }
)
public class Imovel implements Serializable 
{
    public static final String IMOVEL_POR_NOME = "ImovelPorNome";
    public static final String ALL_IMOVEL = "AllImvel";
    public static final String IMOVEL_APARTAMENTO = "ImovelApartamento";
    
  /*  private List<Employee> employeeList;
    private List<Employee> filteredEmployeeList;

    @PostConstruct
    public void postConstruct() {
        employeeList = DataService.INSTANCE.getEmployeeList();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    } */

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
    
  /*  @Pattern (regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message="{invalid.phone}") */
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
    
    @OneToMany(mappedBy = "imovel")
    Set<UserImovel> userImovel;

	public Imovel() {
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