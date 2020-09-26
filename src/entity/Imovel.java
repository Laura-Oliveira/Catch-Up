package entity;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
            )
        }
)
public class Imovel implements Serializable 
{
    public static final String IMOVEL_POR_NOME = "ImovelPorNome";
    public static final String ALL_IMOVEL = "AllImvel";

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
    
    @Pattern (regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$", message="{invalid.phone}")
    @Column(name="PHONE", nullable = false, length = 15)
    private String phone;
    
    @NotNull
    @Size (min = 5)
    @Column(name= "TXT_ENDERECO", nullable = false)
    private String endereco;
    

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


}
